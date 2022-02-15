package ru.project.mebel.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.project.mebel.entity.Message;

public interface MessageRepo extends ReactiveMongoRepository<Message, String> {
}
