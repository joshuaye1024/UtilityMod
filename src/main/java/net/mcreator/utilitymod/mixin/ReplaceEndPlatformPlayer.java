package net.mcreator.utilitymod.mixin;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;


@Mixin(ServerPlayerEntity.class)
public class ReplaceEndPlatformPlayer {

    @ModifyArg(
            method = "createEndSpawnPlatform",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/Dummy;dummy(IIII)V"),
            index = 1
    )
    private static void oncreateEndSpawnPlatform(ServerWorld world, CallbackInfo ci) {
        System.out.println("End Platform creation initiated!");
    }
    /*
    @Overwrite
    private void createEndSpawnPlatform(ServerWorld world, BlockPos centerPos) {
        BlockPos.Mutable mutable = centerPos.mutableCopy();

        for(int i = -2; i <= 2; ++i) {
            for(int j = -2; j <= 2; ++j) {
                for(int k = -1; k < 3; ++k) {
                    BlockState blockState = k == -1 ? Blocks.ACACIA_WOOD.getDefaultState() : Blocks.AIR.getDefaultState();
                    world.setBlockState(mutable.set(centerPos).move(j, k, i), blockState);
                }
            }
        }
    }
     */
}
