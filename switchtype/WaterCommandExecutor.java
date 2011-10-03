
package switchtype;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class WaterCommandExecutor implements CommandExecutor{
    
    private SwitchType plugin;
    
    public WaterCommandExecutor(SwitchType plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(!(cs instanceof Player)){
            System.out.println("You must be in game to do this!");
            return true;
        }
        
        Player player = (Player) cs;
        
        if(!(player.hasPermission("switchtype.water"))){
            player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
            return true;
        }
        
        Material mat = player.getItemInHand().getType();
        
        if(!(mat==Material.WATER || mat==Material.STATIONARY_WATER)){
            player.sendMessage("You need to have water or stationary water in your hand!");
            return true;
        }
        
        ItemStack waterStack = player.getItemInHand();
        
        if(waterStack.getTypeId()==8){
            int amount = waterStack.getAmount();
            waterStack = new ItemStack(9, amount);
            player.setItemInHand(waterStack);
            player.sendMessage("Your water is now stationary water.");
            return true;
        }
        else{
            if(waterStack.getTypeId()==9){
                int amount = waterStack.getAmount();
                waterStack = new ItemStack(8, amount);
                player.setItemInHand(waterStack);
                player.sendMessage("Your stationary water is now water.");
                return true;
            }
        }
        
        return true;
    }
    
}
