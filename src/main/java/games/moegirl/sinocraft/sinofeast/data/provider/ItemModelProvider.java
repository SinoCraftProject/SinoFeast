package games.moegirl.sinocraft.sinofeast.data.provider;

import games.moegirl.sinocraft.sinocore.api.data.ItemModelProviderBase;
import games.moegirl.sinocraft.sinofeast.block.SFBlockItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;

public class ItemModelProvider extends ItemModelProviderBase {
    public ItemModelProvider(DataGenerator generator, String modId, ExistingFileHelper exHelper, DeferredRegister<? extends Item> deferredRegister) {
        super(generator, modId, exHelper, deferredRegister);
    }

    @Override
    protected void registerItemModels() {
        skipItems.add(SFBlockItems.STOVE.get());

        getBuilder(SFBlockItems.STOVE.get().getRegistryName().getPath()).parent(getModel(modLoc("block/stove_off")));
    }

    protected ModelFile getModel(ResourceLocation loc) {
        return new ModelFile.UncheckedModelFile(loc);
    }
}
