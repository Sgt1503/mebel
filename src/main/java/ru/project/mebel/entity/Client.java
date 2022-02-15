package ru.project.mebel.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "clients")
@Getter
public class Client {
    @Id
    private String id;
    private String name;
    private String secondName;
    private int age;
    private Role role;
    @DocumentReference
    private List<Apartment> apartments;
    @DocumentReference
    private List<Message> messages;
}
