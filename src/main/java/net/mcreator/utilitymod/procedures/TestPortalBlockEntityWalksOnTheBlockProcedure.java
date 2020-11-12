package net.mcreator.utilitymod.procedures;

import net.minecraft.entity.Entity;
import net.minecraft.world.World;

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
