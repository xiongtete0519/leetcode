package Offer来了.设计模式.享元模式;

public class Memory {
    private int size;   //内存大小，单位为MB
    private boolean isUsed; //内存是否在被使用
    private String id;  //内存ID

    public Memory(int size, boolean isUsed, String id) {
        this.size = size;
        this.isUsed = isUsed;
        this.id = id;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public boolean isUsed() {
        return isUsed;
    }

    public void setUsed(boolean used) {
        isUsed = used;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
