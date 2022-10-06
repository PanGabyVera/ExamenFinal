/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m5a.Vera_Gabriela_mongodb.repository;

import com.m5a.Vera_Gabriela_mongodb.model.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author ISTA
 */
public interface CursoRepository extends MongoRepository<Curso, Long>{
    
}
