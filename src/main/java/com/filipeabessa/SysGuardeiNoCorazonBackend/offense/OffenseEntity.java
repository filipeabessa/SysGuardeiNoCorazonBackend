package com.filipeabessa.SysGuardeiNoCorazonBackend.offense;

public class OffenseEntity {
    private long id;
    private Long disaffectionId;

    private String title;
    private String description;
    private String cursedFamilyMember;
    private String offendingPerson;

    private String occurrenceDateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getDisaffectionId() {
        return disaffectionId;
    }

    public void setDisaffectionId(Long disaffectionId) {
        this.disaffectionId = disaffectionId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCursedFamilyMember() {
        return cursedFamilyMember;
    }

    public void setCursedFamilyMember(String cursedFamilyMember) {
        this.cursedFamilyMember = cursedFamilyMember;
    }

    public String getOffendingPerson() {
        return offendingPerson;
    }

    public void setOffendingPerson(String offendingPerson) {
        this.offendingPerson = offendingPerson;
    }

    public String getOccurrenceDateTime() {
        return occurrenceDateTime;
    }

    public void setOccurrenceDateTime(String occurrenceDateTime) {
        this.occurrenceDateTime = occurrenceDateTime;
    }
}
