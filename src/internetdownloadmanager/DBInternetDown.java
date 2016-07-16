/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package internetdownloadmanager;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author zamalek
 */
public class DBInternetDown {

    ArrayList<String> lis = new ArrayList<String>();
    Connection con;
    Statement st;
    int number_row;
    ResultSet set;
    public static String[] app20;
    public static int x = 0;
    
    
    
    
    public com.mysql.jdbc.Connection getconnection() throws ClassNotFoundException {

        Class.forName("com.mysql.jdbc.Driver");
        try {
            con = (com.mysql.jdbc.Connection) DriverManager.getConnection("jdbc:mysql://localhost/reg", "root", "");
        } catch (SQLException ex) {
            System.out.println(" EROOR IN CONNECTION ");
        }
        return (com.mysql.jdbc.Connection) con;

    }
    public String AddData(String filename,  String size, String url, String directory ) {
        try {

            //prepare statement
            String qry = "insert into down(filename, size, url, directory,date)"
                    + "values (?,?,?,?,?)";
            System.out.println(filename + "\t" + size + "\t" + url+ "\t" + directory );
            PreparedStatement ps = con.prepareStatement(qry);

            ps.setString(1, filename);
            ps.setString(2, size );
            ps.setString(3, url);
            ps.setString(4, directory);
            ps.setString(5, new java.util.Date().toString());
           
            ps.executeUpdate();


        } catch (Exception e) {


            System.out.println(e + "\t" + e.getMessage() + "????");
        }
        return null;


    }
    public Object[][] Get_Downs() throws ClassNotFoundException, SQLException {

        Object data[][];
//st = (PreparedStatement) con.prepareStatement("Select * from operations where mobile like '" + aa.get_patient_searchname1() + "%'");
        PreparedStatement st = getconnection().prepareStatement("Select * from down ");

        ResultSet result = st.executeQuery();
        result.last();
        number_row = result.getRow();
        data = new String[number_row][8];
        number_row = 0;
        result.beforeFirst();

        while (result.next()) {
            data[number_row][0] = result.getString("filename");
            data[number_row][1] = result.getString("size");
            data[number_row][2] = result.getString("url");
            data[number_row][3] = result.getString("directory");
            data[number_row][4] = result.getString("date");
            number_row++;
        }
        return data;
    }

}
