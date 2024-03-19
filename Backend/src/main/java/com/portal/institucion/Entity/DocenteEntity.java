package com.portal.institucion.Entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Builder
@Table(name = "Profesores")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DocenteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer profesor_id;
    private String profesor_name;
    private String profesor_lastname;
    private String profesor_dni;
    private String profesor_email;
}