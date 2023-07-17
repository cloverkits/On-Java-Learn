package ml.cloverkit.arrays;

import ml.cloverkit.generics.ArrayOfGeneric;

public class ArrayOfGenericType<T> {
    T[] array;  // OK
    @SuppressWarnings("unchecked")
    public ArrayOfGenericType(int size) {
        // 错误：创建泛型数组
        // array = new T[size];
        array = (T[]) new Object[size]; // 未检查的类型转换
    }

    // 错误: 创建类型数组
    // public <U> U[] makeArray() {
    //     return new U[10];
    // }
}
