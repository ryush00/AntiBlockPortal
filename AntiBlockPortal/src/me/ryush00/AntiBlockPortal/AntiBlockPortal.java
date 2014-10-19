package me.ryush00.AntiBlockPortal;

import java.util.logging.Logger;

import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiBlockPortal extends JavaPlugin {
	
	public Logger logger;
	
	@Override
	public void onEnable() {
    	logger = getServer().getLogger();
		//this.getCommand("join").setExecutor(new CommandListener(this));
		registerEvents(new EventListener(this));
		logger.info("ProjectMG가 활성화 되었습니다.");
		
		
	}
	
	private void registerEvents(Listener listener) {
	    this.getServer().getPluginManager().registerEvents(listener, this);
	}
	
	@Override
	public void onDisable() {
		logger.info("ProjectMG가 비활성화 되었습니다.");
	}

}
