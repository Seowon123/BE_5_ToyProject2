package model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Team {
    private int id;         //pk
    private int stadiumId; //fk
    private String name;
    private Timestamp createdAt;

    @Builder
    public Team(int id, int stadiumId, String name, Timestamp createdAt) {
        this.id = id;
        this.stadiumId = stadiumId;
        this.name = name;
        this.createdAt = createdAt;
    }
}
