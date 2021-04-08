package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan ( //스프링빈 끌어오는 애노테이션
//        basePackages = "hello.core.member", //탐색할 패키지의 시작위치를 정함, 이 패키지를 포함하여 하위패키지를 모두 탐색한다
//        basePackageClasses = AutoAppConfig.class,
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
        //기존 예제코드를 유지하기위해 추가한 옵션이다
)
public class AutoAppConfig {


}
