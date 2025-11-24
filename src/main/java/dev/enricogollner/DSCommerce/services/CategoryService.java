package dev.enricogollner.DSCommerce.services;

import dev.enricogollner.DSCommerce.dto.CategoryDTO;
import dev.enricogollner.DSCommerce.entities.Category;
import dev.enricogollner.DSCommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(CategoryDTO::new).toList();
    }
}
