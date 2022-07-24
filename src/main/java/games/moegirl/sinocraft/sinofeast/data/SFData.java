package games.moegirl.sinocraft.sinofeast.data;

import games.moegirl.sinocraft.sinofeast.SinoFeast;
import games.moegirl.sinocraft.sinofeast.block.SFBlockItems;
import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import games.moegirl.sinocraft.sinofeast.data.provider.BlockStateProvider;
import games.moegirl.sinocraft.sinofeast.data.provider.ItemModelProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SinoFeast.MODID)
public class SFData {
    @SubscribeEvent
    public static void onGatherData(GatherDataEvent event) {
        var generator = event.getGenerator();
        var exHelper = event.getExistingFileHelper();

        if (event.includeClient()) {
            generator.addProvider(new BlockStateProvider(generator, SinoFeast.MODID,
                    exHelper, SFBlocks.BLOCKS));

            generator.addProvider(new ItemModelProvider(generator, SinoFeast.MODID,
                    exHelper, SFBlockItems.BLOCK_ITEMS));
        }

        if (event.includeServer()) {

        }
    }
}
