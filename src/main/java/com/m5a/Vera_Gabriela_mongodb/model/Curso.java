/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m5a.Vera_Gabriela_mongodb.model;
import org.springframework.data.annotation.Id;


/**
 *
 * @author ISTA
 */
public class Curso {
    @Id
private Long curso_id;
private Profesor prof_id;
private String nombre;
private String descripcion;
private String nivel;

    public Curso() {
    }

    public Long getCurso_id() {
        return curso_id;
    }

    public void setCurso_id(Long curso_id) {
        this.curso_id = curso_id;
    }

    public Profesor getProf_id() {
        return prof_id;
    }

    public void setProf_id(Profesor prof_id) {
        this.prof_id = prof_id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNivel() {
        return nivel;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }

    
}
