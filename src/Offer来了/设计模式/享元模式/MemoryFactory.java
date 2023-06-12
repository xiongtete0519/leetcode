package Offer来了.设计模式.享元模式;

import com.alibaba.fastjson2.JSON;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryFactory {
    //内存对象列表
    private static List<Memory> memoryList=new ArrayList<>();
    public static Memory getMemory(int size){
        Memory memory=null;
        for (int i = 0; i <memoryList.size() ; i++) {
            memory = memoryList.get(i);
            //如果存在和需求size一样大小并且未使用的内存块，则直接返回
            if(memory.getSize()==size&&memory.isUsed()==false){
                memory.setUsed(true);
                memoryList.set(i,memory);
                System.out.println(JSON.toJSONString(memory));
                break;
            }
        }
        //如果所需内存不存在，则从系统中申请新的内存返回，并将该内存加入内存对象列表中
        if(memory==null){
            memory=new Memory(32,false, UUID.randomUUID().toString());
            System.out.println("create a new memory from system and add to memoryList:"+JSON.toJSONString(memory));
            memoryList.add(memory);
        }
        return memory;
    }

    //释放内存
    public static void releaseMemory(String id){
        for (int i = 0; i <memoryList.size() ; i++) {
            Memory memory = memoryList.get(i);
            //根据id释放内存
            if(memory.getId().equals(id)){
                memory.setUsed(false);
                memoryList.set(i,memory);
                System.out.println("release memory:"+id);
                break;
            }
        }
    }

    //使用享元模式
    public static void main(String[] args) {
        //首次获取内存，将创建一个内存
        Memory memory = MemoryFactory.getMemory(32);
        //在使用后释放内存
        MemoryFactory.releaseMemory(memory.getId());
        //重新获取内存
        MemoryFactory.getMemory(32);
    }
}
