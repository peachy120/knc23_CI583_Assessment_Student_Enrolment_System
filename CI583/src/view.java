import javax.swing.*;
import java.awt.*;

public class view {

    static JFrame jFrame;
    static JLabel fileJLabel;
    static JLabel msgJLabel;
    static JLabel schedulingSelectedJLabel;
    static String[] schedulingOptions;
    static JComboBox<String> jComboBox;

    public void main(String[] arg) {

        jFrame = new JFrame(); // Creating a JFrame
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,500); // Setting the size of the frame

        JPanel jPanel = new JPanel(); // Creating a JPanel
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        jFrame.add(jPanel); // Adding the JPanel into the JFrame

        JLabel titleJLabel = new JLabel("CI583 Student Enrolment System"); // Creating a JLabel to show the name of the system
        titleJLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JLabel to CENTER
        jPanel.add(titleJLabel); // Adding the JLabel to JPanel

        JLabel uploadJLabel = new JLabel("Upload a CSV file"); // Creating a JLabel to give instruction
        uploadJLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JLabel to CENTER
        jPanel.add(uploadJLabel); // Adding the JLabel to JPanel

        fileJLabel = new JLabel("No File Uploaded"); // Creating a Label showing no file have benn uploaded. When a file has been upload, it shows the name of the file uploaded
        fileJLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JLabel to CENTER
        jPanel.add(fileJLabel); // Adding the JLabel to JPanel

        msgJLabel = new JLabel(); // Creating a JLabEL to show msg uf there are any
        msgJLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JLabel to CENTER
        jPanel.add(msgJLabel); // Adding the JLabel to JPanel

        JButton uploadJButton = new JButton("Upload CSV"); // Creating a JButton for user to click on and upload a file from their device
        uploadJButton.addActionListener(e -> {
            controller.selectFile();
        }); // Calling the selectFile method in controller class
        uploadJButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JButton to CENTER
        jPanel.add(uploadJButton); // Adding the JButton to JPanel

        JLabel schedulingJLabel = new JLabel("Select a scheduling method"); // Creating a JLabel to ask user to select a scheduling method, default is Round Robin
        schedulingJLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JLabel to CENTER
        jPanel.add(schedulingJLabel); // Adding the JLabel to JPanel

        schedulingOptions = new String[]{"Round Robin", "Priority Scheduling", "Multi-level Feedback Queue"}; // Creating options for user to select
        jComboBox = new JComboBox<>(schedulingOptions); // Inserting options into a JComboBox
        jComboBox.setMaximumSize(jComboBox.getPreferredSize()); // Setting the size of the JComboBox
        jComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);  // Setting the alignment of the JComboBox to CENTER
        jPanel.add(jComboBox); // Adding the JComboBox to JPanel

        schedulingSelectedJLabel = new JLabel(); // Creating a JLabel to show the option user selected
        schedulingSelectedJLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JLabel to CENTER
        jPanel.add(schedulingSelectedJLabel); // Adding the JLabel to JPanel

        JButton runJButton = new JButton("RUN"); // Created a JButton for user to click after uploaded the csv file and selected a scheduling option
        runJButton.addActionListener(e -> {
            controller.runScheduling();
        }); // Calling the runScheduling  method in controller class
        runJButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Setting the alignment of the JButton to CENTER
        jPanel.add(runJButton); // Adding the JButton to JPanel

        jFrame.setVisible(true); // Setting the visible to true
    }
}
