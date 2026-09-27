package orderCre.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import orderCre.client.UserClient;
import orderCre.dto.UserResponseDto;
import orderCre.entity.Order;
import orderCre.repository.OrderRepository;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final UserClient userClient;

    @Override
    public Order createOrder(Order order) {

        UserResponseDto user = userClient.getUserById(order.getUserId());

        if (user == null) {
            throw new RuntimeException("User not found");
        }

        return orderRepository.save(order);
    }

    @Override
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

	@Override
	public List<Order> findByUserId(Long userId) {
		return orderRepository.findByUserId(userId);
	}
}