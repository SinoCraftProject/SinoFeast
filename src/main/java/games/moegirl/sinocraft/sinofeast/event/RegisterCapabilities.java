package games.moegirl.sinocraft.sinofeast.event;

import games.moegirl.sinocraft.sinofeast.SinoFeast;
import games.moegirl.sinocraft.sinofeast.block.entity.StoveBlockEntity;
import games.moegirl.sinocraft.sinofeast.capability.block.IHeatSource;
import games.moegirl.sinocraft.sinofeast.capability.provider.HeatSourceProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SinoFeast.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterCapabilities {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(IHeatSource.class);
    }

    @SubscribeEvent
    public static void onAttachCapabilities(AttachCapabilitiesEvent<BlockEntity> event) {
        if (event.getObject() instanceof StoveBlockEntity) {
            var provider = new HeatSourceProvider();
            event.addCapability(new ResourceLocation(SinoFeast.MODID, "heat_source"), provider);
            event.addListener(provider::invalidate);
        }
    }
}
