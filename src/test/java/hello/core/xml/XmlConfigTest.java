package hello.core.xml;

import hello.core.Member.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

public class XmlConfigTest {

    @Test
    void xmlAppContext() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService",
                MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }
}
