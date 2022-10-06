/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.m5a.Vera_Gabriela_mongodb.controller;

import com.m5a.Vera_Gabriela_mongodb.model.Depto;
import com.m5a.Vera_Gabriela_mongodb.service.DeptoService;
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

@RestController
@RequestMapping("/api/depto")
public class DeptoController {

    @Autowired
    DeptoService service;

    @GetMapping("/lista")
    public ResponseEntity<List<Depto>> listar() {
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
    public ResponseEntity<?> crear(@RequestBody Depto e) {
        if (e.getNombre().isEmpty() || e.getDireccion().isEmpty() || e.getDirector().isEmpty()) {
            return new ResponseEntity<>("Deben estar llenos todos los campos", HttpStatus.BAD_REQUEST);
            //.matches("[a-zA-Z]")
        } else if (!e.getNombre().matches("[a-zA-Z]*") || !e.getDireccion().matches("[a-zA-Z]*") || !e.getDirector().matches("[a-zA-Z]*")) {
            return new ResponseEntity<>("Debe ser solo letras", HttpStatus.BAD_REQUEST);

        } else if (e.getNombre().length() >= 25) {
            return new ResponseEntity<>("El nombre es muy grande", HttpStatus.BAD_REQUEST);

        } else if (e.getDireccion().length() > 50 || e.getDirector().length() > 50) {
            return new ResponseEntity<>("La direccion o el director es muy grande", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.save(e), HttpStatus.CREATED);
        }
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Depto> eliminar(@PathVariable Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<?> actualizar(@PathVariable Long id, @RequestBody Depto e) {
        Depto p = service.findById(id);
        if (p == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            try {
                if (e.getNombre().isEmpty() || e.getDireccion().isEmpty() || e.getDirector().isEmpty()) {
                    return new ResponseEntity<>("Deben estar llenos todos los campos", HttpStatus.BAD_REQUEST);
                    //.matches("[a-zA-Z]")
                } else if (!e.getNombre().matches("[a-zA-Z]*") || !e.getDireccion().matches("[a-zA-Z]*") || !e.getDirector().matches("[a-zA-Z]*")) {
                    return new ResponseEntity<>("Debe ser solo letras", HttpStatus.BAD_REQUEST);

                } else if (e.getNombre().length() >= 25) {
                    return new ResponseEntity<>("El nombre es muy grande", HttpStatus.BAD_REQUEST);

                } else if (e.getDireccion().length() > 50 || e.getDirector().length() > 50) {
                    return new ResponseEntity<>("La direccion o el director es muy grande", HttpStatus.BAD_REQUEST);
                } else {
                    p.setNombre(e.getNombre());
                    p.setDireccion(e.getDireccion());
                    p.setDirector(e.getDirector());
                }
                return new ResponseEntity<>(service.save(e), HttpStatus.OK);
            } catch (Exception ex) {
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }

        }
    }

}
