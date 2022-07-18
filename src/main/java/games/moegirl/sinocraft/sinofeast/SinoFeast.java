package games.moegirl.sinocraft.sinofeast;

import games.moegirl.sinocraft.sinofeast.block.SFBlockItems;
import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import games.moegirl.sinocraft.sinofeast.block.entity.SFBlockEntities;
import games.moegirl.sinocraft.sinofeast.item.SFItems;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(SinoFeast.MODID)
public class SinoFeast {
    public static final String MODID = "sinofeast";
    public static final String NAME = "SinoFeast";

    private static SinoFeast INSTANCE = null;
    private final Logger LOGGER = LogManager.getLogger(NAME);

    public SinoFeast() {
        INSTANCE = this;

        LOGGER.info("Come here! A banquet for you.");

        final var bus = FMLJavaModLoadingContext.get().getModEventBus();
        SFBlocks.register(bus);
        SFItems.register(bus);
        SFBlockItems.register(bus);
        SFBlockEntities.register(bus);
    }

    public static SinoFeast getInstance() {
        return INSTANCE;
    }

    public Logger getLogger() {
        return LOGGER;
    }
}
