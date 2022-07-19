package games.moegirl.sinocraft.sinofeast.data.provider;

import games.moegirl.sinocraft.sinocore.api.data.BlockStateProviderBase;
import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import games.moegirl.sinocraft.sinofeast.block.StoveBlock;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.VariantBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.DeferredRegister;

public class BlockStateProvider extends net.minecraftforge.client.model.generators.BlockStateProvider {
    public BlockStateProvider(DataGenerator generator, String modId, ExistingFileHelper existingFileHelper,
                              DeferredRegister<? extends Block> deferredRegister) {
        super(generator, modId, existingFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        addStove();
        addPot();
    }

    private void addStove() {
        VariantBlockStateBuilder stoveBuilder = getVariantBuilder(SFBlocks.STOVE.get());
        Direction stoveDirection = Direction.NORTH;
        for (int i = 0; i < 4; i++) {
            stoveBuilder.partialState()
                    .with(StoveBlock.FACING, stoveDirection)
                    .with(StoveBlock.BURNING, false)
                    .modelForState()
                    .modelFile(models().getExistingFile(modLoc("block/stove_off")))
                    .rotationY(90 * i)
                    .addModel();
            stoveBuilder.partialState()
                    .with(StoveBlock.FACING, stoveDirection)
                    .with(StoveBlock.BURNING, true)
                    .modelForState()
                    .modelFile(models().getExistingFile(modLoc("block/stove_on")))
                    .rotationY(90 * i)
                    .addModel();
            stoveDirection = stoveDirection.getClockWise();
        }
    }

    private void addPot() {
        getVariantBuilder(SFBlocks.POT.get())
                .partialState()
                .modelForState()
                .modelFile(models().getExistingFile(modLoc("block/pot")))
                .addModel();
    }
}
