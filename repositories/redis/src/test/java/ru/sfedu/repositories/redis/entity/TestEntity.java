package ru.sfedu.repositories.redis.entity;

import org.hibernate.ogm.datastore.document.options.AssociationStorage;
import org.hibernate.ogm.datastore.document.options.AssociationStorageType;
import org.hibernate.ogm.datastore.redis.options.TTL;

import javax.persistence.*;
import java.util.Date;
import java.util.concurrent.TimeUnit;

@Entity
@TTL(value = 7, unit = TimeUnit.MINUTES)
@AssociationStorage(AssociationStorageType.IN_ENTITY)
public class TestEntity {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    @Temporal(TemporalType.DATE)
    private Date currentDate;

    public TestEntity() {
    }

    public TestEntity(String name, Date currentDate) {
        this.name = name;
        this.currentDate = currentDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }

    @Override
    public String toString() {
        return "TestEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", currentDate=" + currentDate +
                '}';
    }
}