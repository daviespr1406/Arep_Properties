package com.example.arep.properties.service;


import com.example.arep.properties.exception.ResourceNotFoundException;
import com.example.arep.properties.model.Property;
import com.example.arep.properties.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class PropertyService {


    @Autowired
    private PropertyRepository repository;


    public Property create(Property property) {
        return repository.save(property);
    }


    public List<Property> getAll() {
        return repository.findAll();
    }


    public Page<Property> search(String address, Double minPrice, Double maxPrice, int page, int size) {
        Pageable p = PageRequest.of(page, size);
        return repository.search(address, minPrice, maxPrice, p);
    }


    public Property getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Property not found with id " + id));
    }


    public Property update(Long id, Property updated) {
        Property existing = getById(id);
        existing.setAddress(updated.getAddress());
        existing.setPrice(updated.getPrice());
        existing.setSize(updated.getSize());
        existing.setDescription(updated.getDescription());
        return repository.save(existing);
    }


    public void delete(Long id) {
        Property existing = getById(id);
        repository.delete(existing);
    }
}