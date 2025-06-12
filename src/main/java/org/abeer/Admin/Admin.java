package org.abeer.Admin;

import org.abeer.Confidential.Credits;

public class Admin
{
    public static void AddAccount()
    {
        AddAccount.addAccount(Credits.url,Credits.username,Credits.password);
    }
    public static void TotalMoney()
    {
        TotalMoney.totalmoney(Credits.url,Credits.username,Credits.password);
    }
    public static void TotalUser()
    {
        TotalUser.totalUser(Credits.url,Credits.username,Credits.password);
    }
}
