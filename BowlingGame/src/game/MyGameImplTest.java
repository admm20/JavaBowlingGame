package game;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MyGameImplTest {

    private IGame game = new MyGameImpl();

    @Test
    public void onlyZeros(){
        for(int a=0; a<20; a++){
            game.roll(0);
        }
        assertEquals(0, game.score());
    }

    @Test
    public void onlyOnes(){
        for(int a=0; a<20; a++){
            game.roll(1);
        }
        assertEquals(20, game.score());
    }

    @Test
    public void perfectGame(){
        for(int a=0; a<12; a++){
            game.roll(10);
        }
        assertEquals(300, game.score());
    }

    @Test
    public void normalGame(){
        //dwa strike, trzy spare, trzy rzuty w ostatniej ramce
        String numbers = "5 4 2 7 10 2 8 5 4 2 6 8 2 5 4 3 6 1 9 10";
        for(String s : numbers.split(" ") ){
            game.roll(Integer.parseInt(s));
        }
        assertEquals(123, game.score());

    }
}