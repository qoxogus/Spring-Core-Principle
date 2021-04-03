package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    //테스트 코드 넘어가기 전
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService(); //appConfig의 memberService를 달라고 하면 memberService인터페이스를 준다 -> memberService에는 memberServiceImpl이 들어간다.

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); //스프링 객체(Bean)관리
        //AppConfig에 있는 환경설정 정보를 가지고 스프링이 안에인는 컨테이너에 Bean등록 후 관리
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("member = " + member.getName());
        System.out.println("findMember = " + findMember.getName());
    }
}
