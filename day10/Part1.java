package day10;

import java.util.Scanner;

public class Part1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = 1;
        int cycle = 1;
        int sum=0;

        while(scanner.hasNextLine()){
            boolean check = false;
            String[] line = scanner.nextLine().split(" ");
            cycle++;

            if(cycle==20 || cycle==60 || cycle==100 || cycle==140 || cycle==180 || cycle==220){
                sum+=cycle*x;
                check=true;
            }

            if(line[0].equals("addx")){
                x += Integer.valueOf(line[1]);
                cycle++;
            }

            
            
            if(cycle==20 || cycle==60 || cycle==100 || cycle==140 || cycle==180 || cycle==220){
                if(check) continue;
                sum+=cycle*x;
            }
        }
        System.out.println(sum);
        scanner.close();
    }   
    
}
