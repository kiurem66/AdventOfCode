package day7;

import java.util.ArrayDeque;
import java.util.Deque;


public class FileSystem {

    Deque<Directory> dirStack = new ArrayDeque<>();
    Directory pointer = new Directory("/");

    public void cd(String name) {
        if(name.equals("..")){
            pointer = dirStack.pop();
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
        Directory d = null;
        if(dirStack.isEmpty()) d=pointer;
        else d=dirStack.peekFirst();
        return getBigDirSum(d);
    }

    private int getBigDirSum(Directory curr){ 
        int sum = 0;
        if(curr.size() < 100000) sum+=curr.size();
        for(Directory sub : curr){
            sum += getBigDirSum(sub);
        }
        return sum;
    }

    public String getCurr(){
        return pointer.name();
    }

    void print(){
        if(dirStack.isEmpty()) pointer.print();
        else dirStack.peekFirst().print();
    }
}
