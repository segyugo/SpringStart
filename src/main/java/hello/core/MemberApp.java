package hello.core;

import hello.core.Member.Grade;
import hello.core.Member.Member;
import hello.core.Member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

        public static void main(String[] args) {

            ApplicationContext AC = new AnnotationConfigApplicationContext(AppConfig.class);

            MemberService memberService = AC.getBean("memberService", MemberService.class);

            Member member = new Member(1L, "memberA", Grade.VIP);
            memberService.join(member);
            Member findMember = memberService.findMember(1L);
            System.out.println("new member = " + member.getName());
            System.out.println("find Member = " + findMember.getName());
        }
    }

