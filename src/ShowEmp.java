import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Vector;

public class ShowEmp {
    private JPanel showPanel;
    private JButton showDetailsButton;
    private JTable table1;
    JFrame showEmpF=new JFrame();
public ShowEmp() {
    showEmpF.setContentPane(showPanel);
    //showEmpF.pack();
    showEmpF.setExtendedState(java.awt.Frame.MAXIMIZED_BOTH);
    showEmpF.setVisible(true);
    showDetailsButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                String a= "Select* from EmpDetails";
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
    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {
        ResultSetMetaData metaData = rs.getMetaData();
// names of columns
        Vector<String> columnNames = new Vector<String>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }
// data of the table
        Vector<Vector<Object>> data = new Vector<Vector<Object>>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<Object>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }
        return new DefaultTableModel(data, columnNames);
    }
}
