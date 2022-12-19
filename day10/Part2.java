package day10;

import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        int cycle = 1;
        int sum=0;

        while(scanner.hasNextLine()){
            draw(cycle, x);
            boolean check = false;
            String[] line = scanner.nextLine().split(" ");
            cycle++;

            if(cycle==20 || cycle==60 || cycle==100 || cycle==140 || cycle==180 || cycle==220){
                sum+=cycle*x;
                check=true;
            }

            if(line[0].equals("addx")){
                draw(cycle, x);
                x += Integer.valueOf(line[1]);
                cycle++;
            }

            
            
            if(cycle==20 || cycle==60 || cycle==100 || cycle==140 || cycle==180 || cycle==220){
                if(check) continue;
                sum+=cycle*x;
            }
        }
        scanner.close();
    }   

    static void draw(int cycle, int x){
        //int line = (cycle-1)/40;
        int offset = (cycle-1)%40;

        if(Math.abs(offset-x) <= 1)System.out.print("#");
        else System.out.print(".");

        if(offset==39) System.out.println("");
    }
}
