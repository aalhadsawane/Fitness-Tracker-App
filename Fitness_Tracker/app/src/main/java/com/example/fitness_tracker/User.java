package com.example.fitness_tracker;

public class User {

    String name;
    String age;
    String calories;

    public User(String name, String age, String calories) {
        this.name = name;
        this.age = age;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getCalories() {
        return calories;
    }
}
