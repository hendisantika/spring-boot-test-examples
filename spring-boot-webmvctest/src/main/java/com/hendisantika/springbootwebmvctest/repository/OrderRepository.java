package com.hendisantika.springbootwebmvctest.repository;

import com.hendisantika.springbootwebmvctest.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 23/06/21
 * Time: 06.08
 */
public interface OrderRepository extends JpaRepository<Order, Long> {
}
