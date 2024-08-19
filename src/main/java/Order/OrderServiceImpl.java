package Order;

import Discount.DiscountPolicy;
import Discount.FixDiscountPolicy;
import Member.Member;
import Member.MemberRepository;
import Member.MemoryMemberRepository;

public class OrderServiceImpl implements  OrderService{

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long Id, String itemName, int itemPrice) {

        Member member = memberRepository.findById(Id);

        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(itemName, itemPrice, Id, discountPrice);

    }
}
