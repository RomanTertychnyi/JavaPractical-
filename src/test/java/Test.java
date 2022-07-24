


import structure.Product;


import structure.User;
import structure.container.ProductContainer;
import structure.container.PurchaseProcessor;
import structure.container.UserContainer;


import java.util.*;

public abstract class Test {

    public static void main(String[] args) {

        String CREATE_USER_COMMAND = "CREATE_USER";
        String CREATE_PRODUCT_COMMAND = "CREATE_PRODUCT";
        String LIST_USER_COMMAND = "LIST_ALL_USER";
        String LIST_PRODUCT_COMMAND = "LIST_ALL_PRODUCT";
        String PRINT_USER_PURCHASES = "PRINT_USER_PURCHASES";
        String PRINT_PRODUCT_PURCHASES = "PRINT_PRODUCT_PURCHASES";
        String DELETE_PRODUCT_COMMAND = "DELETE_PRODUCT";
        String DELETE_USER_COMMAND = "DELETE_USER";
        String BUY_PRODUCT_COMMAND = "BUY_PRODUCT";


        System.out.println("we have onle command : \n" + "CREATE_USER \n" + "CREATE_PRODUCT \n" + "LIST_ALL_USER \n" +
                "LIST_ALL_PRODUCT \n"+ "BUY_PRODUCT \n" + "PRINT_USER_PURCHASES \n" + "PRINT_PRODUCT_PURCHASES \n" +
                "DELETE_PRODUCT \n" + "DELETE_USER" );
        List<Product> listProducts = new ArrayList<>();

        Map<User, Product> map;
        map = new HashMap<>();

        UserContainer userContainer = new UserContainer();
        ProductContainer productContainer = new ProductContainer();
        PurchaseProcessor purchaseProcessor = new PurchaseProcessor(productContainer, userContainer);
        Scanner command = new Scanner(System.in);
        String a = "";
        boolean isRunning = true;
        while (isRunning) {
            a = command.nextLine().trim();
            try {
                if (a.trim().startsWith(CREATE_USER_COMMAND)) {
                    User user1 = new User(a);
                    userContainer.addUser(user1);
                    System.out.println("user created");
                }
            } catch (Exception ex) {
                System.out.println("Exception happens on executing command CREATE_USER: \n" + ex.getMessage());
            }
            if (a.startsWith(LIST_USER_COMMAND)) {
                userContainer.displayAllUsers();
            }


            try {
                if (a.startsWith(CREATE_PRODUCT_COMMAND)) {
                    Product product1 = new Product(a);
                    productContainer.addProduct(product1);

                    System.out.println("product created");
                }
            } catch (Exception ex) {
                System.out.println("Exception happens on executing command CREATE_PRODUCT: \n" + ex.getMessage());
            }
            if (a.startsWith(LIST_PRODUCT_COMMAND)) {
                productContainer.displayAllProdut();
            }


            try {
                if (a.trim().startsWith(BUY_PRODUCT_COMMAND)) {
                    String[] arguments = a.split(" ");
                    Integer userId = Integer.parseInt(arguments[1]);
                    Integer productId = Integer.parseInt(arguments[2]);
                    purchaseProcessor.madePurchase(userId, productId);
                }
            } catch (Exception ex) {
                System.out.println("Exception happens on executing command BUY_PRODUCT: \n" + ex.getMessage());
            }

            try {
                if (a.trim().startsWith(PRINT_USER_PURCHASES)) {
                    String[] arguments = a.split(" ");
                    Integer userId = Integer.parseInt(arguments[1]);
                    purchaseProcessor.printUserPurchases(userId);
                }
                } catch (Exception ex) {
                System.out.println("Exception happens on executing command PRINT_USER_PURCHASES: \n" + ex.getMessage());
            }

            try {

                if (a.trim().startsWith(PRINT_PRODUCT_PURCHASES)) {
                    String[] arguments = a.split(" ");
                    Integer productId = Integer.parseInt(arguments[1]);
                    purchaseProcessor.printProductPurchases(productId);
                }
            } catch (Exception ex){
                System.out.println("Exception happens on executing command PRINT_PRODUCT_PURCHASES: \n" + ex.getMessage());
            }

       try {


           if (a.startsWith(DELETE_PRODUCT_COMMAND)) {
               String[] arguments = a.split(" ");
               Integer productId = Integer.parseInt(arguments[1]);
               boolean isRemoved = productContainer.removeProduct(productId);
               if (isRemoved) {
                   purchaseProcessor.removeProduct(productId);
               }
           }
       } catch (Exception ex) {
           System.out.println("Exception happens on executing command DELETE_PRODUCT_COMMAND : \n" + ex.getMessage());
       }

       try {
           if (a.startsWith(DELETE_USER_COMMAND)) {
               String[] arguments = a.split(" ");
               Integer userId = Integer.parseInt(arguments[1]);
               boolean isRemoved = userContainer.removeUser(userId);
               if (isRemoved) {
                   purchaseProcessor.removeUser(userId);
               }
           }
       } catch (Exception ex){
           System.out.println("Exception happens on executing command DELETE_USER_COMMAND : \n" + ex.getMessage());
       }


                if (a.equals("exit")) {
                    System.out.println("Exit");
                    isRunning = false;
                }
            }
        }
    }


// CREATE_USER roma poma 100
// CREATE_PRODUCT watter 20
// LIST_ALL_USER
// LIST_ALL_PRODUCT

// BUY_PRODUCT
// MAP_PRODUCT
// DELETE_USER
// DELETE_PRODUCT