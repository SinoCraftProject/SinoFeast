package games.moegirl.sinocraft.sinofeast.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class StoveBlockEntity extends BlockEntity {
    public StoveBlockEntity(BlockPos pos, BlockState state) {
        super(SFBlockEntities.STOVE.get(), pos, state);
    }
}
