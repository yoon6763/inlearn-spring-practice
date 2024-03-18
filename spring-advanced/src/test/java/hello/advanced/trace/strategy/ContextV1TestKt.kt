package hello.advanced.trace.strategy

import hello.advanced.trace.strategy.code.strategy.ContextV1
import lombok.extern.slf4j.Slf4j
import org.junit.jupiter.api.Test

@Slf4j
class ContextV1TestKt {

    @Test
    fun strategyV4() {
        val context1 = ContextV1 { println("비즈니스 로직1 실행") }
        context1.execute()

        val context2 = ContextV1 { println("비즈니스 로직2 실행") }
        context2.execute()
    }

}