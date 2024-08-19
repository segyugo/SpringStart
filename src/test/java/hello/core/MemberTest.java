package hello.core;

import Member.Member;
import Member.MemberService;
import Member.MemberServiceImpl;
import Member.Grade;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;



public class MemberTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    void join() {
        Member member = new Member(1L, "고세규", Grade.VIP);

        memberService.join(member);

        Member FindMember = memberService.findMember(1L);

        Assertions.assertThat(member).isEqualTo(FindMember);

    }

}
