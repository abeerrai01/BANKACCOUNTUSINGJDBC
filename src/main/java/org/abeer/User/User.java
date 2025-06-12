package org.abeer.User;

import org.abeer.Confidential.Credits;

public class User
{
    public static void addmoney(int acno,double amount)
    {
        AddMoney.addMoney(Credits.url,Credits.username,Credits.password,amount,acno);
    }
    public static void sendMoney(int acno,double amount)
    {
        SendMoney.sendmoney(Credits.url,Credits.username,Credits.password,acno,amount);
    }
    public static void checkBalance(int acno)
    {
        CheckBalance.checkBalance(Credits.url,Credits.username,Credits.password,acno);
    }
    public static void withdraw(int acno,double amount)
    {
        Withdraw.withdraw(Credits.url,Credits.username,Credits.password,amount,acno);
    }
}
