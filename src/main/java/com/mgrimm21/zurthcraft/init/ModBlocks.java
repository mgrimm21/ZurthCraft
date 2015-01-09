package com.mgrimm21.zurthcraft.init;



import net.minecraft.block.Block;
import net.minecraft.block.BlockSapling;
import net.minecraftforge.oredict.OreDictionary;

import com.mgrimm21.zurthcraft.block.BlockActivatedStone;
import com.mgrimm21.zurthcraft.block.BlockAlabasterPlank;
import com.mgrimm21.zurthcraft.block.BlockAlabasterSapling;
import com.mgrimm21.zurthcraft.block.BlockAlabasterWood;
import com.mgrimm21.zurthcraft.block.BlockAlloySmelter;
import com.mgrimm21.zurthcraft.block.BlockBauxiteOre;
import com.mgrimm21.zurthcraft.block.BlockBlockOfBrass;
import com.mgrimm21.zurthcraft.block.BlockBlockOfCopper;
import com.mgrimm21.zurthcraft.block.BlockBlockOfSteel;
import com.mgrimm21.zurthcraft.block.BlockBlockOfZinc;
import com.mgrimm21.zurthcraft.block.BlockBlockOfZurdite;
import com.mgrimm21.zurthcraft.block.BlockCableCopper;
import com.mgrimm21.zurthcraft.block.BlockCopperOre;
import com.mgrimm21.zurthcraft.block.BlockElectricFurnace;
import com.mgrimm21.zurthcraft.block.BlockElectrostaticGenerator;
import com.mgrimm21.zurthcraft.block.BlockInertStone;
import com.mgrimm21.zurthcraft.block.BlockQuenchTank;
import com.mgrimm21.zurthcraft.block.BlockQuenchTankBlock;
import com.mgrimm21.zurthcraft.block.BlockRichZincOre;
import com.mgrimm21.zurthcraft.block.BlockStone;
import com.mgrimm21.zurthcraft.block.BlockZincOre;
import com.mgrimm21.zurthcraft.block.BlockZippStone;
import com.mgrimm21.zurthcraft.block.BlockZurditeLamp;
import com.mgrimm21.zurthcraft.block.BlockZurditeOre;
import com.mgrimm21.zurthcraft.block.BlockZurditeOreEnd;
import com.mgrimm21.zurthcraft.block.BlockZurditeOreNether;
import com.mgrimm21.zurthcraft.block.BlockZurthCraft;
import com.mgrimm21.zurthcraft.block.ItemSpecialBlock;
import com.mgrimm21.zurthcraft.tileentity.TileEntityAlloySmelter;
import com.mgrimm21.zurthcraft.tileentity.TileHollowMultiBlock;
import com.mgrimm21.zurthcraft.tileentity.TileStoneMultiblock;

import cpw.mods.fml.common.registry.GameRegistry;

public class ModBlocks {

	//ORES
	public static final BlockZurthCraft zurditeore = new BlockZurditeOre();
	public static final BlockZurthCraft zurditeoreend = new BlockZurditeOreEnd();
	public static final BlockZurthCraft zurditeorenether = new BlockZurditeOreNether();
	public static final BlockZurthCraft zincore = new BlockZincOre();
	public static final BlockZurthCraft richzinceore = new BlockRichZincOre();
	public static final BlockZurthCraft bauxiteore = new BlockBauxiteOre();
	public static final BlockZurthCraft copperore = new BlockCopperOre();
	//METAL BLOCKS
	public static final BlockZurthCraft blockofzurdite = new BlockBlockOfZurdite();
	public static final BlockZurthCraft blockofzinc = new BlockBlockOfZinc();
	public static final BlockZurthCraft blockofcopper = new BlockBlockOfCopper();
	public static final BlockZurthCraft blockofsteel = new BlockBlockOfSteel();
	public static final BlockZurthCraft blockofbrass = new BlockBlockOfBrass();
	//MACHINES
	public static final BlockZurthCraft electricfurnace = new BlockElectricFurnace();
	public static final BlockZurthCraft electrostaticgenerator = new BlockElectrostaticGenerator();
	public static final Block alloysmelteridle = new BlockAlloySmelter(false).setBlockName("alloysmelteridle");
	public static final Block alloysmelteractive = new BlockAlloySmelter(true).setBlockName("alloysmelteractive");
	//CABLES
	public static final BlockZurthCraft coppercable = new BlockCableCopper();
	//OTHER
	public static final BlockZurthCraft zurditelamp = new BlockZurditeLamp();
	public static final BlockZurthCraft quenchtankblock = new BlockQuenchTankBlock();
	public static final BlockZurthCraft zippstone = new BlockZippStone();
	//WOOD
	public static final BlockZurthCraft alabasterwood = new BlockAlabasterWood();
	public static final BlockZurthCraft alabasterplank = new BlockAlabasterPlank();
	public static final BlockSapling alabastersapling = new BlockAlabasterSapling();
	//MAGIC BASED
	public static final BlockZurthCraft inertstone = new BlockInertStone();
	public static final BlockZurthCraft activatedstone = new BlockActivatedStone();
	
	//TEST
	 
	public static Block quench, stoneMulti;

	public static void init() {
		quench = new BlockQuenchTank().setBlockName("quenchMultiBlock");
	 stoneMulti = new BlockStone().setBlockName("stoneMultiBlock");
	 GameRegistry.registerBlock(quench, ItemSpecialBlock.class, "quenchMultiBlock");
	 GameRegistry.registerBlock(stoneMulti, ItemSpecialBlock.class, "StoneMultiBlock");
		
	 GameRegistry.registerTileEntity(TileHollowMultiBlock.class, "multiblock.quench");
	 GameRegistry.registerTileEntity(TileStoneMultiblock.class, "multiblock.stone");
	 GameRegistry.registerTileEntity(TileEntityAlloySmelter.class, "alloysmelter");
	 
		//ORES
		GameRegistry.registerBlock(zurditeore, "zurditeore");
		GameRegistry.registerBlock(zurditeoreend, "zurditeoreend");
		GameRegistry.registerBlock(zurditeorenether, "zurditeorenether");
		GameRegistry.registerBlock(zincore, "zincore");
		GameRegistry.registerBlock(richzinceore, "richzincore");
		GameRegistry.registerBlock(bauxiteore, "bauxiteore");
		GameRegistry.registerBlock(copperore, "copperore");
		//METAL BLOCKS
		GameRegistry.registerBlock(blockofzurdite, "blockofzurdite");
		GameRegistry.registerBlock(blockofzinc, "blockofzinc");
		GameRegistry.registerBlock(blockofcopper, "blockofcopper");
		GameRegistry.registerBlock(blockofsteel, "blockofsteel");
		GameRegistry.registerBlock(blockofbrass, "blockofbrass");
		//MACHINES
		GameRegistry.registerBlock(electricfurnace, "electricefurnace");
		GameRegistry.registerBlock(electrostaticgenerator, "electrostaticgenerator");
		GameRegistry.registerBlock(alloysmelteridle, "alloysmelteridle");
		GameRegistry.registerBlock(alloysmelteractive, "alloysmelteractive");
		//CABLES
		GameRegistry.registerBlock(coppercable, "coppercable");
		//OTHER
		GameRegistry.registerBlock(zurditelamp, "zurditelamp");
		GameRegistry.registerBlock(quenchtankblock, "quenchtankblock");
		GameRegistry.registerBlock(zippstone, "zippstone");
		
		//WOOD
		GameRegistry.registerBlock(alabasterwood, "alabasterwood");
		GameRegistry.registerBlock(alabasterplank, "alabasterplank");
		GameRegistry.registerBlock(alabastersapling, "alabastersapling");
		//MAGIC BASED
		GameRegistry.registerBlock(inertstone, "inertstone");
		GameRegistry.registerBlock(activatedstone, "activatedstone");
		registerOreDictionary();
	}
	
	public static void registerOreDictionary() {
		OreDictionary.registerOre("cobblestone", zippstone);
		OreDictionary.registerOre("logWood", alabasterwood);
		OreDictionary.registerOre("plankWood", alabasterplank);
		OreDictionary.registerOre("stone", inertstone);
	}
	
	
	
}
