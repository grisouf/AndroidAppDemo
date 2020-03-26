package com.gridev.androidappdemo;

class Profile {

    private double weight;
    private double height;
    private int age;
    private Gender gender;

    public Profile(double weight, double height, int age, Gender gender) {
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.gender = gender;
    }

    public double getWeight() {
        return weight;
    }

    public double getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }
}
