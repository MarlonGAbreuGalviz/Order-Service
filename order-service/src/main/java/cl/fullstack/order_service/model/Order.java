package cl.fullstack.order_service.model;

import lombok.Getter;
import lombok.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Order {
    private Long idOrder;
    private Long idProduct;
    private Long idUser;
}