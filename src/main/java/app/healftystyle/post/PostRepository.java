package app.healftystyle.post;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Posts,Long> {
    @NonNull
    List<Posts> findAll();
}
