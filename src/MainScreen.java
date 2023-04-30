import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class MainScreen {
    private JPanel mainPanel;
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JLabel img;
    JFrame mainF = new JFrame();
public MainScreen() {
    mainF.setContentPane(mainPanel);
    mainF.setVisible(true);
    mainF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    //mainF.pack();
  //  mainF.setMaximumSize(new Dimension(1000000, 100));
   // mainF.setState(Frame.NORMAL);
    String username = "admin";
    String password = "admin";
    char[] pwd = password.toCharArray();
    loginButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(username.equals(textField1.getText())&&Arrays.equals(pwd,passwordField1.getPassword())){
                System.out.println("before");
                new AdminScreen();
                System.out.println("after");
            }
            else{
                JOptionPane.showMessageDialog(null,"Incorrect username or password");
            }

        }
    });
}


}


