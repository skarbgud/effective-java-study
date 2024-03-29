package me.whiteship.chapter01.item3.serialization;

import java.io.*;
import java.time.LocalDate;

public class SerializationExample {

    private void serialize(Book book) {
        try (ObjectOutput out = new ObjectOutputStream(new FileOutputStream("book.obj"))) {
            out.writeObject(book);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private Book deserialize() {
        try (ObjectInput in = new ObjectInputStream(new FileInputStream("book.obj"))) {
            return (Book) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        Book book = new Book("12345", "이팩티브 자바 완벽 공략", "백기선",
                LocalDate.of(2022, 3, 21));
        book.setNumberOfSold(200);
        Book.name = "gyuhyeong"; // 클래스에 할당된거라 직렬화에 포함되지 않는다.

        SerializationExample example = new SerializationExample();
        example.serialize(book);
        Book.name = "nam";
        Book deserializedBook = example.deserialize();

        System.out.println(book);
        System.out.println(deserializedBook);
        // 직렬화를 하고 클래스를 변경하면
    }
}