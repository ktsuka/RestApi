package com.example.api;

import com.example.domain.Moogs;
import com.example.service.MoogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("moog")
public class MoogsRestController {
    @Autowired
    MoogsService moogsService;

    @GetMapping
    List<Moogs> getMoogs() {
        List<Moogs> moogs = moogsService.findAll();
        return moogs;
    }

    @GetMapping(path = "{id}")
    Moogs getData(@PathVariable Integer id) {
        Moogs moog = moogsService.findOne(id);
        return moog;
    }
 
    @PostMapping
    ResponseEntity<Moogs> postMoogs(@RequestBody Moogs moogs, UriComponentsBuilder uriBuilder) {
        Moogs created = moogsService.create(moogs);
        URI location = uriBuilder.path("moog/{id}")
                .buildAndExpand(created.getId()).toUri();
        return ResponseEntity.created(location).body(created);
    }
    
    @PutMapping(path = "{id}")
    Moogs putMoogs(@PathVariable Integer id, @RequestBody Moogs moogs) {
        moogs.setId(id);
        return moogsService.update(moogs);
    }
    
    @DeleteMapping(path = "{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deleteMoogs(@PathVariable Integer id) {
        moogsService.delete(id);
    }
 
}