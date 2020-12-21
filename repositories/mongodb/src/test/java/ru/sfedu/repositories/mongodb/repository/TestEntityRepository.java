package ru.sfedu.repositories.mongodb.repository;

import ru.sfedu.repositories.mongodb.api.MongoRepository;
import ru.sfedu.repositories.mongodb.entity.TestEntity;

public interface TestEntityRepository extends MongoRepository<TestEntity, Long> {
}
