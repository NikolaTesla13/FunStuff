package com.github.nikolatesla13;

import com.github.nikolatesla13.commands.Commands;
import com.github.nikolatesla13.events.Events;
import com.github.nikolatesla13.socialCredit.SocialCreditSystem;
import com.github.nikolatesla13.utils.Logger;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class FunStuff extends JavaPlugin {

    @Override
    public void onEnable() {
        Logger.PrintMessage("G'day bois!");
        SocialCreditSystem.Initialize();
        getServer().getPluginManager().registerEvents(new Events(), this);
        getCommand("getSocialScore").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        Logger.PrintError("See ya!");
        SocialCreditSystem.Shutdown();
    }

}
