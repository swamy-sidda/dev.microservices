package orderCre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import orderCre.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByUserId(Long userId);

}