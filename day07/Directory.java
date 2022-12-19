package day7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Directory implements FSElement, Iterable<Directory>{
    private String name;
    List<FSElement> elements = new ArrayList<>();

    public Directory(String name){
        this.name=name;
    }


    public void add(FSElement element){
        elements.add(element);
    }

    @Override
    public int size() {
        int sum=0;
        for(FSElement element : elements){
            sum+=element.size();
        }
        return sum;
    }


    @Override
    public String name() {
        return name;
    }


    @Override
    public boolean isDir() {
        return true;
    }

    public Directory getSubDirectory(String name){
        for(FSElement element : elements){
            if(element.name().equals(name)){
                return (Directory) element;
            }
        }
        return null;
    }


    @Override
    public Iterator<Directory> iterator() {
        List<Directory> subdirs = new ArrayList<>();
        for(FSElement element : elements){
            if(element.isDir()) subdirs.add((Directory)element);
        }
        return Collections.unmodifiableList(subdirs).iterator();
    }


    @Override
    public void print(int tabNum) {
        for(int i=0; i<tabNum; i++){
            System.out.print("\t");
        }
        System.out.println(name);
        for(FSElement element : elements){
            element.print(tabNum+1);
        }
    }


}
