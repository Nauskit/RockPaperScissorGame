import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RockPaperScissorGUI extends JFrame implements ActionListener {
    public RockPaperScissorGUI(){
        super("RockPaperScissor");
        setSize(450,580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        setResizable(false);
        GuiComponents();
        rockPaperScissor = new LogicGamePlay();
    }
    //Label
    JLabel computerChoice;
    JLabel computerScoreLabel,playerScoreLabel;

    //Button
    JButton rockButton,paperButton,scissorButton;
    LogicGamePlay rockPaperScissor;
    public void GuiComponents(){
        //computerScore
        computerScoreLabel = new JLabel("Computer : 0");
        computerScoreLabel.setBounds(0,43,450,30);
        computerScoreLabel.setFont(new Font("Dialog", Font.BOLD, 26));
        computerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(computerScoreLabel);

        //computerChoice
        computerChoice = new JLabel("?");
        computerChoice.setBounds(175,118,98,81);
        computerChoice.setFont(new Font("Dialog", Font.BOLD, 18));
        computerChoice.setHorizontalAlignment(SwingConstants.CENTER);
        computerChoice.setBorder(BorderFactory.createLineBorder(Color.BLACK));
        add(computerChoice);

        //playerScore
        playerScoreLabel = new JLabel("Player : 0");
        playerScoreLabel.setBounds(0,317,450,30);
        playerScoreLabel.setFont(new Font("Dialog", Font.BOLD,26));
        playerScoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(playerScoreLabel);

        //playerButton
        rockButton = new JButton("Rock");
        rockButton.setBounds(40,387,105,81);
        rockButton.setFont(new Font("Dialog", Font.PLAIN,18));
        rockButton.addActionListener(this);
        add(rockButton);

        paperButton = new JButton("Paper");
        paperButton.setBounds(165,387,105,81);
        paperButton.setFont(new Font("Dialog", Font.PLAIN,18));
        paperButton.addActionListener(this);
        add(paperButton);

        scissorButton = new JButton("Scissors");
        scissorButton.setBounds(290,387,105,81);
        scissorButton.setFont(new Font("Dialog", Font.PLAIN,18));
        scissorButton.addActionListener(this);
        add(scissorButton);

    }

    //Massage
        private void showDialog(String massage){
        JDialog resultDialog = new JDialog(this,"Result", true);
        resultDialog.setSize(230, 125);
        resultDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        resultDialog.setResizable(false);

        JLabel resultLabel = new JLabel(massage);
        resultLabel.setFont(new Font("Dialog", Font.PLAIN,20));
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);
        resultDialog.add(resultLabel);

        JButton tryAgainButton = new JButton("You can Try Again!");
        tryAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                computerChoice.setText("?");
                resultDialog.dispose();
            }
        });
        resultDialog.add(tryAgainButton,BorderLayout.SOUTH);
        resultDialog.setLocationRelativeTo(this);
        resultDialog.setVisible(true);
    }

    //ActionEvent
    @Override
    public void actionPerformed(ActionEvent e) {
        String playerChoice = e.getActionCommand().toString();
        String result = rockPaperScissor.playRockPaperScissor(playerChoice);

        computerChoice.setText(rockPaperScissor.getComputerChoice());

        computerScoreLabel.setText("Computer : " + rockPaperScissor.getComputerScore());
        playerScoreLabel.setText("Player : " + rockPaperScissor.getPlayerScore());

        showDialog(result);

    }
}
