/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.Vera_Gabriela_mongodb.repository;

import com.m5a.Vera_Gabriela_mongodb.model.Depto;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface DeptoRepository extends MongoRepository<Depto, Long>{
    
}
