package ru.sfedu.repositories.jpa.repository;

import ru.sfedu.repositories.jpa.api.CrudRepository;
import ru.sfedu.repositories.jpa.entity.TestEntity;

public interface TestEntityRepository extends CrudRepository<TestEntity, Long> {
}
