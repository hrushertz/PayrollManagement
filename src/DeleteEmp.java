import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DeleteEmp {
    private JPanel deleteEmp;
    private JTextField textField1;
    private JButton confirmDeleteButton;
    JFrame deleteEmpF=new JFrame();
public DeleteEmp() {
    deleteEmpF.setContentPane(deleteEmp);
    //deleteEmpF.pack();
    deleteEmpF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    deleteEmpF.setVisible(true);
    confirmDeleteButton.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
           try{
            String str = textField1.getText();
            int id=Integer.parseInt(str);
            String sql = "DELETE from EmpDetails where EmpID="+id;
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","root");
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Employee details deleted successfully");
        }
         catch (Exception ex) {
            System.out.println(ex);
        }
    }});
}
}
