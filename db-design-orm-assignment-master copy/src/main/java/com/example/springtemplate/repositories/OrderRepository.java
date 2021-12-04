package com.example.springtemplate.repositories;

import com.example.springtemplate.models.Customer;
import com.example.springtemplate.models.Order;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends CrudRepository<Order, Integer> {
  @Query(value = "SELECT * FROM orders", nativeQuery = true)
  public List<Order> findAllOrders();
  @Query(value = "SELECT * FROM orders WHERE id=:orderId", nativeQuery = true)
  public Order findOrderById(@Param("orderId") Integer id);

  List<Order> findOrdersByCustomer(Integer id);
}
