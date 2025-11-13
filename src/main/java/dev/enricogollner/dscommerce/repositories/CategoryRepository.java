package dev.enricogollner.dscommerce.repositories;

import dev.enricogollner.dscommerce.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
