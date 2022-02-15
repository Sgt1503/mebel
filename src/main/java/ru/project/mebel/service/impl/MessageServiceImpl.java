package ru.project.mebel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.entity.Message;
import ru.project.mebel.repo.MessageRepo;
import ru.project.mebel.service.MessageService;
@Service
public class MessageServiceImpl implements MessageService {
    @Autowired
    private MessageRepo repo;

    @Override
    public Mono<Message> sendMessage(Mono<Message> message) {
        return message.flatMap(repo::insert);
    }

    @Override
    public Mono<Message> deleteMessage(Mono<Message> message) {
        return null;
    }

    @Override
    public Mono<Message> editMessage(Mono<Message> message, String id) {
        return repo.findById(id)
                .doOnNext(e -> e.setId(id))
                .flatMap(repo::save);

    }

    @Override
    public Flux<Message> getMessages(Flux<Message> messages) {
        return repo.findAll();
    }
}
