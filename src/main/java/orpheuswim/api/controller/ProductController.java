package orpheuswim.api.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import orpheuswim.api.product.RegisterProductData;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @PostMapping
    public void register(@RequestBody RegisterProductData data) {
        System.out.println(data);
    }

}
