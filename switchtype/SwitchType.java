
package switchtype;

import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.config.Configuration;

public class SwitchType extends JavaPlugin{
    
    private PluginDescriptionFile plugin;
    private LavaCommandExecutor lava;
    private WaterCommandExecutor water;
    private CoalCommandExecutor coal;
    protected static Configuration config;
    
    @Override
    public void onDisable() {
        plugin = getDescription();
        System.out.println("[" + plugin.getName() + "] has been disabled!");
    }

    @Override
    public void onEnable() {
        plugin = getDescription();
        System.out.println("[" + plugin.getName() + "] has been enabled!");
        
        lava = new LavaCommandExecutor(this);
        water = new WaterCommandExecutor(this);
        coal = new CoalCommandExecutor(this);
        getCommand("lava").setExecutor(lava);
        getCommand("water").setExecutor(water);
        getCommand("coal").setExecutor(coal);
    }
    
    
}
