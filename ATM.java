import java.util.HashMap;
import java.util.Scanner;

import javax.lang.model.util.ElementScanner6;

public class ATM {

    private HashMap<String, Double> accounts;

    public ATM() {

        this.accounts = new HashMap<String, Double>();

    }

    public void openAccount(String userID, double ammount) {
        try {
            if (!accounts.containsKey(userID)) {
                if (ammount >= 1) {
                    accounts.put(userID, ammount);
                } else {
                    System.out.println("BROKE BOI GET YO MONEY UP! GET YO FUNNY UP! NO HOPS GET YO BUNNIES UP!");
                }

            } else {
                System.out.println("An Account with said user name exists. BOZO!!!! Make a new name!");
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something bugging bro bro...");

        }

    }

    public void closeAccount(String userID) {
        try {
            if (accounts.compute(userID, null) == 0) {
                System.out.println(userID + ", we are closing your account");
                accounts.remove(userID);
            } else if (accounts.compute(userID, null) > 0) {
                System.out.println(userID
                        + ", you need to withdraw money and have 0 dollars in your account before you can close it.");
            } else {
                System.out.println(
                        "YOU IN DEBT BOIIIIII.... get out of the negative and then you can close your account.");
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something bugging bro bro...");
        }
    }

}