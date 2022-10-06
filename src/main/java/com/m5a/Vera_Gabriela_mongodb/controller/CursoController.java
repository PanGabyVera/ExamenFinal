/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.m5a.Vera_Gabriela_mongodb.controller;

import com.m5a.Vera_Gabriela_mongodb.model.Curso;
import com.m5a.Vera_Gabriela_mongodb.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ISTA
 */
@RestController
@RequestMapping("/api/curso")
public class CursoController {

    @Autowired
    CursoService service;

    @GetMapping("/lista")
    public ResponseEntity<List<Curso>> listar() {
        return new ResponseEntity<>(service.findByAll(), HttpStatus.OK);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<?> buscar(@PathVariable Long id) {
        if (id <= 0) {
            return new ResponseEntity<>("Valor no valido", HttpStatus.BAD_REQUEST);
        } else if (service.findById(id) == null) {
            return new ResponseEntity<>("Valor no encontrado", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<?> crear(@RequestBody Curso e) {
        if (e.getNombre().isEmpty() || e.getDescripcion().isEmpty() || e.getNivel().isEmpty() || e.getProf_id().equals(0)) {
            return new ResponseEntity<>("Deben estar llenos todos los campos", HttpStatus.BAD_REQUEST);
            //.matches("[a-zA-Z]")
        } else if (!e.getNombre().matches("[a-zA-Z]*") || !e.getDescripcion().matches("[a-zA-Z]*") || !e.getNivel().matches("[a-zA-Z]*")) {
            return new ResponseEntity<>("Debe ser solo letras", HttpStatus.BAD_REQUEST);

        } else if (e.getNombre().length() >= 25) {
            return new ResponseEntity<>("El nombre es muy grande", HttpStatus.BAD_REQUEST);

        } else if (e.getDescripcion().length() > 50 || e.getNivel().length() > 50) {
            return new ResponseEntity<>("La deescripcion o el nivel es muy grande", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.save(e), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Curso> eliminar(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Curso e) {
        Curso p = service.findById(id);
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {

                if (e.getNombre().isEmpty() || e.getDescripcion().isEmpty() || e.getNivel().isEmpty() || e.getProf_id().equals(0)) {
                    return new ResponseEntity<>("Deben estar llenos todos los campos", HttpStatus.BAD_REQUEST);
                    //.matches("[a-zA-Z]")
                } else if (!e.getNombre().matches("[a-zA-Z]*") || !p.getDescripcion().matches("[a-zA-Z]*")) {
                    return new ResponseEntity<>("Debe ser solo letras", HttpStatus.BAD_REQUEST);

                } else if (e.getNombre().length() >= 25) {
                    return new ResponseEntity<>("El nombre es muy grande", HttpStatus.BAD_REQUEST);

                } else if (e.getDescripcion().length() > 50 || e.getNivel().length() > 50) {
                    return new ResponseEntity<>("La deescripcion o el nivel es muy grande", HttpStatus.BAD_REQUEST);
                } else {
                    
                p.setNombre(e.getNombre());
                p.setDescripcion(e.getDescripcion());
                p.setNivel(e.getNivel());
                p.setProf_id(e.getProf_id());
                
                }
                return new ResponseEntity<>(service.save(e), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }
}
