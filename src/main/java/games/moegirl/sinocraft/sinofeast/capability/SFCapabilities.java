package games.moegirl.sinocraft.sinofeast.capability;

import games.moegirl.sinocraft.sinofeast.capability.block.IHeatSource;
import games.moegirl.sinocraft.sinofeast.capability.player.ITastePreference;
import games.moegirl.sinocraft.sinofeast.capability.stack.IFoodTaste;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class SFCapabilities {
    public static final Capability<IHeatSource> HEAT_SOURCE = CapabilityManager.get(new CapabilityToken<>() { });

    public static final Capability<ITastePreference> TASTE_PREFERENCE = CapabilityManager.get(new CapabilityToken<>() { });

    public static final Capability<IFoodTaste> FOOD_TASTE = CapabilityManager.get(new CapabilityToken<>() { });
}
