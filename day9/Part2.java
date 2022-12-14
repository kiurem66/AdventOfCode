package day9;

import java.util.Scanner;

public class Part2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Rope rope = new Rope(50, 50, 10);


        while(scanner.hasNextLine()){
            String sp[] = scanner.nextLine().split(" ");
            rope.doStep(sp[0].charAt(0), Integer.valueOf(sp[1]));
        }

        System.out.println(rope.getPos());
        scanner.close();
    }
}
