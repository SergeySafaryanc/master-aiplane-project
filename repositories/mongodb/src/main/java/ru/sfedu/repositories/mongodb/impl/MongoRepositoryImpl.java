package ru.sfedu.repositories.mongodb.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.repositories.jpa.impl.CrudRepositoryImpl;
import ru.sfedu.repositories.mongodb.api.MongoRepository;
import ru.sfedu.repositories.mongodb.utils.MongoUtil;

import java.util.List;

import static ru.sfedu.repositories.mongodb.Constant.*;

public class MongoRepositoryImpl<T, ID> extends CrudRepositoryImpl<T, ID> implements MongoRepository<T, ID> {
    private static final Logger log = LogManager.getLogger(MongoRepositoryImpl.class);

    @Override
    public List<T> findAll() {
        return entityManager.createNamedQuery(MongoUtil.getNativeName(entityClass) + MONGO_FIND, entityClass).getResultList();
    }

    @Override
    public long count() {
        return entityManager.createNamedQuery(MongoUtil.getNativeName(entityClass) + MONGO_COUNT, Long.class).getSingleResult();
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery(MongoUtil.getNativeName(entityClass) + MONGO_DELETE).executeUpdate();
        entityManager.getTransaction().begin();
    }


}
