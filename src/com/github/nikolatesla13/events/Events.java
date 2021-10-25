package com.github.nikolatesla13.events;

import com.github.nikolatesla13.socialCredit.SocialCreditSystem;
import com.github.nikolatesla13.utils.Logger;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class Events implements Listener {

    @EventHandler
    public static void onPlayerJoin(PlayerJoinEvent event) {
        SocialCreditSystem.SetupPlayer(event.getPlayer());
    }

    @EventHandler
    public static void onPlayerQuit(PlayerQuitEvent event) {
        SocialCreditSystem.SavePlayerProgress();
    }

    @EventHandler
    public void onHit(EntityDamageByEntityEvent event) {
        SocialCreditSystem.CheckForPlayerDamage(event.getDamager(), event.getEntity());
    }

}
