import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CuurentSalary extends ShowEmp {
    private JPanel currentPanel;
    private JPanel showPanel;
    private JButton showDetailsButton;
    private JTable table1;
    JFrame currentF = new JFrame();
public CuurentSalary() {
    currentF.setContentPane(showPanel);
    currentF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    currentF.setVisible(true);
    showDetailsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String a= "Select* from salarydetails";
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","root");
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(a);
                table1.setModel(buildTableModel(rs));
            }catch (Exception ex1){
                ex1.printStackTrace();

            }
        }

    });
}
}
