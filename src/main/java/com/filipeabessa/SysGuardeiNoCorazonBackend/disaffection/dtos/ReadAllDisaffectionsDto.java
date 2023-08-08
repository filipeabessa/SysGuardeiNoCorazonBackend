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

    public List<DisaffectionEntity> getResults() {
        return results;
    }

    public void setResults(List<DisaffectionEntity> results) {
        this.results = results;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }
}
