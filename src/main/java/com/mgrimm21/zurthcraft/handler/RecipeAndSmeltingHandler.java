package com.mgrimm21.zurthcraft.handler;

import java.util.Random;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.item.ItemZurthCraft;

import cpw.mods.fml.common.registry.GameRegistry;
public class RecipeAndSmeltingHandler {
	
	private static void registerToolAndArmorRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zurditePickaxe), 
				"iii", " s ", " s ", 'i', new ItemStack(ModItems.zurditeIngot), 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zurditeAxe), 
				" ii", " si", " s ", 'i', new ItemStack(ModItems.zurditeIngot), 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zurditeShovel), 
				"i", "s", "s", 'i', new ItemStack(ModItems.zurditeIngot), 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zurditeHoe), 
				" ii", " s ", " s ", 'i', new ItemStack(ModItems.zurditeIngot), 's', new ItemStack(Items.stick));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zurditeSword), 
				"i", "i", "s", 'i', new ItemStack(ModItems.zurditeIngot), 's', new ItemStack(Items.stick));
	}

	private static void registerBlockRecipes() {
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.zurditelamp), 
				"ddd", "drd", "ddd", 'd', new ItemStack(ModItems.zurditeDust), 'r', new ItemStack(Items.redstone));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.zurditeore), 
				"ddd", "ddd", "ddd", 'd', new ItemStack(ModItems.zurditeDust));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockofzurdite), 
				"iii", "iii", "iii", 'i', new ItemStack(ModItems.zurditeIngot));
		GameRegistry.addShapedRecipe(new ItemStack(Blocks.end_portal_frame, 2), 
				"bbb", "bdb", "bbb", 'b', new ItemStack(ModBlocks.blockofzurdite), 'd', new ItemStack(Items.diamond));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockofzinc), 
				"iii", "iii", "iii", 'i', new ItemStack(ModItems.zincingothg));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.blockofzinc, 2), 
				"iii", "iii", "iii", 'i', new ItemStack(ModItems.zincingotshg));
		//GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.richzinceore), "xx", "xx ", 'x', new ItemStack(ModBlocks.zincore));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.electricfurnace),
				"xxx", "xcx", "xxx", 'x', new ItemStack(ModItems.zurditeIngot), 'c', new ItemStack(ModItems.zurditecircuit));
		GameRegistry.addShapedRecipe(new ItemStack(ModBlocks.skillaltar), "aaa", "isi", "sss", 'a', 
				new ItemStack(ModBlocks.alabasterwood), 'i', new ItemStack(ModItems.zurditeIngot), 's', new ItemStack(ModBlocks.activatedstone));
	}
	
	private static void registerItemRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.zurditeNugget, 9), new ItemStack(ModItems.zurditeIngot));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.zincnugget, 9), new ItemStack(ModItems.zincingothg));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.zincnugget, 9), new ItemStack(ModItems.zincingotshg));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zurditeIngot), 
				"nnn", "nnn", "nnn", 'n', new ItemStack(ModItems.zurditeNugget));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zincingothg), 
				"nnn", "nnn", "nnn", 'n', new ItemStack(ModItems.zincnugget));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.zurditeIngot, 9), new ItemStack(ModBlocks.blockofzurdite));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.zincingothg, 9), new ItemStack(ModBlocks.blockofzinc));
		GameRegistry.addShapedRecipe(new ItemStack(ModItems.zurditecircuit, 32), 
				"xrq", "rpr", "qrx", 'r', new ItemStack(Blocks.redstone_block), 'p', new ItemStack(ModItems.zurditePickaxe),
				'q', new ItemStack(Blocks.quartz_block), 'x', new ItemStack(ModBlocks.blockofzurdite));
		
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.zurditeNugget, 1), new ItemStack(ModItems.zurditeDust),
				new ItemStack(ModItems.zurditeDust));
		
		GameRegistry.addShapedRecipe(new ItemStack(Items.apple, 64), "xx", "xx", 'x', new ItemStack(ModItems.sulfur));
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.alumina, 2), new ItemStack(ModBlocks.bauxiteore));
		GameRegistry.addShapelessRecipe(new ItemStack(ModBlocks.alabasterplank, 4), new ItemStack(ModBlocks.alabasterwood));
	}
	
	private static void registerSmeltingRecipes() {
		GameRegistry.addSmelting(ModBlocks.zurditeore, new ItemStack(ModItems.zurditeIngot, 4), 10.0F);
		//GameRegistry.addSmelting(ModItems.zurditeDust, new ItemStack(ModItems.zurditeIngot, 1), 2.0F);
		GameRegistry.addSmelting(ModItems.rawZippMeat, new ItemStack(ModItems.cookedZippMeat, 1), 5.0F);
		GameRegistry.addSmelting(ModItems.zincchunk, new ItemStack(getTypeofZincIngot(), 1), 5.0F);
	}
	
	public static void init() {
		registerToolAndArmorRecipes();
		registerSmeltingRecipes();
		registerBlockRecipes();
		registerItemRecipes();
	}
	
	public static ItemZurthCraft getTypeofZincIngot() {
		Random rnd = new Random();
		int i = rnd.nextInt(2);
		if (i != 1) {
			return ModItems.zincingothg;
		} else {
			return ModItems.zincingotshg;
		}
	}
	
}
