package app.healftystyle.shop;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import app.healftystyle.post.Posts;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    @NonNull
    List<Product> findAll();

    @NonNull
    Optional<Product> findById (Long id);
    List<Product> findAllByCategory(Category category);
}
