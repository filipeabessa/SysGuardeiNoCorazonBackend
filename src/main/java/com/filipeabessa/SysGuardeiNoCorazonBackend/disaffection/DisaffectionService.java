package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.CreateDisaffectionDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class DisaffectionService {
    private final DisaffectionRepository disaffectionRepository;

    public DisaffectionService(DisaffectionRepository disaffectionRepository) {
        this.disaffectionRepository = disaffectionRepository;
    }

    public DisaffectionEntity create(CreateDisaffectionDto createDisaffectionDto) throws SQLException {
        DisaffectionEntity disaffectionEntity = new DisaffectionEntity();
        disaffectionEntity.setTitle(createDisaffectionDto.getTitle());
        disaffectionEntity.setDescription(createDisaffectionDto.getDescription());
        disaffectionEntity.setWitnesses(createDisaffectionDto.getWitnesses());
        disaffectionEntity.setInvolvedPeople(createDisaffectionDto.getInvolvedPeople());

        return disaffectionRepository.create(disaffectionEntity);
    }

    public DisaffectionEntity update(DisaffectionEntity disaffectionEntity) {
        return disaffectionRepository.update(disaffectionEntity);
    }

    public void delete(Long id) {
        disaffectionRepository.deleteById(id);
    }

    public DisaffectionEntity findById(Long id) {
        return disaffectionRepository.findById(id).orElse(null);
    }
}
