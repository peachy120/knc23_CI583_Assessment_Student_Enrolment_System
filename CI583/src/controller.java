import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class controller {

    public static void selectFile() {
        //inputManage.getWaitingQueue().clear(); // Clearing the waitingQueue // Comment if multiply different csv file needs to be pass in

        JFileChooser jFileChooser = new JFileChooser(); // Allows for the interactive selection of a file
        jFileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv")); // Make sure only csv file can be upload

        int fileSelected = jFileChooser.showOpenDialog(view.jFrame); // Open a file picker window for user to pick a file
        if (fileSelected == JFileChooser.APPROVE_OPTION) { // APPROVE_OPTION is when user click on open after selecting a file
            File file = jFileChooser.getSelectedFile(); // File now has the file path of the selected file
            view.fileJLabel.setText("Selected: " + file); // Showing user what file they selected

            File csvUploaded = file;
            String line;
            String delimiter = ","; // csv seperator

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvUploaded))) { // Opens the file so content inside it can be read
                while ((line = bufferedReader.readLine()) != null) { // Checking if the line equals to null
                    String[] value = line.split(delimiter); // Splitting data using commas

                    //inputManage.addToWaitingQueue(value);
                    //System.out.println(Arrays.toString(value));

                    String processID = value[0]; // In the csv file, index 0 stores the processID
                    int burstTime = Integer.parseInt(value[1]); // In the csv file, index 1 stores the burstTime, transforming it to integer since it is originally String
                    int priority = Integer.parseInt(value[2]); // In the csv file, index 2 stores the priority, transforming it to integer since it is originally String

                    input newInput = new input(processID, burstTime, priority); // Create new input
                    inputManage.addToWaitingQueue(newInput); // Add the input into waitingQueue in inputManage class

                    //System.out.println(newInput);

                }

                System.out.println(inputManage.getWaitingQueue());
                System.out.println(inputManage.getWaitingQueue().size());

            } catch (IOException e) {
                view.msgJLabel.setText("404 ERROR 404"); // Shows the user that there is something wrong

                System.out.println("IO exception: " + e.getMessage());
            } catch (Exception e) {
                view.schedulingSelectedJLabel.setText("404 ERROR 404"); // Shows the user that there is something wrong

                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void runScheduling() {
        String selectedScheduling = view.jComboBox.getItemAt(view.jComboBox.getSelectedIndex()); // Get the item selected from the JComboBox from view class

        model.getCompletedQueue().clear(); // Empty the completed queue in model class

        String schedulingMethod = "You selected: " + selectedScheduling; // Creating a String to show what user selected

        List<input> queue = inputManage.getWaitingQueue();

        if (!queue.isEmpty() && selectedScheduling == view.schedulingOptions[0]) { // Checking is queue empty and when the user select Round Robin as it has an index of 0
            view.schedulingSelectedJLabel.setText(schedulingMethod); // Showing the option user selected in view class in schedulingSelectedJLabel

            System.out.println("You selected " + selectedScheduling);

            model.roundRobin(queue); // Calling roundRobin method in model class

            System.out.println(inputManage.getWaitingQueue());
            System.out.println(model.getCompletedQueue());
        } else if (!queue.isEmpty() && selectedScheduling == view.schedulingOptions[1]) { // Checking is queue empty and when the user select Priority Scheduling as it has an index of 1
            view.schedulingSelectedJLabel.setText(schedulingMethod); // Showing the option user selected in view class in schedulingSelectedJLabel

            System.out.println("You selected " + selectedScheduling);

            model.priority(queue); // Calling priority method in model class

            System.out.println(inputManage.getWaitingQueue());
            System.out.println(model.getCompletedQueue());
        } else if (!queue.isEmpty() && selectedScheduling == view.schedulingOptions[2]) { // Checking is queue empty and when the user select Multi-Level Feedback Queue as it has an index of 2
            view.schedulingSelectedJLabel.setText(schedulingMethod); // Showing the option user selected in view class in schedulingSelectedJLabel

            System.out.println("You selected " + selectedScheduling);

            model.mlfq(queue); // Calling mlfq method in model class

            System.out.println(inputManage.getWaitingQueue());
            System.out.println(model.getCompletedQueue());
        } else {
            view.schedulingSelectedJLabel.setText("Upload a CSV file"); // Shows when a csv file isn't uploaded

            System.out.println("Upload a CSV file");
        }
    }
}
