package com.portal.institucion.Service.Implement;

import com.portal.institucion.Dto.AlumnoDto;
import com.portal.institucion.Dto.ResponseDto;
import com.portal.institucion.Entity.AlumnoEntity;
import com.portal.institucion.Repository.AlumnoRepository;
import com.portal.institucion.Service.AlumnosService;
import com.portal.institucion.Util.Constante;
import com.portal.institucion.Util.Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AlumnosServiceImplement implements AlumnosService {
    @Autowired
    private AlumnoRepository aluRep;

    @Override
    public ResponseDto getAlumnosAll(){
        try{
            List<AlumnoEntity> listAlumnoEntity = aluRep.findAll();
            if (listAlumnoEntity.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<AlumnoDto> listAlumnoDto = new ArrayList<AlumnoDto>();
            for (AlumnoEntity alumnoEntity : listAlumnoEntity){
                listAlumnoDto.add(AlumnoDto.builder()
                        .alumno_id(alumnoEntity.getAlumno_id())
                        .alumno_name(alumnoEntity.getAlumno_name())
                        .alumno_lastname(alumnoEntity.getAlumno_lastname())
                        .alumno_dni(alumnoEntity.getAlumno_dni())
                        .alumno_email(alumnoEntity.getAlumno_email())
                        .alumno_age(alumnoEntity.getAlumno_age())
                        .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, listAlumnoDto);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getAlumno(Integer alumno_id){
        try{
            AlumnoEntity alumnoEntity = aluRep.findById(alumno_id).orElse(null);
            if(null == alumnoEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            AlumnoDto alumnoDto = AlumnoDto.builder()
                    .alumno_id(alumnoEntity.getAlumno_id())
                    .alumno_name(alumnoEntity.getAlumno_name())
                    .alumno_lastname(alumnoEntity.getAlumno_lastname())
                    .alumno_dni(alumnoEntity.getAlumno_dni())
                    .alumno_email(alumnoEntity.getAlumno_email())
                    .alumno_age(alumnoEntity.getAlumno_age())
                    .build();
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, alumnoDto);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto addAlumno(AlumnoDto alumnos){
        try{
            AlumnoEntity alumnoEntity = AlumnoEntity.builder()
                    .alumno_name(alumnos.getAlumno_name())
                    .alumno_lastname(alumnos.getAlumno_lastname())
                    .alumno_dni(alumnos.getAlumno_dni())
                    .alumno_email(alumnos.getAlumno_email())
                    .alumno_age(alumnos.getAlumno_age())
                    .build();
            aluRep.save(alumnoEntity);
            alumnos.setAlumno_id(alumnoEntity.getAlumno_id());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, alumnos);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateAlumno(AlumnoDto alumnos){
        try {
            AlumnoEntity alumnoEntity = aluRep.findById(alumnos.getAlumno_id()).orElse(null);
            if(null == alumnoEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            alumnoEntity.setAlumno_name(alumnos.getAlumno_name());
            alumnoEntity.setAlumno_lastname(alumnos.getAlumno_lastname());
            alumnoEntity.setAlumno_dni(alumnos.getAlumno_dni());
            alumnoEntity.setAlumno_email(alumnos.getAlumno_email());
            alumnoEntity.setAlumno_age(alumnos.getAlumno_age());
            aluRep.save(alumnoEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, alumnos);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto deleteAlumno(Integer alumno_id){
        try{
            AlumnoEntity alumnoEntity = aluRep.findById(alumno_id).orElse(null);
            if(null == alumnoEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            aluRep.delete(alumnoEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
}
