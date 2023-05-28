package com.eweb.demo.service;

public class PriceData {
    private Long unitAmount;
    private String currency;
    private ProductData productData;

    public Long getUnitAmount() {
        return unitAmount;
    }

    public void setUnitAmount(Long unitAmount) {
        this.unitAmount = unitAmount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public ProductData getProductData() {
        return productData;
    }

    public void setProductData(ProductData productData) {
        this.productData = productData;
    }

    public static class Builder {
        private final PriceData priceData;

        public Builder() {
            priceData = new PriceData();
        }

        public Builder setUnitAmount(Long unitAmount) {
            priceData.setUnitAmount(unitAmount);
            return this;
        }

        public Builder setCurrency(String currency) {
            priceData.setCurrency(currency);
            return this;
        }

        public Builder setProductData(ProductData productData) {
            priceData.setProductData(productData);
            return this;
        }
    }
}

