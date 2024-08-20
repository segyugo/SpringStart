package hello.core;

import hello.core.Member.Member;
import hello.core.Member.MemberService;
import hello.core.Member.Grade;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



public class MemberTest {

    private MemberService memberService;


    @BeforeEach
    void beforeEach(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }


    @Test
    void join() {
        Member member = new Member(1L, "고세규", Grade.VIP);

        memberService.join(member);

        Member FindMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(FindMember);

    }

}
