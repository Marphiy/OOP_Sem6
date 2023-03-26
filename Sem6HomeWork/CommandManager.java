package Sem6.Sem6HomeWork;

import java.util.Arrays;
import java.util.List;


public class CommandManager {
    
    private RoboMap map;
    private List<CommandHandler> handlers;

    public CommandManager(RoboMap map, List<CommandHandler> handlers){
        this.map = map;
        this.handlers = handlers;
    }

    public void handleCommand(String command){
        String[] split = command.split(" ");
        String commandName = split[0];
        String[] arguments = Arrays.copyOfRange(split, 1, split.length);

        for(CommandHandler handler: handlers){
            if(commandName.toLowerCase().equals(handler.commandName())){
                handler.handleCommand(map, arguments);
                return;
            }
        }
        System.out.println("Комманда не распознанна, поробуйте еще раз!\n");
    }
    
}
