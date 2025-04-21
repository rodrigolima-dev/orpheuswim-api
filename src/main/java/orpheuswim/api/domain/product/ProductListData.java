package orpheuswim.api.domain.product;

import java.math.BigDecimal;

public record ProductListData(
        Long id,
        String title,
        String description,
        BigDecimal price,
        String imageUrl
) {
    public ProductListData(Product product) {
        this(product.getId(), product.getTitle(), product.getDescription(), product.getPrice(), product.getImageUrl());
    }
}
