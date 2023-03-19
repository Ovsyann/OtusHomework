package homework;


import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;

public class CustomerReverseOrder {

    //todo: 2. надо реализовать методы этого класса
    //надо подобрать подходящую структуру данных, тогда решение будет в "две строчки"
    TreeSet<Customer> container = new TreeSet<>(Comparator.comparingLong(Customer::getScores));

    public void add(Customer customer) {

        container.add(new Customer(customer.getId(), customer.getName(), customer.getScores()));
    }

    public Customer take() {

        return container.pollLast(); // это "заглушка, чтобы скомилировать"
    }
}
