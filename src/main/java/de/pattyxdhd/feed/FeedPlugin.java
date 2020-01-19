package de.pattyxdhd.feed;

import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class FeedPlugin extends JavaPlugin {

    public static FeedPlugin instace;

    @Getter
    private static FeedPlugin instance;

    @Getter
    private final static String prefix = "§8[§bSystem§8] §7";

    @Override
    public void onEnable() {
        instance = this;

        loadCommands();
        loadListener(Bukkit.getPluginManager());

        log("§aPlugin geladen.");
    }

    @Override
    public void onDisable() {
        log("§cPlugin entladen.");
    }

    private void loadCommands(){
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("gm").setExecutor(new GamemodeCommand());
        getCommand("heal").setExecutor(new HealCommand());
        getCommand("invsee").setExecutor(new InvseeCommand());
        getCommand("tp").setExecutor(new TeleportCommand());
        getCommand("top").setExecutor(new TopCommand());
        getCommand("msg").setExecutor(new MessageCommand());
        getCommand("kick").setExecutor(new KickCommand());
        getCommand("rtp").setExecutor(new RTPCommand());
        getCommand("mutechat").setExecutor(new MuteChatCommand());
        getCommand("mutep").setExecutor(new MutePCommand());
        getCommand("rename").setExecutor(new RenameCommand());
        getCommand("ping").setExecutor(new PingCommand());
        getCommand("sudo").setExecutor(new SudoCommand());
        getCommand("slowchat").setExecutor(new SlowchatCommand());
        getCommand("rex").setExecutor(new RexSysCommand());
        getCommand("clearchat").setExecutor(new ClearChatCommand());
        getCommand("enderchest").setExecutor(new EnderChestCommand());
        getCommand("generate").setExecutor(new GenerateCommand());
        getCommand("feuerwerk").setExecutor(new FeuerWerkCommand());
        getCommand("vanish").setExecutor(new VanishCommand());
    }

    private void loadListener(final PluginManager pluginManager){
        pluginManager.registerEvents(new InventoryClickListener(), this);
        pluginManager.registerEvents(new JoinListener(), this);
        pluginManager.registerEvents(new MuteChatListener(), this);
        pluginManager.registerEvents(new SlowChatListener(), this);
        pluginManager.registerEvents(new ChatListener(), this);

    }

    private void log(final String message){
        Bukkit.getConsoleSender().sendMessage(getPrefix() + message);
    }


    public static String convertSekToMin(final Integer seconds)
    {
        if (seconds >= 60)
        {
            double minutes = seconds * 0.0166667;
            minutes = Math.round(minutes);
            return (int) minutes + " Minuten";
        } else
        {
            return seconds + " Sekunden";
        }
    }

}