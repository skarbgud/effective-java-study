package me.whiteship.chapter01.item3;

import java.io.*;

// 역직렬화로 여러 인스턴스 만들기
public class ElvisSerialization {

    public static void main(String[] args) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("elvis.obj"))) {
            out.writeObject(Elvis.INSTANCE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInput in = new ObjectInputStream(new FileInputStream("elvis.obj"))){
            Elvis elvis3 = (Elvis) in.readObject();
            System.out.println(elvis3 == Elvis.INSTANCE); //역직렬화를 할 때 마다 새로운 인스턴스가 반환
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
