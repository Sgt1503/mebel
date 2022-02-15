package ru.project.mebel.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import ru.project.mebel.entity.SVG;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApartmentDto {
    @Id
    private String id;
    private SVG svg;
}
