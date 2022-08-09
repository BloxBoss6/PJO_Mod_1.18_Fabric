package net.bloxboss6.pjomod.item.custom;

import net.bloxboss6.pjomod.util.ModTags;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.tag.BlockTags;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.ActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

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
                player.sendMessage(new TranslatableText("info.pjomod.riptide_pen.edit_sign"), false);
            }

        }

        return super.useOnBlock(context);
    }

    private boolean isSign(Block block) {
        return Registry.BLOCK.getOrCreateEntry(Registry.BLOCK.getKey(block).get()).isIn(BlockTags.SIGNS);
    }

    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if(Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("tooltip.pjomod.riptide_pen.shift"));
        } else {
            tooltip.add(new TranslatableText("tooltip.pjomod.riptide_pen"));
        }
    }
}

/*

  if(EditSign.getMod().canPlayerEdit(wrappedPlayer, wrappedHand)){
			isEditable = true;
			SignBlockEntity sign = (SignBlockEntity) (Object) this;
			serverPlayer.openTextEdit(sign);
		}
*/