package ru.sfedu.repositories.redis.repository.impl;

import ru.sfedu.repositories.redis.entity.TestEntity;
import ru.sfedu.repositories.redis.impl.RedisRepositoryImpl;
import ru.sfedu.repositories.redis.repository.TestEntityRepository;

public class TestEntityRepositoryImpl extends RedisRepositoryImpl<TestEntity, Long> implements TestEntityRepository {
}
