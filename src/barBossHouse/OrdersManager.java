package barBossHouse;

public interface OrdersManager {
    void add(MenuItem menuItem, int tableNumber);
    int busyTables ();
    TableOrder[] getOrders ();
    double ordersCostSummary ();
    int dishOuantity (String dishName);
    boolean add(Order order);
    Order order();
    int dishQuantity();
}
