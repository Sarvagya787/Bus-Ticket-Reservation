import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class HomePage implements ActionListener{
JFrame frame;
JPanel panel1;
JPanel panel2;
JLabel headLabel;
JLabel homelabel;
JLabel menuLabel;
JButton bookTickeButton;
JButton cancelTickeButton;
JLabel imageLabel;
JLabel imageLabel2;

BusTicketReservationSystem busTicketReservationSystem;
BusTicketCancellationSystem busTicketCancellationSystem;

    ImageIcon image7 = new ImageIcon("CP_MinorProject/src/bus_image.jpg");
    Image scaledImage7 = image7.getImage().getScaledInstance(480,200, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newBusImage = new ImageIcon(scaledImage7);

    ImageIcon image = new ImageIcon("CP_MinorProject/src/nature.jpg");
    Image scaledImage = image.getImage().getScaledInstance(490,690, java.awt.Image.SCALE_SMOOTH);
    ImageIcon newNatureImage = new ImageIcon(scaledImage);

    ImageIcon image2 = new ImageIcon("CP_MinorProject/src/home.jpg");
    Image scaledImage2 = image2.getImage().getScaledInstance(70,70, java.awt.Image.SCALE_SMOOTH);
    ImageIcon homeIcon = new ImageIcon(scaledImage2);

    ImageIcon image3 = new ImageIcon("CP_MinorProject/src/menu.jpg");
    Image scaledImage3 = image3.getImage().getScaledInstance(50,50, java.awt.Image.SCALE_SMOOTH);
    ImageIcon menuIcon= new ImageIcon(scaledImage3);

    ImageIcon image12 = new ImageIcon("CP_MinorProject/src/main.jpg");
    Image scaledImage12 = image12.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH);
    

    
HomePage(){
    frame = new JFrame();
    frame.setBounds(0,0,1300,900);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.getContentPane().setBackground(new Color(159, 207, 185, 255));
    frame.setResizable(false);
    frame.setLayout(null);
    frame.setIconImage(image12.getImage());
    panel1  = new JPanel();
    panel1.setBounds(50,50,500,700);
    panel1.setBackground(Color.white);
    panel1.setLayout(null);
    panel2 = new JPanel();
    panel2.setBounds(750,50,500,700);
    panel2.setBackground(new Color(47, 215, 176, 255));
    panel2.setLayout(null);
    imageLabel2 = new JLabel();
    imageLabel2.setBounds(5,5,490,690);
    imageLabel2.setIcon(newNatureImage);
    imageLabel2.setBorder(BorderFactory.createEtchedBorder());
    panel2.add(imageLabel2);

    frame.add(panel1);
    frame.add(panel2);

    headLabel = new JLabel();
    headLabel.setBounds(5,5,500,240);
    headLabel.setText("DAODO TRAVELS");
    headLabel.setVerticalAlignment(JLabel.TOP);
    headLabel.setHorizontalAlignment(JLabel.CENTER);
    headLabel.setFont(new Font(null,Font.BOLD,24));
    imageLabel = new JLabel();
    imageLabel.setBounds(5,55,490,210);
    headLabel.setOpaque(true);
    imageLabel.setIcon(newBusImage);
   
    headLabel.add(imageLabel);

    homelabel = new JLabel();
    homelabel.setText("HOME");
    homelabel.setFont(new Font(null,Font.BOLD,24));
    homelabel.setBounds(5,250,500,100);
    homelabel.setOpaque(true);
    homelabel.setBackground(Color.white);
    homelabel.setHorizontalAlignment(JLabel.CENTER);
    homelabel.setIcon(homeIcon);


    menuLabel = new JLabel();
    menuLabel.setBounds(5,355,500,350);
    menuLabel.setText("MENU");
    menuLabel.setFont(new Font(null,Font.BOLD,24));
    menuLabel.setVerticalAlignment(JLabel.TOP);
    menuLabel.setHorizontalAlignment(JLabel.CENTER);
    menuLabel.setBackground(Color.white);
    menuLabel.setIcon(menuIcon);
    menuLabel.setOpaque(true);


    bookTickeButton = new JButton();
    bookTickeButton.setBounds(100,70,300,100);
    bookTickeButton.setBackground(new Color(192,192,192));
    bookTickeButton.setText("Book Ticket");
    bookTickeButton.setFont(new Font(null,Font.BOLD,24));
    bookTickeButton.addActionListener(this);
    bookTickeButton.setBorder(BorderFactory.createEtchedBorder());
    bookTickeButton.setFocusable(false);
    cancelTickeButton = new JButton();
    cancelTickeButton.setText("Cancel Ticket");
    cancelTickeButton.setBounds(100,195,300,100);
    cancelTickeButton.setBackground(new Color(192,192,192));
    cancelTickeButton.addActionListener(this);
    cancelTickeButton.setFont(new Font(null,Font.BOLD,24));
    cancelTickeButton.setBorder(BorderFactory.createEtchedBorder());
    cancelTickeButton.setFocusable(false);
    menuLabel.add(cancelTickeButton);
    menuLabel.add(bookTickeButton);
   

    panel1.add(headLabel);
    panel1.add(homelabel);
    panel1.add(menuLabel);

    frame.setVisible(true);
}

    @Override
    public void actionPerformed(ActionEvent e) {
     if(e.getSource()==bookTickeButton){
       busTicketReservationSystem = new BusTicketReservationSystem();
       frame.dispose();
     }  
     else if(e.getSource()==cancelTickeButton){
     busTicketCancellationSystem = new BusTicketCancellationSystem();
     frame.dispose();
     } 

}
public static void main(String[] args) {
    HomePage h = new HomePage();
}

}
