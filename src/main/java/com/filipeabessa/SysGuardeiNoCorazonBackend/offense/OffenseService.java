package com.filipeabessa.SysGuardeiNoCorazonBackend.offense;

import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.CreateOffenseDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.ReadAllOffensesDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos.UpdateOffenseDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OffenseService {
    private final OffenseRepository offenseRepository;
    OffenseService(OffenseRepository offenseRepository) {
        this.offenseRepository = offenseRepository;
    }
    public OffenseEntity create(long disaffectionId, CreateOffenseDto createOffenseDto) {
        OffenseEntity offenseEntity = new OffenseEntity();
        offenseEntity.setDisaffectionId(disaffectionId);
        offenseEntity.setTitle(createOffenseDto.getTitle());
        offenseEntity.setDescription(createOffenseDto.getDescription());
        offenseEntity.setCursedFamilyMember(createOffenseDto.getCursedFamilyMember());
        offenseEntity.setOffendingPerson(createOffenseDto.getOffendingPerson());

        return offenseRepository.create(offenseEntity);
    }

    public OffenseEntity findById(long offenseId) {
        return offenseRepository.findById(offenseId);
    }

    public ReadAllOffensesDto findAll() {
        List<OffenseEntity> offenses = offenseRepository.findAll();
        return new ReadAllOffensesDto(offenses);
    }

    public OffenseEntity update(long offenseId, UpdateOffenseDto updateOffenseDto) {
        OffenseEntity offenseEntity = offenseRepository.findById(offenseId);

        if (offenseEntity == null) {
            return null;
        }

        offenseEntity.setTitle(updateOffenseDto.getTitle());
        offenseEntity.setDescription(updateOffenseDto.getDescription());
        offenseEntity.setCursedFamilyMember(updateOffenseDto.getCursedFamilyMember());
        offenseEntity.setOffendingPerson(updateOffenseDto.getOffendingPerson());

        return new OffenseEntity();
    }

    public void delete(Long offenseId) throws Exception {
        OffenseEntity offenseEntity = offenseRepository.findById(offenseId);

        if (offenseEntity == null) {
            throw new Exception("Offense not found");
        }
        offenseRepository.delete(offenseEntity);
    }
}
