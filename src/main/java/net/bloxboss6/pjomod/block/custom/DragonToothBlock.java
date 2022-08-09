package net.bloxboss6.pjomod.block.custom;

import net.bloxboss6.pjomod.item.ModItems;
import net.minecraft.block.CropBlock;
import net.minecraft.item.ItemConvertible;

public class DragonToothBlock extends CropBlock {

    public DragonToothBlock(Settings settings) {
        super(settings);
    }

    @Override
    public ItemConvertible getSeedsItem() {
        return ModItems.DRAGON_TOOTH_SEEDS;
    }
}
