package com.kodilla.travel_backend.controller;

import com.kodilla.travel_backend.dto.OrderDto;
import com.kodilla.travel_backend.facade.OrderFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class OrderController {

    private final OrderFacade orderFacade;

    @GetMapping(value = "/getOrders")
    public List<OrderDto> getOrders(){
        return orderFacade.getOrder();
    }

    @PostMapping(value = "/createOrder")
    public OrderDto createOrder (@RequestBody OrderDto orderDto) {
        return orderFacade.createOrder(orderDto);
    }

    @PutMapping(value = "updateOrder")
    public OrderDto updateUser(@RequestBody OrderDto orderDto) {
        return orderFacade.updateUser(orderDto);
    }

    @GetMapping(value = "/getOrder")
    public OrderDto getOrder(@RequestParam Long orderId) throws OrderWithoutException {
        return orderFacade.getOrder(orderId);
    }

    @DeleteMapping(value = "/deleteOrder")
    public void delOrder(@RequestParam Long orderId) {
        orderFacade.deleteOrder(orderId);
    }
}
