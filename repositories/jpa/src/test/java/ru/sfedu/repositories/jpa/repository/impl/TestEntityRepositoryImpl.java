package ru.sfedu.repositories.jpa.repository.impl;

import ru.sfedu.repositories.jpa.entity.TestEntity;
import ru.sfedu.repositories.jpa.impl.CrudRepositoryImpl;
import ru.sfedu.repositories.jpa.repository.TestEntityRepository;

public class TestEntityRepositoryImpl extends CrudRepositoryImpl<TestEntity, Long> implements TestEntityRepository {
}
