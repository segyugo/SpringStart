package hello.core.Order;

public interface OrderService {

    Order createOrder(Long Id, String itemName, int itemPrice);

}
