import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;


public class UpdateEmp {
    private JPanel updateEmp;
    private JTextField tf1;
    private JTextField tf2;
    private JButton confirmUpdateButton;
    JFrame updateEmpF=new JFrame();
public UpdateEmp() {
    updateEmpF.setContentPane(updateEmp);
    //updateEmpF.pack();
    updateEmpF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    updateEmpF.setVisible(true);
    confirmUpdateButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
           try{
               String str = tf1.getText();
               int id=Integer.parseInt(str);
               String str1 = tf2.getText();
               int attendance=Integer.parseInt(str1);
               String sql = "UPDATE EmpDetails set EmpAttendance="+attendance+" where EmpID="+id;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","root");
               PreparedStatement statement = connection.prepareStatement(sql);
               statement.executeUpdate();
               JOptionPane.showMessageDialog(null,"Employee attendance updated successfully");
           }
        catch (Exception ex) {
            System.out.println(ex);
        }
    }});
}
}
