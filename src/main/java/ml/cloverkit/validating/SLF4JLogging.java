package ml.cloverkit.validating;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SLF4JLogging {
    private static Logger log = LoggerFactory.getLogger(SLF4JLogging.class);

    public static void main(String[] args) {
        log.info("hello logging");
    }
}
