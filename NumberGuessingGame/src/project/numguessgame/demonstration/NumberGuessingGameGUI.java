package project.numguessgame.demonstration;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumberGuessingGameGUI extends JFrame {
		private static final long serialVersionUID = 1L;

	    private int randomNumber;
	    private JTextField guessTextField;
	    private JLabel resultLabel;

	    public NumberGuessingGameGUI() {
	        setTitle("Number Guessing Game");
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        setSize(300, 150);
	        setLocationRelativeTo(null);

	        initializeComponents();

	        randomNumber = generateRandomNumber();
	    }

	    private void initializeComponents() {
	        setLayout(new GridLayout(3, 1));

	        JLabel titleLabel = new JLabel("Guess the Number!");
	        titleLabel.setHorizontalAlignment(JLabel.CENTER);
	        add(titleLabel);

	        guessTextField = new JTextField();
	        guessTextField.setHorizontalAlignment(JTextField.CENTER);
	        add(guessTextField);

	        JButton guessButton = new JButton("Guess");
	        guessButton.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                checkGuess();
	            }
	        });
	        add(guessButton);

	        resultLabel = new JLabel("");
	        resultLabel.setHorizontalAlignment(JLabel.CENTER);
	        add(resultLabel);
	    }

	    private int generateRandomNumber() {
	        return (int) (Math.random() * 100) + 1;
	    }

	    private void checkGuess() {
	        try {
	            int guess = Integer.parseInt(guessTextField.getText());

	            if (guess == randomNumber) {
	                resultLabel.setText("Congratulations! You guessed the correct number.");
	            } else if (guess < randomNumber) {
	                resultLabel.setText("Too low. Try again!");
	            } else {
	                resultLabel.setText("Too high. Try again!");
	            }
	        } catch (NumberFormatException ex) {
	            resultLabel.setText("Please enter a valid number.");
	        }
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new NumberGuessingGameGUI().setVisible(true);
            }
        });
	}
}