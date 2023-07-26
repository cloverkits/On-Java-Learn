package ml.cloverkit.enums;

import java.text.DateFormat;
import java.util.Date;

// 常量特定方法
public enum ConstantSpecificMethod {
    DATE_TIME("获取日期时间") {
        @Override
        String getInfo() {
            return DateFormat.getDateInstance().format(new Date());
        }
    },
    CLASSPATH("获取 CLASSPATH") {
        @Override
        String getInfo() {
            return System.getenv("CLASSPATH");
        }
    },
    JAVA_HOME("获取 JAVA_HOME") {
        @Override
        String getInfo() {
            return System.getenv("HOME");
        }
    },
    VERSION("获取 Java 版本") {
        @Override
        String getInfo() {
            return System.getProperty("java.version");
        }
    }
    ;

    private final String desc;

    abstract String getInfo();

    ConstantSpecificMethod(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

    public static void main(String[] args) {
        for (ConstantSpecificMethod csm : values()) {
            System.out.println(csm.getDesc() + ": \t" + csm.getInfo());
        }
    }
}
