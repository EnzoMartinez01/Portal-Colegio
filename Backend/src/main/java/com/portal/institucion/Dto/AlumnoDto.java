package com.portal.institucion.Dto;

import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDto {
    private Integer alumno_id;
    private String alumno_name;
    private String alumno_lastname;
    private String alumno_dni;
    private String alumno_email;
    private String alumno_age;
}
