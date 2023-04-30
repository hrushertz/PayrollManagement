import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class SearchEmployee {
    private JPanel searchPanel;
    private JTextField getID;
    private JTextField empName;
    private JTextField empID;
    private JTextField empDept;
    private JTextField empAttendance;
    private JButton button1;
    JFrame searchF = new JFrame();
    public SearchEmployee() {
        searchF.setContentPane(searchPanel);
       // searchF.pack();
        searchF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
        searchF.setVisible(true);
        empName.setEditable(false);
        empID.setEditable(false);
        empDept.setEditable(false);
        empAttendance.setEditable(false);
    button1.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                String str = getID.getText();
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/payroll","root","root");
                PreparedStatement st = con.prepareStatement("select * from EmpDetails where EmpID=?");
                st.setString(1, str);
                ResultSet rs = st.executeQuery();
                if (rs.next()) {
                    String s = rs.getString(1);
                    int s1 = rs.getInt(2);
                    String s11=String.valueOf(s1);
                    String s2 = rs.getString(3);
                    int s3 = rs.getInt(4);
                    String s31=String.valueOf(s3);

                    empName.setText(s);
                    empID.setText(s11);
                    empDept.setText(s2);
                    empAttendance.setText(s31);
                } else {
                    JOptionPane.showMessageDialog(null, "ID not found");
                }
                //Create Exception Handler
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

    });
}
}
