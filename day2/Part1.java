package day2;

import java.util.Scanner;

public class Part1 {

    static enum Morra{
        ROCK, PAPER, SCISSOR;

        public int compare(Morra other){
            if(this == ROCK){
                if(other == SCISSOR) return 6;
                if(other == PAPER) return 0;
                return 3;
            }
            if(this == PAPER){
                if(other == ROCK) return 6;
                if(other == SCISSOR) return 0;
                return 3;
            }
            if(other == PAPER) return 6;
            if(other == ROCK) return 0;
            return 3;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        while(scanner.hasNextLine()){
            score += score(scanner.nextLine());
        }
        System.out.println(score);
        scanner.close();
    }

    static int score(String line){
        int score=0;

        Morra myMorra = null;
        Morra hisMorra = null;

        char other = line.charAt(0);
        if(other == 'A'){
            hisMorra = Morra.ROCK;
        }else if(other == 'B'){
            hisMorra = Morra.PAPER;
        }
        else{
            hisMorra = Morra.SCISSOR;
        }

        char me = line.charAt(2);
        if(me == 'X'){
            myMorra = Morra.ROCK;
            score +=1;
        }else if(me == 'Y'){
            myMorra = Morra.PAPER;
            score+=2;
        }
        else{
            myMorra = Morra.SCISSOR;
            score+=3;
        }

        score += myMorra.compare(hisMorra);

        return score;
    }
}
