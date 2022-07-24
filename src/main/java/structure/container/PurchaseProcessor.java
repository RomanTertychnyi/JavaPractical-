package structure.container;

import structure.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class PurchaseProcessor {
    ProductContainer productContainer;
    UserContainer userContainer;

    // Map between UserId and List of ProductId
    private Map<Integer, List<Integer>> userPusrchasesMap = new HashMap<>();

    public void printUserPurchases(Integer userId) {
        List<Integer> userPurchases = null;

        if (userPusrchasesMap.containsKey(userId)) {
            userPurchases = userPusrchasesMap.get(userId);
        } else {
            userPurchases = new ArrayList<>();
        }
        for (Integer productId : userPurchases) {
            System.out.println(productContainer.productMap.get(productId));
        }

    }

    public void printProductPurchases(Integer productId) {
        List<User> userPurchasesProduct = new ArrayList<>();

        for (Integer userId : userPusrchasesMap.keySet()) {
            List<Integer> userPurchases = userPusrchasesMap.get(userId);
            if (userPurchases.contains(userId)) {
                userPurchasesProduct.add(userContainer.usersMap.get(userId));
            }
        }

        for (int i = 0; i < userPurchasesProduct.size(); i++) {
            System.out.println(userPurchasesProduct.get(i));
        }


    }


    public PurchaseProcessor(ProductContainer productContainer, UserContainer userContainer) {
        this.productContainer = productContainer;
        this.userContainer = userContainer;


    }

    public void madePurchase(Integer userId, Integer productId) {
        if (!productContainer.productExist(productId)) {
            throw new IllegalArgumentException("such product not exist: " + productId);
        }

        if (!userContainer.userExist(userId)) {
            throw new IllegalArgumentException("such user not exist: " + userId);
        }

        userContainer.chargeUser(userId, productContainer.productMap.get(productId).getPrice());
        if (userPusrchasesMap.containsKey(userId)) {
            List<Integer> userPurchases = userPusrchasesMap.get(userId);
            userPurchases.add(productId);
        } else {
            List<Integer> userPurchases = new ArrayList<>();
            userPurchases.add(productId);

            userPusrchasesMap.put(userId, userPurchases);
        }
        System.out.println("Юзер успішно зробив покупку " + userId + " зробив успішну покупку " + productId);

    }

    public boolean removeUser(Integer userId) {

        if (userPusrchasesMap.containsKey(userId)) {
            userPusrchasesMap.remove(userId);
            System.out.println("User removed from purchases");
            return true;
        } else {
            return false;
        }
    }

    public void removeProduct(Integer productId) {

        for (Integer userId : userPusrchasesMap.keySet()) {
            List<Integer> productIds = userPusrchasesMap.get(userId);
            List<Integer> toRemove = new ArrayList<>();
            toRemove.add(productId);
            productIds.removeAll(toRemove);

        }
    }
}

