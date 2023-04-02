package homework;


import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class CustomerService {

    //todo: 3. надо реализовать методы этого класса
    //важно подобрать подходящую Map-у, посмотрите на редко используемые методы, они тут полезны
    TreeMap<Customer,String> container = new TreeMap<>(Comparator.comparingLong(Customer::getScores));

    public Map.Entry<Customer, String> getSmallest() {

        return copy(container.firstEntry());
    }

    public Map.Entry<Customer, String> getNext(Customer customer) {

        return copy(container.higherEntry(customer));
    }

    public void add(Customer customer, String data) {

        container.put(new Customer(customer.getId(), customer.getName(), customer.getScores()), data);
    }

    private Map.Entry<Customer, String> copy(Map.Entry<Customer, String> found){
        if(found != null){
            return Map.entry(
                    new Customer(
                            found.getKey().getId(),
                            found.getKey().getName(),
                            found.getKey().getScores()
                    ),
                    found.getValue()
            );
        }

        return null;
    }
}
