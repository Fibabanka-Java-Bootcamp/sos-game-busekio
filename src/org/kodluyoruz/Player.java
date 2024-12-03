package org.kodluyoruz;

public class Player {

    private int currentPlayer ;

    public Player(){
        currentPlayer = 0; //oyuncu currentPlayer=1 olusa bilgisayar oynayacak
    }

    public void changePlayer(){

        if(currentPlayer == 0)
            currentPlayer = 1; //bilgisayar
        else
            currentPlayer = 0; //oyuncu
    }

    public String playerName(){

        return currentPlayer == 0 ? "İlk oyuncu " : "Bilgisayar ";
    }
}
