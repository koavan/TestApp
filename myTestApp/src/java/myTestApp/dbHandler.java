/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myTestApp;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author staff
 */
public class dbHandler {
    public static int signupUser(LabUser user)
    {
        int r;
        String table;
        String query;
        Statement ps;
        
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labapp","root","root"))
            {
                table = "userstable";
                query = "insert into " + table + " values ('"+ user.firstName() +"','"+ user.lastName() +"','"+ user.userGender() +"','"+ user.dateOfBirth() +"','"+ user.emailID() +"','"+ user.password() + "'," + String.valueOf(user.privilege()) + ");";
                ps = con.createStatement();
                r = ps.executeUpdate(query);
            }
        } 
        catch (Exception ex) 
        {
            Logger.getLogger(signupUser.class.getName()).log(Level.SEVERE, null, ex);
            r=-1;
        }
        return r;
    }
    
    public static int signinUser(String email, String pswd)
    {
        /* signinUser 
        * returns +1 if user is valid, -1 if password not valid, 0 if user mail not present
        * 100 if multiple entries exist
        *
        */
        
        String table;
        String query;
        String pswdfromDB="";
        
        Statement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        Integer rowCount;
        
        Integer status=-1;
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/labapp","root","root"))
            {
                table = "userstable";
                query = "SELECT * FROM " + table + " where Email='" + email + "'";
                System.out.println(query);
                ps = con.createStatement();
                rs = ps.executeQuery(query);
                rsmd = rs.getMetaData();

                rowCount = 0;
                while(rs.next())
                    rowCount+=1;
                rs.first();
                
                String text;
                if(rowCount == 1)
                {
                    String n = rs.getString(1);
                    pswdfromDB = rs.getString("Password");
                    if(pswdfromDB.equals(pswd))
                    {
                        status=1;
                    }
                    else
                    {
                        status=-1;
                    }
                }
                else if(rowCount == 0)
                {
                    status=0;
                }
                else if(rowCount>1)
                {
                    status=100;
                }
            }
            catch(SQLException sqle)
            {
                Logger.getLogger(signupUser.class.getName()).log(Level.SEVERE, null, sqle);
            }
        }
        catch(ClassNotFoundException e)
        {
            Logger.getLogger(signupUser.class.getName()).log(Level.SEVERE, null, e);
        }
        return status;
    }
}
