package ml.cloverkit;

public class ConvertTo {
    static boolean[] primitive(Boolean[] in) {
        boolean[] result = new boolean[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动拆箱
        return result;
    }

    static char[] primitive(Character[] in) {
        char[] result = new char[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动拆箱
        return result;
    }

    static short[] primitive(Short[] in) {
        short[] result = new short[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动拆箱
        return result;
    }

    static int[] primitive(Integer[] in) {
        int[] result = new int[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动拆箱
        return result;
    }

    static long[] primitive(Long[] in) {
        long[] result = new long[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动拆箱
        return result;
    }

    static float[] primitive(Float[] in) {
        float[] result = new float[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动拆箱
        return result;
    }

    static double[] primitive(Double[] in) {
        double[] result = new double[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动拆箱
        return result;
    }

    // 从基本类型数组转换为包装类型数组:
    static Boolean[] boxed(boolean[] in) {
        Boolean[] result = new Boolean[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

    static Character[] boxed(char[] in) {
        Character[] result = new Character[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

    static Byte[] boxed(byte[] in) {
        Byte[] result = new Byte[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

    static Short[] boxed(short[] in) {
        Short[] result = new Short[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

    static Integer[] boxed(int[] in) {
        Integer[] result = new Integer[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

    static Long[] boxed(long[] in) {
        Long[] result = new Long[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

    static Float[] boxed(float[] in) {
        Float[] result = new Float[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

    static Double[] boxed(double[] in) {
        Double[] result = new Double[in.length];
        for (int i = 0; i < in.length; i++)
            result[i] = in[i];  // 自动装箱
        return result;
    }

}
