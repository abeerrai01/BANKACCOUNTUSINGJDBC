package org.abeer.Admin;

import java.sql.*;
import java.util.Scanner;

public class TotalMoney
{
    public static void totalmoney(String url,String username,String password)
    {
        try
        {
            Connection conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            String add=" SELECT SUM(BALANCE) AS BALANCE FROM ACCOUNTS;";
            PreparedStatement ps=conn.prepareStatement(add);
            ResultSet rs=ps.executeQuery();
            conn.commit();
            while(rs.next())
            {
                System.out.println(rs.getDouble("BALANCE"));
            }
            System.out.println("TRANSACTION SUCESSFULLY ✅");

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
