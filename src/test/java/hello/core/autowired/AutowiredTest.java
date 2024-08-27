package hello.core.autowired;

import hello.core.Member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

public class AutowiredTest {

    ApplicationContext ac = new AnnotationConfigApplicationContext(tempConfig.class);

    @Test
    void AutowiredNullableTest() {
    }


    @Configuration
    @ComponentScan
    public static class tempConfig{

        @Autowired(required = false)
        void setMember(Member member1) {
            System.out.println(member1);
        }

        @Autowired
        void setMember2(@Nullable Member member2) {
            System.out.println(member2);
        }

        @Autowired
        void setMember3(Optional<Member> member3) {
            System.out.println(member3);
        }

    }

}




