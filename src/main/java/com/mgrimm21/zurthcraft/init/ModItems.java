package com.mgrimm21.zurthcraft.init;

import net.minecraft.entity.item.EntityItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import com.mgrimm21.zurthcraft.item.ItemAlumina;
import com.mgrimm21.zurthcraft.item.ItemCookedZippMeat;
import com.mgrimm21.zurthcraft.item.ItemRawZippMeat;
import com.mgrimm21.zurthcraft.item.ItemSulfur;
import com.mgrimm21.zurthcraft.item.ItemZincAmmoniumChloride;
import com.mgrimm21.zurthcraft.item.ItemZurditeCircuit;
import com.mgrimm21.zurthcraft.item.ItemZurthCraft;
import com.mgrimm21.zurthcraft.item.metal.ItemBrassIngot;
import com.mgrimm21.zurthcraft.item.metal.ItemBrassNugget;
import com.mgrimm21.zurthcraft.item.metal.ItemCopperIngot;
import com.mgrimm21.zurthcraft.item.metal.ItemCopperNugget;
import com.mgrimm21.zurthcraft.item.metal.ItemZincChunk;
import com.mgrimm21.zurthcraft.item.metal.ItemZincIngotHG;
import com.mgrimm21.zurthcraft.item.metal.ItemZincIngotSHG;
import com.mgrimm21.zurthcraft.item.metal.ItemZincNugget;
import com.mgrimm21.zurthcraft.item.metal.ItemZurditeDust;
import com.mgrimm21.zurthcraft.item.metal.ItemZurditeIngot;
import com.mgrimm21.zurthcraft.item.metal.ItemZurditeNugget;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelIngot;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelIngotAcidic;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelIngotClean;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelIngotFluxed;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelIngotGalvanized;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelIngotPickled;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelIngotScaled;
import com.mgrimm21.zurthcraft.item.metal.steel.ItemSteelNugget;
import com.mgrimm21.zurthcraft.item.tool.ItemZurditeAxe;
import com.mgrimm21.zurthcraft.item.tool.ItemZurditeHoe;
import com.mgrimm21.zurthcraft.item.tool.ItemZurditePickaxe;
import com.mgrimm21.zurthcraft.item.tool.ItemZurditeShovel;
import com.mgrimm21.zurthcraft.item.tool.ItemZurditeSword;

import cpw.mods.fml.common.registry.GameRegistry;


public class ModItems {

	public static final Item.ToolMaterial zurdite = EnumHelper.addToolMaterial("zurdite", 4, 256, 8.0F, 2.0F, 6);
	
	public static final ItemZurthCraft zurditeDust = new ItemZurditeDust();
	public static final ItemZurthCraft zurditeIngot = new ItemZurditeIngot();
	public static final ItemZurthCraft zurditeNugget = new ItemZurditeNugget();
	public static final Item rawZippMeat = new ItemRawZippMeat(4, 0.1F, false);
	public static final Item cookedZippMeat = new ItemCookedZippMeat(8, 0.3F, true);
	public static final Item zurditePickaxe = new ItemZurditePickaxe(zurdite);
	public static final Item zurditeAxe = new ItemZurditeAxe(zurdite);
	public static final Item zurditeShovel = new ItemZurditeShovel(zurdite);
	public static final Item zurditeHoe = new ItemZurditeHoe(zurdite);
	public static final Item zurditeSword = new ItemZurditeSword(zurdite);
	public static final ItemZurthCraft zurditecircuit = new ItemZurditeCircuit();
	public static final ItemZurthCraft sulfur = new ItemSulfur();
	public static final ItemZurthCraft zincchunk = new ItemZincChunk();
	public static final ItemZurthCraft zincingothg = new ItemZincIngotHG();
	public static final ItemZurthCraft zincingotshg = new ItemZincIngotSHG();
	public static final ItemZurthCraft zincnugget = new ItemZincNugget();
	public static final ItemZurthCraft alumina = new ItemAlumina();
	public static final ItemZurthCraft copperingot = new ItemCopperIngot();
	public static final ItemZurthCraft coppernugget = new ItemCopperNugget();
	public static final ItemZurthCraft brassingot = new ItemBrassIngot();
	public static final ItemZurthCraft brassnugget = new ItemBrassNugget();
	public static final ItemZurthCraft steelingot = new ItemSteelIngot();
	public static final ItemZurthCraft steelnugget = new ItemSteelNugget();
	public static final ItemZurthCraft steelingotacidic = new ItemSteelIngotAcidic();
	public static final ItemZurthCraft steelingotclean = new ItemSteelIngotClean();
	public static final ItemZurthCraft steelingotfluxed = new ItemSteelIngotFluxed();
	public static final ItemZurthCraft steelingotgalvanized = new ItemSteelIngotGalvanized();
	public static final ItemZurthCraft steelingotpickled = new ItemSteelIngotPickled();
	public static final ItemZurthCraft steelingotscaled = new ItemSteelIngotScaled();
	public static final ItemZurthCraft zincammoniumchloride = new ItemZincAmmoniumChloride();
	
	
	public static void init() {
		GameRegistry.registerItem(zurditeDust, "zurditedust");
		GameRegistry.registerItem(zurditeIngot, "zurditeingot");
		GameRegistry.registerItem(zurditeNugget, "zurditenugget");
		GameRegistry.registerItem(rawZippMeat, "rawzippmeat");
		GameRegistry.registerItem(cookedZippMeat, "cookedzippmeat");
		GameRegistry.registerItem(zurditePickaxe, "zurditepickaxe");
		GameRegistry.registerItem(zurditeAxe, "zurditeaxe");
		GameRegistry.registerItem(zurditeShovel, "zurditeshovel");
		GameRegistry.registerItem(zurditeHoe, "zurditehoe");
		GameRegistry.registerItem(zurditeSword, "zurditesword");
		GameRegistry.registerItem(zurditecircuit, "zurditecircuit");
		GameRegistry.registerItem(sulfur, "sulfur");
		GameRegistry.registerItem(zincchunk, "zincchunk");
		GameRegistry.registerItem(zincingothg, "zincingothg");
		GameRegistry.registerItem(zincingotshg, "zincingotshg");
		GameRegistry.registerItem(zincnugget, "zincnugget");
		GameRegistry.registerItem(alumina, "alumina");
		GameRegistry.registerItem(copperingot, "copperingot");
		GameRegistry.registerItem(coppernugget, "coppernugget");
		GameRegistry.registerItem(brassingot, "brassingot");
		GameRegistry.registerItem(brassnugget, "brassnugget");
		GameRegistry.registerItem(steelingot, "steelingot");
		GameRegistry.registerItem(steelnugget, "steelnugget");
		GameRegistry.registerItem(steelingotacidic, "steelingotacidic");
		GameRegistry.registerItem(steelingotclean, "steelingotclean");
		GameRegistry.registerItem(steelingotfluxed, "steelingotfluxed");
		GameRegistry.registerItem(steelingotgalvanized, "steelingotgalvanized");
		GameRegistry.registerItem(steelingotpickled, "steelingotpickled");
		GameRegistry.registerItem(steelingotscaled, "steelingotscaled");
		GameRegistry.registerItem(zincammoniumchloride, "zincammoniumchloride");
	}
	
}
