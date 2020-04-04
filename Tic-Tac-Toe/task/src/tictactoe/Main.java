package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        // write your code here
        Scanner sc = new Scanner( System.in );
        System.out.println( "Enter cells" );
        char[] input = sc.nextLine().toCharArray();
        System.out.println( "---------" );
        System.out.println( "| " + input[0] + " " + input[1] + " " + input[2] + " |" );
        System.out.println( "| " + input[3] + " " + input[4] + " " + input[5] + " |" );
        System.out.println( "| " + input[6] + " " + input[7] + " " + input[8] + " |" );
        System.out.println( "---------" );

    }
}
