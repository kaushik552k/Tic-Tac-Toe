package tictactoe;

import java.util.Scanner;

public class Main {
    final static Scanner scanner = new Scanner( System.in );

    public static int countSymbols(char symbol, char[] arrayTicTac){
        int howManyTimes = 0;
        for (int i = 0; i < arrayTicTac.length; i++) {
            if(arrayTicTac[i] == symbol) {
                howManyTimes++;
            }
        }
        return howManyTimes;
    }


    public static boolean checkRow(char symbol, char[][] symbolArray){
        for (int row = 0; row < 3; row++) {
            if((symbol == symbolArray[row][0]) && (symbol == symbolArray[row][1]) && (symbol == symbolArray[row][2])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkColumn(char symbol, char[][] symbolArray){
        for (int column = 0; column < 3; column++) {
            if((symbol == symbolArray[0][column]) && (symbol == symbolArray[1][column]) && (symbol == symbolArray[2][column])) {
                return true;
            }
        }
        return false;
    }

    public static boolean checkDiagonal(char symbol, char[][] symbolArray){

        return ((symbol == symbolArray[0][0]) && (symbol == symbolArray[1][1]) && (symbol == symbolArray[2][2])) ||
                ((symbol == symbolArray[2][0]) && (symbol == symbolArray[1][1]) && (symbol == symbolArray[0][2]));
    }

    public static boolean xWins(char[][] symbolArray){
        return checkColumn( 'X', symbolArray ) || checkRow( 'X', symbolArray ) || checkDiagonal( 'X', symbolArray );
    }

    public static boolean oWins(char[][] symbolArray){
        return (checkColumn( 'O', symbolArray ) || checkRow( 'O', symbolArray ) || checkDiagonal( 'O', symbolArray ));
    }

    public static char[][] translateTableToMatrix(int tableLenght, char[] tabToTranslate){

        int sqrtedTableLenght = (int) Math.sqrt( tableLenght );
        char[][] newMatrix = new char[sqrtedTableLenght][sqrtedTableLenght];

        int tabIterator = 0;

        for (int i = 0; i < sqrtedTableLenght; i++) {
            for (int j = 0; j < sqrtedTableLenght; j++) {

                newMatrix[i][j] = tabToTranslate[tabIterator];
                tabIterator++;
            }
        }
        return newMatrix;
    }


    public static void main(String[] args){

        char[][] gameTable;

        char[] ticTac = scanner.nextLine().toCharArray();

        gameTable = translateTableToMatrix( ticTac.length, ticTac );

        System.out.println( "---------" );
        for (int rows = 0; rows < 3; rows++) {
            for (int columns = 0; columns < 3; columns++) {

                if(columns == 0)
                    System.out.print( "| " );

                System.out.print( gameTable[rows][columns] + " " );

                if(columns == 2)
                    System.out.print( "|" );
            }
            System.out.println();
        }
        System.out.println( "---------" );

        int numberOfXs = countSymbols( 'X', ticTac );
        int numberOfOs = countSymbols( 'O', ticTac );
        int numberOf_s = countSymbols( '_', ticTac );

        boolean isXaWinner = xWins( gameTable );
        boolean isOaWinner = oWins( gameTable );

        if((isOaWinner && isXaWinner) || (Math.abs( numberOfXs - numberOfOs )) >= 2) System.out.println( "Impossible" );

        else if(isOaWinner) System.out.println( "O wins" );
        else if(isXaWinner) System.out.println( "X wins" );
        else if(numberOf_s > 0 && !isOaWinner && !isXaWinner) System.out.println( "Game not finished" );
        else if(numberOf_s == 0 && !isOaWinner && !isXaWinner) System.out.println( "Draw" );
    }
}