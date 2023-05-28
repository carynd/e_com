package com.eweb.demo.service;

import java.util.List;

public class CheckoutRequest {

    private String successUrl;
    private String cancelUrl;
    private List<LineItem> lineItems;

    public CheckoutRequest(String successUrl, String cancelUrl, List<LineItem> lineItems) {
        this.successUrl = successUrl;
        this.cancelUrl = cancelUrl;
        this.lineItems = lineItems;
    }

    public String getSuccessUrl() {
        return successUrl;
    }

    public String getCancelUrl() {
        return cancelUrl;
    }

    public List<LineItem> getLineItems() {
        return lineItems;
    }

    public static class LineItem {

        private String name;
        private String currency;
        private Long price;
        private Long quantity;

        public LineItem(String name, String currency, Long price, Long quantity) {
            this.name = name;
            this.currency = currency;
            this.price = price;
            this.quantity = quantity;
        }

        public String getName() {
            return name;
        }

        public String getCurrency() {
            return currency;
        }

        public Long getPrice() {
            return price;
        }

        public Long getQuantity() {
            return quantity;
        }
    }
}