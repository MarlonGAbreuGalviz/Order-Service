package cl.fullstack.order_service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.fullstack.order_service.model.Order;
import cl.fullstack.order_service.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService svc;

    @PostMapping
    public String crearOrden(@RequestBody Order order) {
        return svc.crearOrden(order);
    }

    @GetMapping
    public List<Order> getAll() {
        return svc.findAll();
    }

    
    @GetMapping("/{id}")
    public Order getById(@PathVariable Long id) {
        return svc.findById(id);
    }

}
