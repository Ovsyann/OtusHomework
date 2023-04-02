package homework;


import java.util.*;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    Stack<Customer> container = new Stack<>();

    public void add(Customer customer) {

        container.push(new Customer(customer.getId(), customer.getName(), customer.getScores()));
    }

    public Customer take() {

        return container.pop(); // это "заглушка, чтобы скомилировать"
    }
}
