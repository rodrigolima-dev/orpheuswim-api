package orpheuswim.api.product;

import java.math.BigDecimal;

public record ProductListData(
        String title,
        String description,
        BigDecimal price,
        String imageUrl
) {
    public ProductListData(Product product) {
        this(product.getTitle(), product.getDescription(), product.getPrice(), product.getImageUrl());
    }
}
