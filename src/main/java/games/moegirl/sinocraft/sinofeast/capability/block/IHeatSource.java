package games.moegirl.sinocraft.sinofeast.capability.block;

import net.minecraft.core.NonNullList;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

/**
 * All machine Block Entity that can export heat must implement this interface
 *
 * @author Infinity_rain(qyl27)
 */
public interface IHeatSource {
    /**
     * Get heat
     *
     * @return heat
     * @author flysong
     */
    int getHeat();

    /**
     * Set heat
     *
     * @param heat heat
     * @author flysong
     */
    void setHeat(int heat);

    /**
     * Reset heat
     *
     * @author flysong
     */
    void resetHeat();

    boolean isBurning();
    int getBurnTime();
    void setBurnTime(int time);
    void clearBurnTime();
    void addBurnTime(int time);
    void subBurnTime(int time);

    void setFuel(ItemStack fuel);
    boolean hasFuel();
    ItemStack getFuel();
    int getFuelCount();

    void addAshes(ItemStack ash);
    void removeAshes(Item ash);
    void clearAshes();
    int getAshesTypeCount();
    ItemStack takeAshes(Item ashItem, int count);
    NonNullList<ItemStack> getAllAshes();
}
