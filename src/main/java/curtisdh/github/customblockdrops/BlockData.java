package curtisdh.github.customblockdrops;

public class BlockData
{
    String ItemToDrop;
    Integer DropRate;
    Boolean OverrideDrop;

    public BlockData(String itemToDrop, Integer dropRate, Boolean overrideDrop)
    {
        ItemToDrop = itemToDrop;
        DropRate = dropRate;
        OverrideDrop = overrideDrop;
    }
}
