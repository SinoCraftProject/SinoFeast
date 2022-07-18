package games.moegirl.sinocraft.sinofeast.item;

import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class SFTabs extends CreativeModeTab {
    public static final CreativeModeTab SINOFEAST = new SFTabs();

    public SFTabs() {
        super("sinofeast");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(SFBlocks.POT.get());
    }
}
