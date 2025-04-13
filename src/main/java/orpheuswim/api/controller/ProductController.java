package orpheuswim.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;
import orpheuswim.api.product.Product;
import orpheuswim.api.product.ProductListData;
import orpheuswim.api.product.ProductRepository;
import orpheuswim.api.product.RegisterProductData;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;


    @PostMapping
    @Transactional
    public void register(@RequestBody @Valid RegisterProductData data) {
        repository.save(new Product(data));
    }

    @GetMapping("/releases")
    public List<ProductListData> getReleases(@RequestParam(defaultValue = "6") int limit) {
        return repository
                .findAllByOrderByCreatedAtDesc(PageRequest.of(0, limit))
                .getContent()
                .stream()
                .map(ProductListData::new)
                .toList();
    }

}
