package games.moegirl.sinocraft.sinofeast.utility;

import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class StageProperty extends IntegerProperty {
    public static final StageProperty STAGE_0_3 = StageProperty.create("stage", 0, 3);
    public static final StageProperty STAGE_0_7 = StageProperty.create("stage", 0, 7);
    public static final StageProperty STAGE_0_16 = StageProperty.create("stage", 0, 16);

    private final int maxStage;

    protected StageProperty(String name, int min, int max) {
        super(name, min, max);

        maxStage = max;
    }

    public static StageProperty create(String name, int min, int max) {
        return new StageProperty(name, min, max);
    }

    public int getMaxStage() {
        return maxStage;
    }
}
