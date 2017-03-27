package com.afilini.model;

import java.util.List;

public class Products extends Item {
    public static List<String> getProductsList() {
        return getList("product", "Export");
    }
}
