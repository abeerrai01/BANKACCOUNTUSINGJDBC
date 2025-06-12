package org.abeer;

import org.abeer.Admin.Admin;
import org.abeer.Admin.ValidationAdmin;
import org.abeer.Confidential.Credits;
import org.abeer.User.*;

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
                System.out.println("ENTER YOUR USER ID");
                int acno=in.nextInt();
                System.out.println("ENTER YOUR PIN");
                int pin=in.nextInt();
                int flag=0;
                if(ValidationAdmin.validation(Credits.url, Credits.username, Credits.password, acno, pin))
                {
                    while(flag==0)
                    {
                        System.out.println("MENU");
                        System.out.println("1 : ADD ACCOUNT\n2 : TOTAL MONEY\n3 : TOTAL USER\n4 : EXIT");
                        int ch=in.nextInt();
                        switch (ch)
                        {
                            case 1://ADD ACCOUNT
                            {
                                Admin.AddAccount();
                                break;
                            }
                            case 2://total money
                            {
                                Admin.TotalMoney();
                                break;
                            }
                            case 3://total user
                            {
                                Admin.TotalUser();
                                break;
                            }
                            case 4:
                            {
                                System.out.println("EXIT");
                                return;
                            }
                        }
                    }
                    break;
                }
                break;
            }
            case 2 :
            {
                System.out.println("ENTER YOUR ACCOUNT NUMBER");
                int acno=in.nextInt();
                System.out.println("ENTER YOUR ACCOUNT PIN");
                int pin=in.nextInt();
                int flag=0;
                if(ValidationUser.validation(Credits.url, Credits.username, Credits.password, acno, pin))
                {
                    while(flag==0)
                    {
                        System.out.println("MENU");
                        System.out.println("1 : ADD MONEY\n2 : SEND MONEY\n3 : WITHDRAW MONEY\n4 : CHECK BALANCE\n 5 : EXIT");
                        int ch=in.nextInt();
                        switch (ch)
                        {
                            case 1://add money
                            {
                                System.out.println("ENTER AMOUNT");
                                double amount=in.nextDouble();
                                User.addmoney(acno,amount);
                                break;
                            }
                            case 2://send money
                            {
                                System.out.println("ENTER AMOUNT");
                                double amount=in.nextDouble();
                                User.sendMoney(acno,amount);
                                break;
                            }
                            case 3://withdraw
                            {
                                System.out.println("ENTER AMOUNT");
                                double amount=in.nextDouble();
                                User.withdraw(acno,amount);
                                break;
                            }
                            case 4://check Balance
                            {
                                User.checkBalance(acno);
                                break;
                            }
                            case 5:
                            {
                                System.out.println("EXIT");
                                return;
                            }
                        }
                    }
                    break;
                }
                    }
        }
    }
}
