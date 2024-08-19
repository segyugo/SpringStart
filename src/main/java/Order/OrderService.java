package Order;

import Member.Member;

public interface OrderService {

    Order createOrder(Long Id, String itemName, int itemPrice);

}
