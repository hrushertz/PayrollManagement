import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeDetails {
    private JPanel employeePanel;
    private JButton addEmployeeButton;
    private JButton deleteEmployeeButton;
    private JButton updateEmployeeButton;
    private JButton showAllEmployeesButton;
    JFrame employeeF = new JFrame();
public EmployeeDetails() {
    employeeF.setContentPane(employeePanel);
    employeeF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    //employeeF.pack();
    employeeF.setVisible(true);
    addEmployeeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddEmp();
        }
    });
    updateEmployeeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new UpdateEmp();
        }
    });
    deleteEmployeeButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new DeleteEmp();
        }
    });
    showAllEmployeesButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ShowEmp();
        }
    });
}
}
