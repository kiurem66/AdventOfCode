package day2;

import java.util.Scanner;

public class Part2 {

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


        int outcome = 0;
        char me = line.charAt(2);
        if(me == 'X'){
            outcome=0;
        }else if(me == 'Y'){
            outcome=3;
        }
        else{
            outcome=6;
        }

        for(Morra m : Morra.values()){
            if(m.compare(hisMorra) == outcome) myMorra = m;
        }

        if(myMorra == Morra.ROCK) outcome+=1;
        if(myMorra == Morra.PAPER) outcome +=2;
        if(myMorra == Morra.SCISSOR) outcome += 3;
        
        return outcome;
    }
}
