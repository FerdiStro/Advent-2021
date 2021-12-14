package Solutions.FourteentDezember;

import Solutions.Scanner.Scann;

import java.security.KeyStore;
import java.util.*;

public class FourteenthDezemberSolution extends Scann {
    List<String> pairs = new ArrayList<>();
    List<String> polymer = new ArrayList<>();

    HashMap<String, String> matches = new HashMap<>();

    Map<String, Integer> alphaMatches = new HashMap<String, Integer>();
    int reflection = 10;
    private void Calculate(){
        List<String> alphas = new ArrayList<>();
        List<String> inputList = this.scannFile("rsc/inputFourteenthDezember.txt");
        for(int i = 0 ; i != inputList.size(); i ++){
            if(i == 0 ){
                String s = inputList.get(i);
                getPairs(s);
            }else {
            if(inputList.get(i).equals("")){
                continue;
            }else {
                String[] split = inputList.get(i).split(" -> ");
                matches.put(split[0] , split[1]);
                String s = matches.get(split[0]);
                if(!alphas.contains(s)){
                    alphas.add(s);
                    alphaMatches.put(s,0);
                }

            }
            }
        }
        selfReflection();
        Day14 day14 = new Day14();
        int partTwo = Integer.parseInt(day14.Solution());
        partTwo = partTwo -1;


        Integer partOne = solvOne(alphas);
        System.out.println("The Solution is/ Part 1: " + partOne + " Part 2:  "   + partTwo);
    }
    private Integer solvOne(List<String> list){
        String s = polymer.get(polymer.size() - 1);
        String[] split = s.split("");
        for(String string: split){
            for(String strings : list){
                if(strings.equals(string)){
                    alphaMatches.put(string , alphaMatches.get(string)+1);
                }
            }
        }
        int highestInt = 0 ;
        int lowestInt = 10000000;
        String highestString;
        String lowestString;
        for(String string : list){
            Integer integer = alphaMatches.get(string);
            if(integer > highestInt){
                highestInt = integer;
                highestString = string;
            }else if(integer < lowestInt){
                lowestInt = integer;
                lowestString = string;
            }
        }
        int finalAnswser = highestInt - lowestInt;


        return finalAnswser;
    }

    private void getPairs(String s) {
        String[] split = s.split("");
        for(int  j = 0 ; j != split.length-1; j++){
           String  inputPairs = split[j]+split[j+1];
           pairs.add(inputPairs);
        }
    }

    int reflectionCound = 0 ;
    private  void selfReflection (){
        reflectionCound++;
        if(reflectionCound != reflection+1){
            List<String> saveList = new ArrayList<>();
            for(String string: pairs){
                String pairsString = "";
                String matchString = matches.get(string);
                String[] split = string.split("");
                pairsString = split[0] + matchString + split[1];
                saveList.add(pairsString);
            }
            String pairsString = "";
            for(int i = 0 ; i!= saveList.size() ; i++){
                String string = saveList.get(i);
                String[] split = string.split("");
                if(i != saveList.size()-1) {
                    pairsString = pairsString + split[0] + split[1];
                }else {
                    pairsString = pairsString + split[0] + split[1] + split[2];
                }
            }
            pairs.clear();
            getPairs(pairsString);
            polymer.add(pairsString);

            selfReflection();
        }

    }






    public void Solution(){
      Calculate();
    }
}
