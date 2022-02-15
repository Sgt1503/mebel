package ru.project.mebel.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.dto.ApartmentDto;

public interface ApartmentService {
    public Mono<ApartmentDto> getApartment(String id);
    public Flux<ApartmentDto> getApartments();
    public Mono<ApartmentDto> saveApartment(Mono<ApartmentDto> apartmentDto);
    public Mono<ApartmentDto> updateApartment(Mono<ApartmentDto> apartmentDto, String id);
}
