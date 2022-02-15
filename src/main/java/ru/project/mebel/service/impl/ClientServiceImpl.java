package ru.project.mebel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.dto.ClientDto;
import ru.project.mebel.entity.Client;
import ru.project.mebel.repo.ClientRepo;
import ru.project.mebel.service.ClientService;
import ru.project.mebel.util.AppUtils;

@Service
public class ClientServiceImpl implements ClientService {
    private final ClientRepo repo;

    @Autowired
    public ClientServiceImpl(ClientRepo repo) {
        this.repo = repo;
    }

    @Override
    public Flux<ClientDto> getClients() {
        return repo.
                findAll().
                map(AppUtils::clientToDto);
    }

    @Override
    public Mono<ClientDto> getClient(String id) {
        return repo.
                findById(id).map(AppUtils::clientToDto);
    }

    @Override
    public Flux<ClientDto> getClientInRange(double min, double max) {
        return repo.findByAgeBetween(Range.closed(min, max));
    }

    @Override
    public Mono<ClientDto> saveClient(Mono<ClientDto> client) {
        return client.map(AppUtils::dtoToClient)
                .flatMap(repo::insert)
                .map(AppUtils::clientToDto);
    }

    @Override
    public Mono<ClientDto> updateClient(Mono<ClientDto> client, String id) {
        return repo.findById(id).flatMap(c -> client.map(AppUtils::dtoToClient))
                .doOnNext(e -> e.setId(id))
                .flatMap(repo::save)
                .map(AppUtils::clientToDto);
    }

    @Override
    public Mono<Void> deleteClient(String id) {
        return repo.deleteById(id);
    }
}
