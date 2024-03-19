package com.portal.institucion.Service.Implement;

import com.portal.institucion.Dto.DocenteDto;
import com.portal.institucion.Dto.ResponseDto;
import com.portal.institucion.Entity.DocenteEntity;
import com.portal.institucion.Repository.DocenteRepository;
import com.portal.institucion.Service.DocenteService;
import com.portal.institucion.Util.Constante;
import com.portal.institucion.Util.Util;
import org.apache.tomcat.util.bcel.Const;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DocenteServiceImplement implements DocenteService {

    @Autowired
    private DocenteRepository docRep;

    @Override
    public ResponseDto getAllDocentes(){
        try{
            List<DocenteEntity> listDocenteEntity = docRep.findAll();
            if(listDocenteEntity.isEmpty()){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            List<DocenteDto> listDocenteDto = new ArrayList<DocenteDto>();
            for (DocenteEntity docenteEntity : listDocenteEntity){
                listDocenteDto.add(DocenteDto.builder()
                        .profesor_id(docenteEntity.getProfesor_id())
                        .profesor_name(docenteEntity.getProfesor_name())
                        .profesor_lastname(docenteEntity.getProfesor_lastname())
                        .profesor_dni(docenteEntity.getProfesor_dni())
                        .profesor_email(docenteEntity.getProfesor_email())
                        .build());
            }
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, listDocenteDto);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto getDocente(Integer profesor_id){
        try{
            DocenteEntity docenteEntity = docRep.findById(profesor_id).orElse(null);
            if (null == docenteEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            DocenteDto docenteDto = DocenteDto.builder()
                    .profesor_id(docenteEntity.getProfesor_id())
                    .profesor_name(docenteEntity.getProfesor_name())
                    .profesor_lastname(docenteEntity.getProfesor_lastname())
                    .profesor_dni(docenteEntity.getProfesor_dni())
                    .profesor_email(docenteEntity.getProfesor_email())
                    .build();
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, docenteDto);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto addDocente(DocenteDto docente){
        try{
            DocenteEntity docenteEntity = DocenteEntity.builder()
                    .profesor_name(docente.getProfesor_name())
                    .profesor_lastname(docente.getProfesor_lastname())
                    .profesor_dni(docente.getProfesor_dni())
                    .profesor_email(docente.getProfesor_email())
                    .build();
            docRep.save(docenteEntity);
            docente.setProfesor_id(docenteEntity.getProfesor_id());
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, docente);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto updateDocente(DocenteDto docente){
        try {
            DocenteEntity docenteEntity = docRep.findById(docente.getProfesor_id()).orElse(null);
            if(null == docenteEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            docenteEntity.setProfesor_name(docente.getProfesor_name());
            docenteEntity.setProfesor_lastname(docente.getProfesor_lastname());
            docenteEntity.setProfesor_dni(docente.getProfesor_dni());
            docenteEntity.setProfesor_email(docente.getProfesor_email());
            docRep.save(docenteEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, docente);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }

    @Override
    public ResponseDto deleteDocente(Integer profesor_id){
        try{
            DocenteEntity docenteEntity = docRep.findById(profesor_id).orElse(null);
            if(null == docenteEntity){
                return Util.getResponse(true, Constante.NO_RECORDS_FOUND, null);
            }
            docRep.delete(docenteEntity);
            return Util.getResponse(true, Constante.OPERATION_SUCCESS, null);
        } catch (Exception e){
            return Util.getResponse(false, Constante.OPERATION_FAILED, null);
        }
    }
}
