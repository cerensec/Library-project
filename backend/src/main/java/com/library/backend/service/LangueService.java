package com.library.backend.service;

import com.library.backend.model.Langue;

import java.util.List;

public interface LangueService {

    List<Langue> getAll();

    Langue getLangueById(int id);
}
