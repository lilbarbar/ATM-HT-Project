import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

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

    public double depositMoney(String userID, double ammount) {
        try {

            if (accounts.containsKey(userID)) {
                if (ammount > 0) {
                    double currentMoney = accounts.get(userID);
                    double output = currentMoney + ammount;
                    accounts.replace(userID, output);
                    return output;
                } else {
                    System.out.println("can't deposit negative money...");
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

    public double withdrawMoney(String userID, double ammount) {
        try {

            if (accounts.containsKey(userID)) {
                double currentMoney = accounts.get(userID);
                if (currentMoney >= ammount && ammount > 0) {
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

    public boolean transferMoney(String fromAccount, String toAccount, double ammount) {
        try {
            if (accounts.containsKey(fromAccount) && accounts.containsKey(toAccount)) {
                if (ammount > 0) {
                    if (accounts.get(fromAccount) >= ammount) {
                        double fromMoney = accounts.get(fromAccount);
                        double toMoney = accounts.get(fromAccount);
                        fromMoney -= ammount;
                        toMoney += ammount;

                        accounts.replace(fromAccount, fromMoney);
                        accounts.replace(toAccount, toMoney);

                        System.out.println("Successful tranfer!");
                        return true;

                    } else {
                        System.out.println(fromAccount + " does not have enough dinero to transfer.");
                        return false;
                    }
                } else {
                    System.out.println("Money transferred must be positive.");
                    return false;
                }

            } else {
                System.out.println("Either one or both accounts are invalid.");
                return false;
            }

        } catch (Exception e) {
            System.out.println(e);
            System.out.println("Something's bugging bro bro...");
            return false;
        }
    }

    public void audit() throws FileNotFoundException { // credit for sentry for teaching me how to do a for each loop
                                                       // with a Hashmap
        try {
            PrintWriter pw = new PrintWriter("AccountAudit.txt");

            String s = "";
            for (HashMap.Entry<String, Double> entry : accounts.entrySet()) {
                s += entry.getKey() + " " + entry.getValue() + "\n";
            }

            pw.print(s);
            pw.close();

        } catch (Exception e) {

        }

    }

}
