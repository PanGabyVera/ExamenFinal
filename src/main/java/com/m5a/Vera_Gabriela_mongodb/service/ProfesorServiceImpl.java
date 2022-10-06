/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.Vera_Gabriela_mongodb.service;

import com.m5a.Vera_Gabriela_mongodb.model.Profesor;
import com.m5a.Vera_Gabriela_mongodb.repository.ProfesorRepository;
import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author DDinamic
 */
@Service
public class ProfesorServiceImpl extends GenericServiceImpl<Profesor, Long> implements ProfesorService {

    @Autowired
    ProfesorRepository Repository;

    @Override
    public CrudRepository<Profesor, Long> getDao() {
        return Repository;
    }

}
