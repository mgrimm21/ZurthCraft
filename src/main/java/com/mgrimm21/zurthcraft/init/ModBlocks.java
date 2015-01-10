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
import com.mgrimm21.zurthcraft.block.BlockSkillAltar;
import com.mgrimm21.zurthcraft.block.BlockStone;
import com.mgrimm21.zurthcraft.block.BlockZincOre;
import com.mgrimm21.zurthcraft.block.BlockZippStone;
import com.mgrimm21.zurthcraft.block.BlockZurditeLamp;
import com.mgrimm21.zurthcraft.block.BlockZurditeOre;
import com.mgrimm21.zurthcraft.block.BlockZurditeOreEnd;
import com.mgrimm21.zurthcraft.block.BlockZurditeOreNether;
import com.mgrimm21.zurthcraft.block.BlockZurditeTank;
import com.mgrimm21.zurthcraft.block.BlockZurthCraft;
import com.mgrimm21.zurthcraft.block.ItemSpecialBlock;
import com.mgrimm21.zurthcraft.reference.Names;
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
	public static final Block alloysmelteridle = new BlockAlloySmelter(false).setBlockName(Names.ALLOYSMELTERIDLE);
	public static final Block alloysmelteractive = new BlockAlloySmelter(true).setBlockName(Names.ALLOYSMELTERACTIVE);
	//TANKS
	public static final Block zurditetank = new BlockZurditeTank();
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
	public static final BlockZurthCraft skillaltar = new BlockSkillAltar();
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
		GameRegistry.registerBlock(zurditeore, Names.ZURDITEORE);
		GameRegistry.registerBlock(zurditeoreend, Names.ZURDITEOREEND);
		GameRegistry.registerBlock(zurditeorenether, Names.ZURDITEORENETHER);
		GameRegistry.registerBlock(zincore, Names.ZINCORE);
		GameRegistry.registerBlock(richzinceore, Names.RICHZINCORE);
		GameRegistry.registerBlock(bauxiteore, Names.BAUXITEORE);
		GameRegistry.registerBlock(copperore, Names.COPPERORE);
		//METAL BLOCKS
		GameRegistry.registerBlock(blockofzurdite, Names.BLOCKOFZURDITE);
		GameRegistry.registerBlock(blockofzinc, Names.BLOCKOFZINC);
		GameRegistry.registerBlock(blockofcopper, Names.BLOCKOFCOPPER);
		GameRegistry.registerBlock(blockofsteel, Names.BLOCKOFSTEEL);
		GameRegistry.registerBlock(blockofbrass, Names.BLOCKOFBRASS);
		//MACHINES
		GameRegistry.registerBlock(electricfurnace, Names.ELECTRICFURNACE);
		GameRegistry.registerBlock(electrostaticgenerator, Names.ELECTROSTATICGENERATOR);
		GameRegistry.registerBlock(alloysmelteridle, Names.ALLOYSMELTERIDLE);
		GameRegistry.registerBlock(alloysmelteractive, Names.ALLOYSMELTERACTIVE);
		//TANKS
		GameRegistry.registerBlock(zurditetank, Names.ZURDITETANK);
		//CABLES
		GameRegistry.registerBlock(coppercable, Names.COPPERCABLE);
		//OTHER
		GameRegistry.registerBlock(zurditelamp, Names.ZURDITELAMP);
		GameRegistry.registerBlock(quenchtankblock, Names.QUENCHTANKBLOCK);
		GameRegistry.registerBlock(zippstone, Names.ZIPPSTONE);
		//WOOD
		GameRegistry.registerBlock(alabasterwood, Names.ALABASTERWOOD);
		GameRegistry.registerBlock(alabasterplank, Names.ALABASTERPLANK);
		GameRegistry.registerBlock(alabastersapling, Names.ALABASTERSAPLING);
		//MAGIC BASED
		GameRegistry.registerBlock(inertstone, Names.INERTSTONE);
		GameRegistry.registerBlock(activatedstone, Names.ACTIVATEDSTONE);
		GameRegistry.registerBlock(skillaltar, Names.SKILLALTAR);
		registerOreDictionary();
	}
	
	public static void registerOreDictionary() {
		OreDictionary.registerOre("cobblestone", zippstone);
		OreDictionary.registerOre("logWood", alabasterwood);
		OreDictionary.registerOre("plankWood", alabasterplank);
		OreDictionary.registerOre("stone", inertstone);
	}
	
	
	
}
