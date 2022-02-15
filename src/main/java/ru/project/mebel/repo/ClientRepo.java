package ru.project.mebel.repo;

import org.springframework.data.domain.Range;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import ru.project.mebel.dto.ClientDto;
import ru.project.mebel.entity.Client;

@Repository
public interface ClientRepo extends ReactiveMongoRepository<Client, String> {
    Flux<ClientDto> findByAgeBetween(Range<Double> closed);
}
