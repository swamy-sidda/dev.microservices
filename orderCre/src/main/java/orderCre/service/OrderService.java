package orderCre.service;

import java.util.List;

import orderCre.entity.Order;

public interface OrderService {

    Order createOrder(Order order);

    Order getOrderById(Long id);

    List<Order> getAllOrders();
    
    List<Order> findByUserId(Long userId);

}