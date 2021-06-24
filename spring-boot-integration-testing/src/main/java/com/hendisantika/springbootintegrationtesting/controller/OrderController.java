package com.hendisantika.springbootintegrationtesting.controller;

import com.hendisantika.springbootintegrationtesting.dto.OrderRequest;
import com.hendisantika.springbootintegrationtesting.dto.PaymentRequest;
import com.hendisantika.springbootintegrationtesting.dto.PaymentResponse;
import com.hendisantika.springbootintegrationtesting.entity.Order;
import com.hendisantika.springbootintegrationtesting.entity.Payment;
import com.hendisantika.springbootintegrationtesting.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.47
 */
@RestController
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(
            @RequestBody @Valid OrderRequest orderRequest,
            UriComponentsBuilder uriComponentsBuilder) {

        Order order = orderService.createOrder(orderRequest.getAmount());
        URI location = uriComponentsBuilder.path("/order/{id}").buildAndExpand(order.getId()).toUri();
        return ResponseEntity.created(location).body(order);
    }

    @GetMapping("/order/{id}")
    public ResponseEntity<Order> getOrder(@PathVariable("id") Long orderId) {
        Order order = orderService.getOrder(orderId);
        return ResponseEntity.ok().body(order);
    }

    @PostMapping("/order/{id}/payment")
    public ResponseEntity<PaymentResponse> pay(
            @PathVariable("id") Long orderId,
            @RequestBody @Valid PaymentRequest paymentRequest,
            UriComponentsBuilder uriComponentsBuilder) {

        Payment payment = orderService.pay(orderId, paymentRequest.getCreditCardNumber());
        URI location = uriComponentsBuilder.path("/order/{id}/receipt").buildAndExpand(orderId).toUri();
        PaymentResponse response = new PaymentResponse(payment.getOrder().getId(), payment.getCreditCardNumber());
        return ResponseEntity.created(location).body(response);
    }
}
