package comwsd.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import comwsd.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
