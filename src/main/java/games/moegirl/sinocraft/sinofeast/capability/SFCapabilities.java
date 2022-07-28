package games.moegirl.sinocraft.sinofeast.capability;

import games.moegirl.sinocraft.sinofeast.capability.block.IHeatSource;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;

public class SFCapabilities {
    public static final Capability<IHeatSource> HEAT_SOURCE = CapabilityManager.get(new CapabilityToken<>() { });


}
