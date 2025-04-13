package orpheuswim.api.controller;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import orpheuswim.api.product.Product;
import orpheuswim.api.product.ProductRepository;
import orpheuswim.api.product.RegisterProductData;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductRepository repository;

    @PostMapping
    @Transactional
    public void register(@RequestBody RegisterProductData data) {
        repository.save(new Product(data));
    }

}
