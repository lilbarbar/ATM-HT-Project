import java.util.HashMap;
import java.util.Scanner;

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

}