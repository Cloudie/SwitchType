
package switchtype;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class LavaCommandExecutor implements CommandExecutor{
    
    private SwitchType plugin;
    
    public LavaCommandExecutor(SwitchType plugin){
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(!(cs instanceof Player)){
            System.out.println("You must be in game to do this!");
            return true;
        }
        
        Player player = (Player) cs;
        
        if(!(player.hasPermission("switchtype.lava"))){
            player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
            return true;
        }
        
        Material mat = player.getItemInHand().getType();
        
        if(!(mat== Material.LAVA || mat == Material.STATIONARY_LAVA)){
            player.sendMessage("You need to have lava or stationary lava in your hand!");
            return true;
        }
        
        ItemStack lavaStack = player.getItemInHand();
        
        if(lavaStack.getTypeId()==10){
            int amount = lavaStack.getAmount();
            lavaStack = new ItemStack(11, amount);
            player.setItemInHand(lavaStack);
            player.sendMessage("Your lava is now stationary lava.");
            return true;
        }
        else{
            if(lavaStack.getTypeId()==11){
                int amount = lavaStack.getAmount();
                lavaStack = new ItemStack(10, amount);
                player.setItemInHand(lavaStack);
                player.sendMessage("Your stationary lava is now lava.");
                return true;
            }
        }
        
        return true;
    }
    
}
