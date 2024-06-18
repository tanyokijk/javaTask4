package com.aimiko.task4.persistence.entity;

public class Product {

private String name;

private String category;

private double price;

private Product(){

}
    public static ProductBuilder newBuilder() {
        return new Product().new ProductBuilder();
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Продукт: " + name + ", " +
                "категорія: " + category + ", " +
                "ціна: " + price;
    }


    public class ProductBuilder {

        private ProductBuilder() {
        }

        public ProductBuilder name(String name) {
            Product.this.name = name;
            return this;
        }

        public ProductBuilder category(String category) {
            Product.this.category = category;
            return this;
        }

        public ProductBuilder price(double price) {
            Product.this.price = price;
            return this;
        }
        public Product build() {
            return Product.this;
        }
    }

}
