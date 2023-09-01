import java.util.HashMap;
import java.util.Scanner;

public class ATMTester {
    public static void main(String[] args) {

        ATM theBank = new ATM();

        String email1 = "baribl1620@gmail.com";
        String email2 = "ohuang1@hwemail.com";
        String email3 = "amilburn1@hwemail.com";
        String email4 = "dhernandez1@hwemail.com";
        String email5 = "rmalhorta1@hwemail.com";
        String email6 = "burner";

        theBank.openAccount(email1, 100);
        theBank.openAccount(email1, 50);
        theBank.openAccount(email2, 0);
        theBank.openAccount(email2, 80);
        theBank.openAccount(email3, 80);
        theBank.openAccount(email4, 80);
        theBank.openAccount(email5, 80);

        theBank.closeAccount(email1);
        theBank.withdrawMoney(email1, 150);
        theBank.withdrawMoney(email1, 90);
        theBank.closeAccount(email1);
        theBank.withdrawMoney(email1, 10);
        theBank.closeAccount(email1);

        theBank.withdrawMoney(email6, 50);

        System.out.println(theBank.checkBalance(email2));
        System.out.println(theBank.checkBalance(email6));

        System.out.println(theBank.depositMoney(email2, 10));

    }

}
