package org.abeer.User;

import java.sql.*;

public class CheckBalance
{
    public static void checkBalance(String url,String username,String password,int acno)
    {
        try
        {
            Connection conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            String debit="SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNTNUMBER=?";
            PreparedStatement deb=conn.prepareStatement(debit);
            deb.setInt(1,acno);
            ResultSet rs=deb.executeQuery();
            conn.commit();
            while(rs.next())
            {
                System.out.println(rs.getDouble("Balance"));
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
