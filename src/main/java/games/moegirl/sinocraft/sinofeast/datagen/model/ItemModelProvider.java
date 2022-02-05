package games.moegirl.sinocraft.sinofeast.datagen.model;

import games.moegirl.sinocraft.sinofeast.SinoFeast;
import net.minecraft.core.Registry;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.TieredItem;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;

import java.util.Set;
import java.util.stream.Collectors;

public class ItemModelProvider extends net.minecraftforge.client.model.generators.ItemModelProvider {
    private static final ResourceLocation GENERATED = new ResourceLocation("item/generated");
    private static final ResourceLocation HANDHELD = new ResourceLocation("item/handheld");

    public ItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, SinoFeast.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        Set<Item> items = Registry.ITEM.stream()
                .filter(i -> SinoFeast.MODID.equals(Registry.ITEM.getKey(i).getNamespace()))//筛选出我们mod的物品注册
                .collect(Collectors.toSet());
        registerItemBlock(items.stream().filter(i -> i instanceof BlockItem).map(i -> (BlockItem) i).collect(Collectors.toSet()));
        registerItem(items);
    }

    private void registerItemBlock(Set<BlockItem> itemBlocks) {
//        //remove model for block item
//        itemBlocks.removeAll(itemBlocks.stream()
//                .filter(i -> i.getBlock() instanceof )
//                .collect(Collectors.toSet()));

        itemBlocks.forEach(i -> withExistingParent(name(i), prefix("block/" + name(i))));
    }

    private ItemModelBuilder handheldItem(String name) {
        return withExistingParent(name, HANDHELD)
                .texture("layer0", prefix("items/" + name));
    }

    private ItemModelBuilder handheldItem(Item i) {
        return handheldItem(name(i));
    }

    private ItemModelBuilder generatedItem(String name) {
        return withExistingParent(name, GENERATED)
                .texture("layer0", prefix("items/" + name));
    }

    private ItemModelBuilder generatedItem(Item i) {
        return generatedItem(name(i));
    }

    private static String name(Item i) {
        return Registry.ITEM.getKey(i).getPath();
    }

    private void registerItem(Set<Item> items) {
        items.removeAll(items.stream().filter(i -> i instanceof BlockItem || i instanceof CrossbowItem).collect(Collectors.toSet()));
        items.forEach(this::generatedItem);
        items.stream().filter(i -> i instanceof TieredItem).forEach(this::handheldItem);
    }

    /**
     * additional method
     *
     * @param path model path
     * @return model path with prefix
     */
    public static ResourceLocation prefix(String path) {
        return new ResourceLocation(SinoFeast.MODID, path);
    }
}
