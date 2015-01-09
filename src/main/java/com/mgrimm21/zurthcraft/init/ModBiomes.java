package com.mgrimm21.zurthcraft.init;

import net.minecraft.world.biome.BiomeGenBase;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.common.BiomeDictionary.Type;
import net.minecraftforge.common.BiomeManager;
import net.minecraftforge.common.BiomeManager.BiomeEntry;

import com.mgrimm21.zurthcraft.world.biome.biomeZurthForest;

public class ModBiomes {

	public static BiomeGenBase biomeZurthForest;
	
	public static void init() {
		registerBiomes();
	}
	
	public static void registerBiomes() {
		
		biomeZurthForest = new biomeZurthForest(70).setBiomeName("Zurth Forest");
		BiomeDictionary.registerBiomeType(biomeZurthForest, Type.FOREST);
		BiomeManager.warmBiomes.add(new BiomeEntry(biomeZurthForest, 10));
		
		BiomeManager.removeSpawnBiome(BiomeGenBase.beach);
		BiomeManager.addSpawnBiome(biomeZurthForest);
	}
	
}
