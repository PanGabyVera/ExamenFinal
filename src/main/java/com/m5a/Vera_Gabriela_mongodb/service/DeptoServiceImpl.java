/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.Vera_Gabriela_mongodb.service;

import com.m5a.Vera_Gabriela_mongodb.model.Depto;
import com.m5a.Vera_Gabriela_mongodb.repository.DeptoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;


@Service
public class DeptoServiceImpl extends GenericServiceImpl<Depto, Long> implements DeptoService {

    @Autowired
    DeptoRepository Repository;

    @Override
    public CrudRepository<Depto, Long> getDao() {
        return Repository;
    }

}
