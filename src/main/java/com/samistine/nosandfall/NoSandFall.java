package com.samistine.nosandfall;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoSandFall extends JavaPlugin {

    @Override
    public void onEnable() {
        FileConfiguration config = this.getConfig();
        config.options().header("Add the names of the worlds you want to be exempted of falling blocks.");
        config.addDefault("Whitelist", new String[]{"world", "world_nether", "world_the_end"});
        config.options().copyDefaults(true);
        this.saveConfig();

        SandListener s = new SandListener(config);
        this.getServer().getPluginManager().registerEvents(s, this);
//        System.out.println("[NoSandFall] is now enabled :O");
//        System.out.println("Finally! No longer this annoying falling blocks!");
    }
}
