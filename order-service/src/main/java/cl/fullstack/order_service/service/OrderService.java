package cl.fullstack.order_service.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cl.fullstack.order_service.model.Order;
import cl.fullstack.order_service.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private RestTemplate rest;

    @Autowired
    private OrderRepository repo;

    public String crearOrden(Order order){

        try {
            Object producto = rest.getForObject(
                    "http://localhost:8081/productos/" + order.getIdProduct(),
                    Object.class
            );

            if(producto == null){
                return "Producto no encontrado";
            }

        } catch(Exception e){
            return "Error consultando Product Service";
        }

        try {

            String pago = rest.postForObject(
                    "http://localhost:8083/pagos",
                    order,
                    String.class
            );

            if(!pago.contains("OK")){
                return "Pago rechazado";
            }

        } catch(Exception e){
            return "Error en Payment Service";
        }

        repo.save(order);

        return "Orden creada correctamente";

    }

    public Order findById(Long id) {
        return repo.findById(id);
    }
    
    public List<Order> findAll() {
        return repo.findAll();
    }
}