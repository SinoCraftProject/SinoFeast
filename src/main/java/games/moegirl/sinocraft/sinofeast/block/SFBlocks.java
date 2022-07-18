package games.moegirl.sinocraft.sinofeast.block;

import ca.weblite.objc.Proxy;
import games.moegirl.sinocraft.sinofeast.SinoFeast;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, SinoFeast.MODID);

    public static void register(IEventBus bus) {
        SinoFeast.getInstance().getLogger().info("Register blocks.");
        BLOCKS.register(bus);
    }

    public static final RegistryObject<Block> STOVE = BLOCKS.register("stove", StoveBlock::new);
    public static final RegistryObject<Block> POT = BLOCKS.register("pot", PotBlock::new);
}
