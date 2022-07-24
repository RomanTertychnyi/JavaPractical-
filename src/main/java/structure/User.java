package structure;


import java.util.concurrent.atomic.AtomicInteger;

public class User {
    private static final AtomicInteger count = new AtomicInteger(0);
    private final int id;
    private String firstName;
    private String lastName;
    private int amountOfMoney;

    public User(String firstName, String lastName, int amountOfMoney) {
        this.id = count.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountOfMoney;
    }

    public User(String input) {
        String[] params = input.split(" ");
        if (params.length < 4) {
            throw new RuntimeException("Expected CREATE_USER list parameters: [CREATE_USER firstName secondName amountOfMoney]" +
                    " but got \n" + input);
        }
        String firstName = params[1];
        String lastName = params[2];
        int amountMoney = Integer.parseInt(params[3]);
        if (amountMoney < 0) {
            throw new RuntimeException("The amountMoney cannot be less than zero, try creating the User again");
        }
        this.id = count.incrementAndGet();
        this.firstName = firstName;
        this.lastName = lastName;
        this.amountOfMoney = amountMoney;
    }


    public void userPurchase(Integer price) {
        if (price <= amountOfMoney) {
            amountOfMoney = amountOfMoney - price;
        } else {
            throw new IllegalArgumentException("Price of product bigger than amountOfMoney: " + price + " > " + amountOfMoney);
        }
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getAmountOfMoney() {
        return amountOfMoney;
    }


    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAmountOfMoney(int amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", amountOfMoney=" + amountOfMoney +
                '}';
    }


}
