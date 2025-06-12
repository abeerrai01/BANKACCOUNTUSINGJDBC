package org.abeer;

import java.sql.SQLOutput;
import java.util.Scanner;

public class management
{
    public static void main(String[] args)
    {
        System.out.println("WELCOME TO PUNJAB NATIONAL BANK");
        System.out.println("CHOOSE YOUR PROFILE");
        System.out.println("1 : ADMIN \n2 : USER");
        //admin-add account,total bank money,no of transactions,no of users,userwithmosttransaction
        //user-add money,checkbalance,sendmoney,withdraw money
        Scanner in=new Scanner(System.in);
        int choice=in.nextInt();
        switch(choice)
        {
            case 1 :
            {
                //admin
            }
            case 2 :
            {
                System.out.println("ENTER YOUR ACCOUNT NUMBER");
                int acno=in.nextInt();
                System.out.println("ENTER YOUR ACCOUNT PIN");
                int pin=in.nextInt();

                //user
            }
            default:
            {
                System.out.println("Wrong Choice");
            }
        }
    }
}
