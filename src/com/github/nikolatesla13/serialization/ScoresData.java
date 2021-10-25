package com.github.nikolatesla13.serialization;

import org.bukkit.entity.Player;

import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

public class ScoresData implements Serializable {

    private final HashMap<Player, Integer> playerScores;
    private final HashMap<String, Integer> safetyPlayerScores;

    public ScoresData() {
        playerScores = new HashMap<Player, Integer>();
        safetyPlayerScores = new HashMap<String, Integer>();
    }

    public void setInitialScore(Player key, Integer score) {
        playerScores.putIfAbsent(key, score);
        safetyPlayerScores.putIfAbsent(key.getDisplayName(), score);
    }

    public void addToScoreOfPlayer(Player key, Integer amountToIncrement) {
        playerScores.put(key, getScoreOfPlayer(key)+amountToIncrement);
        safetyPlayerScores.put(key.getDisplayName(), getScoreOfPlayer(key)+amountToIncrement);
    }

    public void subtractToScoreOfPlayer(Player key, Integer amountToSubtract) {
        playerScores.put(key, getScoreOfPlayer(key)-amountToSubtract);
        safetyPlayerScores.put(key.getDisplayName(), getScoreOfPlayer(key)-amountToSubtract);
    }

    public Integer getScoreOfPlayer(Player key) {
        if(playerScores.get(key) != null) {
            return playerScores.get(key);
        }
        if(safetyPlayerScores.get(key.getDisplayName()) != null) {
            return safetyPlayerScores.get(key.getDisplayName());
        }
        return -1;
    }

}
