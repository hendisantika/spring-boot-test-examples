package com.hendisantika.controller;

import com.hendisantika.dto.OrderRequest;
import com.hendisantika.dto.PaymentRequest;
import com.hendisantika.dto.PaymentResponse;
import com.hendisantika.entity.Order;
import com.hendisantika.entity.Payment;
import com.hendisantika.entity.Receipt;
import com.hendisantika.service.OrderService;
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
 * Date: 22/06/21
 * Time: 07.00
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

    @GetMapping("/order/{id}/receipt")
    public ResponseEntity<Receipt> getReceipt(@PathVariable("id") Long orderId) {
        Receipt receipt = orderService.getReceipt(orderId);
        return ResponseEntity.ok().body(receipt);
    }
}
