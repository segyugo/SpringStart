package hello.core.scan.filter;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Component;

import static org.junit.jupiter.api.Assertions.*;

public class AssignAnnotationTest {


    @Test
    public void  assign() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoConfig.class);

        BeanA bean1 = ac.getBean(BeanA.class);
        Assertions.assertThat(bean1).isNotNull();


        assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean(BeanB.class));


    }




    @Configuration
    @ComponentScan(
            includeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyIncludeComponent.class),
            excludeFilters = @Filter(type = FilterType.ANNOTATION, classes = MyExcludeComponent.class)
    )
    public static class AutoConfig {

    }


}
