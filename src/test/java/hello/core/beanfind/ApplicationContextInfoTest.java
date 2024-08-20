package hello.core.beanfind;


import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext AC = new AnnotationConfigApplicationContext(AppConfig.class);


    @Test
    @DisplayName("모든 빈 조회")
    void findAllBean() {
        String[] beanDefinitions =  AC.getBeanDefinitionNames();


        for (String beanDefinition : beanDefinitions) {
            Object bean = AC.getBean(beanDefinition);
            System.out.println("name = " + beanDefinition + "bean = " + bean);

        }
    }

    @Test
    @DisplayName("애플리케이션 빈 조회")
    void findApplicationBean() {
        String[] beanDefinitionNames =  AC.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {

            BeanDefinition beanDefinition = AC.getBeanDefinition(beanDefinitionName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = AC.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + "bean = " + bean);
            }
        }
    }
}
