package curtisdh.github.customblockdrops;

import jdk.javadoc.internal.doclint.HtmlTag;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Map;

public class onBlockBreakEvent implements Listener
{
    private Map<String, BlockData> blockDataMap;

    public void SetBlockDataMap(Map<String, BlockData> map)
    {
        blockDataMap = map;
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event)
    {
        Block block = event.getBlock();
        Material blockType = block.getType();
        Player player = event.getPlayer();
        Integer itemSlotID = player.getInventory().getHeldItemSlot();
        if(player.getInventory().getItem(itemSlotID) != null)
        {
            if(player.getInventory().getItem(itemSlotID).containsEnchantment(Enchantment.SILK_TOUCH))
            {
                return;
            }
        }


        if (blockDataMap == null)
        {
            return;
        }
        for (Map.Entry<String, BlockData> blockDataEntries : blockDataMap.entrySet())
        {
            if (Material.valueOf(blockDataEntries.getKey()) == blockType)
            {
                Material itemToDrop = Material.valueOf(blockDataEntries.getValue().ItemToDrop);
                Integer dropRate = blockDataEntries.getValue().DropRate;

                ItemStack itemsToDrop = new ItemStack(itemToDrop, dropRate);
                block.getWorld().dropItemNaturally(block.getLocation(),itemsToDrop);
                if(blockDataEntries.getValue().OverrideDrop == true)
                {
                    block.setType(Material.AIR);
                    event.setCancelled(blockDataEntries.getValue().OverrideDrop);
                }
            }
        }
    }

}
