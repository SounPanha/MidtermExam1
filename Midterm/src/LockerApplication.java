import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LockerApplication extends JFrame implements ActionListener {

    private JTextField passcodeField;
    private JButton enterButton;
    private JLabel statusLabel;

    private String password;
    private boolean passwordSet;

    public LockerApplication() {
        setTitle("Locker Application");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Components initialization
        passcodeField = new JTextField(20);
        enterButton = new JButton("Enter");
        enterButton.addActionListener(this);
        statusLabel = new JLabel("Enter passcode to set password", JLabel.CENTER);

        // Panel for components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(3, 1));
        panel.add(passcodeField);
        panel.add(enterButton);
        panel.add(statusLabel);

        // Adding panel to JFrame
        add(panel, BorderLayout.CENTER);

        // Initialize variables
        password = "";
        passwordSet = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == enterButton) {
            String passcode = passcodeField.getText();

            if (!passwordSet) {
                // Setting the password for the first time
                password = passcode;
                passwordSet = true;
                statusLabel.setText("Password Set");
            } else {
                // Verifying the password
                if (passcode.equals(password)) {
                    statusLabel.setText("Correct Password");
                } else {
                    statusLabel.setText("Incorrect Password");
                }
            }

            // Clear the passcode field after each action
            passcodeField.setText("");
        }
    }
}