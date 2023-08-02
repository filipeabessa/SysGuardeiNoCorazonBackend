package com.filipeabessa.SysGuardeiNoCorazonBackend.disaffection;

import com.filipeabessa.SysGuardeiNoCorazonBackend.offense.OffenseEntity;

import java.util.Date;
import java.util.List;

public class DisaffectionEntity {
    private long id;
    private String title;
    private String description;
    private Date createdAt;
    private Date updatedAt;
    private String witnesses;
    private String involvedPeople;
    private List<OffenseEntity> offenses;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getWitnesses() {
        return witnesses;
    }

    public void setWitnesses(String witnesses) {
        this.witnesses = witnesses;
    }

    public List<OffenseEntity> getOffenses() {
        return offenses;
    }

    public void setOffenses(List<OffenseEntity> offenses) {
        this.offenses = offenses;
    }
    public String getInvolvedPeople() {
        return involvedPeople;
    }

    public void setInvolvedPeople(String involvedPeople) {
        this.involvedPeople = involvedPeople;
    }
}
