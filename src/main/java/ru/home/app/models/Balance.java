package ru.home.app.models;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Balance {
    private Double amount;
    private String currency;
}
