package orpheuswim.api.product;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    BIKINIS,
    CONJUNTOS,
    ACESSORIOS;

    @JsonCreator
    public static Category fromString(String value) {
        if (value == null || value.isBlank()) return null;
        return Category.valueOf(value.toUpperCase());
    }
}


