package EighthDezember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class EighthDezemberSolution<values> {
   private List<List<String[]>> Scann(){
       List<List<String[]>> bothParts = new ArrayList<>();
        List<String[]> rightSideList = new ArrayList<>();
        List<String[]> leftSideList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("rsc/inputEighthDezember.txt"));
            while (scanner.hasNext()){
                String unTransformt = scanner.nextLine();
                String[] splitedSides = unTransformt.split("\\|");
                String[] rightSide = splitedSides[splitedSides.length - 1].split(" ");
                String[] leftSide = splitedSides[0].split(" ");
                rightSideList.add(rightSide);
                leftSideList.add(leftSide);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bothParts.add(rightSideList);
        bothParts.add(leftSideList);
    return bothParts;
    }
    private void Calculate(List<List<String[]>> AllSides){

       //Part 1
       int count = 0;
       List<String[]> calculateList = AllSides.get(0);
       for(String[] rightSides : calculateList){
           for(String stirng: rightSides){
               switch (stirng.length()){
                   case 2:
                       count++;
                       break;
                   case 3:
                       count++;
                       break;
                   case 4:
                       count++;
                       break;
                   case 7:
                       count++;
                       break;
               }
           }
       }
       //Part 2
        List<String []> leftSides = AllSides.get(1);
        HashMap<Integer, String[]> values = new HashMap<>();
       for(String[] leftSide : leftSides){
           for(String string: leftSide){
             switch (string.length()){
                 case 2:
                     String[] splitTwo = string.split("");
                     values.put(1, splitTwo);
                     break;
                 case 3:
                     String[] splitThree = string.split("");
                     values.put(7, splitThree);
                     break;
                 case 4:
                     String[] splitFour = string.split("");
                     values.put(4, splitFour);
                     break;
                 case 7:
                     String[] splitSeven = string.split("");
                     values.put(8, splitSeven);
                     break;
                 case 5:
                     String[] splitFive = string.split("");
                     //3
                 try {
                     String[] intOne = values.get(1);
                     int countIfOne = 0;
                     for(String stirngsOne : intOne){
                         for(String stringsInSplit: splitFive){
                             if(stirngsOne.equals(stringsInSplit)){
                                 countIfOne++;
                             }
                         }
                         if(countIfOne == 2){
                             values.put(3,splitFive);
                         }
                     }
                 }catch (Exception e){}





             }
           }
       }
       String partTwo = "" ;
       String[] intOne = values.get(1);
        for(String[] rightSides : calculateList){
            for(String stirng: rightSides){
                switch (stirng.length()){

                    case 2:
                         partTwo = partTwo + "1";
                        break;
                    case 3:
                        partTwo = partTwo + "7";
                        break;
                    case 4:
                        partTwo = partTwo + "4";
                        break;
                    case 7:
                        partTwo = partTwo + "8";
                        break;
                    case 5:
                        String[] splitFive = stirng.split("");
                        if(check(3, values , stirng, 5  )){
                            partTwo = partTwo + "3";
                            System.out.println("CECK Drei   + " + partTwo);
                        }

                        break;
                        //
                    case 6:
                        int counterOne = 0;
                        String[] splitSix = stirng.split("");
                        for(String stringOne : intOne){
                            for(String stringInSplit : splitSix){
                                if(stringOne.equals(stringInSplit)){
                                    counterOne++;
                                }
                            }
                            if(counterOne != 2){
                                partTwo = partTwo + "6";
                            }
                        }
                }
            }
        }
        System.out.println("The Solution is/ Part 1: " + count + " Part 2: IN PyThonFile " );
    }
    private boolean check(int checkInt , HashMap<Integer, String[]> values , String ceckString, int checkCase){
        String[] split = ceckString.split("");
        boolean returnBoolean = false;

        int checkRound = 0;
        try{
           String[] strings = values.get(checkInt);
           for(String string : strings){
               for(String splits : split){
                  if( string.equals(splits)){
                      checkRound ++;
                  }
               }
           }
           if(checkRound == checkCase){
               returnBoolean = true;
           }
       }catch (Exception e){}
       return returnBoolean;
    }




    public void Solution(){
        List<List<String[]>> scann = Scann();
        Calculate(scann);
    }



}
