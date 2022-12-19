package day7;

public class File implements FSElement{

    private String name;
    private int size;

    public File(String name, int size) {
        this.name=name;
        this.size=size;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String name() {
        return name;
    }

    @Override
    public boolean isDir() {
        return false;
    }

}
