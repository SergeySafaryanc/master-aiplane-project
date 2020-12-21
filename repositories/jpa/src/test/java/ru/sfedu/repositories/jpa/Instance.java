package ru.sfedu.repositories.jpa;

import ru.sfedu.repositories.jpa.entity.TestEntity;

import java.util.Date;

public class Instance {
    protected TestEntity te1 = new TestEntity("Ivan", new Date());
    protected TestEntity te2 = new TestEntity("Petr", new Date());
    protected TestEntity te3 = new TestEntity("Anna", new Date());
}
