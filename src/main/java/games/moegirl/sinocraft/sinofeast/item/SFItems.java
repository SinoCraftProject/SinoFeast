package games.moegirl.sinocraft.sinofeast.item;

import games.moegirl.sinocraft.sinofeast.SinoFeast;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class SFItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SinoFeast.MODID);

    public static void register(IEventBus bus) {
        SinoFeast.getInstance().getLogger().info("Register items.");
        ITEMS.register(bus);
    }

}
