package ru.project.mebel.util;

import org.springframework.beans.BeanUtils;
import ru.project.mebel.dto.ApartmentDto;
import ru.project.mebel.dto.ClientDto;
import ru.project.mebel.entity.Apartment;
import ru.project.mebel.entity.Client;

public class AppUtils {
    public static ClientDto clientToDto(Client client){
        ClientDto clientDto =  new ClientDto ();
        BeanUtils.copyProperties(client, clientDto);
        return clientDto;
    }

    public static Client dtoToClient(ClientDto clientDto){
        Client client =  new Client();
        BeanUtils.copyProperties(clientDto, client);
        return client;
    }

    public static ApartmentDto apartmentToDto(Apartment apartment){
        ApartmentDto apartmentDto =  new ApartmentDto();
        BeanUtils.copyProperties(apartment, apartmentDto);
        return apartmentDto;
    }

    public static Apartment dtoToApartment(ApartmentDto apartmentDto){
        Apartment apartment =  new Apartment();
        BeanUtils.copyProperties(apartmentDto, apartment);
        return apartment;
    }
}
