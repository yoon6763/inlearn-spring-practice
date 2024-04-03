package hello.aop.internalcall;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CallServiceV1 {

    private CallServiceV1 callService1;

    public void setCallService1(CallServiceV1 callService1) {
        log.info("setCallService1 setter={}", callService1.getClass());
        this.callService1 = callService1;
    }

    public void external() {
        log.info("external");
        callService1.internal(); // 외부 메서드 호출 this가 아님
    }

    public void internal() {
        log.info("internal");
    }

}
