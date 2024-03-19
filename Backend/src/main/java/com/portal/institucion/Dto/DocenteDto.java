package com.portal.institucion.Dto;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DocenteDto {
    private Integer profesor_id;
    private String profesor_name;
    private String profesor_lastname;
    private String profesor_dni;
    private String profesor_email;
}
