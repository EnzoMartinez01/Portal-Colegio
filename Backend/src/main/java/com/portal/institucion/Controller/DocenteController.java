package com.portal.institucion.Controller;

import com.portal.institucion.Dto.DocenteDto;
import com.portal.institucion.Dto.ResponseDto;
import com.portal.institucion.Service.DocenteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/portal/docentes")
@CrossOrigin("*")
public class DocenteController {

    @Autowired
    private DocenteService docService;

    //Metodo para listar todos los profesores
    @GetMapping("/getdocentes")
    public ResponseEntity<ResponseDto> readAllDocentes(){
        return ResponseEntity.status(HttpStatus.OK).body(docService.getAllDocentes());
    }

    //Metodo para listar profesor por ID
    @GetMapping("/getdocente/{profesor_id}")
    public ResponseEntity<ResponseDto> readDocente(@PathVariable("profesor_id") Integer profesor_id){
        return ResponseEntity.status(HttpStatus.OK).body(docService.getDocente(profesor_id));
    }

    //Metodo para crear Profesor
    @PostMapping("/createdocente")
    public ResponseEntity<ResponseDto> createDocente(@RequestBody DocenteDto docente){
        return ResponseEntity.status(HttpStatus.CREATED).body(docService.addDocente(docente));
    }

    //Metodo para actualizar Profesor
    @PutMapping("/updatedocente")
    public ResponseEntity<ResponseDto> updateDocente(@RequestBody DocenteDto docente){
        return ResponseEntity.status(HttpStatus.CREATED).body(docService.updateDocente(docente));
    }

    //Metodo para eliminar Profesor
    @DeleteMapping("/deletedocente/{profesor_id}")
    public ResponseEntity<ResponseDto> deleteDocente(@PathVariable("profesor_id") Integer profesor_id){
        return ResponseEntity.status(HttpStatus.OK).body(docService.deleteDocente(profesor_id));
    }
}
