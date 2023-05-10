package ml.cloverkit.validating;

import java.util.Arrays;

// 契约式设计 (DbC) 演示
public class CircularQueue {
    private Object[] data;
    private int
            // 下一个可用的存储空间
            in = 0,
            // 下一个可以获取的对象
            out =  0;
    // 是否已经回到了循环队列的开头?
    private boolean wrapped = false;

    public CircularQueue(int size) {
        data = new Object[size];
        // 构造后必须为真
        assert invariant();
    }

    public boolean empty() {
        return !wrapped && in == out;
    }

    public boolean full() {
        return wrapped && in == out;
    }

    public boolean isWrapped() {
        return wrapped;
    }

    public void put(Object item) {
        preCondition(item != null, "put() null item");
        preCondition(!full(), "put() into full CircularQueue");
        assert invariant();
        data[in++] = item;
        if (in >= data.length) {
            in = 0;
            wrapped = true;
        }
        assert invariant();
    }

    public Object get() {
        preCondition(!empty(), "get() from empty CircularQueue");
        assert invariant();
        Object retVal = data[out];
        data[out] = null;
        out++;
        if (out >= data.length) {
            out = 0;
            wrapped = false;
        }
        assert postCondition(retVal != null, "Null item in CircularQueue");
        assert invariant();
        return retVal;
    }

    // 契约设计的相关方法
    private static void preCondition(boolean cond, String msg) {
        if (!cond) throw new CircularQueueException(msg);
    }

    private static boolean postCondition(boolean cond, String msg) {
        if (!cond) throw new CircularQueueException(msg);
        return true;
    }

    private boolean invariant() {
        // 保证在保存了对象的 data 区域不会有空值:
        for (int i = out; i != in; i = (i + 1) % data.length) {
            if (data[i] == null)
                throw new CircularQueueException("null in CircularQueue");
        }
        // 保证在保存了对象的 data 区域之外只会有空值
        if (full()) return true;
        for (int i = in; i != out; i = (i + 1) % data.length) {
            if (data[i] != null)
                throw new CircularQueueException("non-null outside of CircularQueue range: " + dump());
        }
        return true;
    }

    public String dump() {
        return "in = " + in + ", out = " + out + ", full() = " + full() + ", empty() = " + empty() + ", CircularQueue = " + Arrays.asList(data);
    }
}
