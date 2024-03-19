package com.portal.institucion.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "Alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class AlumnoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer alumno_id;
    private String alumno_name;
    private String alumno_lastname;
    private String alumno_dni;
    private String alumno_email;
    private String alumno_age;
}
