package com.example.service;

import com.example.domain.Moogs;
import com.example.repository.MoogsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class MoogsService {
    @Autowired
    MoogsRepository moogsRepository;

    public List<Moogs> findAll() {
        return moogsRepository.findAll();
    }
    
    public Moogs findOne(Integer id) {
        return moogsRepository.findOne(id);
    }
    
    public Moogs create(Moogs newMoog) {
        return moogsRepository.save(newMoog);
    }
    
    public Moogs update(Moogs updateMoog) {
        return moogsRepository.save(updateMoog);
    }
    
    public void delete(Integer id) {
        moogsRepository.delete(id);
    }

}
