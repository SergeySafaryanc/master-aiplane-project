package ru.sfedu.repositories.jpa.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.engine.spi.SessionImplementor;
import ru.sfedu.repositories.jpa.api.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import java.lang.reflect.ParameterizedType;

import static ru.sfedu.repositories.jpa.Constant.PERSISTENCE_UNIT_NAME;
import static ru.sfedu.repositories.jpa.Constant.THROW_ENTITY;

public abstract class RepositoryImpl<T> implements Repository<T> {
    private static final Logger log = LogManager.getLogger(RepositoryImpl.class);

    @PersistenceContext
    protected final EntityManager entityManager;
    protected final Class<T> entityClass;

    public RepositoryImpl() {
        this.entityManager = Persistence.createEntityManagerFactory(System.getProperty(PERSISTENCE_UNIT_NAME)).createEntityManager();
        this.entityClass = getEntityClass();
    }

    public Class<T> getEntityClass() {
        try {
            ParameterizedType parameterizedType = (ParameterizedType) getClass().getGenericSuperclass();
            String className = parameterizedType.getActualTypeArguments()[0].getTypeName();
            return (Class<T>) Class.forName(className);
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException(THROW_ENTITY);
        }
    }

    protected boolean isNew(T var1) {
        return ((SessionImplementor) entityManager.getDelegate()).getPersistenceContext().getEntry(var1) == null;
    }

}
