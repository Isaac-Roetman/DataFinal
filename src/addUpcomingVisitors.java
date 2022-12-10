import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class addUpcomingVisitors extends JPanel { 
	JFrame frame = new JFrame(); //creates new JFrame
	
	public addUpcomingVisitors() { //method to add to the new frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 400);//sets boundaries
        frame.setVisible(true); //set visible
        JPanel contentPane = new JPanel();
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel AddVisitor = new JLabel(); //label for the title
        AddVisitor.setBounds(230, 50, 100, 20);//sets boundaries
        AddVisitor.setText("Upcoming Visitor");
        contentPane.add(AddVisitor);//adds to frame
        
        JLabel firstName = new JLabel("First Name"); //label for the text box
        firstName.setBounds(230, 80, 130, 20);//sets boundaries
        contentPane.add(firstName); //adds to frame
        
        JLabel lastName = new JLabel("Last Name");//label for the text box
        lastName.setBounds(230, 100, 130, 20);//sets boundaries
        contentPane.add(lastName);
        
        JTextField textFName = new JTextField(); //text box
        textFName.setBounds(500, 80, 130, 20);//sets boundaries
        contentPane.add(textFName);//adds to frame
        textFName.setColumns(10);
        
        JTextField textLName = new JTextField();//text box
        textLName.setBounds(500, 100, 130, 20);//sets boundaries
        contentPane.add(textLName);//adds to frame
        textLName.setColumns(10);
        
        JLabel Warning = new JLabel("");
        Warning.setForeground(new Color(160, 50, 160));//gives the text a new color top stand out
        Warning.setBounds(251, 250, 262, 33);//sets boundaries
        contentPane.add(Warning);//adds to frame
        
        JButton SubmitButton = new JButton("Submit"); // submit button
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // action event to add visitor when clicked
                if (textFName.getText().trim().isEmpty() || textLName.getText().trim().isEmpty()) {
                	Warning.setText("One or more fields are empty!"); // input validation for empty fields
                } else {     
                        String fname = textFName.getText(); //sets the values of the strings from the text box
                        String lname = textLName.getText();
                        MainFrame.upcomingVisitors(fname, lname); // pass them to the add visitor method
                        frame.setVisible(false); // close frame
                    }
                }            
        });
        SubmitButton.setBounds(273, 216, 89, 23);//sets boundaries
        contentPane.add(SubmitButton);//adds to frame
        
        JButton ExitButton = new JButton("Exit"); // exit button
        ExitButton.addActionListener(new ActionListener() { //when button is pushed it exits the application
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ExitButton.setBounds(398, 216, 89, 23);//sets boundaries
        contentPane.add(ExitButton);//adds to frame
	}
}
