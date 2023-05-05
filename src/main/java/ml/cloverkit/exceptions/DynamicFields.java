package ml.cloverkit.exceptions;

// 一个可以动态添加数据项的类，用于演示异常链
class DynamicFieldsException extends Exception {}

public class DynamicFields {
    private Object[][] fields;

    public DynamicFields(int initialSize) {
        fields = new Object[initialSize][2];
        for (int i = 0; i < initialSize; i++) {
            fields[i] = new Object[] { null, null };
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (Object[] obj : fields) {
            result.append(obj[0]);
            result.append(": ");
            result.append(obj[1]);
            result.append("\n");
        }
        return result.toString();
    }

    private int hasField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (id.equals(fields[i][0])) {
                return i;
            }
        }
        return -1;
    }

    private int getFieldNumber(String id) throws NoSuchFieldException {
        int fieldNum = hasField(id);
        if (fieldNum == -1) {
            throw new NoSuchFieldException();
        }
        return fieldNum;
    }

    private int makeField(String id) {
        for (int i = 0; i < fields.length; i++) {
            if (fields[i][0] == null) {
                fields[i][0] = id;
                return i;
            }
        }
        // 没有空的数据项，则添加一个
        Object[][] tmp = new Object[fields.length + 1][2];
        System.arraycopy(fields, 0, tmp, 0, fields.length);
        for (int i = fields.length; i < tmp.length; i++) {
            tmp[i] = new Object[] { null, null };
        }
        fields = tmp;
        // 在扩展后的 fields 上递归调用
        return makeField(id);
    }

    public Object getField(String id) throws NoSuchFieldException {
        return fields[getFieldNumber(id)][1];
    }

    public Object setField(String id, Object value) throws DynamicFieldsException {
        if (value == null) {
            // 大部分异常没有支持 cause 参数的构造器
            // 这种情况下必须使用 initCause(),
            // Throwable 的所有子类都支持这个方法
            DynamicFieldsException dfe = new DynamicFieldsException();
            dfe.initCause(new NullPointerException());
            throw dfe;
        }
        int fieldNumber = hasField(id);
        if (fieldNumber == -1)
            fieldNumber = makeField(id);
        Object result = null;
        try {
            // 得到原来的值
            result = getField(id);
        } catch (NoSuchFieldException e) {
            // 使用接受 cause 的构造器
            throw new RuntimeException(e);
        }
        fields[fieldNumber][1] = value;
        return result;
    }

    public static void main(String[] args) {
        DynamicFields df = new DynamicFields(3);
        System.out.println(df);

        try {
            df.setField("d", "A value for d");
            df.setField("number", 47);
            df.setField("number2", 48);
            System.out.println(df);
            df.setField("d", "A new value for d");
            df.setField("number3", "11");
            System.out.println("df: " + df);;
            System.out.println("df.getField(\"d\") : " + df.getField("d"));
            // 异常
            Object field = df.setField("d", null);
        } catch (NoSuchFieldException | DynamicFieldsException e) {
            e.printStackTrace(System.out);
        }
    }
}
