package pl.romanek.webprojekt.shop.repository;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.springframework.stereotype.Repository;
import pl.romanek.webprojekt.shop.domain.Product;

@Repository
public class InMemoryProductRepository implements ProductRepository {

    private List<Product> listOfProducts = new ArrayList<Product>();

    @Override
    public List<Product> getProductByManufacturer(String manufacturer) {

        List<Product> productsByManufacturer = new ArrayList<>();

        for (Product productByManufacturer : listOfProducts) {

            if (productByManufacturer.getManufacturer().equalsIgnoreCase(manufacturer)) {

                productsByManufacturer.add(productByManufacturer);
            }

        }
        return productsByManufacturer;
    }

    @Override
    public Set<Product> getProductsByPriceFilter(Map<String, String> filterParams) {

        Set<String> criterias = filterParams.keySet();

        Set<Product> productsByLowPrice = new HashSet<Product>();
        Set<Product> productsByHighPrice = new HashSet<Product>();
        Set<Product> productsByPrice = new HashSet<Product>();

   if (criterias.contains("low")) {

            BigDecimal price = new BigDecimal(filterParams.get("low"));

            for (Product product : listOfProducts) {

                if (price.floatValue() <= product.getUnitPrice().floatValue()) {

                    productsByLowPrice.add(product);
                    productsByPrice.add(product);
                
                }
            }

        }
        if (criterias.contains("high")) {

            BigDecimal price = new BigDecimal(filterParams.get("high"));

            for (Product product : listOfProducts) {

                if (price.floatValue() > product.getUnitPrice().floatValue()) {

                    productsByHighPrice.add(product);
                    productsByPrice.add(product);
                 

                }
                
                
            }
        } if(criterias.contains("low")&&criterias.contains("high")){
            
            productsByPrice.retainAll(productsByLowPrice);
            productsByPrice.retainAll(productsByHighPrice);
            
        }
        return productsByPrice;

    }

    @Override
    public Set<Product> getProducsByFilter(Map<String, List<String>> filterParams) {

        Set<Product> productsByBrand = new HashSet<Product>();
        Set<Product> productsByCategory = new HashSet<Product>();
        Set<String> criterias = filterParams.keySet();

        if (criterias.contains("brand")) {

            for (String brandName : filterParams.get("brand")) {

                for (Product product : listOfProducts) {

                    if (brandName.equalsIgnoreCase(product.getManufacturer())) {
                        productsByBrand.add(product);
                    }
                }
            }
        }

        if (criterias.contains("category")) {

            for (String category : filterParams.get("category")) {

                productsByCategory.addAll(getProductByCategory(category));
            }
        }

        productsByCategory.retainAll(productsByBrand);
        return productsByCategory;

    }

    @Override
    public List<Product> getProductByCategory(String category) {

        List<Product> productsByCategory = new ArrayList<>();

        for (Product productByCategory : listOfProducts) {

            if (productByCategory.getCategory().equalsIgnoreCase(category)) {

                productsByCategory.add(productByCategory);

            }

        }

        return productsByCategory;
    }

    public InMemoryProductRepository() {

        Product iphone = new Product("P1234", "iPhone 8", new BigDecimal(500));

        iphone.setDescription("Apple iPhone 8, smartfon z 4-calowym wyświetlaczem o rozdzielczości 640×1136 oraz 8-megapikselowym aparatem");
        iphone.setCategory("Smartphone");
        iphone.setManufacturer("Apple");
        iphone.setUnitsInStock(1000);
        iphone.setCondition("New");
        
        
        Product samsungs20 = new Product("P1237" ,"Samsung S20", new BigDecimal(3999));
        
        samsungs20.setDescription("Samsung S20, wyposażono w ośmiordzeniowy procesor oraz nowe kości pamięci.Teraz myśli i działa szybciej");
        samsungs20.setCategory("Smartphone");
        samsungs20.setManufacturer("Samsung");
        samsungs20.setUnitsInStock(1000);
        samsungs20.setCondition("New");
        
        Product lgv40 = new Product("P1238" ,"LG V40", new BigDecimal(2999));
        
        lgv40.setDescription("LG V40, wyposażono w ośmiordzeniowy procesor oraz nowe kości pamięci.Teraz myśli i działa szybciej");
        lgv40.setCategory("Smartphone");
        lgv40.setManufacturer("LG");
        lgv40.setUnitsInStock(1000);
        lgv40.setCondition("New");

        Product laptop_dell = new Product("P1235", "Dell Inspiron", new BigDecimal(700));

        laptop_dell.setDescription("Dell Inspiron, 14-calowy laptop(czarny)z procesorem Intel Core 3. generacji");
        laptop_dell.setCategory("Laptop");
        laptop_dell.setManufacturer("Dell");
        laptop_dell.setUnitsInStock(1000);
        laptop_dell.setCondition("New");
        
        Product laptop_apple = new Product("P1239", "Apple MacBook", new BigDecimal(700));

        laptop_apple.setDescription("Nowy MacBook Air ma olśniewający wyświetlacz Retina");
        laptop_apple.setCategory("Laptop");
        laptop_apple.setManufacturer("Apple");
        laptop_apple.setUnitsInStock(1000);
        laptop_apple.setCondition("New");

        Product tablet_Nexus = new Product("P1236", "Nexus 7", new BigDecimal(300));

        tablet_Nexus.setDescription("Google Nexus 7 jest najlżejszym 7-calowym tabletem");
        tablet_Nexus.setCategory("Tablet");
        tablet_Nexus.setManufacturer("Google");
        tablet_Nexus.setUnitsInStock(1000);
        tablet_Nexus.setCondition("New");

        listOfProducts.add(iphone);
        listOfProducts.add(laptop_dell);
        listOfProducts.add(tablet_Nexus);
        listOfProducts.add(samsungs20);
        listOfProducts.add(lgv40);
        listOfProducts.add(laptop_apple);
        
    
      

    }

    @Override
    public void addProduct(Product prdct) {

        listOfProducts.add(prdct);
    }

    @Override
    public Product getProductById(String productId) {

        Product productById = null;

        for (Product product : listOfProducts) {

            if (product.getProductId().equals(productId)) {

                productById = product;
                break;
            }
        }

        if (productById == null) {

            throw new IllegalArgumentException("Brak produktu o podanym id");
        }

        return productById;

    }

    @Override
    public List<Product> getAllProducts() {
        return listOfProducts;
    }
}
