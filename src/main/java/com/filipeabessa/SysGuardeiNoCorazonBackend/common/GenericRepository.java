package com.filipeabessa.SysGuardeiNoCorazonBackend.common;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {
    T create(T entity) throws SQLException;
    T update(T entity);
    void deleteById(long id);
    List<T> findAll();
    Optional<T> findById(long id);
    boolean existsById(long id);

    T mapResultSetToEntity(ResultSet resultSet) throws SQLException;
}

