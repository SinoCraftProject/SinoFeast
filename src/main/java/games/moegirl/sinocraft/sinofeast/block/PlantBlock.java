package games.moegirl.sinocraft.sinofeast.block;

import games.moegirl.sinocraft.sinofeast.utility.PlantType;
import games.moegirl.sinocraft.sinofeast.utility.StageProperty;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.CropBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.Random;

public class PlantBlock extends CropBlock {
    protected static final VoxelShape[] SHAPES = new VoxelShape[]{
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 2.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 5.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 7.0D, 16.0D),
            Block.box(0.0D, 0.0D, 0.0D, 16.0D, 9.0D, 16.0D),
    };

    private static final ThreadLocal<PlantType> TYPE = new ThreadLocal<>();

    private final PlantType plantType;

    public static PlantBlock create(PlantType type) {
        TYPE.set(type);
        return type.getHeight() > 1 ? new DoublePlantBlock() : new PlantBlock();
    }

    protected PlantBlock() {
        super(Block.Properties
                .of(Material.PLANT)
                .randomTicks());

        plantType = TYPE.get();
        TYPE.remove();
    }

    public StageProperty getAgeProperty() {
        return getType().getStageProperty();
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return SHAPES[getGrowingShape(state)];
    }

    protected int getGrowingShape(BlockState state) {
        int age = state.getValue(getAgeProperty());
        return age / ((getAgeProperty().getMaxStage() + 1) / 4);
    }

    @Override
    protected ItemLike getBaseSeedId() {
        return getType().getSeed().get();
    }

    @Override
    public int getMaxAge() {
        return getAgeProperty().getMaxStage();
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(getAgeProperty());
    }

    @Override
    protected int getAge(BlockState state) {
        return state.getValue(getAgeProperty());
    }

    @Override
    public BlockState getStateForAge(int age) {
        return defaultBlockState().setValue(getAgeProperty(), age);
    }

    @Override
    public StateDefinition<Block, BlockState> getStateDefinition() {
        return stateDefinition;
    }

    @Override
    protected int getBonemealAgeIncrease(Level level) {
        return super.getBonemealAgeIncrease(level);
    }

    @Override
    public void growCrops(Level level, BlockPos pos, BlockState state) {
        grow(level, pos, state, getBonemealAgeIncrease(level));
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, Random random) {
        if (!level.isLoaded(pos)) {
            return;
        }

        if (level.getLightEmission(pos) >= 9) {
            if (canGrowTick(state, level, pos)) {
                float f = getGrowthSpeed(this, level, pos);
                if (net.minecraftforge.common.ForgeHooks.onCropsGrowPre(level, pos, state, random.nextInt((int)(25.0F / f) + 1) == 0)) {
                    grow(level, pos, state, 1);
                    net.minecraftforge.common.ForgeHooks.onCropsGrowPost(level, pos, state);
                }
            }
        }
    }

    protected boolean canGrowTick(BlockState state, ServerLevel worldIn, BlockPos pos) {
        return isValidBonemealTarget(worldIn, pos, state, false);
    }

    public void grow(Level level, BlockPos pos, BlockState state, int age) {
        int current = getAge(state);
        int maxAge = getMaxAge();

        if (current == maxAge) {
            return;
        }

        // Todo: qyl27.
//        BlockState newState = withAge(Math.min(maxAge, current + age));
//        level.setBlock(pos, newState, 2);
    }

    public PlantType getType() {
        if (plantType == null) {
            return TYPE.get();
        }
        return plantType;
    }
}