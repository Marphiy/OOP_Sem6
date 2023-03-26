package Sem6.Sem6HomeWork;


public interface CommandHandler {
    String commandName();
    void handleCommand(RoboMap map, String[] args);
}
