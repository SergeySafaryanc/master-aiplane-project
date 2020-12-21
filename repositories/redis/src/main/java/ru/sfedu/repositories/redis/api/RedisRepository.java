package ru.sfedu.repositories.redis.api;

import ru.sfedu.repositories.jpa.api.CrudRepository;

public interface RedisRepository<T, ID> extends CrudRepository<T, ID> {
}
