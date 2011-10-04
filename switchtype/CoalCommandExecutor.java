
package switchtype;

import org.bukkit.ChatColor;
import org.bukkit.CoalType;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.material.Coal;

public class CoalCommandExecutor implements CommandExecutor{
    
    private SwitchType plugin;
    
    public CoalCommandExecutor(SwitchType plugin){
        this.plugin=plugin;
    }

    @Override
    public boolean onCommand(CommandSender cs, Command cmnd, String string, String[] strings) {
        if(!(cs instanceof Player)){
            System.out.println("You must be in game to do this!");
            return true;
        }
        
        Player player = (Player) cs;
        
        if(!(player.hasPermission("switchtype.coal"))){
            player.sendMessage(ChatColor.RED + "You don't have permission to do that!");
            return true;
        }
        
        if(!(player.getItemInHand().getType()==Material.COAL)){
            player.sendMessage(ChatColor.RED + "You need to have coal or charcoal in your hand!");
            return true;
        }
        
        ItemStack coalStack = player.getItemInHand();
        
        if(((Coal) coalStack.getData()).getType() == CoalType.COAL){
            coalStack = new ItemStack(Material.COAL, coalStack.getAmount(),(short) 0, CoalType.CHARCOAL.getData());
            player.setItemInHand(coalStack);
            player.sendMessage(ChatColor.GOLD + "Your coal is now charcoal.");
            return true;
        }
        else{
            if(((Coal) coalStack.getData()).getType() == CoalType.CHARCOAL){
                coalStack = new ItemStack(Material.COAL, coalStack.getAmount(),(short) 0, CoalType.COAL.getData());
                player.setItemInHand(coalStack);
                player.sendMessage(ChatColor.GOLD + "Your charcoal is now coal.");
                return true;
            }
        }
        
        return true;
    }
    
}
