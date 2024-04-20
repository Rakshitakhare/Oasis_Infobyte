import javax.swing.*;

// import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;

public class RailwayReservationSystem extends JFrame implements ActionListener {
  // Components for login page
  private JPanel loginPanel;
  private JPanel mainpagPanel;
  private JPanel cancelPanel;
  private JPanel reservePanel;
  private JTextField usernameField;
  private JPasswordField passwordField;
  private JButton loginButton;

  // Components for main menu page
  private JButton reserveTicketButton;
  private JButton cancelTicketButton;
  private JButton logoutButton;
  // Components for reserve ticket page
  private JTextField trainNameField;
  private JTextField trainNumberField;
  private JTextField dateField;
  private JTextField timeField;
  private JTextField sourceField;
  private JTextField destinationField;
  private JButton reserveTicketConfirmButton;
  private JButton back_resButton;
  // Components for cancel ticket page
  private JTextField pnrNumberField;
  private JButton cancelTicketConfirmButton;
  private int pnr_number;
  private JButton back_cancelButton;

  // Database connection variables
  private Connection conn;

  public RailwayReservationSystem() {
    // Initialize database connection
    try {
      conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/railwayreservationsystem", "root",
          "shubham01");
      conn.createStatement();
    } catch (SQLException e) {
      e.printStackTrace();
    }

    // Initialize login page components
    usernameField = new JTextField(20);
    passwordField = new JPasswordField(20);
    loginButton = new JButton("Login");
    loginButton.addActionListener(this);

    // Initialize main menu page components
    reserveTicketButton = new JButton("Reserve Ticket");
    cancelTicketButton = new JButton("Cancel Ticket");
    logoutButton = new JButton("Logout");
    reserveTicketButton.addActionListener(this);
    cancelTicketButton.addActionListener(this);
    logoutButton.addActionListener(this);

    // Initialize reserve ticket page components
    trainNameField = new JTextField(20);
    trainNumberField = new JTextField(20);
    dateField = new JTextField(20);
    timeField = new JTextField(20);
    sourceField = new JTextField(20);
    destinationField = new JTextField(20);
    reserveTicketConfirmButton = new JButton("Reserve");
    reserveTicketConfirmButton.addActionListener(this);
    back_resButton = new JButton("Back");
    back_resButton.addActionListener(this);

    // Initialize cancel ticket page components
    pnrNumberField = new JTextField(20);
    cancelTicketConfirmButton = new JButton("Confirm Cancellation");
    cancelTicketConfirmButton.addActionListener(this);
    back_cancelButton = new JButton("Back");
    back_cancelButton.addActionListener(this);
  }

  private void login() {
    // Add components to login page
    loginPanel = new JPanel(new GridLayout(3, 2));
    loginPanel.add(new JLabel("Username:"));
    loginPanel.add(usernameField);
    loginPanel.add(new JLabel("Password:"));
    loginPanel.add(passwordField);
    loginPanel.add(new JLabel(""));
    loginPanel.add(loginButton);
    add(loginPanel);
    // Set JFrame properties
    setTitle("Railway Reservation System");
    setSize(400, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    if (e.getSource() == loginButton) {
      // Perform login action
      String username = usernameField.getText();
      String password = String.valueOf(passwordField.getPassword());
      if (validateLogin(username, password)) {
        // Show main menu page
        showMainMenuPage();
      } else {
        JOptionPane.showMessageDialog(this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
      }
    } else if (e.getSource() == reserveTicketButton) {

      showReserveTicketPage();
    } else if (e.getSource() == cancelTicketButton) {
      // Show cancel ticket page
      showCancelTicketPage();
    } else if (e.getSource() == logoutButton) {
      remove(mainpagPanel);
      login();
    } else if (e.getSource() == reserveTicketConfirmButton) {
      // Perform reserve ticket action
      String trainName = trainNameField.getText();
      String trainNumber = trainNumberField.getText();
      String date = dateField.getText();
      String time = timeField.getText();
      String source = sourceField.getText();
      String destination = destinationField.getText();
      if (reserveTicket(trainName, trainNumber, date, time, source, destination)) {
        JOptionPane.showMessageDialog(this, "Ticket reserved successfully\nYour PNR Number is : " + pnr_number,
            "Success",
            JOptionPane.INFORMATION_MESSAGE);
        remove(reservePanel);
        showMainMenuPage();
      } else {
        JOptionPane.showMessageDialog(this, "Failed to reserve ticket", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    } else if (e.getSource() == cancelTicketConfirmButton) {
      // Perform cancel ticket action
      int pnrNumber = Integer.parseInt(pnrNumberField.getText());
      if (cancelTicket((pnrNumber))) {
        JOptionPane.showMessageDialog(this, "Ticket cancelled successfully",
            "Success",
            JOptionPane.INFORMATION_MESSAGE);
        remove(cancelPanel);
        showMainMenuPage();
      } else {
        JOptionPane.showMessageDialog(this, "Failed to cancel ticket", "Error",
            JOptionPane.ERROR_MESSAGE);
      }
    } else if (e.getSource() == back_resButton) {
      remove(reservePanel);
      showMainMenuPage();
    } else if (e.getSource() == back_cancelButton) {
      remove(cancelPanel);
      showMainMenuPage();
    }
  }

  private boolean validateLogin(String username, String password) {
    try {
      // Execute a SQL query to check if the provided username and password existin
      // the database
      String sql = "SELECT * FROM users WHERE username = ? AND password = ?;";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, username);
      statement.setString(2, password);
      ResultSet resultSet = statement.executeQuery();
      // If a record is found, return true, indicating successful login
      return resultSet.next();
    } catch (SQLException e) {
      e.printStackTrace();
      return false; // Return false in case of any database error
    }
  }

  private void showMainMenuPage() {
    passwordField.setText("");
    remove(loginPanel);
    mainpagPanel = new JPanel(new GridLayout(2, 2));
    mainpagPanel.add(reserveTicketButton);
    mainpagPanel.add(logoutButton);
    mainpagPanel.add(cancelTicketButton);
    add(mainpagPanel);
    setVisible(true);
  }

  private void showReserveTicketPage() {
    // Code to show reserve ticket page
    remove(mainpagPanel);
    reservePanel = new JPanel(new GridLayout(7, 2));
    reservePanel.add(new JLabel("Train Number"));
    reservePanel.add(trainNumberField);
    reservePanel.add(new JLabel("Train Name"));
    reservePanel.add(trainNameField);
    reservePanel.add(new JLabel("Date"));
    reservePanel.add(dateField);
    reservePanel.add(new JLabel("Source"));
    reservePanel.add(sourceField);
    reservePanel.add(new JLabel("Destination"));
    reservePanel.add(destinationField);
    reservePanel.add(reserveTicketConfirmButton);
    reservePanel.add(back_resButton);
    add(reservePanel);
    setVisible(true);
  }

  private boolean reserveTicket(String trainName, String trainNumber, String date, String time, String source,
      String destination) {
    try {
      // Execute a SQL query to insert reservation details into the database
      Random rn = new Random();
      int pnr = rn.nextInt(999999999);
      String sql = "INSERT INTO reservations (train_name, train_number, date, time,source, destination,pnr_number) VALUES (?, ?, ?, ?, ?, ?,?)";
      PreparedStatement statement = conn.prepareStatement(sql);
      statement.setString(1, trainName);
      statement.setString(2, trainNumber);
      statement.setString(3, date);
      statement.setString(4, time);
      statement.setString(5, source);
      statement.setString(6, destination);
      statement.setFloat(7, pnr);

      // Execute the query
      int rowsInserted = statement.executeUpdate();

      // If the query successfully inserts a row, return true, indicating
      // successful reservation;
      pnr_number = pnr;
      return rowsInserted > 0;
    } catch (SQLException e) {
      e.printStackTrace();
      return false; // Return false in case of any database error
    }
  }

  private void showCancelTicketPage() {
    remove(mainpagPanel);
    cancelPanel = new JPanel(new GridLayout(3, 2));
    cancelPanel.add(new JLabel("PNR Number"));
    cancelPanel.add(pnrNumberField);
    cancelPanel.add(new JLabel("Confirm Password"));
    cancelPanel.add(passwordField);
    cancelPanel.add(cancelTicketConfirmButton);
    cancelPanel.add(back_cancelButton);
    add(cancelPanel);
    setVisible(true);
  }

  private boolean cancelTicket(int pnr_number) {
    String pass = String.valueOf(passwordField.getPassword());
    String user = usernameField.getText();
    int rowsDeleted = 0;
    boolean result = false;
    try {
      // Execute a SQL query to delete the ticket based on the PNR number
      String check = "select password from users where username = ?";
      PreparedStatement state = conn.prepareStatement(check);
      state.setString(1, user);
      ResultSet res = state.executeQuery();
      if (res.next()) {
        String get_pass = res.getString(1);
        if (get_pass.compareTo(pass) == 0) {
          String sql = "DELETE FROM reservations WHERE pnr_number = ?";
          PreparedStatement statement = conn.prepareStatement(sql);
          statement.setInt(1, pnr_number);

          // Execute the query
          rowsDeleted = statement.executeUpdate();

          // If the query successfully deletes a row, return true, indicating
          // successful ticket cancellation;
          result = rowsDeleted > 0;
        } else {
          JOptionPane.showMessageDialog(this, "Wrong Password !!");
          result = false;
        }
      }
      return result;
    } catch (SQLException e) {
      e.printStackTrace();
      return false; // Return false in case of any database error
    }
  }

  public static void main(String[] args) {
    new RailwayReservationSystem().login();

  }
}