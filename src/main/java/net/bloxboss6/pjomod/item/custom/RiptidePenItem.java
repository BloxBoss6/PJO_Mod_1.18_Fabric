package net.bloxboss6.pjomod.item.custom;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;

import java.util.Arrays;
import java.util.List;

public class RiptidePenItem extends Item {

    public RiptidePenItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        if(context.getWorld().isClient()) {
            BlockPos positionClicked = context.getBlockPos();
            PlayerEntity player = context.getPlayer();
            boolean foundBlock = false;

            Block blockClicked = context.getWorld().getBlockState(positionClicked).getBlock();

            if(isSign(blockClicked)) {
                player.sendMessage(new TranslatableText("item.pjomod.riptide_pen.edit_sign"), false);
            }

        }

        return super.useOnBlock(context);
    }

    private boolean isSign(Block block) {
        Block[] listSigns = {
                Blocks.ACACIA_SIGN,
                Blocks.ACACIA_WALL_SIGN,
                Blocks.BIRCH_SIGN,
                Blocks.BIRCH_WALL_SIGN,
                Blocks.CRIMSON_SIGN,
                Blocks.CRIMSON_WALL_SIGN,
                Blocks.DARK_OAK_SIGN,
                Blocks.DARK_OAK_WALL_SIGN,
                Blocks.JUNGLE_SIGN,
                Blocks.JUNGLE_WALL_SIGN,
                Blocks.OAK_SIGN,
                Blocks.OAK_WALL_SIGN,
                Blocks.SPRUCE_SIGN,
                Blocks.SPRUCE_WALL_SIGN,
                Blocks.WARPED_SIGN,
                Blocks.WARPED_WALL_SIGN
        };
        List<Block> signs = Arrays.asList(listSigns);

        return signs.contains(block);
    }
}

/*

  if(EditSign.getMod().canPlayerEdit(wrappedPlayer, wrappedHand)){
			isEditable = true;
			SignBlockEntity sign = (SignBlockEntity) (Object) this;
			serverPlayer.openTextEdit(sign);
		}
*/