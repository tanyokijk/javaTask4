package com.aimiko.task4.persistence.entity;

public class Projector {

    private String name;

    private int year;

    private double price;

    private String producer;

    private Projector(){

    }
    public static Projector.ProjectorBuilder newBuilder() {
        return new Projector().new ProjectorBuilder();
    }

    public String getName() {
        return name;
    }

    public int getYear() {
        return year;
    }

    public double getPrice() {
        return price;
    }

    public String getProducer() {
        return producer;
    }


    @Override
    public String toString() {
        return "Проектор: " + name + ", " +
                "рік випуску: "+ year + ", " +
                "виробник: " + producer + ", " +
                "ціна: " + price;
    }


    public class ProjectorBuilder {

        private ProjectorBuilder() {
        }

        public Projector.ProjectorBuilder name(String name) {
            Projector.this.name = name;
            return this;
        }

        public Projector.ProjectorBuilder producer(String producer) {
            Projector.this.producer = producer;
            return this;
        }

        public Projector.ProjectorBuilder price(double price) {
            Projector.this.price = price;
            return this;
        }

        public Projector.ProjectorBuilder year(int year) {
            Projector.this.year = year;
            return this;
        }

        public Projector build() {
            return Projector.this;
        }
    }

}
