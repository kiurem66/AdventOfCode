package day7;

import java.io.FileReader;
import java.util.Scanner;

public class Part1 {
    public static void main(String[] args) throws Exception {

        FileSystem fs = new FileSystem();
        Scanner scanner = new Scanner(new FileReader("day7/input.txt"));
        while(scanner.hasNextLine()){
            String line = scanner.nextLine();
            if(line.startsWith("$")){
                String command = line.split(" ")[1];
                if(command == "ls") continue;
                if(command == "cd") fs.cd(line.split(" ")[2]);
            }else{
                String type = line.split(" ")[0];
                String name = line.split(" ")[1];
                if(type.equals("dir")){
                    fs.addDir(name);
                }else{
                    fs.addFile(name, Integer.valueOf(type));
                }
            }
            System.out.println(fs.getCurr());
        }

        //fs.print();
    }
}
