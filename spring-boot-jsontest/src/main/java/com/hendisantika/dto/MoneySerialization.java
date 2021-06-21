package com.hendisantika.dto;

import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 22/06/21
 * Time: 06.53
 */
@JsonComponent
public class MoneySerialization {

    private static final MonetaryAmountFormat monetaryAmountFormat;

    static {
        monetaryAmountFormat = MonetaryFormats.getAmountFormat(LocaleContextHolder.getLocale());
    }

}
