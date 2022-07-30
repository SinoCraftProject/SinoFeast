package games.moegirl.sinocraft.sinofeast.utility;

import games.moegirl.sinocraft.sinofeast.block.PlantBlock;
import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import games.moegirl.sinocraft.sinofeast.item.SFItems;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.CropBlock;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

import static games.moegirl.sinocraft.sinofeast.utility.StageProperty.STAGE_0_3;
import static games.moegirl.sinocraft.sinofeast.utility.StageProperty.STAGE_0_7;

public enum PlantType {
//    WHITE_RADISH("white_radish", 1, STAGE_0_3, 0, 2, SFItems.WHITE_RADISH, SFBlocks.WHITE_RADISH_PLANT),
//    SUMMER_RADISH("summer_radish", 1, STAGE_0_3, 0, 2, SFItems.SUMMER_RADISH, SFBlocks.SUMMER_RADISH_PLANT),
//    GREEN_RADISH("green_radish", 1, STAGE_0_3, 0, 2, SFItems.GREEN_RADISH, SFBlocks.GREEN_RADISH_PLANT),
//    CHILI_PEPPER("chili_pepper", 1, STAGE_0_7, 2, 5, SFItems.CHILI_PEPPER_SEED, SFBlocks.CHILI_PEPPER_PLANT),
//    GREEN_PEPPER("green_pepper", 1, STAGE_0_7, 2, 5, SFItems.GREEN_PEPPER_SEED, SFBlocks.GREEN_PEPPER_PLANT),
//    EGGPLANT("eggplant", 1, STAGE_0_7, 2, 5, SFItems.EGGPLANT_SEED, SFBlocks.EGGPLANT_PLANT),
//    CABBAGE("cabbage", 1, STAGE_0_3, 0, 2, SFItems.CABBAGE_SEED, SFBlocks.CABBAGE_PLANT),
//    RICE("rice", 2, STAGE_0_7, 2, 5, SFItems.RICE_SEED, SFBlocks.RICE_PLANT),
//    MILLET("millet", 1, STAGE_0_7, 2, 5, SFItems.MILLET_SEED, SFBlocks.MILLET_PLANT),
//    SOYBEAN("soybean", 1, STAGE_0_3, 0, 2, SFItems.SOYBEAN, SFBlocks.SOYBEAN_PLANT),
//    SORGHUM("sorghum", 2, STAGE_0_3, 0, 2, SFItems.SORGHUM_SEED, SFBlocks.SORGHUM_PLANT);
    ;

    private final String plantName;
    private final int maxHeight;
    private final StageProperty stageProperty;
    private final int minBonemeal;
    private final int maxBonemeal;
    private final RegistryObject<? extends Item> seedItem;
    private final RegistryObject<? extends CropBlock> cropBlock;

    PlantType(String name, int height, StageProperty stages, int minBonemealChance, int maxBonemealChance,
              RegistryObject<? extends Item> seed, RegistryObject<? extends CropBlock> crop) {
        plantName = name;
        maxHeight = height;
        stageProperty = stages;
        minBonemeal = minBonemealChance;
        maxBonemeal = maxBonemealChance;
        seedItem = seed;
        cropBlock = crop;
    }

    public String getName() {
        return plantName;
    }

    public StageProperty getStageProperty() {
        return stageProperty;
    }

    public int getMinBonemealChance() {
        return minBonemeal;
    }

    public int getMaxBonemealChance() {
        return maxBonemeal;
    }

    public RegistryObject<? extends Item> getSeed() {
        return seedItem;
    }

    public RegistryObject<? extends CropBlock> getCrop() {
        return cropBlock;
    }

    public int getHeight() {
        return maxHeight;
    }


}
