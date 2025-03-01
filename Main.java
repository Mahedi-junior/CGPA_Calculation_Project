package Project.CGPA;

import javax.swing.*;
import java.text.DecimalFormat;

public class Main {
    public static void start() {

        String title = "CGPA Calculator";

        String msg = """
                MENU :

                -------------------------------------------------------------------------------------------------------
                                                            Select your Choice
                -------------------------------------------------------------------------------------------------------""";

        String[] option = {"Semester CGPA", "Total CGPA", "EXIT"};
        int select = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 7);


        if (select == 0)
            semesterCGPA(0,0);
        else if (select == 1)
            totalCGPA();
        else if (select == 2)
            System.exit(0);

        else
            JOptionPane.showMessageDialog(null, "Please select exit button to EXIT", title, JOptionPane.ERROR_MESSAGE);

        start();

    }

}