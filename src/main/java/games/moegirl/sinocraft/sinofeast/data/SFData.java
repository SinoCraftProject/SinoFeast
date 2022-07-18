package games.moegirl.sinocraft.sinofeast.data;

import games.moegirl.sinocraft.sinocore.api.datagen.DefaultItemModelProvider;
import games.moegirl.sinocraft.sinofeast.SinoFeast;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = SinoFeast.MODID)
public class SFData {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        event.getGenerator().addProvider(new DefaultItemModelProvider(event.getGenerator(),
                SinoFeast.MODID, event.getExistingFileHelper()));
    }
}
