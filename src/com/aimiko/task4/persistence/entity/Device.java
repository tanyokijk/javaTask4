package com.aimiko.task4.persistence.entity;

public class Device {

    private String name;

    private int year;

    private double price;

    private String color;

    private String type;

    private Device(){

    }
    public static Device.DeviceBuilder newBuilder() {
        return new Device().new DeviceBuilder();
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

    public String getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Пристрій: " + name + ", " +
                "рік випуску: "+ year + ", " +
                "колір: " + color + ", " +
                "тип: " + type + ", " +
                "ціна: " + price;
    }


    public class DeviceBuilder {

        private DeviceBuilder() {
        }

        public Device.DeviceBuilder name(String name) {
            Device.this.name = name;
            return this;
        }

        public Device.DeviceBuilder color(String color) {
            Device.this.color = color;
            return this;
        }

        public Device.DeviceBuilder price(double price) {
            Device.this.price = price;
            return this;
        }

        public Device.DeviceBuilder year(int year) {
            Device.this.year = year;
            return this;
        }

        public Device.DeviceBuilder type(String type) {
            Device.this.type = type;
            return this;
        }

        public Device build() {
            return Device.this;
        }
    }

}
