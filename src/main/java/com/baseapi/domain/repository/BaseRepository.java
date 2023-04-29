package com.baseapi.domain.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public class BaseRepository<T> implements PanacheRepositoryBase<T, Long> {

    private final Class<T> entityClass;

    public BaseRepository(Class<T> entityClass) {
        this.entityClass = entityClass;
    }

    public Class<T> getEntityClass() {
        return entityClass;
    }
}
