package barBossHouse;

import java.time.LocalDate;

public  class InternetOrdersManager implements OrdersManager {

    private QueueNode head;
    private QueueNode tail;
    private int size;
   // private int count;

    public InternetOrdersManager() {
        size=0;
    }
    public InternetOrdersManager(MenuItem order) {

    }

    public boolean add(Order order){

        QueueNode node = new QueueNode();

        if (head == null)
        {
            head = node;
            tail = node;
        }
        else
        {
            tail.setNext(node);
            tail = node;
        }

        return true;
    }
    public Order order()
    {
        return head.getValue();
    }

    public int dishQuantity(){
        return size;
    }

    public Order remove(){
        Order dish = head.getValue();
        if (size != 0) {
            head = head.getNext();
            head.setPrevious(null);
            size--;
            return dish;
        }
        return dish;
    }

    public double costTotal() {
        double cost =0.0;
        QueueNode queue = head;
        while (queue!=null)
        {
            cost+=queue.getValue().costTotal();
            queue=queue.getNext();
        }
        return cost;
    }

    //возвращающий общее среди всех занятых столиков количество заданных позиций.
    //Принимает в качестве параметра объект по ссылке типа MenuItem
    public int ordersQuantity(MenuItem item) {
        int count = 0;
        QueueNode queue = head;
        if (size !=0) {
            for (int i = 0; i < size; i++) {
                count += queue.getValue().dishQuantity0(item);
                queue = queue.getNext();
            }
            return count;
        }
        else return 0;
    }

    //возвращающий общее среди всех занятых столиков количество заказанных порций
    //заданного блюда по его имени. Принимает имя блюда в качестве параметра.
    public int itemsQuantity(String item) {
        int count = 0;
        QueueNode queue = head;
        if (size !=0) {
            for (int i = 0; i < size; i++) {
                count += queue.getValue().dishQuantity(item);
                queue = queue.getNext();
            }
            return count;
        }
        else return 0;
    }


    @Override
    public void add(MenuItem menuItem, int tableNumber) {
    }

    @Override
    public int busyTables() {
        return 0;
    }

    @Override
    public TableOrder[] getOrders() {
        return new TableOrder[0];
    }

    @Override
    public double ordersCostSummary() {
        return 0;
    }

    @Override
    public int dishOuantity(String dishName) {
        return 0;
    }
}

class QueueNode {
    private Order value;
    private QueueNode previous;
    private QueueNode next;



    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        next = next;
    }

    public void setValue(){
        this.value=value;
    }
    public Order getValue(){
        return value;
    }

    public void setPrevious(QueueNode previous) {
        this.previous=previous;
    }

    public QueueNode getPrevious() {
        return previous;
    }

}

