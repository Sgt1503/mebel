package ru.project.mebel.entity;

import lombok.Data;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class Message {
    @Id
    String id;
    String targetId;
    String text;
    Binary attachment;
}
