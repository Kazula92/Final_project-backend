package com.kodilla.travel_backend.facade;

import com.kodilla.travel_backend.controller.OrderWithoutException;
import com.kodilla.travel_backend.dto.OrderDto;
import com.kodilla.travel_backend.mapper.OrderMapper;
import com.kodilla.travel_backend.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class OrderFacade {

    @Autowired
    private OrderService orderService;

    @Autowired
    private OrderMapper orderMapper;

    public List<OrderDto> getOrder(){
        return orderMapper.mapToOrderDtoList(orderService.getAllOrder());
    }

    public OrderDto getOrder(Long orderId) throws OrderWithoutException {
        return orderMapper.mapToOrderDto(orderService.getOrder(orderId).orElseThrow(OrderWithoutException::new));
    }

    public OrderDto createOrder (OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.save(orderMapper.mapToOrder(orderDto)));
    }

    public OrderDto updateUser(OrderDto orderDto) {
        return orderMapper.mapToOrderDto(orderService.save(orderMapper.mapToOrder(orderDto)));
    }

    public void deleteOrder(Long orderId) {
        orderService.deleteOrder(orderId);
    }
}
