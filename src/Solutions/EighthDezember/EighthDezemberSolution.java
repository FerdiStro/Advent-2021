package Solutions.EighthDezember;

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
    private void Calculate(List<List<String[]>> AllSides) {

        //Part 1
        int count = 0;
        List<String[]> calculateListPartOne = AllSides.get(0);
        for (String[] rightSides : calculateListPartOne) {
            for (String stirng : rightSides) {
                switch (stirng.length()) {
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
        List<String[]> leftSides = AllSides.get(1);
        List allSolution = new ArrayList();
        for (String[] leftSide : leftSides) {
            HashMap<Integer, String[]> values = new HashMap<>();
            for (String string : leftSide) {
                switch (string.length()) {
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
                }
            }
            String[] intOne = values.get(1);
            String[] intFour = values.get(4);

            for (String stirng : leftSide) {
                switch (stirng.length()) {

                    case 2:

                        break;
                    case 3:

                        break;
                    case 4:

                        break;
                    case 7:

                        break;
                    case 5:
                        String[] splitFive = stirng.split("");
                        try {
                            int countIfOne = 0;
                            int countFour = 0;
                            for (String stirngsOne : intOne) {
                                //3
                                for (String stringsInSplit : splitFive) {
                                    if (stirngsOne.equals(stringsInSplit)) {
                                        countIfOne++;
                                    }
                                }

                            }
                            //5
                            for (String stringFour : intFour) {
                                for (String stringsInSplit : splitFive) {
                                    if (stringFour.equals(stringsInSplit)) {
                                        countFour++;
                                    }
                                }
                            }
                            //3
                            if (countIfOne == 2) {
                                values.put(3, splitFive);
                                break;
                                //2
                            } else if (countFour == 2) {
                                values.put(2, splitFive);
                                break;
                                //5
                            } else if (countFour == 3) {
                                values.put(5, splitFive);
                                break;
                            }
                        } catch (Exception e) {
                        }
                    case 6:
                        int counterOne = 0;
                        int counterFour = 0;
                        String[] splitSix = stirng.split("");
                        for (String stringOne : intOne) {
                            for (String stringInSplit : splitSix) {
                                if (stringOne.equals(stringInSplit)) {
                                    counterOne++;
                                }
                            }
                        }
                        for (String stringSix : intFour) {
                            for (String stringInSplit : splitSix) {
                                if (stringSix.equals(stringInSplit)) {
                                    counterFour++;
                                }
                            }
                        }
                        //6
                        if (counterOne != 2) {

                            break;
                            //9
                        }else if (counterFour == 4) {
                            values.put(9, splitSix);
                            break;
                            //0
                        } else if (counterFour == 3) {
                            values.put(0, splitSix);;
                            break;
                        }
                }
            }
            String solution = "" ;
            try {
                for(int i = 0  ; i != values.size(); i ++){
                    int countHelp = 0 ;
                    String[] stringsInList = values.get(i);
                    for(String stringOutOfList : stringsInList){
                        for(String string : leftSide){
                            String[] split = string.split("");
                            for(String splittedString : split) {
                                if (splittedString.equals(stringOutOfList) &&  string.length() == stringsInList.length) {
                                    countHelp++;
                                }
                            }

                        }

                    }
                    if(countHelp == stringsInList.length){
                        solution = solution + countHelp;
                    }
                }
                allSolution.add(solution);

            }catch (Exception e){}



        }

        System.out.println("The Solution is/ Part 1: " + count + " Part 2: IN PyThonFile ");
    }

    public void Solution(){
        List<List<String[]>> scann = Scann();
        Calculate(scann);
    }



}
