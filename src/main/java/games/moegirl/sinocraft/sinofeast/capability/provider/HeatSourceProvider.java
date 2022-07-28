package games.moegirl.sinocraft.sinofeast.capability.provider;

import games.moegirl.sinocraft.sinofeast.capability.SFCapabilities;
import games.moegirl.sinocraft.sinofeast.capability.block.HeatSource;
import games.moegirl.sinocraft.sinofeast.capability.block.IHeatSource;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HeatSourceProvider implements ICapabilitySerializable<CompoundTag> {
    private final IHeatSource heatSource = new HeatSource();

    private final LazyOptional<IHeatSource> heatSourceOptional = LazyOptional.of(() -> heatSource);

    public void invalidate() {
        heatSourceOptional.invalidate();
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> capability, @Nullable Direction arg) {
        if (capability == SFCapabilities.HEAT_SOURCE) {
            return heatSourceOptional.cast();
        }

        return LazyOptional.empty();
    }

    @Override
    public CompoundTag serializeNBT() {
        var heat = heatSourceOptional.orElse(new HeatSource());

        var tag = new CompoundTag();
        tag.putInt(HeatSource.HEAT_TAG_NAME, heat.getHeat());
        tag.putInt(HeatSource.BURN_TIME_TAG_NAME, heat.getBurnTime());
        tag.put(HeatSource.FUEL_TAG_NAME, heat.getFuel().serializeNBT());

        var ashes = heat.getAllAshes();
        var list = new ListTag();
        for (var ash : ashes) {
            list.add(ash.serializeNBT());
        }
        tag.put(HeatSource.ASHES_TAG_NAME, list);

        return tag;
    }

    @Override
    public void deserializeNBT(CompoundTag tag) {
        var heat = heatSourceOptional.orElse(new HeatSource());

        if (tag.contains(HeatSource.HEAT_TAG_NAME)) {
            heat.setHeat(tag.getInt(HeatSource.HEAT_TAG_NAME));
        }

        if (tag.contains(HeatSource.BURN_TIME_TAG_NAME)) {
            heat.setBurnTime(tag.getInt(HeatSource.BURN_TIME_TAG_NAME));
        }

        if (tag.contains(HeatSource.FUEL_TAG_NAME)) {
            var stack = ItemStack.EMPTY;
            stack.deserializeNBT(tag.getCompound(HeatSource.FUEL_TAG_NAME));
            heat.setFuel(stack);
        }

        if (tag.contains(HeatSource.ASHES_TAG_NAME)) {
            var list = tag.getList(HeatSource.ASHES_TAG_NAME, ListTag.TAG_COMPOUND);
            heat.clearAshes();

            for (var ash : list) {
                var stack = ItemStack.EMPTY;
                stack.deserializeNBT((CompoundTag) ash);
                heat.addAshes(stack);
            }
        }
    }
}
