import java.util.HashMap;
import java.util.Scanner;

public class ATMTester {
    public static void main(String[] args) {

        ATM theBank = new ATM();

        theBank.openAccount("baribl1620@gmail.com", 100);

        System.out.println(theBank.checkBalance("baribl1620@gmail.com"));
        System.out.println(theBank.checkBalance("bb@gmail.com"));
        theBank.closeAccount("baribl1620@gmail.com");

    }

}
