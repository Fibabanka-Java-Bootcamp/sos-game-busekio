package org.kodluyoruz;

public class Main {


    public static void main(String[] args) {
        // write your code here

        runGame();

    }

    public static void runGame(){


        int playCount = 0;
        int scorePlayer = 0, scoreComputer = 0;

        RandomGenerate generate = new RandomGenerate();

        Scanner kb = new Scanner(System.in);

        System.out.println("Oyuna Basliyor!!!");

        System.out.print("Oyun alaninin boyutunu giriniz: ");
        int dimension = Integer.parseInt(kb.nextLine());

        BoardOperations boardOperation = new BoardOperations(dimension);
        boardOperation.printBoard(dimension);

        Player player = new Player();

        do {

            int row, column;
            String boardInput;

            System.out.printf("%s icin input degerleri aliniyor...%n", player.playerName());

            System.out.print("Satir numarasi giriniz: ");


            if (playCount % 2 == 0) {
                row = Integer.parseInt(kb.nextLine());
            } else {
                row = generate.generateRowColumnNumber(dimension);
                System.out.printf("%d%n", row);
            }

            System.out.print("Sutun numarasi giriniz: ");

            if (playCount % 2 == 0) {
                column = Integer.parseInt(kb.nextLine());
            } else {
                column = generate.generateRowColumnNumber(dimension);
                System.out.printf("%d%n", column);
            }

            System.out.print("Oyunda yazmak istediginiz karakteri giriniz: ");

            if (playCount % 2 == 0) {
                boardInput = kb.nextLine();
            } else {

                boardInput = generate.generateCharacter();
                System.out.printf("%s%n", boardInput);
            }


            playCount++;

            boardOperation.markBoard(row, column, dimension, boardInput);
            boardOperation.printBoard(dimension);

            if ("İlk oyuncu".equals(player.playerName())) {
                scorePlayer += boardOperation.scoreCalculation(playCount, dimension);
            } else {
                scoreComputer += boardOperation.scoreCalculation(playCount, dimension);
            }

            player.changePlayer();

        } while (!boardOperation.isBoardFull(dimension));

        if (scoreComputer > scorePlayer)
            System.out.printf("Bilgisayar kazandi!!!%nBilgisayarin toplam puani: %d%nOyuncunun toplam puani:%d%n ", scoreComputer, scorePlayer);

        else if (scoreComputer < scorePlayer)
            System.out.printf("Ilk oyuncu kazandi!!!%nOyuncunun toplam puani: %d%nBilgisayarin toplam puani:%d%n ", scorePlayer, scoreComputer);

        else
            System.out.printf("Oyun berabere bitti!!! %n %d - %d", scoreComputer, scorePlayer);

    }
}
