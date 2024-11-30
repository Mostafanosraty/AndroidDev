import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class LoginFrame extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton;

  private void loginButtonActionPerformed(ActionEvent e) {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
    boolean isValid = true;
    if (username.isEmpty() || password.isEmpty()) {
      isValid = false;
      String errorMessage = ".لطفا نام کاربری و رمز عبور را وارد کنید";
      JOptionPane.showMessageDialog(this,errorMessage);
      return;
    }
    if (isValid) {
      try {
     
      Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "username", "password");
      
      String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
      PreparedStatement statement = connection.prepareStatement(sql);
      statement.setString(1, username);
      statement.setString(2, password);
      
      ResultSet resultSet = statement.executeQuery();
      if (resultSet.next()){
        JOptionPane.showMessageDialog(null, "با موفقیت وارد شدید.");
      } else {
        JOptionPane.showMessageDialog(null, "نام کاربری یا رمز عبور اشتباه است.");
      }
      resultSet.close();
      statement.close();
      connection.close();
    }
    catch (SQLException ex) {
      JOptionPane.showMessageDialog(null, "خطا در اتصال به سیستم: " + ex.getMessage());
    }
  }
  }
}