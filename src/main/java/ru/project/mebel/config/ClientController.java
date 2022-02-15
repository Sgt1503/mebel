package ru.project.mebel.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import ru.project.mebel.dto.ClientDto;
import ru.project.mebel.service.ClientService;

@RestController
@RequestMapping("/clients")
public class ClientController {
    @Autowired
    private ClientService clientService;

    @GetMapping
    public Flux<ClientDto> clients(){
        return clientService.getClients();
    }

    @GetMapping("/{id}")
    public Mono<ClientDto> getClient(@PathVariable String id){
        return clientService.getClient(id);
    }

    @GetMapping("/clientsByRange")
    public Flux<ClientDto> getClientsByRange(@RequestParam double min,
                                             @RequestParam double max){
        return clientService.getClientInRange(min, max);
    }

    @PostMapping
    public Mono<ClientDto> saveClient(@RequestBody Mono<ClientDto> clientDtoMono){
        return clientService.saveClient(clientDtoMono);
    }

    @PutMapping("/update/{id}")
    public Mono<ClientDto> updateClient(@RequestBody Mono<ClientDto> clientDtoMono,
                                      @PathVariable String id){
        return clientService.updateClient(clientDtoMono, id);
    }
}
