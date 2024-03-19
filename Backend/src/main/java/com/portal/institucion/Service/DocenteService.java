package com.portal.institucion.Service;

import com.portal.institucion.Dto.DocenteDto;
import com.portal.institucion.Dto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public interface DocenteService {
    public ResponseDto getAllDocentes();
    public ResponseDto getDocente(Integer profesor_id);
    public  ResponseDto addDocente(DocenteDto docente);
    public ResponseDto updateDocente(DocenteDto docente);
    public ResponseDto deleteDocente(Integer profesor_id);
}
