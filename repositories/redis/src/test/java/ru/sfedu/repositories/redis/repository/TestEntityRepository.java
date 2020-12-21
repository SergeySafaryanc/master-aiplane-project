package ru.sfedu.repositories.redis.repository;

import ru.sfedu.repositories.redis.api.RedisRepository;
import ru.sfedu.repositories.redis.entity.TestEntity;

public interface TestEntityRepository extends RedisRepository<TestEntity, Long> {
}
