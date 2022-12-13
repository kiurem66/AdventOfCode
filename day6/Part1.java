package day6;

import java.util.Scanner;

public class Part1 {
    static class Buffer{
        private char[] arr;

        public Buffer(int size){
            arr = new char[size];
        }

        public void add(char c){
            for(int i=arr.length-1; i > 0; i--){
                arr[i] = arr[i-1];
            }
            arr[0] = c;
        }

        public boolean isVallid(){
            for(int i=0; i<arr.length;i++){
                for(int j=i+1; j<arr.length; j++){
                    if(arr[i] == arr[j]) return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        String line = new Scanner(System.in).nextLine();
        System.out.println(findMarker(line));
    }

    static int findMarker(String line){
        Buffer b = new Buffer(4);
        for(int i=0; i<line.length(); i++){
            b.add(line.charAt(i));
            if(b.isVallid() && i >= 3) return i+1;
        }
        return -1;
    }
}
