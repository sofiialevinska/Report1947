package com.opencart.steps;

import com.opencart.containers.ProductsContainersAdmin;
import com.opencart.pages.AdminProductsPage;
import io.qameta.allure.Step;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdminProductsPageBL {
    private final AdminProductsPage adminProductsPage;

    public AdminProductsPageBL() {
        adminProductsPage = new AdminProductsPage();
    }

    @Step("put Products names and prices from Admin Page to Map <String,String>")
    public Map<String, String> getProductsAdminPrices() {
        Map<String, String> productsPricesMap = new HashMap<>();
        List<ProductsContainersAdmin> productsContainersAdmin = new AdminProductsPage().getProductsContainersAdmin();
        for (ProductsContainersAdmin container
                : productsContainersAdmin) {
            if (!container.getProductName().contains("Product Name")) {
                productsPricesMap.put(container.getProductName(), container.getProductPrice());
                }
            }
        return productsPricesMap;
    }
}
