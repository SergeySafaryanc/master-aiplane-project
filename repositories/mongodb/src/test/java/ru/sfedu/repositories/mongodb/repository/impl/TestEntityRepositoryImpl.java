package ru.sfedu.repositories.mongodb.repository.impl;

import ru.sfedu.repositories.mongodb.entity.TestEntity;
import ru.sfedu.repositories.mongodb.impl.MongoRepositoryImpl;
import ru.sfedu.repositories.mongodb.repository.TestEntityRepository;

public class TestEntityRepositoryImpl extends MongoRepositoryImpl<TestEntity, Long> implements TestEntityRepository {
}
