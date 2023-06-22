package com.devproject.springboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controllador {
    @Autowired
    private Servicio servicio;

    @GetMapping
    public ResponseEntity<?> devolverCursos(){
        return ResponseEntity.ok().body(servicio.findAll());
    }   

    @GetMapping("/{id}")
    public ResponseEntity<?> devolverCurso(@PathVariable Long id){
        Optional<Curso> cu = servicio.findById(id);
        
        if(cu.isEmpty()){
            return ResponseEntity.notFound().build();
        } else{
            return ResponseEntity.ok(cu.get());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> borrar(@PathVariable Long id){
        servicio.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<?> addCurso(@RequestBody Curso curso){
        Curso cu = servicio.save(curso);
        return ResponseEntity.status(HttpStatus.CREATED).body(cu);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editarCurso(@RequestBody Curso curso,@PathVariable Long id){
        Optional<Curso> cu = servicio.findById(id);

        if(cu.isEmpty()){
            return ResponseEntity.notFound().build();
        } 
        Curso ocurso = cu.get();
        ocurso.setTitulo(curso.getTitulo());
        ocurso.setDescription(curso.getDescription());
        ocurso.setFechaCreacion(curso.getFechaCreacion());
        ocurso.setId(id);
        ocurso.setThumbnail(curso.getThumbnail());
        ocurso.setUrl(curso.getUrl());

        Curso ocurso2 = servicio.save(ocurso);

        return ResponseEntity.status(HttpStatus.CREATED).body(ocurso2);
    }

}
