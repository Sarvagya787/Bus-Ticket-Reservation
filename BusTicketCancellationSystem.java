import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class BusTicketCancellationSystem implements ActionListener {
    JFrame frame;
    JPanel panel;
    JPanel panel2;
    JButton backButton, cancelButton;
    JLabel titleLabel, textLabel;
    JTextField textField;
    JLabel buttonLabel; 

    JLabel adLabel;

    JLabel logoLabel;

    String tktUID;

    ImageIcon image = new ImageIcon("CP_MinorProject/src/normal_cat.jpg");
    Image scaledImage= image.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newCatIcon = new ImageIcon(scaledImage);

    ImageIcon image2 = new ImageIcon("CP_MinorProject/src/thug_cat.jpg");
    Image scaledImage2 = image2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon thugcatIcon = new ImageIcon(scaledImage2);

    ImageIcon image11 = new ImageIcon("CP_MinorProject/src/city.jpg");
    Image scaledImage11 = image11.getImage().getScaledInstance(490, 690, java.awt.Image.SCALE_SMOOTH);
    ImageIcon cityIcon = new ImageIcon(scaledImage11);

    ImageIcon image10 = new ImageIcon("CP_MinorProject/src/cancel.jpg");
    Image scaledImage10= image10.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon cancelIcon = new ImageIcon(scaledImage10);

    ImageIcon image7 = new ImageIcon("CP_MinorProject/src/bus_image.jpg");
    Image scaledImage7 = image7.getImage().getScaledInstance(490,220, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newBusImage = new ImageIcon(scaledImage7);

    ImageIcon image12 = new ImageIcon("CP_MinorProject/src/main.jpg");
    Image scaledImage12 = image12.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    

    ImageIcon image13 = new ImageIcon("CP_MinorProject/src/main.jpg");
    Image scaledImage13 = image13.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    

    

    HomePage home;
    BusTicketCancellationSystem() {
        frame = new JFrame("JOHNNY SINS SOFTWARE");
        frame.setBounds(0,0,1300,900);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
       frame.getContentPane().setBackground(new Color(159, 207, 185, 255));
       frame.setResizable(false);
       frame.setIconImage(scaledImage13);
        panel = new JPanel();
        panel.setBounds(50, 50, 500, 700);
        panel.setLayout(null);
        panel.setBackground(Color.cyan);

        titleLabel = new JLabel("Ticket Cancellation Window");
        titleLabel.setBounds(5, 5, 490, 50);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(JLabel.TOP);
        titleLabel.setOpaque(true);
        titleLabel.setIcon(cancelIcon);

        textLabel = new JLabel("Enter Ticket UID:");
        textLabel.setBounds(5, 100, 490, 200);
        textLabel.setFont(new Font("Arial", Font.BOLD, 24));
        textLabel.setBorder(BorderFactory.createEtchedBorder());
        textLabel.setVerticalAlignment(JLabel.TOP);
        textLabel.setOpaque(true);
        textLabel.setBackground(new Color(135,206,255));

        textField = new JTextField();
        textField.setBounds(5, 100, 480, 70);
        textField.setBorder(BorderFactory.createEtchedBorder());
        textField.setFont(new Font(null,Font.PLAIN,24));
       
        textLabel.add(textField);
         

        panel2 = new JPanel();
        panel2.setBounds(700, 50, 500, 700);
        panel2.setLayout(null);
        panel2.setBackground(new Color(47, 215, 176, 255));

        adLabel = new JLabel();
        adLabel.setBounds(5, 5, 490, 690);
        adLabel.setOpaque(false);
        adLabel.setIcon(cityIcon);

        panel2.add(adLabel);

        buttonLabel = new JLabel();
        buttonLabel.setBounds(5,350,490,100);
        buttonLabel.setOpaque(false);
        
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(300, 5, 150, 75);
        cancelButton.setBackground(new Color(255,255,255));
        cancelButton.setFont(new Font("Arial", Font.BOLD, 18));
        cancelButton.addActionListener(this);
        cancelButton.setFocusable(false);

        backButton = new JButton("Back");
        backButton.setBounds(50, 5, 150, 75);
        
        backButton.setBackground(new Color(255,255,255));
        backButton.setFont(new Font("Arial", Font.BOLD, 18));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        buttonLabel.add(backButton);
        buttonLabel.add(cancelButton);
       
        logoLabel = new JLabel();
        logoLabel.setBounds(5,475,490,220);
        logoLabel.setOpaque(true);
        logoLabel.setIcon(newBusImage);

        panel.add(titleLabel);
        panel.add(textLabel);   
        panel.add(buttonLabel);
        panel.add(logoLabel);
        frame.add(panel);
        frame.add(panel2);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cancelButton) {
            String ticketUID = textField.getText().trim();
            if (!ticketUID.isEmpty()) {
                tktUID = textField.getText().trim();
                textField.setText("");  
            
                //Work on database
String url = "jdbc:mysql://localhost:3306/UserDatabase?serverTimezone=UTC";
String user = "root";
String password = "@Sarvagya2004";

String sql = "DELETE FROM UserTickets WHERE ticket_UID = ?";

try (
    Connection connection = DriverManager.getConnection(url, user, password);
    PreparedStatement preparedStatement = connection.prepareStatement(sql)
) {
    preparedStatement.setString(1, tktUID);

    int rowsDeleted = preparedStatement.executeUpdate();
    if (rowsDeleted > 0) {
        JOptionPane.showMessageDialog(null,  "Ticket Canceled Successfully", "Message", JOptionPane.INFORMATION_MESSAGE,thugcatIcon);
        System.out.println("Data deleted successfully!");
    } else {
        System.out.println("No record found with the given UID.");
        JOptionPane.showMessageDialog(null,  "UID didn't matched", "Message", JOptionPane.INFORMATION_MESSAGE,newCatIcon);
    }
} catch (SQLException exception) {
    exception.printStackTrace();
    System.out.println("Failed to delete data.");
}
 
//database work ends here

            } else {
                JOptionPane.showMessageDialog(null,  "UID can't be empty", "Message", JOptionPane.INFORMATION_MESSAGE,newCatIcon);
            }
        } 
        else if(e.getSource()==backButton){
           home = new HomePage();
           frame.dispose();
        }
    }
}

