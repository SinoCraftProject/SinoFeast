package games.moegirl.sinocraft.sinofeast.data;

import games.moegirl.sinocraft.sinofeast.SinoFeast;
import games.moegirl.sinocraft.sinofeast.block.SFBlockItems;
import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import games.moegirl.sinocraft.sinofeast.data.provider.BlockStateProvider;
import games.moegirl.sinocraft.sinofeast.data.provider.ItemModelProvider;
import games.moegirl.sinocraft.sinofeast.data.provider.language.LanguageProviderENUS;
import games.moegirl.sinocraft.sinofeast.data.provider.language.LanguageProviderZHCN;
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
            generator.addProvider(new LanguageProviderZHCN(generator, SinoFeast.MODID, "zh_cn"));
            generator.addProvider(new LanguageProviderENUS(generator, SinoFeast.MODID, "en_us"));
        }
    }
}
