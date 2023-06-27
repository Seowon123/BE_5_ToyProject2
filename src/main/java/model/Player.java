package model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Player {

    private int id;
    private int team_id;
    private String name;
    private String position;
    private Timestamp createdAt;

    @Builder
    public Player(int id, int team_id, String name, String position, Timestamp createdAt) {
        this.id = id;
        this.team_id = team_id;
        this.name = name;
        this.position = position;
        this.createdAt = createdAt;
    }
}
