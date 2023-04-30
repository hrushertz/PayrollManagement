import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminScreen {
    private JButton employeeDetailsButton;
    private JButton searchButton;
    private JButton payrollCalculationButton;
    private JPanel adminPanel;
    private JButton currentSalaryButton;

    JFrame adminF =new JFrame();
    public AdminScreen() {
        adminF.setContentPane(adminPanel);
        adminF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
       // adminF.pack();
        adminF.setVisible(true);
    employeeDetailsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new EmployeeDetails();
        }
    });
    searchButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new SearchEmployee();
        }
    });
    payrollCalculationButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new PayrollCalculation();
        }
    });
        currentSalaryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CuurentSalary();
            }
        });
    }
}
