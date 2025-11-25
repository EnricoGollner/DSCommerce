package dev.enricogollner.DSCommerce.controllers;

import dev.enricogollner.DSCommerce.dto.CategoryDTO;
import dev.enricogollner.DSCommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryController {
    @Autowired
    private CategoryService service;

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> findAll() {
        List<CategoryDTO> categories = service.findAll();
        return ResponseEntity.ok(categories);
    }
}
