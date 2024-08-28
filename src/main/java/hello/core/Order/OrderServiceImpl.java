package hello.core.Order;

import hello.core.Discount.DiscountPolicy;
import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import hello.core.annotation.MainDiscountPolicy;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
//@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService{
    @Getter
    private final MemberRepository memberRepository;
    @Getter
    private final DiscountPolicy discountPolicy;

// 같은 이름이 빈이 있을 때 인자에 필드 명을 빈 이름으로 변경한다.
    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy ratediscountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = ratediscountPolicy;
    }


    @Override
    public Order createOrder(Long Id, String itemName, int itemPrice) {

        Member member = memberRepository.findById(Id);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(itemName, itemPrice, Id, discountPrice);

    }


}
