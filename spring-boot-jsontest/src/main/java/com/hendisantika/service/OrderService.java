package com.hendisantika.service;

import com.hendisantika.entity.Order;
import com.hendisantika.entity.Payment;
import com.hendisantika.exception.OrderAlreadyPaid;
import com.hendisantika.repository.OrderRepository;
import com.hendisantika.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.money.MonetaryAmount;
import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 06.58
 */
@Service
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final PaymentRepository paymentRepository;

    public Order createOrder(MonetaryAmount amount) {
        Order order = new Order(LocalDateTime.now(), amount.getNumber().numberValue(BigDecimal.class), false);
        return orderRepository.save(order);
    }

    public Order getOrder(Long orderId) {
        return orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);
    }

    public Payment pay(Long orderId, String creditCardNumber) {
        Order order = orderRepository.findById(orderId).orElseThrow(EntityNotFoundException::new);

        if (order.isPaid()) {
            throw new OrderAlreadyPaid();
        }

        orderRepository.save(order.markPaid());
        return paymentRepository.save(new Payment(order, creditCardNumber));
    }

}
