package ru.sfedu.repositories.redis;


import ru.sfedu.repositories.redis.entity.TestEntity;

import java.util.Date;

public class Instance {
    protected TestEntity te1 = new TestEntity("Ivan", new Date());
    protected TestEntity te2 = new TestEntity("Petr", new Date());
    protected TestEntity te3 = new TestEntity("Anna", new Date());
}
