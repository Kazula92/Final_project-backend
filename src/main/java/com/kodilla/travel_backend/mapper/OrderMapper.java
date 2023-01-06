package com.kodilla.travel_backend.mapper;

import com.kodilla.travel_backend.domain.Order;
import com.kodilla.travel_backend.dto.OrderDto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderMapper {

    public Order mapToOrder(final OrderDto orderDto) {
        return new Order(
                orderDto.getOrderId(),
                orderDto.getUserId(),
                orderDto.getAccommodationId(),
                orderDto.getFlightId()
        );
    }

    public OrderDto mapToOrderDto (final Order order) {
        return new OrderDto(
                order.getOrderId(),
                order.getUserId(),
                order.getAccommodationId(),
                order.getFlightId()
        );
    }

    public List<OrderDto> mapToOrderDtoList(final List<Order> orderList) {
        return orderList.stream()
                .map(s-> mapToOrderDto(s))
                .collect(Collectors.toList());
    }
}
