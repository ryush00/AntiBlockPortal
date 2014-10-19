package me.ryush00.AntiBlockPortal;

import java.util.logging.Logger;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class EventListener implements Listener {
	private final AntiBlockPortal plugin;
	private final Logger logger;
	
	public EventListener (AntiBlockPortal plugin) {
		this.plugin = plugin;
		this.logger = plugin.logger;
	}
	@EventHandler(priority = EventPriority.NORMAL)
	public void BlockPlace(BlockPlaceEvent e) {
		Location l = e.getBlock().getLocation();
		World lw = l.getWorld();
		Double lx = l.getX();
		Double ly = l.getY();
		Double lz = l.getZ();
		boolean existportal = false;
		for(Double fx = lx - 1; fx <= lx + 1; fx++) {
			for(Double fz = lz - 1; fz <= lz + 1; fz++) {
				if(CheckPortal(lw, fx,ly,fz)) {
					existportal = true;
				}
			}
		}
		if(existportal) { //주위 1블럭 내에 포탈이 존재할 경우 //
			e.getPlayer().sendMessage("포탈 주위에 블럭을 설치할 수 없습니다.");
			e.setCancelled(true);
		}
	}
	
	private boolean CheckPortal(World world, Double x, Double y, Double z) {
		logger.info(new Location(world,x,y,z).getBlock().toString());
		if(new Location(world,x,y,z).getBlock().getType() == Material.PORTAL) { //포탈일경우
			return true; //참을 반환
		}
		return false; //포탈이 아닐 경우 거짓을 반환
	}
}
