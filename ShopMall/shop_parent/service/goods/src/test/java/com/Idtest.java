package com;
import com.common.util.IdWorker;

public class Idtest {
    public static void main(String[] args) {
        IdWorker idWorker = new IdWorker(1,1); //workerId 工作机器的id   序列号大小
        long id = idWorker.nextId();
        System.out.println(id);
    }
}
