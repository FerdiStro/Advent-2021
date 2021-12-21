package Solutions.TwentyFirstDezember;

import Solutions.Scanner.Scann;

import java.util.List;

public class TwentyFirstDezemberSolution extends Scann {
    int unsiversers = 0 ;
    private  void Calculate(){
        long partOne;
        List<String> list = this.scannFile("rsc/input21Dezember.txt");
        int startPlayerOne = Integer.parseInt(list.get(0).split(": ")[1]);
        int startPlayerTwo = Integer.parseInt(list.get(1).split(": ")[1]);
        Player playerOne = new Player();
        playerOne.setStart(startPlayerOne);
        Player playerTwo = new Player();
        playerTwo.setStart(startPlayerTwo);
        int wurfel= 0 ;
        int wurfelcount = 0;
        int roundCount = 0 ; 
        while(playerOne.getPoints() <= 1000 || playerTwo.getPoints() <= 1000){
            int zug = 0; 
         for(int i = 0 ; i != 3 ; i++){
             wurfelcount++;
             zug = zug+wurfel +1;
             wurfel = wurfel + 1;
             if(wurfel == 100 ){
                 wurfel = 0;
             }
         }
         if(roundCount % 2 ==  0){
             getpoint(playerOne, zug);
             if(playerOne.getPoints() >= 1000){
                 playerOne.setWin(true);
                 break;
             }
         }else{
             getpoint(playerTwo, zug);

             if(playerTwo.getPoints() >= 1000){
                 playerTwo.setWin(true);
                 break;
             }
         }
         roundCount += 1;
        }
        if(playerOne.isWin()){
           partOne =  playerTwo.getPoints() * wurfelcount;
        }else {
            partOne = playerOne.getPoints() * wurfelcount;
        }
        //Part Two
        playerOne.setPoints(0);
        playerTwo.setPoints(0);
        playerOne.setStart(startPlayerOne);
        playerTwo.setStart(startPlayerTwo);


//        Run out of Memory
//        partTwo(playerOne, playerTwo, 0);
        Part2 part2 = new Part2();
        long partTwo = part2.Solution();
        System.out.println("The Solution is/ Part 1: " + partOne + " Part 2: " + partTwo);



    }
    private void partTwo(Player playerOne , Player playerTwo , int wurfel   ){

        long startOne = playerOne.getStart();
        long startTwo = playerTwo.getStart();
        for(int i = 0; i  != wurfel; i++){
            if(startOne > 10){
                startOne = 0 ;
            }
            startOne =  startOne + 1 ;
            if(startOne > 10){
                startOne = 1 ;
            }
        }
        for(int i = 0; i  != wurfel; i++){
            if(startTwo > 10){
                startTwo = 0 ;
            }
            startTwo =  startTwo + 1 ;
            if(startTwo > 10){
                startTwo = 1 ;
            }
        }
        if(playerOne.getPoints() >=  21){
            playerOne.setUniversers(playerOne.getUniversers()+1);
            playerOne.setPoints(0);
            return;
        }else if (playerOne.getPoints() >= 21){
            playerTwo.setUniversers(playerTwo.getUniversers()+1);
            playerTwo.setPoints(0);
            return;
        }
        playerOne.setStart(startOne);
        playerOne.setPoints(playerOne.getPoints()+startOne);
        playerTwo.setStart(startTwo);
        playerTwo.setPoints(playerTwo.getPoints()+startTwo);





        partTwo(playerOne , playerTwo, 1);
        partTwo(playerOne, playerTwo, 2 );
        partTwo(playerOne, playerTwo , 3 );

    }






    private void getpoint(Player playerOne, int zug) {
        long start = playerOne.getStart();
        for(int i = 0; i != zug; i++){
            if(start > 10){
                start = 0 ;
            }
            start =  start + 1 ;
            if(start > 10){
                start = 1 ;
            }
        }
        playerOne.setStart(start);
        playerOne.setPoints(playerOne.getPoints()+start);
    }
    public void Solution(){
        Calculate();
    }

}
class Player{
    private long start;
    private long points;
    private boolean win;
    private int universers;

    public long getPoints() {
        return points;
    }

    public void setPoints(long points) {
        this.points = points;
    }

    public long getStart() {
        return start;
    }

    public void setStart(long start) {
        this.start = start;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public int getUniversers() {
        return universers;
    }

    public void setUniversers(int universers) {
        this.universers = universers;
    }
}
