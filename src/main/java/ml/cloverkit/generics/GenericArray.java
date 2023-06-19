package ml.cloverkit.generics;

public class GenericArray<T> {
    private T[] array;
    public GenericArray(int size) {
        array = (T[]) new Object[size];
    }
    public void put(int index, T item) {
        array[index] = item;
    }
    public T get(int index) {
        return array[index];
    }
    // 暴露了潜在的表现形式方法:
    public T[] rep() {
        return array;
    }

    public static void main(String[] args) {
        GenericArray<Integer> gai = new GenericArray<>(10);
        try {
            Integer[] ia = gai.rep();
        } catch (ClassCastException e) {
            System.out.println(e.getMessage());
        }
        // 这没问题
        Object[] oa = gai.rep();
    }
}
