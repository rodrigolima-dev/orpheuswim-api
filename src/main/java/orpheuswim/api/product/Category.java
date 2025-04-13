package orpheuswim.api.product;


import com.fasterxml.jackson.annotation.JsonCreator;

public enum Category {
    BIKINIS,
    CONJUNTOS,
    ACESSORIOS;

    @JsonCreator
    public static Category fromString(String value) {
        return Category.valueOf(value.toUpperCase());
    }
}


