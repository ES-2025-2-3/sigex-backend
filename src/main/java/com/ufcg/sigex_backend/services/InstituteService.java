package com.ufcg.sigex_backend.services;

import com.ufcg.sigex_backend.repositories.InstituteRepository;
import com.ufcg.sigex_backend.models.Institute;



@Service
public class InstituteService {
    @Autowired
    private InstituteRepository repository;

    public Institute create(Institute institute) {
        return repository.save(institute);
    }
}
