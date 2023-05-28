package com.eweb.demo.service;

public class SessionLineItem {
    private PriceData priceData;
    private Integer quantity;

    public PriceData getPriceData() {
        return priceData;
    }

    public void setPriceData(PriceData priceData) {
        this.priceData = priceData;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static class Builder {
        private final SessionLineItem lineItem;

        public Builder() {
            lineItem = new SessionLineItem();
        }

        public Builder setPriceData(PriceData priceData) {
            lineItem.setPriceData(priceData);
            return this;
        }

        public Builder setQuantity(Integer quantity) {
            lineItem.setQuantity(quantity);
            return this;
        }

        public SessionLineItem build() {
            return lineItem;
        }
    }
}
