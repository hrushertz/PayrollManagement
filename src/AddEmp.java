import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class AddEmp {
    private JPanel addEmpPanel;
    private JTextField tf1;
    private JTextField tf2;
    private JButton addDetailsButton;
    private JComboBox cb1;
    JFrame addEmpF = new JFrame();
public AddEmp() {
    addEmpF.setContentPane(addEmpPanel);
    //addEmpF.pack();
    addEmpF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    addEmpF.setVisible(true);


    addDetailsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            if(tf1.getText().equals("")|| tf2.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Please fill all the records to continue");
            }
                else{
                String sql = "insert into empdetails (EmpName,EmpID,EmpDept)"+"values (?,?,?)";
    try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","root");
        PreparedStatement statement = connection.prepareStatement(sql);
        String selected = cb1.getSelectedItem().toString();
        statement.setString(1,tf1.getText());
        statement.setInt(2, Integer.parseInt(tf2.getText()));
        statement.setString(3, selected);
        statement.executeUpdate();
    JOptionPane.showMessageDialog(null,"Employee details added successfully");}
catch (Exception ex){
                // JOptionPane.showMessageDialog(null,"add item exception");
                ex.printStackTrace();
            }
        }
    }});
}
}
