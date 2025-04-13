package orpheuswim.api.product;

import java.time.LocalDateTime;

public record RegisterProductData(
        String title,
        String description,
        String price,
        String imageUrl,
        Category category
) {
}
