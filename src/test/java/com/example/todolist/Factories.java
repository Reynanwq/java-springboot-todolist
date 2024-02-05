package com.example.todolist;

import com.example.todolist.entity.Todo;
import com.github.javafaker.Faker;

public class Factories {
    private static Faker faker = new Faker();

    public static Todo createFakeTodoData(){
        return new Todo(
            faker.name().username(),
            faker.internet().password(),
            faker.random().nextBoolean(),
            faker.random().nextInt(0,100000));

    }
}
