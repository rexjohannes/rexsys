package de.pattyxdhd.feed;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GamemodeManager {

    static List<String> gm0 = new ArrayList<String>(Arrays.asList("0", "survival", "überleben"));
    static List<String> gm1 = new ArrayList<String>(Arrays.asList("1", "creative", "kreative"));
    static List<String> gm2 = new ArrayList<String>(Arrays.asList("2", "adventure", "abenteuer"));
    static List<String> gm3 = new ArrayList<String>(Arrays.asList("3", "spectator", "zuschauer"));

    public static void changeGamemode(final Player player, final String gamemode){

        if(gm0.contains(gamemode)){
            if(player.hasPermission("gamemode.use.0")){

                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else if(gm1.contains(gamemode)){
            if(player.hasPermission("gamemode.use.1")){

                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else if(gm2.contains(gamemode)){
            if(player.hasPermission("gamemode.use.2")){

                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else if(gm3.contains(gamemode)){
            if(player.hasPermission("gamemode.use.3")){

                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                player.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else{
            player.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Gamemode konnte nicht gefunden werden.");
        }

    }

    public static void changeGamemode(final Player player, final String gamemode, final Player sender){

        if(gm0.contains(gamemode)){
            if(sender.hasPermission("gamemode.use.other.0")){

                player.setGameMode(GameMode.SURVIVAL);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else if(gm1.contains(gamemode)){
            if(sender.hasPermission("gamemode.use.other.1")){

                player.setGameMode(GameMode.CREATIVE);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else if(gm2.contains(gamemode)){
            if(sender.hasPermission("gamemode.use.other.2")){

                player.setGameMode(GameMode.ADVENTURE);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else if(gm3.contains(gamemode)){
            if(sender.hasPermission("gamemode.use.other.3")){

                player.setGameMode(GameMode.SPECTATOR);
                player.sendMessage(FeedPlugin.getPrefix() + "Dein Gamemode wurde geändert. §8[§e" + player.getGameMode() + "§8]");
                sender.sendMessage(FeedPlugin.getPrefix() + "Du hast den Gamemode von §e" + player.getName() + " §7geändert. §8[§e" + player.getGameMode() + "§8]");

            }else{
                sender.sendMessage(FeedPlugin.getPrefix() + "Dazu hast du keinen Zugiff.");
            }
        }else{
            sender.sendMessage(FeedPlugin.getPrefix() + "§cDer angegebene Gamemode konnte nicht gefunden werden.");
        }

    }

}
