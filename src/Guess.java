import java.util.Scanner;

class Guesser {
    int difficultyLevel;
    int guessNumber;

    int getGuessedNumber() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Choose the difficulty level from 1 to 3:");
        difficultyLevel = scan.nextInt();
        switch (difficultyLevel) {
            case 1:
                System.out.println("Guesser, guess the number from 1 to 10:");
                while (true) {
                    guessNumber = scan.nextInt();
                    if (guessNumber >= 1 && guessNumber <= 10) {
                        return guessNumber;
                    } else {
                        System.out.println("Invalid number, out of range. Try again.");
                    }
                }
            case 2:
                System.out.println("Guesser, guess the number from 1 to 50:");
                while (true) {
                    guessNumber = scan.nextInt();
                    if (guessNumber >= 1 && guessNumber <= 50) {
                        return guessNumber;
                    } else {
                        System.out.println("Invalid number, out of range. Try again.");
                    }
                }
            case 3:
                System.out.println("Guesser, guess the number from 1 to 100:");
                while (true) {
                    guessNumber = scan.nextInt();
                    if (guessNumber >= 1 && guessNumber <= 100) {
                        return guessNumber;
                    } else {
                        System.out.println("Invalid number, out of range. Try again.");
                    }
                }
            default:
                System.out.println("Invalid choice! Please select a valid difficulty.");
                return -1;
        }
    }
}

class Player {
    Scanner scan = new Scanner(System.in);
    int guessedNumber;
    int difficultyLevel;

    int guessNumber() {
        for (int i = 1; i <= 3; i++) {
            if (difficultyLevel == 1) {
                System.out.println("Player" + i +" guess the number from 1 to 10:");
                while (true) {
                    guessedNumber = scan.nextInt();
                    if (guessedNumber >= 1 && guessedNumber <= 10) {
                        return guessedNumber;
                    } else {
                        System.out.println("Invalid number, out of range. Try again.");
                    }
                }
            } else if (difficultyLevel == 2) {
                System.out.println("Player" + i +" guess the number from 1 to 50:");
                while (true) {
                    guessedNumber = scan.nextInt();
                    if (guessedNumber >= 1 && guessedNumber <= 50) {
                        return guessedNumber;
                    } else {
                        System.out.println("Invalid number, out of range. Try again.");
                    }
                }
            } else if (difficultyLevel == 3) {
                System.out.println("Player "+ i + " guess the number from 1 to 100:");
                while (true) {
                    guessedNumber = scan.nextInt();
                    if (guessedNumber >= 1 && guessedNumber <= 100) {
                        return guessedNumber;
                    } else {
                        System.out.println("Invalid number, out of range. Try again.");
                    }
                }
            } else {
                System.out.println("Invalid difficulty level! Please select a valid difficulty.");
                return -1;
            }
        }return -1;
    }
}

class Umpire {
    int guessedNumberByGuesser;
    int guessedNumberByPlayer1;
    int guessedNumberByPlayer2;
    int guessedNumberByPlayer3;
    int difficultyLevel;

    void collectGuesserNumber() {
        Guesser guesser = new Guesser();
        guessedNumberByGuesser = guesser.getGuessedNumber();
        difficultyLevel = guesser.difficultyLevel;
    }

    void collectPlayerNumbers() {
        Player player1 = new Player();
        player1.difficultyLevel = difficultyLevel;
        guessedNumberByPlayer1 = player1.guessNumber();

        Player player2 = new Player();
        player2.difficultyLevel = difficultyLevel;
        guessedNumberByPlayer2 = player2.guessNumber();

        Player player3 = new Player();
        player3.difficultyLevel = difficultyLevel;
        guessedNumberByPlayer3 = player3.guessNumber();
    }

    void compareGuesses() {
        if (guessedNumberByGuesser == guessedNumberByPlayer1 &&
                guessedNumberByGuesser == guessedNumberByPlayer2 &&
                guessedNumberByGuesser == guessedNumberByPlayer3) {
            System.out.println("All players won. Game tied. Restart the game.");
        } else if (guessedNumberByGuesser == guessedNumberByPlayer1) {
            if (guessedNumberByGuesser == guessedNumberByPlayer2) {
                System.out.println("Player 1 and Player 2 won.");
            } else if (guessedNumberByGuesser == guessedNumberByPlayer3) {
                System.out.println("Player 1 and Player 3 won.");
            } else {
                System.out.println("Player 1 guessed correctly.");
            }
        } else if (guessedNumberByGuesser == guessedNumberByPlayer2) {
            if (guessedNumberByGuesser == guessedNumberByPlayer3) {
                System.out.println("Player 2 and Player 3 won.");
            } else {
                System.out.println("Player 2 guessed correctly.");
            }
        } else if (guessedNumberByGuesser == guessedNumberByPlayer3) {
            System.out.println("Player 3 guessed correctly.");
        } else {
            System.out.println("No one guessed correctly. Game lost. Try again.");
        }
    }
}

public class Guess {
    public static void main(String[] args) {
        Lc obj = new Lc();
        obj.login();
        Umpire umpire = new Umpire();
        while (true) {
            umpire.collectGuesserNumber();
            umpire.collectPlayerNumbers();
            umpire.compareGuesses();

            Scanner scan = new Scanner(System.in);
            System.out.println("Do you want to play again? (y/n)");
            String playAgain = scan.next();
            if (!playAgain.equalsIgnoreCase("y")) {
                System.out.println("Thanks for playing!");
                break;
            }
        }
    }
}
 class Lc {
    public void login() {
        Scanner scan = new Scanner(System.in);
        String username = new String("madhujith005@gmail.com");
        String password = new String("Error@123");
        while(true)
        {
            System.out.println("Username:");
            String un=scan.next();
            if (un.equalsIgnoreCase(username))
            {
                System.out.println("Password:");
                String pa = scan.next();
                if (pa.equals(password))
                {
                    System.out.println("Login successfull");
                    break;
                }
                else
                {
                    System.out.println("Password incorrect Try Again!");
                }
            }
            else
            {
                System.out.println("Username Incorrect Try Again!");
            }
        }


    }
}