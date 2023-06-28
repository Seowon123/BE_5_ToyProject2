import db.DBConnection;
import model.Player;
import constant.Position;
import service.PlayerService;
import Dao.PlayerDao;

import java.sql.Connection;
import java.util.List;
import java.util.Scanner;

public class BaseBallApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Connection connection = DBConnection.getInstance();

        System.out.println("어떤 기능을 요청하시겠습니까?");
        String userInput = scanner.nextLine();

        if (userInput.startsWith("선수등록")) {
            String[] params = userInput.split("\\?")[1].split("&");
            int teamId = 0;
            String name = "";
            Position position = null;

            for (String param : params) {
                String[] keyValue = param.split("=");
                String key = keyValue[0];
                String value = keyValue[1];

                switch (key) {
                    case "teamId":
                        teamId = Integer.parseInt(value);
                        break;
                    case "name":
                        name = value;
                        break;
                    case "position":
                        position = Position.findByName(value);
                        break;
                    default:
                        System.out.println("잘못된 입력입니다.");
                        return;
                }
            }

            PlayerDao playerDao = new PlayerDao(connection);
            PlayerService playerService = new PlayerService(playerDao);
            int result = playerService.registerPlayer(teamId, name, position);

            if (result == 1) {
                System.out.println("선수 등록이 성공적으로 완료되었습니다.");
            } else {
                System.out.println("선수 등록에 실패하였습니다.");
            }
        } else {
            System.out.println("잘못된 입력입니다.");
        }
    }
}