package hello.core.scope;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Scope;

import static org.assertj.core.api.Assertions.*;

public class SingletonScope {


    @Test
    void singletonTest() {

        System.out.println("생성 전");

        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonBean.class);

        System.out.println("생성 후");


        System.out.println("빈 1 만듬");
        SingletonBean bean1 = ac.getBean(SingletonBean.class);

        System.out.println("빈 2 만듬");
        SingletonBean bean2 = ac.getBean(SingletonBean.class);

        System.out.println("bean1 : " + bean1);
        System.out.println("bean2 : " + bean2);


        assertThat(bean1).isEqualTo(bean2);

        ac.close();
    }




    @Scope("singleton")
    static class SingletonBean {

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