// 嵌套注解示例
package ml.cloverkit.annotations.database;

public @interface Uniqueness {
    Constraints constraints() default @Constraints(unique = true);
}
