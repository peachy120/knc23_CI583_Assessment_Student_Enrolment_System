import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class controller {

    public static void selectFile() {
        JFileChooser jFileChooser = new JFileChooser();
        jFileChooser.setFileFilter(new FileNameExtensionFilter("CSV files", "csv"));

        int fileSelected = jFileChooser.showOpenDialog(view.jFrame);
        if (fileSelected == JFileChooser.APPROVE_OPTION) {
            File file = jFileChooser.getSelectedFile();
            view.fileJLabel.setText("Selected: " + file);

            File csvUploaded = file;
            String line;
            String delimiter = ",";

            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(csvUploaded))) {
                while ((line = bufferedReader.readLine()) != null) {
                    String[] value = line.split(delimiter);

                    //inputManage.addToWaitingQueue(value);
                    //System.out.println(Arrays.toString(value));

                    String processID = value[0];
                    int burstTime = Integer.parseInt(value[1]);
                    int priority = Integer.parseInt(value[2]);

                    input newInput = new input(processID, burstTime, priority);
                    inputManage.addToWaitingQueue(newInput);

                }

                //System.out.println(inputManage.waitingQueue);

            } catch (IOException e) {
                view.msgJLabel.setText("404 ERROR 404");

                System.out.println("IO exception: " + e.getMessage());
            } catch (Exception e) {
                view.schedulingSelectedJLabel.setText("404 ERROR 404");

                System.out.println("Error: " + e.getMessage());
            }
        }
    }

    public static void runScheduling() {
        String selectedScheduling = view.jComboBox.getItemAt(view.jComboBox.getSelectedIndex());

        String schedulingMethod = "You selected: " + selectedScheduling;

        List<input> queue = inputManage.waitingQueue;

        if (!queue.isEmpty() && selectedScheduling == view.schedulingOptions[0]) {
            view.schedulingSelectedJLabel.setText(schedulingMethod);

            model.roundRobin(queue);

            System.out.println("You selected " + selectedScheduling);
        } else if (!queue.isEmpty() && selectedScheduling == view.schedulingOptions[1]) {
            view.schedulingSelectedJLabel.setText(schedulingMethod);

            model.priority(queue);

            System.out.println("You selected " + selectedScheduling);
        } else if (!queue.isEmpty() && selectedScheduling == view.schedulingOptions[2]) {
            view.schedulingSelectedJLabel.setText(schedulingMethod);

            model.mlfq(queue);

            System.out.println("You selected " + selectedScheduling);
        } else {
            view.schedulingSelectedJLabel.setText("Upload a CSV file");

            System.out.println("Upload a CSV file");
        }
    }
}
