package ru.sfedu.repositories.mongodb.api;

import ru.sfedu.repositories.jpa.api.CrudRepository;

public interface MongoRepository<T, ID> extends CrudRepository<T, ID> {
}
