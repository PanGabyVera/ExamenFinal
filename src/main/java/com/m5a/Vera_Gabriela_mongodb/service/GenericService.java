/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.m5a.Vera_Gabriela_mongodb.service;

import java.io.Serializable;
import java.util.List;


public interface GenericService<T, ID extends Serializable> {

//T representa a la clase, es una forma generica
//y vale para toda bd

    public T save(T entity);

    public T findById(ID id);

    public List<T> findByAll();

    public void delete(ID id);

}
