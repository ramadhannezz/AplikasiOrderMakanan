package com.rama.myapplication2.model_home;

public class Food {

        private final String name;
        private final String price;
        private final int image;

        public Food(String name, String price, int image) {
            this.name = name;
            this.price = price;
            this.image = image;
        }

        public String getName() {
            return name;
        }

        public String getPrice() {
            return price;
        }

        public int getImage() {
            return image;
        }
    }

