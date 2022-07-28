package games.moegirl.sinocraft.sinofeast.event;

import games.moegirl.sinocraft.sinocore.api.capability.IPlayerCapability;
import games.moegirl.sinocraft.sinocore.api.capability.SCCapabilities;
import games.moegirl.sinocraft.sinocore.api.utility.capability.CapabilityHelper;
import games.moegirl.sinocraft.sinocore.capability.QuizzingPlayer;
import games.moegirl.sinocraft.sinofeast.SinoFeast;
import games.moegirl.sinocraft.sinofeast.block.entity.StoveBlockEntity;
import games.moegirl.sinocraft.sinofeast.capability.block.IHeatSource;
import games.moegirl.sinocraft.sinofeast.capability.provider.HeatSourceProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = SinoFeast.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class RegisterCapabilities {
    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(IHeatSource.class);
        event.register(IHeatSource.class);
        event.register(IHeatSource.class);
    }

    @SubscribeEvent
    public static void onAttachBlockEntity(AttachCapabilitiesEvent<BlockEntity> event) {
        if (event.getObject() instanceof StoveBlockEntity) {
            var provider = new HeatSourceProvider();
            event.addCapability(new ResourceLocation(SinoFeast.MODID, "heat_source"), provider);
            event.addListener(provider::invalidate);
        }
    }

    // Todo: qyl27.

    @SubscribeEvent
    public static void onAttachPlayer(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
//            var provider = new HeatSourceProvider();
//            event.addCapability(new ResourceLocation(SinoFeast.MODID, "heat_source"), provider);
//            event.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public static void onAttachItemStack(AttachCapabilitiesEvent<ItemStack> event) {
        var item = event.getObject().getItem();

        if (item.isEdible()) {
//            var provider = new HeatSourceProvider();
//            event.addCapability(new ResourceLocation(SinoFeast.MODID, "heat_source"), provider);
//            event.addListener(provider::invalidate);
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        if (!event.isWasDeath()) {
            return;
        }

//        CapabilityHelper.clone(event.getPlayer(), event.getOriginal(), LazyOptional.empty(), );
    }
}
