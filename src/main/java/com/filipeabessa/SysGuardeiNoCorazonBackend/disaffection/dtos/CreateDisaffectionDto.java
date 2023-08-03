package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection.dtos;

public class CreateDisaffectionDto {

    private String title;
    private String description;
    private String witnesses;
    private String involvedPeople;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getWitnesses() {
        return witnesses;
    }

    public String getInvolvedPeople() {
        return involvedPeople;
    }
}
