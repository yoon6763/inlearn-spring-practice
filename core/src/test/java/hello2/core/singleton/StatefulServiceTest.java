package hello2.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.assertThat;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A 사용자 10000원 주문
        int userA = statefulService1.order("userA", 10000);
        //ThreadB : B 사용자 20000원 주문
        int userB = statefulService2.order("userB", 20000);

        //ThreadA : 사용자 A 주문 금액 조회

        /**
         * 중간에 사용자 B가 끼어들었기 떄문에 기대값 10000이 아닌 20000이 나옴
         */

        assertThat(userA).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}