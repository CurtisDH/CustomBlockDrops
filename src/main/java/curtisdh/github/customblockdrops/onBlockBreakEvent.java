package curtisdh.github.customblockdrops;

import jdk.javadoc.internal.doclint.HtmlTag;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;

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
        Material blockType = event.getBlock().getType();
        System.out.println(blockType);
        if(blockDataMap == null)
        {
            return;
        }
        for (Map.Entry<String, BlockData> blockDataEntries : blockDataMap.entrySet())
        {
            if(Material.valueOf(blockDataEntries.getKey()) == blockType)
            {
                System.out.println("Hello");
            }
        }
    }

}
