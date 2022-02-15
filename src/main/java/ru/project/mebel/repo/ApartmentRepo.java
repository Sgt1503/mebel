package ru.project.mebel.repo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.project.mebel.entity.Apartment;

public interface ApartmentRepo extends ReactiveMongoRepository<Apartment, String> {
}
