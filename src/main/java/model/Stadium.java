package model;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Stadium {
    private int stadiumId;
    private String stadiumName;
    private Timestamp stadiumCreatedAt;

    public Stadium(int stadiumId, String stadiumName, Timestamp stadiumCreatedAt) {
        this.stadiumId = stadiumId;
        this.stadiumName = stadiumName;
        this.stadiumCreatedAt = stadiumCreatedAt;
    }

    @Override
    public String toString() {
        return "Stadium{" +
                "stadiumId=" + stadiumId +
                ", stadiumName='" + stadiumName + '\'' +
                ", stadiumCreatedAt=" + stadiumCreatedAt +
                '}';
    }
}
