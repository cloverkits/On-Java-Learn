package ml.cloverkit.validating;

import org.junit.jupiter.api.DynamicTest;

import java.util.function.Function;
import java.util.stream.Stream;

public class DynamicStringInverterTests {
    // 组合操作来防止重复代码
    Stream<DynamicTest> testVersions(String id, Function<StringInverter, String> test) {
        return null;
    }
}
