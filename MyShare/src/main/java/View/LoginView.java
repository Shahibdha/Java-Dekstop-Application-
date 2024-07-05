package View;

import Controllers.LoginController;
import Models.User;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubDarkContrastIJTheme;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JFrame{
    private JTextField txtUserName;
    private JTextField txtPassword;
    private JButton btnLogin;
    private JLabel lblUsername;
    private JLabel lblPassword;
    private JLabel lblTitle;
    private JLabel lblMyShare;
    private JPanel contentPane;

    public LoginView() {
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String user = txtUserName.getText();
                String pass = txtPassword.getText();
                User u = new User(null, user, null, pass);
                LoginController controller = new LoginController();
                User valid = controller.validateUser(u);

                if (valid != null) {
                    //Can add switch cases for different views according to different admins
                    FlatGitHubDarkContrastIJTheme.setup();
                    HomeView ui = new HomeView();
                    setVisible(false);
                    ui.setContentPane(ui.contentPane);
                    ui.setTitle("Group Project ");
                    ui.lblWelcome.setText("WELCOME " + valid.getName().toUpperCase());
                    ui.setSize(600, 600);
                    ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    ui.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Incorrect username or password", "Error", 0);
                }
            }
        });
    }

    public static void main(String[] args) {
        FlatGitHubDarkContrastIJTheme.setup();
        LoginView ui=new LoginView();
        ui.setContentPane(ui.contentPane);
        ui.setTitle("Login Page");
        ui.setSize(400,400);
        ui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ui.setVisible(true);
    }
}
