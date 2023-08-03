package com.filipeabessa.SysGuardeiNoCorazonBackend.offense;

import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.CreateOffenseDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.ReadAllOffensesDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.UpdateOffenseDto;
import org.springframework.stereotype.Service;

@Service
public class OffenseService {
    public OffenseEntity create(CreateOffenseDto createOffenseDto) {
        return new OffenseEntity();
    }

    public OffenseEntity findById(long offenseId) {
        return new OffenseEntity();
    }

    public ReadAllOffensesDto findAll() {
        return new ReadAllOffensesDto();
    }

    public OffenseEntity update(long offenseId, UpdateOffenseDto updateOffenseDto) {
        return new OffenseEntity();
    }

    public void delete(Long offenseId) {
    }
}
