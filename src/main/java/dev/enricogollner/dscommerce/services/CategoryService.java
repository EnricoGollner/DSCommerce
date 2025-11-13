package dev.enricogollner.dscommerce.services;

import java.util.List;

import dev.enricogollner.dscommerce.dto.CategoryDTO;
import dev.enricogollner.dscommerce.entities.Category;
import dev.enricogollner.dscommerce.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    @Transactional(readOnly = true)
    public List<CategoryDTO> findAll() {
        List<Category> result = repository.findAll();
        return result.stream().map(x -> new CategoryDTO(x)).toList();
    }
}
