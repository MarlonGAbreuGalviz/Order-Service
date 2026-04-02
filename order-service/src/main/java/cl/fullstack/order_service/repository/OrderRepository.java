package cl.fullstack.order_service.repository;

import cl.fullstack.order_service.model.Order;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class OrderRepository {

    private List<Order> lista = new ArrayList<>();
    public List<Order> findAll() {
        return lista;
    }
    public Order findById(Long id) {
        return lista.stream()
                .filter(o -> o.getIdOrder().equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(Order o)  { lista.add(o); }
    public void delete1(Long id)  {
        lista.removeIf(p -> p.getIdUser().equals(id));
    }

}
