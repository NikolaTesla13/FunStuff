package com.github.nikolatesla13.socialCredit;

import com.github.nikolatesla13.serialization.ScoresData;
import com.github.nikolatesla13.utils.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

import java.io.*;

public class SocialCreditSystem {

    public static ScoresData scoresData;
    private static final Boolean Debug = true;

    public static void Initialize() {
        if(!(new File("cache/.scores").isFile())) {
            Serialize();
        } else {
            Deserialize();
        }
        Logger.PrintMessage("[Social Credit System] Successfully initialized!");
    }

    public static void Shutdown() {
        Logger.PrintError("[Social Credit System] Successfully shutdown!");
    }

    public static void Serialize() {
        Logger.PrintWarning("Serializing");
        scoresData = new ScoresData();
        try {
            FileOutputStream fileOut = new FileOutputStream("cache/.scores");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(scoresData);
            out.close();
            fileOut.close();
        } catch (IOException exception) {
            Logger.PrintError(exception.getMessage());
            System.exit(-1);
        }
    }

    public static void Deserialize() {
        Logger.PrintWarning("Deserializing");
        try {
            FileInputStream fileIn = new FileInputStream("cache/.scores");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            scoresData = (ScoresData) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException | ClassNotFoundException exception) {
            Logger.PrintError(exception.getMessage());
            System.exit(-1);
        }
    }

    public static void SetupPlayer(Player player) {
        Deserialize();
        player.sendMessage(ChatColor.BOLD + "Hello comrade " + ChatColor.AQUA + player.getDisplayName() + ChatColor.WHITE + "!");
        scoresData.setInitialScore(player, 500);
        player.sendMessage("You have " + ChatColor.LIGHT_PURPLE + scoresData.getScoreOfPlayer(player) + ChatColor.WHITE + "/1000 initial social points!");
    }

    public static void CheckForPlayerDamage(Entity damagerEntity, Entity damagedEntity) {
        if(damagerEntity instanceof Player) {
            if(damagedEntity instanceof Animals) {
                damagerEntity.sendMessage(ChatColor.RED + "-50" + ChatColor.WHITE + " social points");
                scoresData.subtractToScoreOfPlayer((Player)damagerEntity, 50);
            } else if(damagedEntity instanceof Player) {
                damagerEntity.sendMessage(ChatColor.RED + "-100" + ChatColor.WHITE + " social points");
                scoresData.subtractToScoreOfPlayer((Player)damagerEntity, 100);
            }
        }
    }

    public static void SendScore(CommandSender commandSender) {
        Player player = (Player) commandSender;
        player.sendMessage(ChatColor.LIGHT_PURPLE + String.valueOf(scoresData.getScoreOfPlayer(player)) + ChatColor.WHITE + " social points, comrade!");
    }

    public static void SavePlayerProgress() {
        Serialize();
    }
}
