package com.filipeabessa.SysGuardeiNoCorazonBackend.common;

import java.util.List;

public interface GenericRepository<T> {
    T create(T t);
    T update(T t);
    T findById(long id);
    List<T> findAll();
    void delete(T t);
}
