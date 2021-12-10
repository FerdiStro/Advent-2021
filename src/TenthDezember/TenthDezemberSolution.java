package TenthDezember;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class TenthDezemberSolution {
    List<Character> openings= Arrays.asList('(', '[', '{', '<');
    HashMap<Character , Character> openClosingMap = new HashMap<>(){{
        put('(', ')');
        put('{', '}');
        put('[', ']');
        put('<', '>');
    }};
    HashMap<Character , Integer> scorePartOne = new HashMap<>(){{
        put(')', 3);
        put(']', 57);
        put('}', 1197);
        put('>', 25137);

    }};
    HashMap<Character, Long> scorePartTwo = new HashMap<>(){{
        put(')', 1L);
        put(']', 2L);
        put('}', 3L);
        put('>', 4L);
    }};
    List<Long> scoresPartTwo = new ArrayList<>();




    public  void Solution () {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("rsc/inputTenthDezember.txt"));
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        int finalScorePartOne = 0;
        Long finalScorePartTwo = 0L;
        while (scanner.hasNextLine()){
            String line = scanner.nextLine();
            finalScorePartOne = getFinalScorePartOne(finalScorePartOne, line);
            getFinalScorePartTwo(line);
        }
        scoresPartTwo.sort(Comparator.naturalOrder());
        finalScorePartTwo = scoresPartTwo.get((scoresPartTwo.size()-1)/2);
        scanner.close();
        System.out.println("The Solution is/ Part 1: " + finalScorePartOne + " Part 2:  "+ finalScorePartTwo );


    }
    private void getFinalScorePartTwo(String line){
        boolean check = false;
        Stack<Character> chunks = new Stack<>();
        for (Character c : line.toCharArray()){
            if(openings.contains(c)){
                chunks.push(c);
            }else {
                final Character expectedClosing = openClosingMap.get(chunks.pop());
                if(c != expectedClosing){
                    check = true;
                    break;
                }

            }
        }
        Long lineScore = 0L;
        if( !check && !chunks.isEmpty()){
            while (!chunks.isEmpty()){
               final Long charScore = scorePartTwo.get(openClosingMap.get(chunks.pop()));
               lineScore = lineScore * 5 +charScore;
            }
            scoresPartTwo.add(lineScore);
        }
    }


    private int getFinalScorePartOne(int finalScore, String line) {
        Stack<Character> chunks = new Stack<>();
        for(Character c : line.toCharArray()){
            if(openings.contains(c)){
                chunks.push(c);
            }else{
                final Character expectedClosing = openClosingMap.get(chunks.pop());
                if(c != expectedClosing){
                    finalScore += scorePartOne.get(c);
                    break;
                }

            }
        }
        return finalScore;
    }
}
