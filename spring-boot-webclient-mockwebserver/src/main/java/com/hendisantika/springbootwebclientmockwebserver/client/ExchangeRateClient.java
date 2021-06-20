package com.hendisantika.springbootwebclientmockwebserver.client;

import com.hendisantika.springbootwebclientmockwebserver.config.ExchangeClientProperties;
import com.hendisantika.springbootwebclientmockwebserver.dto.ExchangeResponse;
import com.hendisantika.springbootwebclientmockwebserver.exception.ExchangeFailure;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import javax.money.CurrencyUnit;
import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-test-examples
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 20/06/21
 * Time: 16.42
 */
@Component
@RequiredArgsConstructor
public class ExchangeRateClient {
    private final WebClient webClient;
    private final ExchangeClientProperties properties;

    public BigDecimal getExchangeRate(CurrencyUnit from, CurrencyUnit to) {
        String baseUrl = properties.getBaseUrl();
        String apiKey = properties.getApiKey();

        return webClient.get()
                .uri(baseUrl + "/v6/{apiKey}/pair/{from}/{to}", apiKey, from, to)
                .retrieve()
                .bodyToMono(ExchangeResponse.class)
                .blockOptional()
                .map(response -> {
                    if ("error".equals(response.getResult())) {
                        throw new ExchangeFailure();
                    } else {
                        return response.getConversionRate();
                    }
                })
                .orElseThrow(ExchangeFailure::new);
    }
}
