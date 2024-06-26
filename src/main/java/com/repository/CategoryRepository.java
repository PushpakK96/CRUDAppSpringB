package com.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import com.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {
}


