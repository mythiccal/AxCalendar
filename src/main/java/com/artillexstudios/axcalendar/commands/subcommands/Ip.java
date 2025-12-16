package com.artillexstudios.axcalendar.commands.subcommands;

import com.artillexstudios.axcalendar.AxCalendar;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.PermissionAttachment;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

import static com.artillexstudios.axcalendar.AxCalendar.MESSAGEUTILS;

public enum Ip {
    INSTANCE;

    public void execute(@NotNull CommandSender sender, String playerName) {
        Player player = Bukkit.getPlayer(playerName);
        
        if (player == null) {
            MESSAGEUTILS.sendLang(sender, "ip.failed", Map.of("%player%", playerName));
            return;
        }

        // Grant the bypass permission to the player
        PermissionAttachment attachment = player.addAttachment(AxCalendar.getInstance());
        attachment.setPermission("axcalendar.bypass-ip-limit", true);
        
        MESSAGEUTILS.sendLang(sender, "ip.success", Map.of("%player%", player.getName()));
        MESSAGEUTILS.sendLang(player, "ip.received");
    }
}

