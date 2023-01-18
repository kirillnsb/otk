package ru.kirillnsb.otk.model;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "item_types")
public class Type {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name = "type_id")
private Long id;
@Column(name = "type_name")
private String typeName;
@Column(name = "description")
private String description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Type type = (Type) o;
        return id.equals(type.id) && Objects.equals(typeName, type.typeName) && Objects.equals(description, type.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, typeName, description);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Type{" +
                "id=" + id +
                ", typeName='" + typeName + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
