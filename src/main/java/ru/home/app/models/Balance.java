package ru.home.app.models;

import lombok.*;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Balance {
    private Number amount;
    private String currency;

    public MonetaryAmount getMonetary() {
        return Money.of(this.getAmount(), this.getCurrency());
    }
}
