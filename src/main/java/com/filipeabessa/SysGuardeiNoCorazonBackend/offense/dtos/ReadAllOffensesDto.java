package com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos;

import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.OffenseEntity;

import java.util.List;

public class ReadAllOffensesDto {
    private List<OffenseEntity> results;
    private long totalCount;

    public ReadAllOffensesDto(List<OffenseEntity> results) {
        this.results = results;
        this.totalCount = results.size();
    }

    public List<OffenseEntity> getResults() {
        return results;
    }

    public long getTotalCount() {
        return totalCount;
    }
}
