package fr.titou.unbreakableglass;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	
	@Override
	public void onEnable() {
		System.out.println("[UnbreakableGlass] Enabling...");
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		System.out.println("[UnbreakableGlass] Disabling...");
	}
	
	
	
	@EventHandler
	public void onBreak(BlockBreakEvent event){
		
		Player player = event.getPlayer();
		Block block = event.getBlock();
		boolean msg = getConfig().getBoolean("message");
		String permission = getConfig().getString("permission");
		
		if(block.getType() == Material.GLASS) {
			if(player.hasPermission(permission)) {
			}else {
				event.setCancelled(true);
				
				if(msg == true) {
					player.sendMessage("§b[UnbreakableGlass] you can't destroy glass");
				}
			}
		}		
	}
	
}
