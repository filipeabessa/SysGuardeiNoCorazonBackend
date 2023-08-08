package com.filipeabessa.SysGuardeiNoCorazonBackend.offense.dtos;

public class UpdateOffenseDto {
    private String title;
    private String description;
    private String cursedFamilyMember;
    private String offendingPerson;

    private String occurrenceDateTime;

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

    public String getOccurrenceDateTime() {
        return occurrenceDateTime;
    }
}
