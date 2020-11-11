package net.mcreator.utilitymod.procedures;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;

import java.util.Map;

public class TestPortalBlockEntityWalksOnTheBlockProcedure{
	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			System.err.println("Failed to load dependency entity for procedure TestPortalBlockEntityWalksOnTheBlock!");
			return;
		}
		Entity player = (Entity) dependencies.get("entity");

		if(!player.world.isClient){
			player.moveToWorld(player.world.getServer().getWorld(World.END));

		}
	}
}
