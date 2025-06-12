package org.abeer.Admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class AddAccount
{
    public static void addAccount(String url,String username,String password)
    {
        try
        {
            Connection conn= DriverManager.getConnection(url,username,password);
            conn.setAutoCommit(false);
            Scanner in=new Scanner(System.in);
            System.out.println("ENTER ACCOUNT NUMBER");
            int acno=in.nextInt();
            System.out.println("ENTER ACCOUNT PIN");
            int pin=in.nextInt();
            System.out.println("ENTER THE INTIAL AMOUNT");
            double amount=in.nextDouble();
            String add="INSERT INTO ACCOUNTS VALUES(?,?);";
            String debit="INSERT INTO AUTH VALUES(?,?);";
            PreparedStatement cre=conn.prepareStatement(add);
            PreparedStatement deb=conn.prepareStatement(debit);
            cre.setInt(1,acno);
            cre.setDouble(2,amount);
            deb.setDouble(1,acno);
            deb.setInt(2,pin);
            int rowAffected1=cre.executeUpdate();
            int rowAffected2=deb.executeUpdate();
            if(rowAffected2<=0 && rowAffected1<=0)
            {
                System.out.println("failed ❌");
                conn.rollback();
                return;
            }
            conn.commit();
            System.out.println("ACCOUNT ADDED SUCESSFULLY ✅");

        }
        catch (SQLException e)
        {
            System.out.println(e);
        }
    }

}
