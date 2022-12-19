package day7;

public interface FSElement {
    int size();
    String name();
    boolean isDir();
    
    default void print(int tabNum){
        for(int i=0; i<tabNum; i++){
            System.out.print("\t");
        }
        System.out.println(name());
    }

    default void print(){
        print(0);
    }
}
