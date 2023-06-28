package model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Team {
    private int teamId;
    private int stadiumId;
    private String teamName;
    private Timestamp teamCreatedAt;

    public Team(int teamId, int stadiumId, String teamName, Timestamp teamCreatedAt) {
        this.teamId = teamId;
        this.stadiumId = stadiumId;
        this.teamName = teamName;
        this.teamCreatedAt = teamCreatedAt;
    }

    @Override
    public String toString() {
        return "Team{" +
                "teamId=" + teamId +
                ", stadiumId=" + stadiumId +
                ", teamName='" + teamName + '\'' +
                ", teamCreatedAt=" + teamCreatedAt +
                '}';
    }
}