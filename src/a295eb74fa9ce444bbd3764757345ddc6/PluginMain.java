package a295eb74fa9ce444bbd3764757345ddc6;
import java.io.*;
import java.nio.file.*;
import java.sql.*;
import java.util.*;
import org.bukkit.*;
import org.bukkit.block.*;
import org.bukkit.command.*;
import org.bukkit.entity.*;
import org.bukkit.event.*;
import org.bukkit.inventory.*;
import org.bukkit.inventory.meta.*;
import org.bukkit.plugin.java.*;
import org.bukkit.util.*;

public class PluginMain extends JavaPlugin implements Listener {

	private static PluginMain instance;

	public void onEnable() {
		instance = this;
		getServer().getPluginManager().registerEvents(this, this);
		try {
			Bukkit.getConsoleSender()
					.sendMessage(PluginMain.color("Will now set non op players to Spectator on join!"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void onDisable() {
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] commandArgs) {
		return true;
	}

	public static void procedure(String procedure, Collection<?> args) throws Exception {
	}

	public static Object function(String function, Collection<?> args) throws Exception {
		return null;
	}

	private static List<Object> createList(Object obj) {
		List<Object> list = new ArrayList<>();
		if (obj.getClass().isArray()) {
			int length = java.lang.reflect.Array.getLength(obj);
			for (int i = 0; i < length; i++) {
				list.add(java.lang.reflect.Array.get(obj, i));
			}
		} else if (obj instanceof Collection<?>) {
			list.addAll((Collection<?>) obj);
		} else {
			list.add(obj);
		}
		return list;
	}

	private static String color(String string) {
		return string != null ? ChatColor.translateAlternateColorCodes('&', string) : null;
	}

	public static PluginMain getInstance() {
		return instance;
	}

	@EventHandler(priority = EventPriority.NORMAL)
	public void onPlayerJoinEvent18(org.bukkit.event.player.PlayerJoinEvent event) throws Exception {
		if (!event.getPlayer().isOp()) {
			Bukkit.dispatchCommand(Bukkit.getConsoleSender(), ("gm 3" + event.getPlayer().getName()));
			event.getPlayer().sendTitle("Welcome!", "Please read the chat!",
					(int) java.time.Duration.ofSeconds(((long) 2d)).getSeconds() * 20,
					(int) java.time.Duration.ofSeconds(((long) 5d)).getSeconds() * 20,
					(int) java.time.Duration.ofSeconds(((long) 2d)).getSeconds() * 20);
			event.getPlayer().sendMessage(PluginMain.color(
					"The server is currently still in InDev stage of development, which is why you're currently in Spectator mode!"));
			Bukkit.getConsoleSender().sendMessage(
					PluginMain.color((event.getPlayer().getName() + "wasn't opped so was set to spectator gamemode.")));
		}
	}
}
