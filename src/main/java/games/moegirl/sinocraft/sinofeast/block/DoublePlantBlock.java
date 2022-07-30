package games.moegirl.sinocraft.sinofeast.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class DoublePlantBlock extends PlantBlock {
    public static final BooleanProperty TOP = BooleanProperty.create("top");
    protected static final VoxelShape[] NOT_FULL_SHAPE = new VoxelShape[] {
            Block.box(1.0D,0.0D,1.0D,15.0D,2.0D,15.0D),
            Block.box(1.0D,0.0D,1.0D,15.0D,3.0D,15.0D),
            Block.box(1.0D,0.0D,1.0D,15.0D,5.0D,15.0D),
            Block.box(1.0D,0.0D,1.0D,15.0D,7.0D,15.0D),
            Block.box(1.0D,0.0D,1.0D,15.0D,8.0D,15.0D),
            Block.box(1.0D,0.0D,1.0D,15.0D,10.0D,15.0D),
            Block.box(1.0D,0.0D,1.0D,15.0D,13.0D,15.0D),
            Block.box(1.0D,0.0D,1.0D,15.0D,16.0D,15.0D)
    };
    protected static final VoxelShape FULL_SHAPE = Block.box(1.0D, 0.0D, 1.0D, 15.0D, 16.0D, 15.0D);

    protected DoublePlantBlock() {
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        if (isTop(state)) {
            return NOT_FULL_SHAPE[getGrowingShape(state)];
        } else {
            // Todo: qyl27.
        }

        return isTop(state) ? NOT_FULL_SHAPE[getGrowingShape(state)] : FULL_SHAPE;
    }

    @Override
    protected int getGrowingShape(BlockState state) {
        int age = state.getValue(getAgeProperty());
        return age / ((getAgeProperty().getMaxStage() + 1) / 8);
    }

    protected boolean isTop(BlockState state) {
        return state.getValue(TOP);
    }
}
