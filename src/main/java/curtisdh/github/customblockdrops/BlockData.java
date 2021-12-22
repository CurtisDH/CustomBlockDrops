package curtisdh.github.customblockdrops;

public class BlockData
{
    String ItemToDrop;
    Integer DropRate;
    Boolean OverrideDrop;
    Boolean SilkTouchDrop;
    public BlockData(String itemToDrop, Integer dropRate, Boolean overrideDrop, Boolean silkTouchDrop)
    {
        ItemToDrop = itemToDrop;
        DropRate = dropRate;
        OverrideDrop = overrideDrop;
        SilkTouchDrop = silkTouchDrop;
    }
}
