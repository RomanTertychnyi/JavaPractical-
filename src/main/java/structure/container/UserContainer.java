package structure.container;

import structure.User;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserContainer {

    // id user to user
    Map<Integer, User> usersMap = new HashMap<>();

    public UserContainer() {
    }

    public boolean userExist(Integer id) {
        return usersMap.containsKey(id);
    }


    /**
     * @return true if object were deleted else return false
     */
    public boolean removeUser(Integer id) {

        if (usersMap.containsKey(id)) {
            usersMap.remove(id);
            System.out.println("User removed from userContainer");
            return true;
        } else {
            return false;
        }
    }

    public boolean addUser(User user) {
        if (usersMap.containsKey(user.getId())) {
            return false;
        } else {
            usersMap.put(user.getId(), user);
            return true;
        }
    }

    public void chargeUser(Integer id, Integer price) {
        if (usersMap.containsKey(id)) {
            usersMap.get(id).userPurchase(price);
        }
    }

    public  void displayAllUsers() {
        System.out.println("********************** List of Users **********************");
        for(Integer  entry:  usersMap.keySet()){
            System.out.println(usersMap.get(entry));
        }
        System.out.println("***********************************************************");
    }



}
