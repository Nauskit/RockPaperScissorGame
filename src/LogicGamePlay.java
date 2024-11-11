import java.util.Random;

public class LogicGamePlay {
    private static final String[] computerChoices = {"Rock", "Paper", "Scissors"};

    private String  computerChoice;

    public String getComputerChoice() {
        return computerChoice;
    }
    public int getComputerScore(){
        return computerScore;
    }
    public int getPlayerScore(){
        return playerScore;
    }

    private int computerScore,playerScore;
    private  Random random;

    public LogicGamePlay(){
        random = new Random();
    }
    public String playRockPaperScissor(String platerChoice) {
        computerChoice = computerChoices[random.nextInt(computerChoices.length)];
        String result;

        if (computerChoice.equals("Rock")) {
            if (platerChoice.equals("Paper")) {
                result = "Player Wins";
                playerScore++;
            } else if (platerChoice.equals("Scissors")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else if (computerChoice.equals("Paper")) {
            if (platerChoice.equals("Scissors")) {
                result = "Player Wins";
                playerScore++;
            } else if (platerChoice.equals("Rock")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        } else {
            if (platerChoice.equals("Rock")) {
                result = "Player Wins";
                playerScore++;
            } else if (platerChoice.equals("Paper")) {
                result = "Computer Wins";
                computerScore++;
            } else {
                result = "Draw";
            }
        }
        return result;
    }
}
