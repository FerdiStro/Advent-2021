package NinthDezember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class NinthDezemberSolution {
    private List<String[]> Scann(){
        List<String[]> raws = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("rsc/inputNinthDezember.txt"));
            while (scanner.hasNext()){
                String unsplitted = scanner.nextLine();
                String[] split = unsplitted.split("");
                raws.add(split);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return raws;
    }
    Integer[][] map = new Integer[500][500];
    private void Calculate(List<String[]> raws){
    List<Integer> lowestPeak = new ArrayList<>();
    List<Integer> basins = new ArrayList<>();
    for(int i = 0; i != raws.size(); i++){
        String[] stringArray = raws.get(i);
        for(int k = 0; k  !=  stringArray.length; k++){
            int onPoint = Integer.parseInt(stringArray[k]);
            int overPoint = 10;
            int underPoint= 10;
            int rightPoint= 10;
            int leftPoint = 10;
            if(i > 0){ overPoint = Integer.parseInt(raws.get(i-1)[k]);}
            if(i <= raws.size()-2){underPoint = Integer.parseInt(raws.get(i+1)[k]);}
            if(k < stringArray.length-1){rightPoint= Integer.parseInt(stringArray[k+1]);}
            if(k > 0){ leftPoint= Integer.parseInt(stringArray[k-1]);}
            if(onPoint  < underPoint && onPoint < overPoint && onPoint < rightPoint && onPoint < leftPoint){
                //Part1
                lowestPeak.add(onPoint+1);
                //Part2
                Integer  basin = checkBasin(raws, i, k)+1;
                map = new Integer[500][500];
                basins.add(basin);

            }
        }
    }
    int solveOne = 0;
    for(Integer x :lowestPeak){
        solveOne = solveOne + x;
    }
        Collections.sort(basins);
        int solveTwo = basins.get(basins.size()-1)* basins.get(basins.size()-2)*basins.get(basins.size()-3);
        System.out.println("The Solution is/ Part 1: " + solveOne + "  Part 2: "+solveTwo);
    }

    private Integer checkBasin(List<String[]> raws , int xKord , int yKord){
        int count = 0 ;
        int onePoint = Integer.parseInt(raws.get(xKord)[yKord]);
        int overPoint = -1;
        int underPoint = -1;
        int rightPoint = -1;
        int lefPoint = -1;
        if(xKord > 0){overPoint = Integer.parseInt(raws.get(xKord-1)[yKord]);}
        if(xKord <= raws.size()-2){underPoint = Integer.parseInt(raws.get(xKord+1)[yKord]);}
        if(yKord < raws.get(xKord).length-1){rightPoint = Integer.parseInt(raws.get(xKord)[yKord+1]);}
        if(yKord > 0){lefPoint = Integer.parseInt(raws.get(xKord)[yKord-1]);}

        if(overPoint == onePoint+1 && overPoint !=9){
            try {
                if(map[xKord-1][yKord] != -1) {
                    map[xKord-1][yKord] = -1;
                    Integer integer = checkBasin(raws, xKord - 1, yKord);
                    count = count + integer + 1;
                }
            }catch (Exception e){
                map[xKord-1][yKord] = -1;
                Integer integer = checkBasin(raws, xKord - 1, yKord);
                count = count + integer + 1;
            }
        }
        if(underPoint == onePoint+1 && underPoint != 9 ){
            try {
                if(map[xKord+1][yKord] != -1) {
                    map[xKord+1][yKord] = -1;
                    Integer integer = checkBasin(raws, xKord + 1, yKord);
                    count = count + integer + 1;
                }
            }catch (Exception e){
                map[xKord+1][yKord] = -1;
                Integer integer = checkBasin(raws, xKord + 1, yKord);
                count = count + integer + 1;
            }

        }
          if(rightPoint == onePoint+1 && rightPoint != 9){
            try {
                if(  map[xKord][yKord+1] != -1) {

                    map[xKord][yKord+1] = -1;
                    Integer integer = checkBasin(raws, xKord, yKord + 1);
                    count = count + integer + 1;
                }
            }catch (Exception e) {
                map[xKord][yKord+1] = -1;
                Integer integer = checkBasin(raws, xKord, yKord + 1);
                count = count + integer + 1;
            }
        }
        if (lefPoint == onePoint + 1 && lefPoint != 9 ) {
            try {
                if( map[xKord][yKord-1] != -1) {
                    map[xKord][yKord-1] = -1;
                    Integer integer = checkBasin(raws, xKord, yKord - 1);
                    count = count + integer + 1;
                }
            }catch (Exception e ){
                map[xKord][yKord-1] = -1;
                Integer integer = checkBasin(raws, xKord, yKord - 1);
                count = count + integer + 1;
            }


        }
        return  count;
    }




    public void Solution(){
        List<String[]> scann = Scann();
        Calculate(scann);
    }








}
