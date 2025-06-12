package org.abeer;

import java.sql.*;
import java.util.Scanner;

public class AddMoney
{
    public static void addMoney(String url,String username,String password,double amount,int acno)
    {
        try
        {
            Connection conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            Scanner in=new Scanner(System.in);
            String debit="UPDATE ACCOUNTS SET BALANCE=BALANCE+? WHERE ACCOUNTNUMBER=?;";
            PreparedStatement deb=conn.prepareStatement(debit);
            deb.setDouble(1,amount);
            deb.setInt(2,acno);
            int rowAffected2=deb.executeUpdate();
            if(rowAffected2<=0)
            {
                System.out.println("Credit failed ❌");
                conn.rollback();
                return;
            }
            conn.commit();
            System.out.println("Transaction successful ✅");

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

}
