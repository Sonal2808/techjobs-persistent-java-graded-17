package org.launchcode.techjobs.persistent.models;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Objects;

@MappedSuperclass
public abstract class AbstractEntity {
    @Id
    @GeneratedValue
    private int id;
    @Size(min=1, max = 255, message = "Name cannot exceed 255 characters")
    @NotBlank(message = "Name cannot be blank") String name;

    public AbstractEntity() {
    }
    public AbstractEntity(String name) {
        this.name = name;
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }


    public boolean equals(Object o) {
        if (this == o) {
            return true;
        } else if (o != null && this.getClass() == o.getClass()) {
            AbstractEntity that = (AbstractEntity)o;
            return this.id == that.id;
        } else {
            return false;
        }
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.id});
    }

    public void setId(int id) {
        this.id = id;
    }

    public abstract void setSkills(List<Skill> skillObjs);
}
