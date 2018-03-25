package game;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BowlingGame {
    public static void main(String args[]){
        System.out.println("10-pin bowling game");
        System.out.println("Insert your points (separate them with space)");

        //wczytaj punkty z konsoli
        Scanner keyInput = new Scanner(System.in);
        String numbers = keyInput.nextLine();

        //obiekt gry
        IGame game = new MyGameImpl();

        //rozdziel String na liczby i dodaj je do gry
        for(String s : numbers.split(" ") ){
            game.roll(Integer.parseInt(s));
        }

        //zwróć liczbę punktów
        System.out.println(game.score());

    }

}
