package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.assertThat;

public class PrototypeScope{
    @Test
    void PrototypeTest() {

        System.out.println("생성 전");

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(PrototypeBean.class);

        System.out.println("생성 후");


        System.out.println("빈 1 만듬");
        PrototypeBean bean1 = ac.getBean(PrototypeBean.class);

        System.out.println("빈 2 만듬");
        PrototypeBean bean2 = ac.getBean(PrototypeBean.class);

        System.out.println("bean1 : " + bean1);
        System.out.println("bean2 : " + bean2);


        assertThat(bean1).isNotEqualTo(bean2);

        ac.close();


    }




    @Scope("prototype")
    static class PrototypeBean {

        @PostConstruct
        void init() {
            System.out.println("초기화 중");
        }

        @PreDestroy
        void destory() {
            System.out.println("종료 중");
        }

    }
}

