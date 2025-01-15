package com.study.grahqljava.modules.category;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.Optional;
import java.util.UUID;

@Controller
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @MutationMapping
    CategoryEntity addCategory(@Argument CategoryInput category) {
        return this.categoryRepository.save(new CategoryEntity(category.name()));
    }

    @QueryMapping
    Optional<CategoryEntity> categoryById(@Argument UUID id) {
        return this.categoryRepository.findById(id);
    }
}
