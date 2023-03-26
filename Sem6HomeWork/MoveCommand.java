package Sem6.Sem6HomeWork;

public class MoveCommand implements CommandHandler{

    @Override
    public String commandName() {
        return "move";
    }

    @Override
    public void handleCommand(RoboMap map, String[] args) {
        try {
            Integer id = Integer.parseInt(args[0]);
            RoboMap.Robot robot = map.getRobot(id);
            if (robot != null) {
                robot.checkRobotId(id);
                try {
                    robot.move();
                } catch (PositionException e) {
                    System.out.println("Во время создания робота возникла ошибка: " + e.getMessage());
                }
            } else {
                System.out.println("Сперва создайте роботов!\n");
            }
        } catch (RobotIdExeption e) {
            System.out.println(e.getMessage());
        }
    }
    
}
