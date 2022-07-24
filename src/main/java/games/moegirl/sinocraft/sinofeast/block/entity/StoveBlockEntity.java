package games.moegirl.sinocraft.sinofeast.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;

public class StoveBlockEntity extends BlockEntity implements BlockEntityTicker<StoveBlockEntity> {
    public StoveBlockEntity(BlockPos pos, BlockState state) {
        super(SFBlockEntities.STOVE.get(), pos, state);
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap) {
        // Todo.
        return LazyOptional.empty();
    }

    @Override
    public void tick(Level level, BlockPos pos, BlockState state, StoveBlockEntity te) {

    }
}
