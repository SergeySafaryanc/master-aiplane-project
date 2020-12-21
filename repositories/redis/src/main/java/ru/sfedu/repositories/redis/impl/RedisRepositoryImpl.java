package ru.sfedu.repositories.redis.impl;

import ru.sfedu.repositories.jpa.impl.CrudRepositoryImpl;
import ru.sfedu.repositories.redis.api.RedisRepository;

public class RedisRepositoryImpl<T, ID> extends CrudRepositoryImpl<T, ID> implements RedisRepository<T, ID> {
}
