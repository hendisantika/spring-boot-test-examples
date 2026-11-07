package com.hendisantika.springbootwebmvctest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.time.LocalDateTime;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/21
 * Time: 06.03
 */
@Entity(name = "orders")
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue
    private Long id;
    @NonNull
    private LocalDateTime date;
    @NonNull
    private Double amount;
    @NonNull
    private Boolean paid;

    public boolean isPaid() {
        return paid;
    }

    public Order markPaid() {
        paid = true;
        return this;
    }
}
