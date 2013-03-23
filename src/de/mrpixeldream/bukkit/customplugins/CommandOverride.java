package de.mrpixeldream.bukkit.customplugins;

import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandOverride implements Listener
{
	private String message;
	
	public CommandOverride(String msg)
	{
		this.message = msg;
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onCommandPreProcess(PlayerCommandPreprocessEvent e)
	{
		if (e.getMessage().startsWith("/pl") || e.getMessage().startsWith("pl"))
		{
			if (!e.getPlayer().hasPermission("customplugins.original"))
			{
				e.getPlayer().sendMessage(
						ChatColor.GREEN + "Plugins: " + ChatColor.WHITE
								+ this.message);
				e.setCancelled(true);
			}
		}
	}
}