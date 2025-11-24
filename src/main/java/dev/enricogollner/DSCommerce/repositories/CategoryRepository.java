package dev.enricogollner.DSCommerce.repositories;

import dev.enricogollner.DSCommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
