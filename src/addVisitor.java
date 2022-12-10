import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class addVisitor extends JPanel{
	JFrame frame = new JFrame(); //creates new JFrame
	
	public addVisitor() { //method to add to the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(100, 100, 800, 400);//sets boundaries
        frame.setVisible(true); // set to visible
        JPanel contentPane = new JPanel();
        frame.setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JLabel AddVisitor = new JLabel();
        AddVisitor.setBounds(230, 50, 100, 20);//sets boundaries
        AddVisitor.setText("Add Visitor");
        contentPane.add(AddVisitor);//adds to the frame
        
        JLabel firstName = new JLabel("First Name"); // label for the text box
        firstName.setBounds(230, 80, 130, 20);//sets boundaries
        contentPane.add(firstName); //adds to the frame
        
        JLabel lastName = new JLabel("Last Name");// label for the text box
        lastName.setBounds(230, 100, 130, 20);//sets boundaries
        contentPane.add(lastName);//adds to the frame

        JLabel relation = new JLabel("Relation (Relative - 1, Friend - 2, Buisiness - 3)");// label for the text box
        relation.setBounds(230, 120, 300, 20);//sets boundaries
        contentPane.add(relation);//adds to the frame
        
        JLabel timeVisited = new JLabel("Time Visited (In minutes)");// label for the text box
        timeVisited.setBounds(230, 140, 200, 20);//sets boundaries
        contentPane.add(timeVisited);//adds to the frame
        
        JTextField textFName = new JTextField(); //new text field for first name
        textFName.setBounds(500, 80, 130, 20);//sets boundaries
        contentPane.add(textFName);//adds to the frame
        textFName.setColumns(10);
        
        JTextField textLName = new JTextField();//new text field for last name
        textLName.setBounds(500, 100, 130, 20);//sets boundaries
        contentPane.add(textLName);//adds to the frame
        textLName.setColumns(10);
        
        JTextField textRelation = new JTextField();//new text field for relation
        textRelation.addKeyListener(new KeyAdapter() {//input validation so that nothing but a number can be entered in the text field
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        textRelation.setBounds(500, 120, 130, 20);//sets boundaries
        contentPane.add(textRelation);//adds to the frame
        textRelation.setColumns(10);
        
        JTextField textTimeVisited = new JTextField();//new text field for time visited
        textTimeVisited.addKeyListener(new KeyAdapter() { //input validation so that nothing but a number can be entered in the text field
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        textTimeVisited.setBounds(500, 140, 130, 20);//sets boundaries
        contentPane.add(textTimeVisited);//adds to the frame
        textTimeVisited.setColumns(10);
        
        JLabel Warning = new JLabel("");
        Warning.setForeground(new Color(160, 50, 160));//sets the new color of the text that appears
        Warning.setBounds(251, 250, 262, 33);//sets boundaries
        contentPane.add(Warning);//adds to the frame

        JButton SubmitButton = new JButton("Submit"); // submit button
        SubmitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) { // action event to add visitor when button clicked
                if (textFName.getText().trim().isEmpty() || textLName.getText().trim().isEmpty() || textRelation.getText().trim().isEmpty() || textTimeVisited.getText().trim().isEmpty()) {
                	Warning.setText("One or more fields are empty!"); // input validation for empty fields
                } else {
                    int relation = Integer.parseInt(textRelation.getText());
                    if (relation < 1 || relation > 3 ) { // input validation for priority
                    	Warning.setText("Relation must 1-3");
                    } else { // if input is correct
                        String fname = textFName.getText();
                        String lname = textLName.getText();
                        int timeVisited = Integer.parseInt(textTimeVisited.getText()); // set strings from the text fields
                        MainFrame.visitorInfo(fname, lname, relation, timeVisited); // pass them to the add visitor method
                        frame.setVisible(false); // close frame
                    }
                }
            }
        });
        SubmitButton.setBounds(273, 216, 89, 23);//sets boundaries
        contentPane.add(SubmitButton);//adds to the frame
        
        JButton ExitButton = new JButton("Exit"); // exit button
        ExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        ExitButton.setBounds(398, 216, 89, 23);//sets boundaries
        contentPane.add(ExitButton);//adds to the frame
	}
	
	
	

}
