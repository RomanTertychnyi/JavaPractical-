package structure;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Product  {
    private static final AtomicInteger count = new AtomicInteger(0);
    private int id;
   private String name;
    private int price;

    public Product( String name, int price) {
        this.id = count.incrementAndGet();
        this.name = name;
        this.price = price;
    }

    public Product(String input){
        String[] params1 = input.split(" ");
        if (params1.length < 3) {
            throw new RuntimeException("Expected CREATE_PRODUCT list parameters: [CREATE_PRODUCT name price]" +
                    " but got \n" + input);
        }
        String name = params1[1];
        int price = Integer.parseInt(params1[2]);
        if (price < 0) {
            throw new RuntimeException("The price cannot be less than zero, try creating the Product again");
        }
        this.id = count.incrementAndGet();
        this.name = name;
        this.price = price;
    }

    public int  getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
