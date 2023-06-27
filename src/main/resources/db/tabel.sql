
CREATE TABLE stadium (
                         id INT PRIMARY KEY AUTO_INCREMENT,
                         name VARCHAR(30),
                         created_at TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE team (
                      id INT PRIMARY KEY AUTO_INCREMENT,
                      stadium_id INT,
                      name VARCHAR(30),
                      created_at TIMESTAMP,
                      FOREIGN KEY (stadium_id) REFERENCES stadium(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE player (
                        id INT PRIMARY KEY AUTO_INCREMENT,
                        team_id INT,
                        name VARCHAR(30),
                        position VARCHAR(30),
                        created_at TIMESTAMP,
                        FOREIGN KEY (team_id) REFERENCES team(id),
                        CONSTRAINT uc_team_position UNIQUE (team_id, position)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE out_player (
                            id INT PRIMARY KEY AUTO_INCREMENT,
                            player_id INT,
                            reason VARCHAR(30),
                            created_at TIMESTAMP,
                            FOREIGN KEY (player_id) REFERENCES player(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;