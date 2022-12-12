package day1;

import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int maxCal = 0;
        int secondMax = 0;
        int thirdMax = 0;
        int sum = 0;

        while(scanner.hasNextLine()){
            

            String line = scanner.nextLine();

            if(line.equals("")){
                
                if(sum>maxCal){

                    thirdMax = secondMax;
                    secondMax = maxCal;
                    maxCal=sum;
                }else if(sum > secondMax){
                    thirdMax = secondMax;
                    secondMax = sum;
                }else if(sum > thirdMax){
                    thirdMax = sum;
                }
                sum=0;
            }else{
                sum+=Integer.valueOf(line);
            }
        }
        //System.out.println(maxCal); //Parte 1
        System.out.println((maxCal+secondMax+thirdMax)); //Parte 2
        scanner.close();
    }
}