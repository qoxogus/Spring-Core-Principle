package hello.core.beanfind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //iter 리스트같은게 있으면 for문을 자동생성해주는 단축
            Object bean = ac.getBean(beanDefinitionName);
            System.out.println("name = " + beanDefinitionName + " object = " + bean);
        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) { //iter 리스트같은게 있으면 for문을 자동생성해주는 단축
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName); //getBeanDefinition bean에 대한 메타데이터 정보

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) { //ROLE_APPLICATION 스프링이 자체적으로 필요해 등록한 빈이 아니라 내가 개발하려고 등록한 빈이라고 보면 된다
                Object bean = ac.getBean(beanDefinitionName);
                System.out.println("name = " + beanDefinitionName + " object = " + bean);
            }
        }

    }
}
