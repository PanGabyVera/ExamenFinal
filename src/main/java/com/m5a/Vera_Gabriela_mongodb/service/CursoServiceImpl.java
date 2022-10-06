/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m5a.Vera_Gabriela_mongodb.service;

import com.m5a.Vera_Gabriela_mongodb.model.Curso;
import com.m5a.Vera_Gabriela_mongodb.repository.CursoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

/**
 *
 * @author ISTA
 */
@Service
public class CursoServiceImpl extends GenericServiceImpl<Curso, Long> implements CursoService{

   @Autowired
    CursoRepository Repository;

    @Override
    public CrudRepository<Curso, Long> getDao() {
        return Repository;
    }
    
}
