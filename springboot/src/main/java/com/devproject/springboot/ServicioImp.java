package com.devproject.springboot;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicioImp implements Servicio {

    @Autowired
    private Repository repository;

    @Override
    @Transactional(readOnly = true)
    public Iterable<Curso> findAll(){
        return repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Curso> findById(Long id){
        return repository.findById(id);
    }
    
    @Override
    @Transactional
    public Curso save(Curso curso){
        return repository.save(curso);
    }

    @Override
    @Transactional
    public void deleteById(Long id){
        repository.deleteById(id);
    }

}
