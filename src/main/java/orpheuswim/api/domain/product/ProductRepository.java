package orpheuswim.api.domain.product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Page<Product> findAllByOrderByCreatedAtDesc(Pageable pageable);

    List<Product> findByCategory(Category category);

    List<Product> findByTitleContainingIgnoreCase(String search);

    List<Product> findByCategoryAndTitleContainingIgnoreCase(Category enumCategory, String search);
}
