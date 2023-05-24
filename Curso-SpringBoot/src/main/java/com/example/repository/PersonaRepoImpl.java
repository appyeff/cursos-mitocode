package com.example.repository;

import com.example.CursoSpringBootApplication;
import com.example.model.Persona;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonaRepoImpl implements IPersonaRepo {

    private static Logger LOG = LoggerFactory.getLogger(CursoSpringBootApplication.class);

    @Override
    public void registrar(String nombre) {
        LOG.info("Se registro a " + nombre);
    }

}
