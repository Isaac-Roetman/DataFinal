/***************************************************************
* Name : MainFrame.java
* Author: Isaac Roetman
* Created : 12/9/2022
* Course: CIS 152 - Data Structure
* Version: 1.0
* OS: Windows 10
* IDE: eclipse Enterprise
* Copyright : This is my own original work 
* based on specifications issued by our instructor
* Description : a program which demonstrates the use of two different types of
* data structures and a GUI that fixes the real world problem of hospitals 
* using pen and paper for visitor sign in sheets. This program allows uses sorting
* in a priority queue and a linked list to simplify having visitors data stored
* online.
* I have not used unauthorized source code, either modified or
* unmodified. I have not given other fellow student(s) access
* to my program.
***************************************************************/
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.awt.event.ActionEvent;

public class MainFrame {

    private JFrame frame; // main frame
    private static PriorityQueue < visitorInfo > visitorQueue = new PriorityQueue < visitorInfo > (); //creating the Priority Queue
    private static LinkedList < upcomingVisitors > visitorList = new LinkedList < upcomingVisitors > (); //creating the Linked List

    /**
     * Launch the application.
     */
    public static void main(String[] args) { // main program
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    MainFrame window = new MainFrame(); //creates a window and makes it visible
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

   
    public MainFrame() { //starts the application
    	Start();
    }

    public static void visitorInfo(String fname, String lname, int relation, int timeVisited) { // method to add visitor
    	visitorInfo temp = new visitorInfo(); // create object from class
        temp.setFName(fname);	//sets the values that have been entered
        temp.setLName(lname);
        temp.setRelation(relation);
        temp.setTimeVisited(timeVisited);
        visitorQueue.add(temp); // add the visitor to the priority queue
    }
    public static void upcomingVisitors(String fName, String lName) {
    	upcomingVisitors temp = new upcomingVisitors(); //object from class
    	temp.setFName(fName); //sets the values that were entered
    	temp.setLName(lName);
    	visitorList.add(temp); //adds object to the list
    }

    public static void displayVisitorLog() { // method to display the queue
        JFrame viewQueue = new JFrame("Visitor Queue");
        viewQueue.getContentPane().add(new JList(visitorQueue.toArray())); // create a Jlist object from the queue and add to the new frame
        viewQueue.pack();
        viewQueue.setLocationRelativeTo(null);
        viewQueue.setBounds(100, 100, 828, 355); // set boundaries
        viewQueue.setVisible(true); // set visibility true
    }

    public static void displayUpcomingV() { // method to display upcoming visitors in a linked list
        JFrame viewList = new JFrame("Upcoming Visitors");
        viewList.getContentPane().add(new JList(visitorList.toArray())); //creates jList object from the list and adds to the frame
        viewList.pack();
        viewList.setLocationRelativeTo(null);
        viewList.setBounds(100, 100, 828, 355);
        viewList.setVisible(true); //turns visible
    }

    /**
     * Initialize the contents of the frame.
     */
    private void Start() {
        frame = new JFrame(); // creation of the frame
        frame.setBounds(100, 100, 828, 355);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JLabel MountainMedical = new JLabel(); //Title label
        MountainMedical.setText("Mountain Medical Visitor Log, Welcome!");
        MountainMedical.setBounds(278, 20, 400, 50); //sets boundaries
        frame.getContentPane().add(MountainMedical); //adds to the frame

        JButton SignInButton = new JButton("Visitor Sign In"); // button to add visitor
        SignInButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addVisitor add = new addVisitor(); // action event when button clicked take them to the add visitor frame
                add.setVisible(true); //set visible
            }
        });
        SignInButton.setBounds(300, 100, 180, 23);//sets boundaries
        frame.getContentPane().add(SignInButton);

        JButton viewQueueButton = new JButton("View Visitor Log"); // view queue button
        viewQueueButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (visitorQueue.isEmpty()) { // if empty message is displayed that there is nothing inside
                    JFrame viewQueue = new JFrame("Previous Visitors");
                    JLabel empty = new JLabel("Log is Empty");
                    viewQueue.setLocationRelativeTo(null);
                    viewQueue.setSize(200, 200);
                    viewQueue.getContentPane().add(empty);
                    viewQueue.setVisible(true);
                } else { // if not display the queue using method
                	displayVisitorLog(); //method to display the visitor log
                }
            }
        });
        viewQueueButton.setBounds(301, 133, 181, 23);//sets boundaries
        frame.getContentPane().add(viewQueueButton);

        JButton UpComingVisitorButton = new JButton("Add Upcoming Visitor"); // button to add a new upcoming visitor
        UpComingVisitorButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	addUpcomingVisitors add = new addUpcomingVisitors();
               add.setVisible(true);// set to visible
            }
        });
        UpComingVisitorButton.setBounds(301, 167, 181, 23);//sets boundaries
        frame.getContentPane().add(UpComingVisitorButton);

        JButton UpComingVisitorListButton = new JButton("Upcoming Visitor List"); // button to view the upcoming visitors list
        UpComingVisitorListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (visitorList.isEmpty()) { // if empty displays a pop-up
                    JFrame viewList = new JFrame();
                    JLabel empty = new JLabel("No Upcoming Visitors");
                    viewList.setLocationRelativeTo(null);
                    viewList.setSize(140, 100);
                    viewList.getContentPane().add(empty);
                    viewList.setVisible(true);//set to visible
                } else {
                	displayUpcomingV(); // displays the upcoming visitors list
                }
            }
        });

        UpComingVisitorListButton.setBounds(301, 201, 181, 23);//sets boundaries
        frame.getContentPane().add(UpComingVisitorListButton);

        JButton ExitButton = new JButton("Exit"); // exit button to terminate the application
        ExitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // exits program
            }
        });
        ExitButton.setBounds(301, 235, 181, 23);//sets boundaries
        frame.getContentPane().add(ExitButton);
    }
}
