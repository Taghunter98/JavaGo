package JavaGo;

import java.util.Scanner;

public class Terminal {
    /*
    This class is only to make the terminal look pretty :)
     */

    // clear terminal
    public static void clearTerminal(){
        for(int i = 0; i < 100; i++) {
            System.out.println();
        }
    };

    // print heading
    public static void printHeader(String h) {
        Terminal.printDivider(50);
        System.out.println(h.toUpperCase());
        Terminal.printDivider(50);
    }

    // print divider
    public static void printDivider(int n) {
        for(int i = 0; i < n; i++) {
            System.out.print("-");
        }
        System.out.println();
    }


}
