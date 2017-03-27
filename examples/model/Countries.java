package com.afilini.model;

import java.util.List;

public class Countries extends Item {
    public static List<String> getCountriesList() {
        return getList("country", "Export");
    }
}
