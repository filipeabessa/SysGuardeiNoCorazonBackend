package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.CreateDisaffectionDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.ReadAllDisaffectionsDto;
import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.UpdateDisaffectionDto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Optional;

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

    public ReadAllDisaffectionsDto findAll() {
        return new ReadAllDisaffectionsDto(disaffectionRepository.findAll());
    }

    public DisaffectionEntity update(long disaffectionId, UpdateDisaffectionDto updateDisaffectionDto) throws Exception {
        Optional<DisaffectionEntity> disaffectionEntityOptional = disaffectionRepository.findById(disaffectionId);

        if (disaffectionEntityOptional.isEmpty()) {
            throw new Exception("Disaffection not found");
        }

        DisaffectionEntity disaffectionEntityToUpdate = disaffectionEntityOptional.get();
        disaffectionEntityToUpdate.setTitle(updateDisaffectionDto.getTitle());
        disaffectionEntityToUpdate.setDescription(updateDisaffectionDto.getDescription());
        disaffectionEntityToUpdate.setWitnesses(updateDisaffectionDto.getWitnesses());
        disaffectionEntityToUpdate.setInvolvedPeople(updateDisaffectionDto.getInvolvedPeople());

        return disaffectionRepository.update(disaffectionEntityToUpdate);
    }

    public void delete(Long id) {
        disaffectionRepository.deleteById(id);
    }

    public DisaffectionEntity findById(Long id) {
        return disaffectionRepository.findById(id).orElse(null);
    }
}
