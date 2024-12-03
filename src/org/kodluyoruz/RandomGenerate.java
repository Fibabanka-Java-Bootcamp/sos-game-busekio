package org.kodluyoruz;

import java.util.Random;

public class RandomGenerate{

    private Random random = new Random();

    private int generateNumber(){
        return random.nextInt(2);
    }

    private int generateNumber(int range){
        return random.nextInt(range) ;
    }

    public String generateCharacter(){

        if(generateNumber() == 1)
            return "s";
        else
            return "o";

    }

    public int generateRowColumnNumber(int dimension){

        return generateNumber(dimension);

    }


}
