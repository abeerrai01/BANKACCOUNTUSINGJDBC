package org.abeer.User;

import java.sql.*;
import java.util.Scanner;

public class SendMoney
{

    public static void sendmoney(String url,String username,String password,int acno,double amount)
    {
       try
       {
           Connection conn=DriverManager.getConnection(url,username,password);
           conn.setAutoCommit(false);
           Scanner in=new Scanner(System.in);
           if (!CheckBalance(conn, acno, amount)) {
               System.out.println("Insufficient balance ❌");
               conn.rollback();
               return;
           }
           String credit="UPDATE ACCOUNTS SET BALANCE=BALANCE-? WHERE ACCOUNTNUMBER=?;";
           PreparedStatement cre=conn.prepareStatement(credit);
           cre.setDouble(1,amount);
           cre.setInt(2,acno);
           int rowAffected=cre.executeUpdate();
           if(rowAffected<=0)
           {
               System.out.println("Debit failed ❌");
               conn.rollback();
               return;
           }
           String debit="UPDATE ACCOUNTS SET BALANCE=BALANCE+? WHERE ACCOUNTNUMBER=?;";
           PreparedStatement deb=conn.prepareStatement(debit);
           System.out.println("ENTER ACCOUNT NUMBER TO CREDIT");
           int acno2=in.nextInt();
           deb.setDouble(1,amount);
           deb.setInt(2,acno2);
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
    public static boolean CheckBalance(Connection conn,int acno,double amount)
    {
        try
        {
            String query="SELECT BALANCE FROM ACCOUNTS WHERE ACCOUNTNUMBER=?";
            PreparedStatement ps=conn.prepareStatement(query);
            ps.setInt(1,acno);
            ResultSet rs=ps.executeQuery();
            double balance=-1;
            while(rs.next())
            {
                balance=rs.getDouble("BALANCE");
            }
            if(balance>=amount)
            {
                conn.commit();
            }
            else
            {
                return false;
            }
        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
        return true;
    }
}