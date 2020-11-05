/*
 *    MCreator note:
 *
 *    If you lock base mod element files, you can edit this file and the proxy files
 *    and they won't get overwritten. If you change your mod package or modid, you
 *    need to apply these changes to this file MANUALLY.
 *
 *
 *    If you do not lock base mod element files in Workspace settings, this file
 *    will be REGENERATED on each build.
 *
 */
package net.mcreator.utilitymod;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.Identifier;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Item;
import net.minecraft.item.BlockItem;
import net.minecraft.block.Block;

import net.mcreator.utilitymod.block.TestPortalBlockBlock;

import net.fabricmc.fabric.api.command.v1.CommandRegistrationCallback;
import net.fabricmc.api.ModInitializer;

public class UtilitymodMod implements ModInitializer {
	public static final Logger LOGGER = LogManager.getLogger();
	public static final Block TestPortalBlock_BLOCK = Registry.register(Registry.BLOCK, id("test_portal_block"), new TestPortalBlockBlock());
	public static final BlockItem TestPortalBlock_ITEM = Registry.register(Registry.ITEM, id("test_portal_block"),
			new BlockItem(TestPortalBlock_BLOCK, new Item.Settings().group(ItemGroup.BUILDING_BLOCKS)));
	public void onInitialize() {
		LOGGER.info("Initializing UtilitymodMod");
		CommandRegistrationCallback.EVENT.register((dispatcher, dedicated) -> {
		});
	}

	public static final Identifier id(String s) {
		return new Identifier("utilitymod", s);
	}
}
