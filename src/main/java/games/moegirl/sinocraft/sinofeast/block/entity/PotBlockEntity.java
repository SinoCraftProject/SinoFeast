package games.moegirl.sinocraft.sinofeast.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class PotBlockEntity extends BlockEntity {
    public PotBlockEntity(BlockPos pos, BlockState state) {
        super(SFBlockEntities.POT.get(), pos, state);
    }
}
