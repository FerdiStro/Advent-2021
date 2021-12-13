package Solutions.SeventhDezember;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class SeventhDezemberSolution {


    public List<Integer> Scann(){
        List<Integer> returnList = new ArrayList<>();
        try {
            Scanner scanner = new Scanner(new File("rsc/inputSeventhDezember.txt"));
            while (scanner.hasNext()){
                String nonSplitted = scanner.nextLine();
                String[] split = nonSplitted.split(",");
                for(String input: split){
                    int splitted = Integer.parseInt(input);
                    returnList.add(splitted);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return returnList;
    }


    public void Calculate(List<Integer> datList){
        Collections.sort(datList);

        List<Integer> allFulesPart1 = new ArrayList<>();
        List<Integer> allFuelsPart2 = new ArrayList<>();

        for(int i = 0 ;  i != datList.get(datList.size()-1); i++ ){
        int fuelPart1 = 0 ;
        int fulePart2 = 0 ;
        int added = 0;
        int addedPart2 = 0;
        for(int x : datList){
           added = x - i;
            int abs = Math.abs(added);
            fuelPart1 = fuelPart1 + abs;
            for(int j = 1 ;  j != abs+1; j++){

                    addedPart2 = addedPart2 + j;


            }






        }fulePart2 = fulePart2 +addedPart2;
        //Part 1
        allFulesPart1.add(fuelPart1);
        //Part 2
        allFuelsPart2.add(fulePart2);
         }
        Collections.sort(allFulesPart1);
        Collections.sort(allFuelsPart2);





        System.out.println("The Solution is/ Part 1: " + allFulesPart1.get(0) + " Part 2:  " + allFuelsPart2.get(0) );

    }








    public void Solution(){
        List<Integer> scann = Scann();
        Calculate(scann);


    }




}
