package com.filipeabessa.SysGuardeiNoCorazonBackend.offense;

import com.filipeabessa.SysGuardeiNoCorazonBackend.common.GenericRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class OffenseRepository implements GenericRepository<OffenseEntity> {
    @Override
    public OffenseEntity create(OffenseEntity offenseEntity) {
        return null;
    }

    @Override
    public OffenseEntity update(OffenseEntity offenseEntity) {
        return null;
    }

    @Override
    public OffenseEntity findById(long id) {
        return null;
    }

    @Override
    public List<OffenseEntity> findAll() {
        return null;
    }

    @Override
    public void delete(OffenseEntity offenseEntity) {

    }
}
