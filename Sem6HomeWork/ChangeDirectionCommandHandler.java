package Sem6.Sem6HomeWork;

public class ChangeDirectionCommandHandler implements CommandHandler {

    @Override
    public String commandName() {
        return "change-direction";
    }

    @Override
    public void handleCommand(RoboMap map, String[] args) {
        Integer id = Integer.parseInt(args[0]);
        String direction = args[1].toUpperCase();
        RoboMap.Robot robot = map.getRobot(id);
        // robot.checkRobotId(id);
        try {
            switch (direction) {
                case "UP" -> robot.changeDirection(Direction.UP);
                case "DOWN" -> robot.changeDirection(Direction.DOWN);
                case "LEFT" -> robot.changeDirection(Direction.LEFT);
                case "RIGHT" -> robot.changeDirection(Direction.RIGHT);
            };
        } catch (IllegalArgumentException e){
            System.out.println("Что-то пошло не так!\n");
        }
    }

}