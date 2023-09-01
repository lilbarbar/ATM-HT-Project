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
                    System.out.println(userID + ", we made your account with " + ammount + " dollars");
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
            if (accounts.get(userID) == 0) {
                System.out.println(userID + ", we are closing your account");
                accounts.remove(userID);
            } else if (accounts.get(userID) > 0) {
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

    public double checkBalance(String userID) {
        try {
            if (accounts.containsKey(userID)) {
                double output = accounts.get(userID);
                return output;
            } else {
                System.out.println("BROKE BOI..make a valid account first...");
                return 0.0;
            }
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something bugging bro bro...");
            return 0.0;
        }
    }

    public double withdrawMoney(String userID, double ammount) {
        try {

            if (accounts.containsKey(userID)) {
                double currentMoney = accounts.get(userID);
                if (currentMoney >= ammount) {
                    double output = currentMoney - ammount;
                    accounts.replace(userID, output);
                    return output;
                } else {
                    System.out.println("INSUFFECIENT FUNDS BROKE BOI!");
                    System.out.println(userID + " only has " + currentMoney);
                    return 0.0;
                }
            } else {
                System.out.println(userID + " is not a valid account.");
                return 0.0;

            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something bugging bro bro...");
            return 0.0;
        }
    }
}
