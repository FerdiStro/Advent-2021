package SecondDezember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class secondDezemberSolution {
    List<String> commands = new ArrayList<String>();
    List<String> value = new ArrayList<String>();


    public  void scannDoc(){
        try {
            Scanner scanner = new Scanner(new File("rsc/inputSecentDezember.txt"));
            while (scanner.hasNext()) {
                String nonSplit = scanner.nextLine();
                String[] SplittedString = nonSplit.split(" ");
                commands.add(SplittedString[0]);
                value.add(SplittedString[1]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("File konnte nicht gefunden werden");
        }
        String partOne = calculate1(commands, value);
        String partTwo = calculate2(commands, value);
        System.out.println("The Solution is/ Part 1: " + partOne + " Part 2: " + partTwo);
    }
    //Part 1
    public String calculate1(List<String> commands , List<String> value){
        int aim = 0;
        int horizontal = 0;
        int depth = 0 ;
        for(int  i = 0; i != commands.size(); i++){
            switch (commands.get(i)){
                case "forward":
                    int xF = Integer.parseInt(value.get(i));
                    horizontal = horizontal + xF;
                    break;
                case "down":
                    int xD = Integer.parseInt(value.get(i));
                    depth = depth + xD ;
                    break;
                case "up":
                    int xU = Integer.parseInt(value.get(i));
                    depth = depth - xU;
                    break;
            }


        }
        int Answer = depth * horizontal;
        String s = ""+Answer;
        return s;
    }


    //Part 2
    public String calculate2(List<String> commands , List<String> value){
        int aim = 0;
        int horizontal = 0;
        int depth = 0 ;
        for(int  i = 0; i != commands.size(); i++){
            switch (commands.get(i)){
                case "forward":
                    int xF = Integer.parseInt(value.get(i));
                    horizontal = horizontal + xF;
                    depth = depth + xF * aim;
                    break;
                case "down":
                    int xD = Integer.parseInt(value.get(i));
                    aim = aim + xD;
                    break;
                case "up":
                    int xU = Integer.parseInt(value.get(i));
                    aim = aim - xU;
                    break;
            }


        }
        int Answer = depth * horizontal;
        String s = ""+Answer;
        return s;
    }
    public void Solution(){
        scannDoc();
    }





}
