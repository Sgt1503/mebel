package ru.project.mebel.entity;


import lombok.Data;
import org.bson.BsonBinarySubType;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class SVG {
    @Id
    private String id;
    private String title;
    private Binary file;

    public void setFile(Binary file) {
        this.file = new Binary(BsonBinarySubType.BINARY, file.getData());
    }
}