package Sem6.Sem6HomeWork;

public class CreateRobotCommand implements CommandHandler{

    @Override
    public String commandName() {
        return "create-robot";
    }

    @Override
    public void handleCommand(RoboMap map, String[] args) {
        if (args.length >= 2) {
            try {
                map.createNewRobot(new Point(Integer.parseInt(args[0]), Integer.parseInt(args[1])));
            } catch (PositionException e) {
                System.out.println("Во время создания робота возникла ошибка: " + e.getMessage());
            }
        } else
            System.out.println("Введено некорректное значение координат!\n");
    }
    
}
