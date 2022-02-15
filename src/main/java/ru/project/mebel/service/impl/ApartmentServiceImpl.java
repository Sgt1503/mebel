package ru.project.mebel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.dto.ApartmentDto;
import ru.project.mebel.entity.Apartment;
import ru.project.mebel.repo.ApartmentRepo;
import ru.project.mebel.service.ApartmentService;
import ru.project.mebel.util.AppUtils;

@Service
public class ApartmentServiceImpl implements ApartmentService {
    private final ApartmentRepo repo;

    @Autowired
    public ApartmentServiceImpl(ApartmentRepo apartmentRepo) {
        this.repo = apartmentRepo;
    }

    @Override
    public Mono<ApartmentDto> saveApartment(Mono<ApartmentDto> apartmentDto) {
        return apartmentDto.map(AppUtils::dtoToApartment)
                .flatMap(repo::insert)
                .map(AppUtils::apartmentToDto);
    }

    @Override
    public Mono<ApartmentDto> getApartment(String id) {
        return repo.
                findById(id)
                .map(AppUtils::apartmentToDto);
    }

    @Override
    public Flux<ApartmentDto> getApartments() {
        return repo.findAll().map(AppUtils::apartmentToDto);
    }

    @Override
    public Mono<ApartmentDto> updateApartment(Mono<ApartmentDto> apartmentDto, String id) {
        return repo.findById(id).flatMap(a -> apartmentDto.map(AppUtils::dtoToApartment))
                .doOnNext(e -> e.setId(id))
                .flatMap(repo::save)
                .map(AppUtils::apartmentToDto);
    }
}
