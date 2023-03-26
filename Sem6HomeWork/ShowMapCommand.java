package Sem6.Sem6HomeWork;

public class ShowMapCommand implements CommandHandler{

    @Override
    public String commandName() {
        return "show-map";
    }

    @Override
    public void handleCommand(RoboMap map, String[] args) {
        System.out.println(map);
    }
    
}
