package curtisdh.github.customblockdrops;

import org.bukkit.plugin.java.JavaPlugin;

public final class CustomBlockDrops extends JavaPlugin
{

    @Override
    public void onEnable()
    {
        PrintWithClassName(this, "Starting...");

        PrintWithClassName(this, "Initialised");
    }

    @Override
    public void onDisable()
    {
        // Plugin shutdown logic
    }


    public static void PrintWithClassName(Object obj, String str)
    {
        System.out.println(obj.getClass().getName() + "::" + str);
    }
}
