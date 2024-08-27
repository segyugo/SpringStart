package hello.core.Order;

import hello.core.Discount.DiscountPolicy;
import hello.core.Member.Member;
import hello.core.Member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService{

    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;

    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long Id, String itemName, int itemPrice) {

        Member member = memberRepository.findById(Id);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(itemName, itemPrice, Id, discountPrice);

    }
}
