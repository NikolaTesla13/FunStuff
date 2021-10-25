package com.github.nikolatesla13.utils;

import org.bukkit.ChatColor;

import static org.bukkit.Bukkit.getServer;

public class Logger {

    public static void PrintMessage(String message) {
        getServer().getConsoleSender().sendMessage(ChatColor.GREEN + message);
    }

    public static void PrintWarning(String message) {
        getServer().getConsoleSender().sendMessage(ChatColor.YELLOW + message);
    }

    public static void PrintError(String message) {
        getServer().getConsoleSender().sendMessage(ChatColor.RED + message);
    }

}
