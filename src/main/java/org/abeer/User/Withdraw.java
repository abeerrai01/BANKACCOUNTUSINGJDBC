package org.abeer.User;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Withdraw
{
    public static void withdraw(String url,String username,String password,double amount,int acno)
    {
        try
        {
            Connection conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            Scanner in=new Scanner(System.in);
            String debit="UPDATE ACCOUNTS SET BALANCE=BALANCE-? WHERE ACCOUNTNUMBER=?;";
            PreparedStatement deb=conn.prepareStatement(debit);
            deb.setDouble(1,amount);
            deb.setInt(2,acno);
            int rowAffected2=deb.executeUpdate();
            if(rowAffected2<=0)
            {
                System.out.println("debit failed ❌");
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
