package games.moegirl.sinocraft.sinofeast.capability.block;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * Heat output default implement
 *
 * @author qyl27
 */
public class HeatSource implements IHeatSource {
    public static final String HEAT_TAG_NAME = "heat";
    public static final String BURN_TIME_TAG_NAME = "burnTime";
    public static final String FUEL_TAG_NAME = "fuel";
    public static final String ASHES_TAG_NAME = "ashes";

    private int heatValue = 0;
    private int burnTime = 0;
    private ItemStack fuelStack = ItemStack.EMPTY;
    private NonNullList<ItemStack> ashes = NonNullList.create();

    @Override
    public int getHeat() {
        return heatValue;
    }

    @Override
    public void setHeat(int heat) {
        heatValue = heat;
    }

    @Override
    public void resetHeat() {
        heatValue = 0;
    }

    @Override
    public boolean isBurning() {
        return burnTime <= 0;
    }

    @Override
    public int getBurnTime() {
        return burnTime;
    }

    @Override
    public void setBurnTime(int time) {
        burnTime = time;
    }

    @Override
    public void clearBurnTime() {
        burnTime = 0;
    }

    @Override
    public void addBurnTime(int time) {
        burnTime += time;
    }

    @Override
    public void subBurnTime(int time) {
        burnTime -= time;
    }

    @Override
    public void setFuel(ItemStack fuel) {
        fuelStack = fuel;
    }

    @Override
    public boolean hasFuel() {
        return fuelStack.isEmpty();
    }

    @Override
    public ItemStack getFuel() {
        return fuelStack;
    }

    @Override
    public int getFuelCount() {
        return fuelStack.getCount();
    }

    @Override
    public void addAshes(ItemStack ash) {
        ashes.add(ash);
    }

    @Override
    public void removeAshes(Item ash) {
        var stackOptional = ashes.stream().filter(e -> e.is(ash)).findAny();

        if (stackOptional.isEmpty()) {
            return;
        }

        ashes.remove(stackOptional.get());
    }

    @Override
    public void clearAshes() {
        ashes.clear();
    }

    @Override
    public int getAshesTypeCount() {
        return ashes.size();
    }

    @Override
    public ItemStack takeAshes(Item ash, int count) {
        return ashes.stream()
                .filter(e -> e.is(ash))
                .peek(stack -> stack.shrink(count))
                .map(ItemStack::copy)
                .findFirst()
                .orElse(ItemStack.EMPTY);
    }

    @Override
    public NonNullList<ItemStack> getAllAshes() {
        return ashes;
    }
}
