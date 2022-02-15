package ru.project.mebel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.dto.ApartmentDto;
import ru.project.mebel.service.ApartmentService;

@RestController
@RequestMapping("/apartments")
public class ApartmentController {
    @Autowired
    private ApartmentService apartmentService;

    @GetMapping
    public Flux<ApartmentDto> clients(){
        return apartmentService.getApartments();
    }

    @GetMapping("/{id}")
    public Mono<ApartmentDto> getApartment(@PathVariable String id){
        return apartmentService.getApartment(id);
    }

    @PostMapping
    public Mono<ApartmentDto> saveApartment(@RequestBody Mono<ApartmentDto> apartmentDto){
        return apartmentService.saveApartment(apartmentDto);
    }

    @PutMapping("/update/{id}")
    public Mono<ApartmentDto> updateApartment(@RequestBody Mono<ApartmentDto> apartmentDto,
                                        @PathVariable String id){
        return apartmentService.updateApartment(apartmentDto, id);
    }
}
