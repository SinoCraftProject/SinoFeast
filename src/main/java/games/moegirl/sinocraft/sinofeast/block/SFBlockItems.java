package games.moegirl.sinocraft.sinofeast.block;

import games.moegirl.sinocraft.sinofeast.SinoFeast;
import games.moegirl.sinocraft.sinofeast.item.SFTabs;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFBlockItems {
    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SinoFeast.MODID);

    public static void register(IEventBus bus) {
        SinoFeast.getInstance().getLogger().info("Register block items.");
        BLOCK_ITEMS.register(bus);
    }


    public static RegistryObject<BlockItem> STOVE = BLOCK_ITEMS.register("stove", () -> new BlockItem(SFBlocks.STOVE.get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
    public static RegistryObject<BlockItem> POT = BLOCK_ITEMS.register("pot", () -> new BlockItem(SFBlocks.POT.get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
}
