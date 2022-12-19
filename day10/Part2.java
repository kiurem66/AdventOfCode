package day10;

import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        int cycle = 1;

        while(scanner.hasNextLine()){
            draw(cycle, x);
            String[] line = scanner.nextLine().split(" ");
            cycle++;
            if(line[0].equals("addx")){
                draw(cycle, x);
                x += Integer.valueOf(line[1]);
                cycle++;
            }
        }
        scanner.close();
    }   

    static void draw(int cycle, int x){
        int offset = (cycle-1)%40;

        if(Math.abs(offset-x) <= 1)System.out.print("#");
        else System.out.print(".");

        if(offset==39) System.out.println("");
    }
}
