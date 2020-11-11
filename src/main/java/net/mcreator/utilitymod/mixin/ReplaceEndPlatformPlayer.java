package net.mcreator.utilitymod.mixin;

import net.minecraft.block.Blocks;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;


@Mixin(ServerPlayerEntity.class)
public class ReplaceEndPlatformPlayer {
    private static final BlockPos END_SPAWN_POS = new BlockPos(100, 50, 0);
    /*
    @Inject(at = @At("TAIL"), method = "createEndSpawnPlatform")
    private static void oncreateEndSpawnPlatform(ServerWorld world, CallbackInfo ci) {
        System.out.println("End Platform creation initiated!");
    }*/

    @Overwrite
    public static void createEndSpawnPlatform(ServerWorld world) {
        System.out.println("End Platform creation initiated!");
        BlockPos blockPos = END_SPAWN_POS;
        int i = blockPos.getX();
        int j = blockPos.getY() - 2;
        int k = blockPos.getZ();
        BlockPos.iterate(i - 2, j + 1, k - 2, i + 2, j + 3, k + 2).forEach((blockPosx) -> {
            world.setBlockState(blockPosx, Blocks.AIR.getDefaultState());
        });
        BlockPos.iterate(i - 2, j, k - 2, i + 2, j, k + 2).forEach((blockPosx) -> {
            world.setBlockState(blockPosx, Blocks.ACACIA_WOOD.getDefaultState());
        });
    }
}
