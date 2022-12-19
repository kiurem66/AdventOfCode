package day7;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;


public class FileSystem {

    Deque<Directory> dirStack = new ArrayDeque<>();
    Directory pointer = new Directory("/");


    public void cd(String name) {
        if(name.equals("..")){
            pointer = dirStack.pop();
            return;
        }
        if(name.equals("/")){
            if(!dirStack.isEmpty()) pointer = dirStack.peekLast();
            return;
        }
        dirStack.push(pointer);
        pointer = pointer.getSubDirectory(name);
    }

    public void addDir(String name) {
        pointer.add(new Directory(name));
    }

    public void addFile(String name, int size) {
        pointer.add(new File(name, size));
    }

    public int getBigDirSum(){
        Queue<Directory> sumQueue = new ArrayDeque<>();
        sumQueue.add(getRoot());
        int sum=0;

        while(!sumQueue.isEmpty()){
            Directory curr = sumQueue.remove();
            for(Directory sub : curr){
                sumQueue.add(sub);
            }
            if(curr.size() <= 100000) sum+=curr.size();
        }

        return sum;
    }

    public String getCurr(){
        return pointer.name();
    }

    void print(){
        getRoot().print();
    }

    public Directory getRoot(){
        if(dirStack.isEmpty()) return pointer;
        return dirStack.peekLast();
    }

    public int getDelDir(int totalSize, int needed) {
        int toFree = needed - (totalSize - getRoot().size());

        Queue<Directory> sumQueue = new ArrayDeque<>();
        sumQueue.add(getRoot());
        int min=getRoot().size();

        while(!sumQueue.isEmpty()){
            Directory curr = sumQueue.remove();
            for(Directory sub : curr){
                sumQueue.add(sub);
            }
            if(curr.size() >= toFree && curr.size() < min) min = curr.size();
        }
        return min;
    }
}
