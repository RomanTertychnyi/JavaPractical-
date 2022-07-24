package structure.container;



import structure.Product;

import java.util.HashMap;
import java.util.Map;

public class ProductContainer {
    Map<Integer, Product> productMap = new HashMap<>();

    public ProductContainer() {
    }



    public boolean productExist(Integer id) {
        return productMap.containsKey(id);
    }

    public boolean removeProduct(Integer id){
        if(productMap.containsKey(id)){
            productMap.remove(id);
            System.out.println("product removed from productContainer");
            return true;
        } else {
            return false;
        }
    }

    public boolean addProduct(Product product){
        if(productMap.containsKey(product.getId())){
            return false;
        } else {
            productMap.put(product.getId(),product);
            return true;
        }
    }

    public  void displayAllProdut() {
        System.out.println("********************** List of Product **********************");
        for(Integer  entry:  productMap.keySet()){
            System.out.println(productMap.get(entry));
        }
        System.out.println("***********************************************************");
    }
}
