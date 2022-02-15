package ru.project.mebel.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.dto.ClientDto;

public interface ClientService {
    public Flux<ClientDto> getClients();
    public Mono<ClientDto> getClient(String id);
    public Flux<ClientDto> getClientInRange(double min, double max);
    public Mono<ClientDto> saveClient(Mono<ClientDto> client);
    public Mono<ClientDto> updateClient(Mono<ClientDto> client, String id);
    public Mono<Void> deleteClient(String id);
}
