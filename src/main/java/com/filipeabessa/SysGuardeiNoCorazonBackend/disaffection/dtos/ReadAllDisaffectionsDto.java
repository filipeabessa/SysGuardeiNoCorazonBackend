package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos;

import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.DisaffectionEntity;

import java.util.List;

public class ReadAllDisaffectionsDto {
    List<DisaffectionEntity> results;
    long totalCount;

    public ReadAllDisaffectionsDto(List<DisaffectionEntity> results) {
        this.results = results;
        this.totalCount = results.size();
    }
}
