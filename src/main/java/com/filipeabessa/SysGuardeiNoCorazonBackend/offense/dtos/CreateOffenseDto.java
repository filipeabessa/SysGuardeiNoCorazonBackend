package com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos;

public class CreateOffenseDto {
    private String title;
    private String description;
    private String cursedFamilyMember;
    private String offendingPerson;

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCursedFamilyMember() {
        return cursedFamilyMember;
    }

    public String getOffendingPerson() {
        return offendingPerson;
    }
}
