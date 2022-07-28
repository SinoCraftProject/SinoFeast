package games.moegirl.sinocraft.sinofeast.block.entity;

import ca.weblite.objc.Proxy;
import games.moegirl.sinocraft.sinofeast.SinoFeast;
import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITIES, SinoFeast.MODID);


    public static void register(IEventBus bus) {
        BLOCK_ENTITIES.register(bus);
    }

    // Todo: qyl27: DataUpperFixer here.
    public static final RegistryObject<BlockEntityType<PotBlockEntity>> POT = BLOCK_ENTITIES.register("pot",
            () -> BlockEntityType.Builder.of(PotBlockEntity::new,
                    SFBlocks.POT.get()).build(null));
    public static final RegistryObject<BlockEntityType<?>> STOVE = BLOCK_ENTITIES.register("stove",
            () -> BlockEntityType.Builder.of(StoveBlockEntity::new,
                    SFBlocks.STOVE.get()).build(null));
}
