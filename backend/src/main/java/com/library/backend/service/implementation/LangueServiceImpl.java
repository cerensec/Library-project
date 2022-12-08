package com.library.backend.service.implementation;

import com.library.backend.model.Langue;
import com.library.backend.repository.LangueRepository;
import com.library.backend.service.LangueService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class LangueServiceImpl implements LangueService {

    private LangueRepository langueRepository;

    public LangueServiceImpl(LangueRepository langueRepository) {
        this.langueRepository = langueRepository;
    }

    @Override
    public List<Langue> getAll() {
        return langueRepository.findAll();
    }

    @Override
    public Langue getLangueById(int id) {
        return langueRepository.findById(id).orElseThrow();
    }
}
