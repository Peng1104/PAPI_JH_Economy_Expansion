package net.peng1104;

import java.util.Arrays;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.plugin.Plugin;

import JH_Economy.API;
import JH_Economy.Main;

import me.clip.placeholderapi.expansion.PlaceholderExpansion;

/**
 * {@link Class} to get the placeholders from
 * 
 * @since 1.0.0
 * 
 * @author Peng1104
 */

public class JH_EconomyExpansion extends PlaceholderExpansion {
	
	@Override
	public String getIdentifier() {
		return "jh_economyexpansion";
	}
	
	@Override
	public String getAuthor() {
		return "Peng1104";
	}
	
	@Override
	public String getVersion() {
		return "1.0.0";
	}
	
	@Override
	public String getRequiredPlugin() {
		return "JH_Economy";
	}
	
	@Override
	public List<String> getPlaceholders() {
		return Arrays.asList("%jh_economyexpansion_magnata%", "%jh_economyexpansion_tag%");
	}
	
	@Override
	public boolean register() {
		Plugin pl = Bukkit.getPluginManager().getPlugin(getRequiredPlugin());
		
		if (pl == null) return false;
		if (!pl.isEnabled()) Bukkit.getPluginManager().enablePlugin(pl);
		
		return super.register();
	}
	
	@Override
	public String onRequest(OfflinePlayer player, String identifier) {
		if (identifier.equalsIgnoreCase("magnata")) {
			return API.getMagnata();
		}
		if (identifier.equalsIgnoreCase("tag") && (player.getName().equals(API.getMagnata()))) {
			return Main.getInstace().getConfig().getString("Magnata.tag");
		}
		return "";
	}
}