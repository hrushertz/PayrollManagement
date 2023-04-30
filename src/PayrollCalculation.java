import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class PayrollCalculation {
    private JPanel payrollPanel;
    private JTextField tf1;
    private JTextField tf2;
    private JTextField tf3;
    private JTextField tf4;
    private JTextField tf5;
    private JTextField tf6;
    private JTextField tf7;
    private JTextField tf8;
    private JButton CalButton;
    JFrame payrollF =new JFrame();
public PayrollCalculation() {
    payrollF.setContentPane(payrollPanel);
    payrollF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    //payrollF.pack();
    payrollF.setVisible(true);
    tf2.setEditable(false);
    tf3.setEditable(false);
    tf4.setEditable(false);
    tf5.setEditable(false);
    tf6.setEditable(false);
    tf7.setEditable(false);
    tf8.setEditable(false);

    CalButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            try {
                String str = tf1.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll", "root", "root");
                PreparedStatement st = con.prepareStatement("select * from EmpDetails where EmpID=?");
                st.setString(1, str);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String s = rs.getString(1);
                    String s1 = rs.getString(3);
                    int s2 = rs.getInt(4);
                    String s3 = String.valueOf(s2);

                    tf2.setText(s);
                    tf3.setText(s1);
                    tf4.setText(s3);

                    PreparedStatement st1 = con.prepareStatement("select * from salarydetails where Dept=?");
                    st1.setString(1, s1);
                    ResultSet rs1 = st1.executeQuery();
                    if (rs1.next()) {
                        int s4 = rs1.getInt(2);
                        int s6 = s4 * s2;
                        String s5 = String.valueOf(s6);
                        tf5.setText(s5);
                        double hra = 0.4 * s6;
                        double da = 0.42 * s6;
                        String s7 = String.valueOf(hra);
                        String s8 = String.valueOf(da);
                        double gs = hra + da + s6;
                        String s9 = String.valueOf(gs);
                        tf6.setText(s7);
                        tf7.setText(s8);
                        tf8.setText(s9);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "ID not found");
                }
            }
            catch (Exception ex) {
                    JOptionPane.showMessageDialog(null,"exception");
            }
        }

    });
}
}
