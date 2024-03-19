package com.portal.institucion.Controller;

import com.portal.institucion.Dto.AlumnoDto;
import com.portal.institucion.Dto.ResponseDto;
import com.portal.institucion.Service.AlumnosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/portal/alumnos")
@CrossOrigin("*")
public class AlumnosController {

    @Autowired
    private AlumnosService aluService;

    //Metodo para listar todos los alumnos
    @GetMapping("/getalumnos")
    public ResponseEntity<ResponseDto> readAllAlumnos(){
        return ResponseEntity.status(HttpStatus.OK).body(aluService.getAlumnosAll());
    }

    //Metodo para listar Alumno por ID
    @GetMapping("/getalumno/{alumno_id}")
    public ResponseEntity<ResponseDto> readAlumno(@PathVariable("alumno_id") Integer alumno_id){
        return ResponseEntity.status(HttpStatus.OK).body(aluService.getAlumno(alumno_id));
    }

    //Metodo para crear Alumnos
    @PostMapping("/createalumno")
    public ResponseEntity<ResponseDto> createAlumno(@RequestBody AlumnoDto alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(aluService.addAlumno(alumno));
    }

    //Metodo para actualizar Alumno
    @PutMapping("/updatealumno")
    public ResponseEntity<ResponseDto> updateAlumno(@RequestBody AlumnoDto alumno){
        return ResponseEntity.status(HttpStatus.CREATED).body(aluService.updateAlumno(alumno));
    }

    //Metodo para eliminar Alumno
    @DeleteMapping("/deletealumno/{alumno_id}")
    public ResponseEntity<ResponseDto> deleteAlumno(@PathVariable("alumno_id") Integer alumno_id){
        return ResponseEntity.status(HttpStatus.OK).body(aluService.deleteAlumno(alumno_id));
    }
}
