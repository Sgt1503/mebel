package ru.project.mebel.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.entity.Message;

public interface MessageService {
    public Mono<Message> sendMessage(Mono<Message> message);
    public Mono<Message> deleteMessage(Mono<Message> message);
    public Mono<Message> editMessage(Mono<Message> message, String id);
    public Flux<Message> getMessages(Flux<Message> messages);
}
