package me.herp.derp.nbe;


import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.util.logging.Logger;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.PluginDescriptionFile;
/* Please do not skid the programmables */
/* (Yes I know it is actually "programs") */

public class NoBedExplode extends JavaPlugin implements Listener {
			public NoBedExplode plugin;
			public final Logger logger = Logger.getLogger("Minecraft");
			@Override
			public void onEnable() 
			{
				getServer().getPluginManager().registerEvents(this, this);
			}
			/* Begin useful code */
		    @EventHandler
		    public void onInteract(PlayerInteractEvent e)
		    {
		    	Player p = e.getPlayer();
		    	if(e.getAction() == Action.RIGHT_CLICK_BLOCK)
		    	{
		    			if(e.getClickedBlock().toString().toLowerCase().contains("bed"))
		    			{

		    			    Block block = e.getClickedBlock();
		    				if(((org.bukkit.block.Block) block).getLocation().getWorld().getName().toLowerCase().contains("nether"))
		    				{
		    					p.sendMessage(ChatColor.YELLOW+"You are not allowed to use a bed in the Nether!");
		    					e.setCancelled(true);
		    				}
		    			}
		    			else
		    			{   /* Some debug code that helped me get this working */
		    				//p.sendMessage("You actually clicked a "+e.getClickedBlock().toString());
		    			}
		    	}
		    }
		    /* End */	
}
