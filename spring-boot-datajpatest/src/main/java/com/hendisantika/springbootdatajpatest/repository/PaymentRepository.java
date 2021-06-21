package com.hendisantika.springbootdatajpatest.repository;

import com.hendisantika.springbootdatajpatest.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 21/06/21
 * Time: 09.10
 */
public interface PaymentRepository extends JpaRepository<Payment, Long> {

    Optional<Payment> findByOrderId(Long orderId);

    @Query("SELECT p FROM Payment p JOIN p.order o ON o.date > :after")
    List<Payment> findAllAfter(@Param("after") LocalDateTime afterDate);

    @Query(value = "SELECT * FROM payment WHERE credit_card_number = :ccn", nativeQuery = true)
    List<Payment> findByCreditCardNumber(@Param("ccn") String creditCardNumber);
}
