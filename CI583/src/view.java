import javax.swing.*;
import java.awt.*;

public class view {

    static JFrame jFrame;
    static JLabel fileJLabel;
    static JLabel msgJLabel;
    static JLabel schedulingSelectedJLabel;
    static String[] schedulingOptions;
    static JComboBox<String> jComboBox;
    static JLabel runningJLabel;

    public void main(String[] arg) {

        jFrame = new JFrame();
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,500);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        jFrame.add(jPanel);

        JLabel titleJLabel = new JLabel("CI583 Student Enrolment System");
        titleJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(titleJLabel);

        JLabel uploadJLabel = new JLabel("Upload a CSV file");
        uploadJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(uploadJLabel);

        fileJLabel = new JLabel("No File Uploaded");
        fileJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(fileJLabel);

        msgJLabel = new JLabel();
        msgJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(msgJLabel);

        JButton uploadJButton = new JButton("Upload CSV");
        uploadJButton.addActionListener(e -> {
            controller.selectFile();
        });
        uploadJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(uploadJButton);

        JLabel schedulingJLabel = new JLabel("Select a scheduling method");
        schedulingJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(schedulingJLabel);

        schedulingOptions = new String[]{"Round Robin", "Priority Scheduling", "Multi-level Feedback Queue"};
        jComboBox = new JComboBox<>(schedulingOptions);
        jComboBox.setMaximumSize(jComboBox.getPreferredSize());
        jComboBox.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(jComboBox);

        schedulingSelectedJLabel = new JLabel();
        schedulingSelectedJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(schedulingSelectedJLabel);

        JButton runJButton = new JButton("RUN");
        runJButton.addActionListener(e -> {
            controller.runScheduling();
        });
        runJButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(runJButton);

        runningJLabel = new JLabel();
        runningJLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jPanel.add(runningJLabel);

        jFrame.setVisible(true);
    }
}
