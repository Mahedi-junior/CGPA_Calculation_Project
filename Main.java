
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

        public static void semesterCGPA(double previousGP, double previousCredit) {

            String title = "CGPA Calculator";
            //String creditString;
            String[] returnOption = {"Return Home","Cancel"};
            String[] returnOption2 = {"Return Home"};
    
            String[] option = {"   1   ", " 2 ", " 3 ", " 4 ", " 5 ", " 6 "};
    
            int select;
    
            while (true) {
    
                select = JOptionPane.showOptionDialog(null, "Select the number of Course of current Semester", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 3);
    
                if (select != -1)
                    break;
    
                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    start();
    
            }
    
            Course[] courses = new Course[select + 1];
    
            for (int i = 0; i < courses.length; i++) {
    
                courses[i] = new Course();
    
                while (true) {
    
                    String msgCourse = "Enter the name of Course-" + (i + 1);
                    courses[i].setName(JOptionPane.showInputDialog(null, msgCourse, title, JOptionPane.QUESTION_MESSAGE));
    
                    if (courses[i].getName() == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            start();
                    }
                    else if (courses[i].getName() != null)
                        break;
    
    
                }
    
    
                if (courses[i].getName().isBlank()) {
                    JOptionPane.showOptionDialog(null, "Name     iS    b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    start();
                }                    //blank check
    
    
    
                while (true) {
    
                    String msg = "Enter the credit for " + courses[i].getName();
    
                    String creditString = JOptionPane.showInputDialog(null, msg,title,JOptionPane.QUESTION_MESSAGE);
    
    
    
                    if (creditString == null ) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            start();
                    }
    
                    if (creditString != null && creditString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "Credit    iS    b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        start();
                    }
    
    
                    try {
    
                        if (creditString != null && (Double.parseDouble(creditString) != 1 && Double.parseDouble(creditString) != 1.5 && Double.parseDouble(creditString) != 2 && Double.parseDouble(creditString) != 2.5 && Double.parseDouble(creditString) != 3 && Double.parseDouble(creditString) != 3.5 && Double.parseDouble(creditString) != 4 && Double.parseDouble(creditString) != 4.5 && Double.parseDouble(creditString) != 5 && Double.parseDouble(creditString) != 5.5 && Double.parseDouble(creditString) != 6 && Double.parseDouble(creditString) != 6.5 && Double.parseDouble(creditString) != 7 && Double.parseDouble(creditString) != 7.5 && Double.parseDouble(creditString) != 8 && Double.parseDouble(creditString) != 8.5 && Double.parseDouble(creditString) != 9 && Double.parseDouble(creditString) != 9.5 && Double.parseDouble(creditString) != 10 && Double.parseDouble(creditString) != 10.5 && Double.parseDouble(creditString) != 11 && Double.parseDouble(creditString) != 11.5 && Double.parseDouble(creditString) != 12)) {
                            JOptionPane.showMessageDialog(null,"Invalid Credit",title,JOptionPane.ERROR_MESSAGE);
                        }
    
                        if (creditString != null && (Double.parseDouble(creditString) == 1 || Double.parseDouble(creditString) == 1.5 || Double.parseDouble(creditString) == 2 || Double.parseDouble(creditString) == 2.5 || Double.parseDouble(creditString) == 3 || Double.parseDouble(creditString) == 3.5 || Double.parseDouble(creditString) == 4 || Double.parseDouble(creditString) == 4.5 || Double.parseDouble(creditString) == 5 || Double.parseDouble(creditString) == 5.5 || Double.parseDouble(creditString) == 6 || Double.parseDouble(creditString) == 6.5 || Double.parseDouble(creditString) == 7 || Double.parseDouble(creditString) == 7.5 || Double.parseDouble(creditString) == 8 || Double.parseDouble(creditString) == 8.5 || Double.parseDouble(creditString) == 9 || Double.parseDouble(creditString) == 9.5 || Double.parseDouble(creditString) == 10 || Double.parseDouble(creditString) == 10.5 || Double.parseDouble(creditString) == 11 || Double.parseDouble(creditString) == 11.5 || Double.parseDouble(creditString) == 12)) {
                            courses[i].setCredit(Double.parseDouble(creditString));
                            break;
                        }
    
    
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null,"Please input correct credit format",title,JOptionPane.ERROR_MESSAGE);
                    }
    
    
    
    
                }
    
    
                while (true) {
    
                    String msg = "Select the predicted garde for " + courses[i].getName();
                    String[] optionGrade = {"4.0 (A)", "3.7 (A-)", "3.3 (B+)", "3.0 (B)", "2.7 (B-)", "2.3 (C+)", "2.0 (C)", "1.7 (C-)", "1.3 (D+)", "1.0 (D)", "0 (F)"};
    
                    int grade = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionGrade, 0);
    
                    if (grade != -1) {
                        courses[i].setGrade(grade);
                        courses[i].setLetterGrade(grade);
                        break;
                    }
    
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        start();
    
                }
    
            }
    
            printResult(courses,previousGP,previousCredit);
    
    
    
    
        }       // end of semester CGPA
    

    }

}