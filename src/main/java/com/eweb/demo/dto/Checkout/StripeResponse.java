package com.eweb.demo.dto.Checkout;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class StripeResponse {
    private String sessionId;
}
