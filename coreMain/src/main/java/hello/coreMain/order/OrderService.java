package hello.coreMain.order;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
