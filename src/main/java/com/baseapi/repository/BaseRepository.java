package com.baseapi.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

public class BaseRepository<T> implements PanacheRepositoryBase<T, Long> {

}
