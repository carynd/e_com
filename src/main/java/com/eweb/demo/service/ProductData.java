package com.eweb.demo.service;

import java.util.List;

public  class ProductData {
    private String name;
    private String description;
    private List<String> images;

    public static class Builder {
        private String name;
        private String description;
        private List<String> images;

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setDescription(String description) {
            this.description = description;
            return this;
        }

        public Builder setImages(List<String> images) {
            this.images = images;
            return this;
        }

        public ProductData build() {
            ProductData productData = new ProductData();
            productData.name = this.name;
            productData.description = this.description;
            productData.images = this.images;
            return productData;
        }
    }
}

