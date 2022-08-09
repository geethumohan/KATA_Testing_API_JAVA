package dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;

public class Pet {
    private int id;
    private String name;
    private String birthDate;
    private Type type;
    private String ownerId;
    @JsonIgnore
    private ArrayList<Visit> visits;

    public Pet() {

    }

    public Pet(String name, String birthDate, Type type) {
        this.name = name;
        this.birthDate = birthDate;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getOwnerID() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public ArrayList<Visit> getVisits() {
        return visits;
    }

    public void setVisits(ArrayList<Visit> visits) {
        this.visits = visits;
    }



}
