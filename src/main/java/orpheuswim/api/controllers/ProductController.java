package orpheuswim.api.controllers;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import orpheuswim.api.domain.product.*;

import java.util.List;


@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductRepository repository;


    @GetMapping("/releases")
    public ResponseEntity<List<ProductListData>> getReleases(@RequestParam(defaultValue = "6") int limit) {
        List<ProductListData> products = repository
                .findAllByOrderByCreatedAtDesc(PageRequest.of(0, limit))
                .getContent()
                .stream()
                .map(ProductListData::new)
                .toList();

        if (products.isEmpty()) {
            return ResponseEntity.noContent().build(); // HTTP 204 no content
        }

        return ResponseEntity.ok(products); // HTTP 200
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductListData>> getAllProducts(
            @RequestParam(required = false) String category,
            @RequestParam(required = false) String search
    ) {
        List<Product> products;

        if (search != null && !search.isEmpty()) {
            if (category != null && !category.isEmpty()) {
                Category enumCategory = Category.fromString(category);
                products = repository.findByCategoryAndTitleContainingIgnoreCase(enumCategory, search);
            } else {
                products = repository.findByTitleContainingIgnoreCase(search);
            }
        } else if (category != null && !category.isEmpty()) {
            Category enumCategory = Category.fromString(category);
            products = repository.findByCategory(enumCategory);
        } else {
            products = repository.findAll();
        }

        List<ProductListData> result = products.stream()
                .map(ProductListData::new)
                .toList();

        if (result.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(result);
    }

    //uptimeRobot
    @RequestMapping(value = "/products", method = RequestMethod.HEAD)
    public ResponseEntity<Void> headAllProducts() {
        return ResponseEntity.ok().build(); // headers (HTTP 200)
    }



    @PostMapping("/admin")
    @SecurityRequirement(name = "bearer-key")
    @Transactional
    public ResponseEntity register(@RequestBody @Valid RegisterProductData data, UriComponentsBuilder uriBuilder) {
        var product = new Product(data);
        repository.save(product);

        var uri = uriBuilder.path("/admin/{id}").buildAndExpand(product.getId()).toUri();

        return ResponseEntity.created(uri).body(new ProductListData(product));
    }


    @PutMapping("/admin")
    @SecurityRequirement(name = "bearer-key")
    @Transactional
    public ResponseEntity update(@RequestBody @Valid ProductUpdateData data) {
        var product = repository.getReferenceById(data.id());
        product.update(data);

        return ResponseEntity.ok(new ProductListData(product));
    }



    @DeleteMapping("/admin/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

    @GetMapping("/admin/{id}")
    @SecurityRequirement(name = "bearer-key")
    @Transactional
    public ResponseEntity detail(@PathVariable Long id) {
        var product = repository.getReferenceById(id);

        return ResponseEntity.ok(new ProductListData(product));
    }

}
