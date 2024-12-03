package org.kodluyoruz;

public class BoardOperations {

    public String board [][];

    public BoardOperations(int dimension){

        board = new String[dimension][dimension];
        initializeBoard(dimension);

    }

    private boolean checkBoardSize(int dimension) {
        return dimension > 2;

    }

    public void initializeBoard( int dimension) {
        if(checkBoardSize(dimension)){
            for (int i = 0; i < dimension; i++) {

                for (int j = 0; j < dimension; j++) {
                    board[i][j] = "-";
                }
            }
        }
        else{
            System.out.println("Gecersiz oyun alani boyutu girdiniz!!!");
        }

    }
    public boolean checkRangeForMarkBoard(int row, int column, int dimension) {
        return (row >= 0 && row <= dimension) || (column >= 0 && column <= dimension);
    }

    public boolean isFullWithCharacter(int row, int column) {
        return !"s".equals(board[row][column]) && !"o".equals(board[row][column]);
    }

    public void markBoard(int row, int column, int dimension, String boardInput){


        if(checkRangeForMarkBoard(row, column, dimension)){

            if(isFullWithCharacter(row, column))
                board[row][column] = boardInput;

            else //mainin içini düzenledikten sonra kaldır
                System.out.println("Girdiginiz konum dolu!!!");
        }
        else //mainin içini düzenledikten sonra kaldır
            System.out.println("Lutfen oyun alani sinirlarinda deger giriniz!!!");

    }

    public void printBoard(int dimension) {

        if(checkBoardSize(dimension)){
            for (int i = 0; i < dimension; i++) {

                for (int j = 0; j < dimension; j++) {
                    System.out.print("[ " + board[i][j] + " ] ");
                }
                System.out.println();

            }

        }
        else{
            System.out.println("Gecersiz oyun alani boyutu girdiniz!!!");
        }

    }

    public String[][] getBoard(){

        return this.board;
    }


    public boolean isBoardFull(int dimension) {
        boolean isFull = true;
        String [][] board = getBoard();
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                if (board[i][j] == "-") {
                    isFull = false;
                }
            }
        }

        return isFull;
    }


    private boolean checkColumns(int dimension) {

        String[][] board = getBoard();
        //sutun kontrol
        for (int row = 0; row <= dimension-3 ; ++row) {
            for(int column = 0; column < dimension ; ++column){
                if (!"-".equals(board[row][column]) && "s".equals(board[row][column]))
                    if("o".equals(board[row+1][column]) && "s".equals(board[row+2][column])){

                        return true;
                    }
            }

        }

        return false;
    }
    private boolean checkRows(int dimension) {
        String[][] board = getBoard();
        //sutun kontrol
        for (int column = 0; column <= dimension-3 ; ++column) {
            for(int row = 0; row < dimension ; ++row ){
                if (!"-".equals(board[row][column]) && "s".equals(board[row][column]))
                    if("o".equals(board[row][column+1]) && "s".equals(board[row][column+2])){

                        return true;
                    }

            }

        }

        return false;
    }


    private boolean checkFirstDiagonal(int dimension) {
        String[][] board = getBoard();
        //sutun kontrol
        for (int column = 0; column <= dimension-3 ; ++column) {
            for(int row = 0; row < dimension ; ++row ){
                if(column == row) {
                    if (!"-".equals(board[row][column]) && "s".equals(board[row][column]))
                        if ("o".equals(board[row+1][column+1]) && "s".equals(board[row+2][column+2])){

                            return true;
                        }
                }
            }

        }

        return false;
    }

    public boolean checkFirstDiagonalSubTriangleMatrix(int dimension){

        String[][] board = getBoard();

        for (int row = 1; row <= dimension-3 ; ++row) {
            for(int column = 0; column < row ; ++column ){

                if (!"-".equals(board[row][column]) && "s".equals(board[row][column]))
                    if ("o".equals(board[row+1][column+1]) && "s".equals(board[row+2][column+2]))
                        return true;
            }

        }

        return false;
    }

    public boolean checkSecondDiagonalSubTriangleMatrix(int dimension){

        String[][] board = getBoard();

        if(dimension > 3) {

            for (int row = 1; row <= dimension - 3; ++row) {
                for (int column = dimension - 1; column >= 0; --column) {

                    if (!"-".equals(board[row][column]) && "s".equals(board[row][column]))
                        if ("o".equals(board[row + 1][column - 1]) && "s".equals(board[row + 2][column - 2]))
                            return true;
                }

            }
        }
        return false;
    }

    private boolean checkSecondDiagonal(int dimension) {
        String[][] board = getBoard();

        if(dimension > 3) {

            for (int row = 0; row <= dimension - 3; ++row) {
                for (int column = dimension - 1; column >= 0; --column) {

                    if (!"-".equals(board[row][column]) && "s".equals(board[row][column]))
                        if ("o".equals(board[row + 1][column - 1]) && "s".equals(board[row + 2][column - 2]))
                            return true;
                }

            }
        }
        return false;
    }



    public int scoreCalculation(int playCount, int dimension){
        int score = 0;

        if(playCount > 2){


            if(checkColumns(dimension)) {
                score++;
            }
            if(checkRows(dimension)) {
                score++;
            }
            if(checkFirstDiagonal(dimension)) {
                score++;
            }
            if(checkSecondDiagonal(dimension)) {
                score++;
            }
            if(checkFirstDiagonalSubTriangleMatrix(dimension)) {
                score++;
            }
            if(checkSecondDiagonalSubTriangleMatrix(dimension)) {
                score++;
            }

            System.out.println(score);

        }
        return score;
    }


}
