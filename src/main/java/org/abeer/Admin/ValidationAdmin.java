package org.abeer.Admin;

import java.sql.*;

public class ValidationAdmin
{
    public static boolean validation(String url,String username,String password,int acno,int pin)
    {

        try
        {
            Connection conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            String debit="SELECT PIN FROM ADMIN WHERE ID=?;";
            PreparedStatement deb=conn.prepareStatement(debit);
            deb.setInt(1,acno);
            ResultSet rs=deb.executeQuery();
            conn.commit();
            int Pin=-1;
            while(rs.next())
            {
                Pin=rs.getInt("PIN");
            }
            if(Pin==pin) {
                return true;
            }

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return false;
    }
    }
