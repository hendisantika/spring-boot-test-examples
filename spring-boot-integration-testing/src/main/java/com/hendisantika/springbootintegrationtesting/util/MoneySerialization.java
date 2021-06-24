package com.hendisantika.springbootintegrationtesting.util;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import org.springframework.boot.jackson.JsonComponent;
import org.springframework.context.i18n.LocaleContextHolder;

import javax.money.MonetaryAmount;
import javax.money.format.MonetaryAmountFormat;
import javax.money.format.MonetaryFormats;
import java.io.IOException;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 24/06/21
 * Time: 07.39
 */
@JsonComponent
public class MoneySerialization {

    private static final MonetaryAmountFormat monetaryAmountFormat;

    static {
        monetaryAmountFormat = MonetaryFormats.getAmountFormat(LocaleContextHolder.getLocale());
    }

    static class MonetaryAmountSerializer extends StdSerializer<MonetaryAmount> {

        public MonetaryAmountSerializer() {
            super(MonetaryAmount.class);
        }

        @Override
        public void serialize(
                MonetaryAmount value,
                JsonGenerator generator,
                SerializerProvider provider) throws IOException {

            generator.writeString(monetaryAmountFormat.format(value));
        }
    }

}
