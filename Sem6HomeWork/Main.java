package Sem6.Sem6HomeWork;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    // Имеется карта nxm
    // На ней создаются роботы
    // Если начальная точка инекорректна или занята другим - исключение
    // Можно менять направление движения и перемещать на 1 шаг
    // create-robot x y
    // change-direction LEFT
    // move-robot
    
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RoboMap map = null;
        System.out.println("Введите команду создания карты (create-map m n): ");
        while (true) {
            String command = sc.nextLine();
        
            if (command.startsWith("create-map")) {
                String[] split = command.split(" ");
                String[] arguments = Arrays.copyOfRange(split, 1, split.length);
                try {
                    map = new RoboMap(Integer.parseInt(arguments[0]), Integer.parseInt(arguments[1]));
                    System.out.printf("Создана новая карта с размерами [%d x %d]\n", map.getM(), map.getN());
                    break;
                } catch (IllegalArgumentException e) {
                    System.out.println("При создании карты возникло исключение: " + e.getMessage());
                }
            } else
                System.out.println("Комманда не найдена! Попробуйте еще раз!");
        }
    
        CommandManager commandManager = new CommandManager(map, 
            List.of(new ChangeDirectionCommandHandler(), 
            new MoveCommand(), 
            new ShowMapCommand(), 
            new CreateRobotCommand()));

        while (true) {

            System.out.println("Введите команду (create-robot x y)\n" +
                    "                (change-direction id dir (UP, DOWN, LEFT, RIGHT)\n" +
                    "                (move id)\n" +
                    "                (show-map)\n" +
                    "                (exit)");
            String command = sc.nextLine();
            if (command.equals("exit")) break;
            else commandManager.handleCommand(command);
        }
    }
}
