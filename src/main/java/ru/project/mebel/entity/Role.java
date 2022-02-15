package ru.project.mebel.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public enum Role {
    ADMIN, Client, Designer, Fabric
}
