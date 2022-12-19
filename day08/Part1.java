package day8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Scanner scanner=new Scanner(System.in);

        while(scanner.hasNextLine()){
            list.add(scanner.nextLine());
        }

        Forest forest= new Forest(list);

        System.out.println(forest.getVisible());
        scanner.close();
    }

}
