package games.moegirl.sinocraft.sinofeast.block;

import games.moegirl.sinocraft.sinofeast.block.entity.PotBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;

public class PotBlock extends Block implements EntityBlock {
    public static final double P1 = 1d / 16d;

    protected static final VoxelShape OUT_SHAPE = Shapes.create(new AABB(P1, 0, P1, P1 * 15, P1 * 6, P1 * 15));
    protected static final VoxelShape SHAPE = Shapes.join(
            OUT_SHAPE, Block.box(
                    2.0D, 2.0D, 2.0D,
                    14.0D, 6.0D, 14.0D),
            BooleanOp.ONLY_FIRST);

    public PotBlock() {
        super(BlockBehaviour.Properties.of(Material.HEAVY_METAL)
                .requiresCorrectToolForDrops()
                .strength(3.0f)
                .noOcclusion()
                .sound(SoundType.ANVIL));
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return new PotBlockEntity(pos, state);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPE;
    }
}
