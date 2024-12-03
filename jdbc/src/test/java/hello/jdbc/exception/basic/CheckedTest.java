package hello.jdbc.exception.basic;

import lombok.extern.slf4j.Slf4j;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.yaml.snakeyaml.error.MarkedYAMLException;

@Slf4j
public class CheckedTest {

    @Test
    void catch_exception() {
        Service service = new Service();
        service.callCatch();
    }

    @Test
    void catch_throw() {
        Service service = new Service();
        Assertions.assertThatThrownBy(() -> service.callThrow()).isInstanceOf(MarkedYAMLException.class);
    }

    /**
     * Exception을 상속받은 예외는 체크 예외가 된다
     */
    static class MyCheckedException extends Exception {
        public MyCheckedException(String message) {
            super(message);
        }
    }

    static class Service {
        Repository repository = new Repository();

        public void callCatch() {
            try {
                repository.call();
            } catch (MyCheckedException e) {
                log.info("예외 처리, message={}", e.getMessage(), e);
            }
        }

        public void callThrow() throws MyCheckedException {
            repository.call();
        }
    }

    static class Repository {
        public void call() throws MyCheckedException {
            throw new MyCheckedException("ex");
        }
    }

}
