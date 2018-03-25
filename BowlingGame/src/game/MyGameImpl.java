package game;

public class MyGameImpl implements IGame {

    // aktualny rzut
    private int numberOfRolls = 0;

    // ile kręgli zostało zbitych w rzucie (można wykonać maks. 21 rzutów)
    private int[] knockedPins = new int[21];


    @Override
    public void roll(int pins) {
        knockedPins[numberOfRolls] = pins;
        numberOfRolls++;
    }


    @Override
    public int score() {
        int score = 0;

        // indeks aktualnego rzutu
        int currentRoll = 0;

        // wszystkie ramki od 1 do 9
        for(int frame = 0; frame<9; frame++){
            if(knockedPins[currentRoll] == 10){ // Strike

                // dodaj 10 punktów oraz dodatkowe punkty z dwóch następnych rzutów
                score += (10 + knockedPins[currentRoll + 1] + knockedPins[currentRoll + 2]);

                // w ramce był strike, więc wykonano w niej tylko jeden rzut
                currentRoll++;
            }
            else if((knockedPins[currentRoll] + knockedPins[currentRoll + 1]) == 10){ // Spare

                // suma całej ramki (zawsze 10) oraz jednego następnego rzutu
                score += (10 + knockedPins[currentRoll + 2]);

                // w ramce było spare, więc rzucono dwa razy
                currentRoll += 2;

            }
            else{ // Brak bonusu
                // suma ramki
                score += knockedPins[currentRoll] + knockedPins[currentRoll + 1];

                // wykonano dwa rzuty
                currentRoll += 2;
            }
        }

        //Dodanie punktów z ostatniej ramki
        if(numberOfRolls - 3 == currentRoll){ // 3 rzuty w ostatniej ramce
            score += knockedPins[currentRoll] + knockedPins[currentRoll + 1] + knockedPins[currentRoll + 2];
        }
        else if(numberOfRolls - 2 == currentRoll){ // 2 rzuty w ostatniej ramce
            score += knockedPins[currentRoll] + knockedPins[currentRoll + 1];
        }

        return score;
    }

}
