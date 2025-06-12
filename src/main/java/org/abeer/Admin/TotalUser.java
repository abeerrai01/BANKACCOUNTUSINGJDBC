package org.abeer.Admin;

import java.sql.*;

public class TotalUser
{
    public static void totalUser(String url,String username,String password)
    {
        try
        {
            Connection conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            String add="SELECT COUNT(ACCOUNTNUMBER) AS ACCOUNTNUMBER FROM ACCOUNTS;";
            PreparedStatement ps=conn.prepareStatement(add);
            ResultSet rs=ps.executeQuery();
            conn.commit();
            while(rs.next())
            {
                System.out.println(rs.getDouble("ACCOUNTNUMBER"));
            }
            System.out.println("TRANSACTION SUCESSFULLY ✅");

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }
}
