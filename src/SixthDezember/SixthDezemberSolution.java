package SixthDezember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SixthDezemberSolution {
    public void Solution(){
        List<Integer> scann = Scann();
        calculate(scann, 80);
    }
    private void calculate(List<Integer> dataList, int countDays){
        //Part 1
        for(int d = 0 ; d !=  countDays;  d++) {
            for (int i = 0; i != dataList.size(); i++) {
                if (dataList.get(i) == 0) {
                    dataList.add(9);
                    dataList.set(i, 6);
                } else {
                    dataList.set(i, dataList.get(i) - 1);
                }
            }
        }
        int partOne = dataList.size();
        System.out.println("The Solution is/ Part 1: " + partOne + " Part 2: IN PyThonFile " );
    }
    private List<Integer> Scann()  {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("rsc/inputSixthDezember.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<Integer> datalist = new ArrayList<>();
        while (scanner.hasNext()){
        String nonSplitted = scanner.nextLine();
            String[] split = nonSplitted.split(",");
            for(int i = 0 ; i != split.length; i ++ ){
                int onelatenfish = Integer.parseInt(split[i]);
                datalist.add(onelatenfish);
            }
        }



        return datalist;
    }












}
