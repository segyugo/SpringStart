package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.Member.MemberService;
import hello.core.Member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext AC = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("특정 빈 조회")
    void findBean() {
        MemberService memberService = AC.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("이름 없이 특정 빈 조회")
    void findBeanNotName() {
        MemberService memberService = AC.getBean(MemberService.class);
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }

    @Test
    @DisplayName("없는 빈 조회시 오류")
    void canNotfindBean() {
        assertThrows(NoSuchBeanDefinitionException.class,
                () -> AC.getBean("xxx", MemberService.class));

    }


}
