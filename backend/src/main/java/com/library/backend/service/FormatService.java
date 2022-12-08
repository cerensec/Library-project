package com.library.backend.service;

import com.library.backend.model.Format;

import java.util.List;

public interface FormatService {

    List<Format> getAllFormats();
    Format getFormatById(int id);
}
