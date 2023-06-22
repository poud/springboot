package com.devproject.springboot;

import java.util.Optional;

public interface Servicio {

    public Iterable<Curso> findAll();

    public Optional<Curso> findById(Long id);

    public Curso save(Curso curso);

    public void deleteById(Long id);

}
