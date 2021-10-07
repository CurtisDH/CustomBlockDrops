package curtisdh.github.customblockdrops;

import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public final class CustomBlockDrops extends JavaPlugin
{
    public static CustomBlockDrops Instance;
    onBlockBreakEvent blockBreakEvent = new onBlockBreakEvent();
    @Override
    public void onEnable()
    {
        PrintWithClassName(this, "Starting...");
        Instance = this;
        //Events
        getServer().getPluginManager().registerEvents(blockBreakEvent,this);
        //Commands
        getCommand("reloadConfig").setExecutor(new onReloadCommand());
        LoadConfig();
        PrintWithClassName(this, "Initialised");
    }
    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }

    public void LoadConfig()
    {
        PrintWithClassName(this, "Loading config");
        saveDefaultConfig();
        Map<String, BlockData> blockData = new HashMap<>();
        for (String key : getConfig().getConfigurationSection("settings.blocks").getKeys(false))
        {
            BlockData data;
            Object droprateObj = getConfig().getConfigurationSection("settings.blocks." + key)
                    .getValues(true).get("droprate");

            Object itemMaterial = getConfig().getConfigurationSection("settings.blocks." + key)
                    .getValues(true).get("itemMaterial");
            Object overrideDrop = getConfig().getConfigurationSection("settings.blocks."+ key)
                    .getValues(true).get("overrideDrop");
            boolean overrideDropBool = overrideDrop.toString().equalsIgnoreCase("true");
            int dropRate = Integer.parseInt(droprateObj.toString());
            key = key.toUpperCase(Locale.ROOT);

            data = new BlockData(itemMaterial.toString(),dropRate,overrideDropBool);
            PrintWithClassName(this, "Loaded mob: " + key +
                    "materialDrop: " + itemMaterial + " droprate:" + dropRate);

            blockData.put(key, data);
        }
        blockBreakEvent.SetBlockDataMap(blockData);
        saveConfig();
        PrintWithClassName(this, "Loaded config");
    }

    public static void PrintWithClassName(Object obj, String str)
    {
        System.out.println(obj.getClass().getName() + "::" + str);
    }
}

