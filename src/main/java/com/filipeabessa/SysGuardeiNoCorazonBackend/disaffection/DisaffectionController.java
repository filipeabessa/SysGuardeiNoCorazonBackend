package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos.CreateDisaffectionDto;

import java.sql.SQLException;

public class DisaffectionController {
    private DisaffectionService disaffectionService;

    public DisaffectionController(DisaffectionService disaffectionService) {
        this.disaffectionService = disaffectionService;
    }

    public DisaffectionEntity createDisaffection(CreateDisaffectionDto createDisaffectionDto) throws SQLException {
        return disaffectionService.create(createDisaffectionDto);
    }

    public DisaffectionEntity getDisaffectionById(long id) {
        return disaffectionService.findById(id);
    }
}
