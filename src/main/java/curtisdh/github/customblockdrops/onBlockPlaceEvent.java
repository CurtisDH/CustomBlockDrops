package curtisdh.github.customblockdrops;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.CreatureSpawner;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.BlockStateMeta;

public class onBlockPlaceEvent implements Listener
{
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event)
    {
        ItemStack itemInHand = event.getItemInHand();
        Block block = event.getBlockPlaced();
        if(itemInHand.getType() == Material.SPAWNER)
        {
            BlockStateMeta blockStateMeta = (BlockStateMeta) itemInHand.getItemMeta();
            CreatureSpawner creatureSpawner = (CreatureSpawner) blockStateMeta.getBlockState();
            CreatureSpawner blockCreatureSpawner = (CreatureSpawner) block.getState();
            blockCreatureSpawner.setSpawnedType(creatureSpawner.getSpawnedType());
            blockCreatureSpawner.update();
        }
    }
}
