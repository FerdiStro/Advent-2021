package Solutions.FirstDezember;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class firstDezemberSolution {
    public List<Integer> getAllNummbersList(){
        List<Integer> allNummbers = new ArrayList<>();
        try {

            Scanner scanner = new Scanner(new File("rsc/inputFirstDezember.txt"));
            while (scanner.hasNext()){

                String line = scanner.nextLine();
                int valueInLine = Integer.parseInt(line);
                allNummbers.add(valueInLine);
            }

        }catch (Exception e){
            e.printStackTrace();
            System.out.println("File konnte nicht gefunden werden");
        }
        return allNummbers;
    }
    public String Solution(){
        List<Integer> allNummbersList = getAllNummbersList();
        int higherNummber = 0;
        int count = 0 ;
        int higherNummber2 = 0;
        int count2 = 0 ;
        List<Integer> messBereiche = new ArrayList<Integer>();
        //  Part 1
        for(int i = 0; i != allNummbersList.size(); i++){

            if(higherNummber < allNummbersList.get(i)){
                higherNummber = allNummbersList.get(i);
                count++;
            }else if(higherNummber > allNummbersList.get(i)){
                higherNummber = allNummbersList.get(i);
            }
        }
        // Part 2
        for(int i = 0; i != allNummbersList.size()-2; i++){
            int messBereich = allNummbersList.get(i)+allNummbersList.get(i+1)+allNummbersList.get(i+2);
            messBereiche.add(messBereich);
            if(higherNummber2 < messBereiche.get(i)){
                higherNummber2 = messBereiche.get(i);
                count2++;
            }else if(higherNummber2 > messBereiche.get(i)){
                higherNummber2 = messBereiche.get(i);
            }
        }






        int finalAnswerPartOne = count-1;
        int finalAnswerPartTwo = count2-1;
//
        String answer = "The Solution is/ Part 1: " + finalAnswerPartOne + "  Part 2: " +finalAnswerPartTwo;
        System.out.println(answer);
        return  answer;

    }



}
