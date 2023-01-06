package com.kodilla.travel_backend.service;

import com.kodilla.travel_backend.domain.Order;
import com.kodilla.travel_backend.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> getAllOrder() {
        return orderRepository.findAll();
    }

    public Optional<Order> getOrder(final Long id) {
        return orderRepository.findById(id);
    }

    public Order save(final Order order) {
        return orderRepository.save(order);
    }

    public void deleteOrder(final Long id) {
        orderRepository.deleteById(id);
    }
}
