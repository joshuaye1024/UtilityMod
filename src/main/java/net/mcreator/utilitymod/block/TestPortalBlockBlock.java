
package net.mcreator.utilitymod.block;

import net.minecraft.world.World;
import net.minecraft.util.math.BlockPos;
import net.minecraft.loot.context.LootContext;
import net.minecraft.item.ItemStack;
import net.minecraft.entity.Entity;
import net.minecraft.block.Material;
import net.minecraft.block.BlockState;
import net.minecraft.block.Block;

import net.mcreator.utilitymod.procedures.TestPortalBlockEntityWalksOnTheBlockProcedure;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

import java.util.List;
import java.util.Collections;

public class TestPortalBlockBlock extends Block {
	public TestPortalBlockBlock() {
		super(FabricBlockSettings.of(Material.STONE).strength(1F, 10F).lightLevel(0));
	}

	@Override
	public List<ItemStack> getDroppedStacks(BlockState state, LootContext.Builder builder) {
		List<ItemStack> dropsOriginal = super.getDroppedStacks(state, builder);
		if (!dropsOriginal.isEmpty())
			return dropsOriginal;
		return Collections.singletonList(new ItemStack(this, 1));
	}

	@Override
	public void onSteppedOn(World world, BlockPos pos, Entity entity) {
		super.onSteppedOn(world, pos, entity);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		{
			java.util.HashMap<String, Object> $_dependencies = new java.util.HashMap<>();
			$_dependencies.put("entity", entity);
			TestPortalBlockEntityWalksOnTheBlockProcedure.executeProcedure($_dependencies);
		}
	}
}
