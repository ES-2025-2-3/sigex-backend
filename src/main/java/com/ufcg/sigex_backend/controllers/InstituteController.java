package com.ufcg.sigex_backend.controllers;

import com.ufcg.sigex_backend.services.InstituteService;

@RestController
@RequestMapping("/api/institutes")
public class InstituteController {
    @Autowired
    private InstituteService service;

    @PostMapping
    public ResponseEntity<Institute> save(@RequestBody Institute institute) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.create(institute));
    }
}
