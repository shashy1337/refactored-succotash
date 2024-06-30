package ru.shashy.orderrestapi.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.shashy.orderrestapi.domain.entity.Categories;

import java.util.Optional;

@Repository
public interface CategoriesRepository extends CrudRepository<Categories, Long> {
    Optional<Categories> findByName(String name);
}