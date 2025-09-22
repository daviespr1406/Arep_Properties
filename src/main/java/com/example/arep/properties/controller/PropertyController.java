package com.example.arep.properties.controller;


import com.example.arep.properties.model.Property;
import com.example.arep.properties.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/properties")
@CrossOrigin(origins = "*")
public class PropertyController {


    @Autowired
    private PropertyService service;


    @PostMapping
    public ResponseEntity<Property> create(@RequestBody Property property) {
        Property created = service.create(property);
        return ResponseEntity.created(URI.create("/api/properties/" + created.getId())).body(created);
    }


    @GetMapping
    public List<Property> getAll() {
        return service.getAll();
    }


    // pagination + search
    @GetMapping("/search")
    public Page<Property> search(@RequestParam(required = false) String address,
                                 @RequestParam(required = false) Double minPrice,
                                 @RequestParam(required = false) Double maxPrice,
                                 @RequestParam(defaultValue = "0") int page,
                                 @RequestParam(defaultValue = "10") int size) {
        return service.search(address, minPrice, maxPrice, page, size);
    }


    @GetMapping("/{id}")
    public Property getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @PutMapping("/{id}")
    public Property update(@PathVariable Long id, @RequestBody Property property) {
        return service.update(id, property);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
