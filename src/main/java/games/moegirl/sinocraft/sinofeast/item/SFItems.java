package games.moegirl.sinocraft.sinofeast.item;

import games.moegirl.sinocraft.sinofeast.SinoFeast;
import games.moegirl.sinocraft.sinofeast.utility.PlantType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class SFItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SinoFeast.MODID);

    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }

//    public static final RegistryObject<Item> WHITE_RADISH = ITEMS.register("white_radish", () -> new BlockItem(PlantType.WHITE_RADISH.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> GREEN_RADISH = ITEMS.register("green_radish", () -> new BlockItem(PlantType.GREEN_RADISH.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> SUMMER_RADISH = ITEMS.register("summer_radish", () -> new BlockItem(PlantType.SUMMER_RADISH.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> CHILI_PEPPER_SEED = ITEMS.register("chili_pepper_seed", () -> new BlockItem(PlantType.CHILI_PEPPER.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> GREEN_PEPPER_SEED = ITEMS.register("green_pepper_seed", () -> new BlockItem(PlantType.GREEN_PEPPER.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> EGGPLANT_SEED = ITEMS.register("eggplant_seed", () -> new BlockItem(PlantType.EGGPLANT.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> CABBAGE_SEED = ITEMS.register("cabbage_seed", () -> new BlockItem(PlantType.CABBAGE.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> RICE_SEED = ITEMS.register("rice_seed", () -> new BlockItem(PlantType.RICE.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> SOYBEAN = ITEMS.register("soybean", () -> new BlockItem(PlantType.SOYBEAN.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> SORGHUM_SEED = ITEMS.register("sorghum_seed", () -> new BlockItem(PlantType.SORGHUM.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));
//    public static final RegistryObject<Item> MILLET_SEED = ITEMS.register("millet_seed", () -> new BlockItem(PlantType.MILLET.getCrop().get(), new Item.Properties().tab(SFTabs.SINOFEAST)));

}
