package net.bloxboss6.pjomod.mixin;

import net.bloxboss6.pjomod.util.IEntityDataSaver;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NbtCompound;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Entity.class)
public class ModEntityDataSaver implements IEntityDataSaver {
    private NbtCompound persistantData;

    @Override
    public NbtCompound getPersistantData() {
        if (this.persistantData == null) {
            this.persistantData = new NbtCompound();
        }
        return persistantData;
    }

    @Inject(method = "writeNbt", at = @At("Head"))
    protected void injectWriteMethod(NbtCompound nbt, CallbackInfoReturnable info) {
        if (persistantData != null) {
            nbt.put("PJOMod", persistantData);
        }
    }

    @Inject(method = "readNbt", at = @At("Head"))
    protected void injectReadMethod(NbtCompound nbt, CallbackInfo info) {
        if (nbt.contains("PJOMod", 10)) {
            persistantData = nbt.getCompound("PJOMod");
        }
    }
}
