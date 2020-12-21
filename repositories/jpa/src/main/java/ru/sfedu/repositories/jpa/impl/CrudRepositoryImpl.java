package ru.sfedu.repositories.jpa.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import ru.sfedu.repositories.jpa.api.CrudRepository;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaDelete;
import javax.persistence.criteria.CriteriaQuery;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public abstract class CrudRepositoryImpl<T, ID> extends RepositoryImpl<T> implements CrudRepository<T, ID> {
    private static final Logger log = LogManager.getLogger(CrudRepositoryImpl.class);

    @Override
    public <S extends T> S save(S var1) {
        entityManager.getTransaction().begin();
        if (isNew(var1)) {
            entityManager.persist(var1);
        }
        entityManager.merge(var1);
        entityManager.getTransaction().commit();
        return var1;
    }

    @Override
    public <S extends T> List<S> saveAll(List<S> var1) {
        return var1.stream().map(this::save).collect(Collectors.toList());
    }

    @Override
    public Optional<T> findById(ID var1) {
        return Optional.ofNullable(entityManager.find(entityClass, var1));
    }

    @Override
    public boolean existsById(ID var1) {
        return findById(var1).isPresent();
    }

    @Override
    public List<T> findAll() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = builder.createQuery(entityClass);
        return entityManager.createQuery(query.select(query.from(entityClass))).getResultList();
    }

    @Override
    public List<T> findAllById(List<ID> var1) {
        List<T> list = new ArrayList<>();
        var1.forEach(o -> findById(o).ifPresent(list::add));
        return list;
    }

    @Override
    public long count() {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Long> query = builder.createQuery(Long.class);
        return entityManager.createQuery(query.select(builder.count(query.from(entityClass)))).getSingleResult();
    }

    @Override
    public void deleteById(ID var1) {
        entityManager.getTransaction().begin();
        findById(var1).ifPresent(entityManager::remove);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T var1) {
        entityManager.getTransaction().begin();
        entityManager.remove(var1);
        entityManager.getTransaction().commit();
    }

    @Override
    public void deleteAll(List<? extends T> var1) {
        var1.forEach(this::delete);
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaDelete<T> delete = builder.createCriteriaDelete(entityClass);
        delete.from(entityClass);
        entityManager.createQuery(delete).executeUpdate();
        entityManager.getTransaction().commit();
    }
}
