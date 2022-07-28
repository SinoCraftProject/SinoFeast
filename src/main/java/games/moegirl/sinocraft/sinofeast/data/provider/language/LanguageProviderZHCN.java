package games.moegirl.sinocraft.sinofeast.data.provider.language;

import games.moegirl.sinocraft.sinocore.api.data.I18nProviderBase;
import games.moegirl.sinocraft.sinofeast.block.SFBlocks;
import net.minecraft.data.DataGenerator;

public class LanguageProviderZHCN extends I18nProviderBase {
    public LanguageProviderZHCN(DataGenerator genIn, String modIdIn, String localeIn) {
        super(genIn, modIdIn, modIdIn, localeIn);
    }

    @Override
    protected void addTranslations() {
        add(SFBlocks.POT.get(), "铁锅");
        add(SFBlocks.STOVE.get(), "灶台");
    }
}
