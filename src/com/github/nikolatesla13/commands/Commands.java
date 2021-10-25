package com.github.nikolatesla13.commands;

import com.github.nikolatesla13.socialCredit.SocialCreditSystem;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Commands implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {

        if(!(commandSender instanceof Player)) {
            return true;
        }

        switch (command.getName()) {
            case "getSocialScore":
                SocialCreditSystem.SendScore(commandSender);
                break;
            default:
                break;
        }

        return true;
    }

}
