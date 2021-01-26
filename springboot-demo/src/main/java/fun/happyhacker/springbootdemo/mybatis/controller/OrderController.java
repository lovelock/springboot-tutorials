package fun.happyhacker.springbootdemo.mybatis.controller;

import fun.happyhacker.springbootdemo.mybatis.controller.request.OrderDto;
import fun.happyhacker.springbootdemo.mybatis.order.entity.Order;
import fun.happyhacker.springbootdemo.mybatis.order.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/orders")
public class OrderController {
    @Autowired
    private IOrderService orderService;

    @GetMapping("/list")
    @ResponseBody
    public String list() {
        return orderService.listAll().toString();
    }

    @PostMapping("/create")
    @ResponseBody
    public int createOrder(@RequestBody OrderDto orderDto) {
        Order order = new Order();
        order.setId(orderDto.getId());
        order.setCtime(LocalDateTime.now());
        order.setName(orderDto.getName());
        return orderService.createOrder(order);
    }
}
