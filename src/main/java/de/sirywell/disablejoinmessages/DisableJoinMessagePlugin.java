package de.sirywell.disablejoinmessages;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class DisableJoinMessagePlugin extends JavaPlugin implements Listener {

    private boolean bypass;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        this.bypass = getConfig().getBoolean("enable-bypass-perms");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        if (!this.bypass || !event.getPlayer().hasPermission("disablejoinmessages.join.bypass")) {
            event.joinMessage(null);
        }
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent event) {
        if (!this.bypass || !event.getPlayer().hasPermission("disablejoinmessages.leave.bypass")) {
            event.quitMessage(null);
        }
    }
}
