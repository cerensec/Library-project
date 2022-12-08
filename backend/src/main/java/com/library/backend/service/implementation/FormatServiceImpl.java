package com.library.backend.service.implementation;

import com.library.backend.model.Format;
import com.library.backend.repository.FormatRepository;
import com.library.backend.service.FormatService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormatServiceImpl implements FormatService {

    private FormatRepository formatRepository;

    public FormatServiceImpl(FormatRepository formatRepository) {
        this.formatRepository = formatRepository;
    }

    @Override
    public List<Format> getAllFormats() {
        return formatRepository.findAll();
    }

    @Override
    public Format getFormatById(int id) {
        return formatRepository.findById(id).orElseThrow();
    }
}
