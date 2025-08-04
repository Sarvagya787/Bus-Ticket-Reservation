import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BusTicketReservationSystem extends JFrame implements ActionListener {

   //Supplimentary components
   String name, contact, gender, age, destination,date,tktUID;
   Algorithms algo;

  
HomePage hp;

    JLabel bookingPageLabel;;
    JLabel nameLabel;
    JLabel contactLabel;
    JLabel destinationLabel;
    JLabel fromLabel;
    JLabel toLabel;
    JLabel  ageLabel;
    JLabel dateLabel;
    JLabel genderLabel;
    JTextField nameField;
    JTextField contactField;
    JLabel availabilityLabel;
    JTextField  availabilityField;
    JTextArea tickTextField;
    JRadioButton maleRadioButton;
    JRadioButton femaleRadioButton ;
    JRadioButton LGBTQRadioButton;
    MyButton checkButton;
    JLabel noticeLabel;
    JLabel gifLabel;
    JLabel wishLabel;
    JButton bookButton;
    JButton backButton;


    JSpinner ageSpinner;
    JComboBox<String> dateComboBox;
    JComboBox<String> genderComboBox;
    JComboBox<String> fromComboBox;
    JComboBox<String> toComboBox;

    JPanel panel;
    JPanel noticePanel;


   // Work on design
   ImageIcon image1 = new ImageIcon("CP_MinorProject/src/name_icon.jpg");
    Image scaledImage1 = image1.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newNameIcon = new ImageIcon(scaledImage1);

    ImageIcon image2 = new ImageIcon("CP_MinorProject/src/contact_icon.jpg");
    Image scaledImage2 = image2.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newContactIcon = new ImageIcon(scaledImage2);

    ImageIcon image3 = new ImageIcon("CP_MinorProject/src/destination_icon.jpg");
    Image scaledImage3 = image3.getImage().getScaledInstance(50, 40, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newDestinationIcon = new ImageIcon(scaledImage3);

    ImageIcon image4 = new ImageIcon("CP_MinorProject/src/gender_icon.jpg");
    Image scaledImage4 = image4.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newGenderIcon = new ImageIcon(scaledImage4);

    ImageIcon image5 = new ImageIcon("CP_MinorProject/src/date_icon.jpg");
    Image scaledImage5 = image5.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newDateIcon = new ImageIcon(scaledImage5);

    ImageIcon image6 = new ImageIcon("CP_MinorProject/src/age_icon.jpg");
    Image scaledImage6 = image6.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newAgeIcon = new ImageIcon(scaledImage6);

    ImageIcon image7 = new ImageIcon("CP_MinorProject/src/bus_image.jpg");
    Image scaledImage7 = image7.getImage().getScaledInstance(300, 150, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newBusImage = new ImageIcon(scaledImage7);

    ImageIcon image8 = new ImageIcon("CP_MinorProject/src/bus2_image.jpg");
    Image scaledImage8 = image8.getImage().getScaledInstance(500, 280, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newBus2Image = new ImageIcon(scaledImage8);

    ImageIcon image9 = new ImageIcon("CP_MinorProject/src/wish_image.jpg");
    Image scaledImage9 = image9.getImage().getScaledInstance(500, 280, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newWishImage = new ImageIcon(scaledImage9);

    ImageIcon image10 = new ImageIcon("CP_MinorProject/src/normal_cat.jpg");
    Image scaledImage10= image10.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newCatIcon = new ImageIcon(scaledImage10);

    ImageIcon image11 = new ImageIcon("CP_MinorProject/src/thug_cat.jpg");
    Image scaledImage11 = image11.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newcat2Icon = new ImageIcon(scaledImage11);

    ImageIcon image12 = new ImageIcon("CP_MinorProject/src/main.jpg");
    Image scaledImage12 = image12.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    


BusTicketReservationSystem(){
    algo = new Algorithms();
    bookingPageLabel= new JLabel("Ticket Booking");


    bookingPageLabel.setBounds(5,5,500,50);
    bookingPageLabel.setHorizontalAlignment(JLabel.CENTER);
    bookingPageLabel.setVerticalAlignment(JLabel.CENTER);
    bookingPageLabel.setForeground(Color.black);
    bookingPageLabel.setFont(new Font(null,Font.BOLD,32));


    // Work on name
    nameLabel = new JLabel("Name:");
    nameLabel.setBounds(3,3,500,50);//wrt panel
    nameLabel.setOpaque(true);
    nameLabel.setForeground(Color.black);
    nameLabel.setFont(new Font(null,Font.PLAIN,20));
    nameLabel.setBorder(BorderFactory.createEtchedBorder());
    nameLabel.setIcon(newNameIcon);
    nameLabel.setIconTextGap(5);
   
    nameField = new JTextField("Name");
    nameField.setBounds(175,3,322,44);
    nameField.setFont(new Font(null,Font.PLAIN,20));

    nameLabel.add(nameField);


    //Work on contact
    contactLabel = new JLabel("Contact:");
    contactLabel.setBounds(3,56,500,50);
    contactLabel.setOpaque(true);
    contactLabel.setForeground(Color.black);
    contactLabel.setFont(new Font(null,Font.PLAIN,20));
    contactLabel.setBorder(BorderFactory.createEtchedBorder());
    contactLabel.setIcon(newContactIcon);
    contactLabel.setIconTextGap(5);
    contactField = new JTextField("Contact");
    contactField.setBounds(175,3,322,44);
    contactField.setFont(new Font(null,Font.PLAIN,20));

    contactLabel.add(contactField);

// Work on gender selection
    genderLabel = new JLabel("Gender:");
   // genderLabel.setBounds(600,300,400,50);
    genderLabel.setBounds(3,109,500,50);
    genderLabel.setOpaque(true);
    genderLabel.setForeground(Color.black);
    genderLabel.setFont(new Font(null,Font.PLAIN,20));
    genderLabel.setBorder(BorderFactory.createEtchedBorder());
    genderLabel.setIcon(newGenderIcon);
    genderLabel.setIconTextGap(5);
  
    String [] gender = {"Male","Female","LGBTQ"};
    genderComboBox = new JComboBox(gender);
    genderComboBox.setBounds(175,3,322,44);
   genderComboBox.setFont(new Font(null,Font.PLAIN,20));

genderLabel.add(genderComboBox);


    

    ageLabel = new JLabel("Age:");
    ageLabel.setBounds(3,162,500,50);
    ageLabel.setOpaque(true);
    ageLabel.setForeground(Color.black);
    ageLabel.setFont(new Font(null,Font.PLAIN,20));
    ageLabel.setBorder(BorderFactory.createEtchedBorder());
    ageLabel.setIcon(newAgeIcon);
    ageLabel.setIconTextGap(5);
    ageSpinner = new JSpinner(new SpinnerNumberModel(1,1,80,1));
    ageSpinner.setFont(new Font(null,Font.PLAIN,20));
    ageSpinner.setBounds(175,3,322,44);

    ageLabel.add(ageSpinner);


    //Work on destination
   destinationLabel = new JLabel("Select Destination");
   fromLabel = new JLabel("From:");
   toLabel = new JLabel("To:");
  // destinationLabel.setBounds(600,400,400,150);
    destinationLabel.setBounds(3,215,500,150);
    destinationLabel.setVerticalAlignment(JLabel.TOP);
   destinationLabel.setFont(new Font(null,Font.PLAIN,20));
   destinationLabel.setOpaque(true);
   destinationLabel.setBorder(BorderFactory.createEtchedBorder());
   destinationLabel.setIcon(newDestinationIcon);
   destinationLabel.setIconTextGap(5);

    fromLabel.setBounds(0,43,500,50);
    fromLabel.setOpaque(true);
    fromLabel.setForeground(Color.black);
    fromLabel.setFont(new Font(null,Font.PLAIN,20));
    fromLabel.setBorder(BorderFactory.createEtchedBorder());
    toLabel.setBounds(0,96,500,50);
    toLabel.setOpaque(true);
    toLabel.setForeground(Color.black);
    toLabel.setFont(new Font(null,Font.PLAIN,20));
    toLabel.setBorder(BorderFactory.createEtchedBorder());
    destinationLabel.add(fromLabel);
    destinationLabel.add(toLabel);

    String [] city = {"City A","City B", "City C","City D"};

    fromComboBox= new JComboBox(city);
    fromComboBox.setBounds(75,3,322,44);
    fromComboBox.setFont(new Font(null,Font.PLAIN,20));
    fromLabel.add(fromComboBox);

    toComboBox = new JComboBox(city);
    toComboBox.setBounds(75,3,322,44);
    toComboBox.setFont(new Font(null,Font.PLAIN,20));
    toLabel.add(toComboBox);


    
    dateLabel = new JLabel("Date:");
    dateLabel.setBounds(3,370,500,50);
    dateLabel.setOpaque(true);
    dateLabel.setForeground(Color.black);
    dateLabel.setFont(new Font(null,Font.PLAIN,20));
    dateLabel.setBorder(BorderFactory.createEtchedBorder());
    dateLabel.setIcon(newDateIcon);
    dateLabel.setIconTextGap(5);


    String [] dates = Algorithms.getDates(3);
    dateComboBox = new JComboBox(dates);
    dateComboBox.setBounds(175,3,322,44);
    dateComboBox.setFont(new Font(null,Font.PLAIN,20));

    dateLabel.add(dateComboBox);



    //Work on logo
    availabilityLabel = new JLabel("Daodo Bus Service");
   
    availabilityLabel.setBounds(3,423,500,150);
    availabilityLabel.setOpaque(true);
    availabilityLabel.setForeground(Color.black);
    availabilityLabel.setFont(new Font(null,Font.BOLD,20));
    availabilityLabel.setBorder(BorderFactory.createEtchedBorder());
    availabilityLabel.setIcon(newBusImage);
    

    //Work on panel
    panel = new JPanel();
    panel.setBounds(50,50,510,700);
    panel.setLayout(null);
    panel.setBackground(Color.cyan);


    //Work on second notice panel
    noticePanel = new JPanel();
    noticePanel.setVisible(true);
    noticePanel.setBounds(700,50,500,700);
    noticePanel.setBackground(new Color(47, 215, 176, 255));
    noticePanel.setLayout(null);
   String notice = "      Ticket      ";
    noticeLabel = new JLabel(notice);
    noticeLabel.setBounds(5,260,490,250);
     noticeLabel.setBorder(BorderFactory.createEtchedBorder());
     noticeLabel.setFont(new Font(null,Font.BOLD,22));
     noticeLabel.setForeground(Color.black);
     noticeLabel.setBackground(new Color(118, 232, 113, 255));
     noticeLabel.setVerticalAlignment(JLabel.TOP);
     noticeLabel.setOpaque(true);
     tickTextField = new JTextArea();
     tickTextField.setBounds(5,50,480,190);
     tickTextField.setBorder(BorderFactory.createEtchedBorder());
     tickTextField.setEditable(false);
     tickTextField.setFont(new Font(null,Font.PLAIN,20));
     tickTextField.setForeground(Color.black);
     tickTextField.setBackground(new Color(135,206,255));
     noticeLabel.add(tickTextField);

     gifLabel = new JLabel();
     gifLabel.setBounds(5,5,490,250);
     gifLabel.setBorder(BorderFactory.createEtchedBorder());
     gifLabel.setIcon(newBus2Image);

     wishLabel = new JLabel();
     wishLabel.setBounds(5,495,490,200);
     wishLabel.setBorder(BorderFactory.createEtchedBorder());
     wishLabel.setIcon(newWishImage);
     noticePanel.add(gifLabel);
     noticePanel.add(noticeLabel);
     noticePanel.add(wishLabel);
    //Work on button
    bookButton = new JButton("Book");
    bookButton.setBounds(340,585,150,70);
    bookButton.setBorder(BorderFactory.createEtchedBorder());
    bookButton.setBackground(Color.white);
    bookButton.setFocusable(false);
    bookButton.setFont(new Font(null,Font.PLAIN,20));
    bookButton.setEnabled(true);
    bookButton.addActionListener(this);



   backButton = new JButton("Back");
   backButton.setBounds(12,585,150,70);
   backButton.setBorder(BorderFactory.createEtchedBorder());
   backButton.setBackground(Color.white);
   backButton.setFocusable(false);
   backButton.setFont(new Font(null,Font.PLAIN,20));
   backButton.addActionListener(this);

    this.setTitle("JOHNNY SINS SOFTWARES");
    this.setBounds(0,0,1300,900);
    this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    this.setResizable(false);
    this.setLayout(null);
    this.setIconImage(scaledImage12);
    this.add(bookingPageLabel);
    this.add(panel);
    this.add(noticePanel);
    this.getContentPane().setBackground(new Color(159, 207, 185, 255));
    panel.add(nameLabel);
    panel.add(contactLabel);
    panel.add(genderLabel);
    panel.add(ageLabel);
    panel.add(destinationLabel);
    panel.add(dateLabel);
    panel.add(availabilityLabel);
    panel.add(bookButton);
    panel.add(backButton);
    this.setVisible(true);
}


@Override
    public void actionPerformed(ActionEvent e) {
 if(e.getSource() == bookButton){
    if((!nameField.getText().trim().isEmpty()) && (!contactField.getText().trim().isEmpty())&&((String)fromComboBox.getSelectedItem()!=(String)toComboBox.getSelectedItem())){
    bookButton.setEnabled(false);
    name = nameField.getText();
    nameField.setEditable(false);
    contact = contactField.getText();
    contactField.setEditable(false);
    gender =(String) genderComboBox.getSelectedItem();
    genderComboBox.setEnabled(false);
    age = ageSpinner.getValue().toString();
    ageSpinner.setEnabled(false);
    destination = (String)fromComboBox.getSelectedItem()+" to "+ (String)toComboBox.getSelectedItem();
    fromComboBox.setEnabled(false);
    toComboBox.setEnabled(false);
    date = (String)dateComboBox.getSelectedItem();
    dateComboBox.setEnabled((false));
    tktUID = algo.generateTktUid();
    System.out.println(destination);
    System.out.println(gender);
    tickTextField.setText("Ticket UID: "+tktUID+"\n"+"Name: "+name+"\n"+"Contact: "+contact+"\n"+"Gender: "+gender+"\n"+"Destination: "+destination+"\n"+"Date: "+date);
    JOptionPane.showMessageDialog(null,  "Ticket booked successfully", "Message", JOptionPane.INFORMATION_MESSAGE,newcat2Icon);   

// Work For JDBC starts from here



String url = "jdbc:mysql://localhost:3306/UserDatabase?serverTimezone=UTC";
String user = "root"; 
String password = "@Sarvagya2004"; 
String sql = "INSERT INTO UserTickets (ticket_UID, name, contact, gender, age, destination, date) VALUES (?, ?, ?, ?, ?, ?, ?)";

try (
    Connection connection = DriverManager.getConnection(url, user, password);
    PreparedStatement preparedStatement = connection.prepareStatement(sql)
) {
    
    preparedStatement.setString(1, tktUID); 
    preparedStatement.setString(2, name);
    preparedStatement.setString(3, contact);
    preparedStatement.setString(4, gender);
    preparedStatement.setString(5, age);
    preparedStatement.setString(6, destination);
    preparedStatement.setString(7, date);

    int rowsInserted = preparedStatement.executeUpdate();
    if (rowsInserted > 0) {
        System.out.println("Data inserted successfully!");
    }
} catch (SQLException exception) {
    exception.printStackTrace();
    System.out.println("Failed to insert data.");
}
    
//Work on database completed here


}
else{
    if(nameField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null,  "Please fill your name", "Message", JOptionPane.INFORMATION_MESSAGE,newCatIcon);
    }
    else if(contactField.getText().trim().isEmpty()){
        JOptionPane.showMessageDialog(null,  "Please fill your contact", "Message", JOptionPane.INFORMATION_MESSAGE,newCatIcon);
    }
    else if((String)fromComboBox.getSelectedItem()==(String)toComboBox.getSelectedItem()){
        JOptionPane.showMessageDialog(null,  "Start and Destination can't be same", "Message", JOptionPane.INFORMATION_MESSAGE,newCatIcon);
    }
    else{
        JOptionPane.showMessageDialog(null,  "Sorry some Error occured", "Message", JOptionPane.INFORMATION_MESSAGE,newCatIcon);
    }
}

}
if(e.getSource()==backButton){
  hp = new HomePage();
  this.dispose();
}
}
public static void main(String[] args) {
    BusTicketReservationSystem b = new BusTicketReservationSystem();
}
}
