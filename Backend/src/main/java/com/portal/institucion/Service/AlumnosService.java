package com.portal.institucion.Service;

import com.portal.institucion.Dto.AlumnoDto;
import com.portal.institucion.Dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface AlumnosService {
    public ResponseDto getAlumnosAll();
    public ResponseDto getAlumno(Integer alumno_id);
    public ResponseDto addAlumno(AlumnoDto alumnos);
    public ResponseDto updateAlumno(AlumnoDto alumnos);
    public ResponseDto deleteAlumno(Integer alumno_id);
}
