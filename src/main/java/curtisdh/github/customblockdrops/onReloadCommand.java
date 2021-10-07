package curtisdh.github.customblockdrops;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class onReloadCommand implements CommandExecutor
{
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        if(!(sender.isOp()))
        {
            sender.sendMessage(ChatColor.RED+"You do not have permission for this command.");
            return true;
        }
        CustomBlockDrops.PrintWithClassName(this, "Reloading config");
        CustomBlockDrops.Instance.reloadConfig();
        CustomBlockDrops.Instance.LoadConfig();
        sender.sendMessage(ChatColor.GREEN+"Config successfully reloaded:"+this.getClass().getSimpleName());
        return true;
    }
}
