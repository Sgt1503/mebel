package ru.project.mebel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.DocumentReference;
import ru.project.mebel.entity.Apartment;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientDto {
    private String id;
    private String name;
    private String secondName;
    private int age;
    @DocumentReference
    private List<Apartment> apartments;
}