package com.mgrimm21.zurthcraft.world.biome;

import net.minecraft.world.biome.BiomeGenBase;

public class biomeZurthForest extends BiomeGenBase{

	private static final Height biomeHeight = new Height(0.1F, 0.2F);
	
	public biomeZurthForest(int id) {
		super(id);
		this.setHeight(biomeHeight);
		this.setColor(0x13F0F0);
		this.setTemperatureRainfall(0.9F, 1.0F);
		this.waterColorMultiplier = 1306864;
		this.addDefaultFlowers();
		this.enableRain = true;
		this.enableSnow = false;
	}

	@Override
	public int getBiomeGrassColor(int x, int y, int z) {
		return 0x13F0F0;
	}
	
	@Override
	public int getBiomeFoliageColor(int x, int y, int z) {
		return 0x13F0F0;
	}
	
	
	@Override
	public int getSkyColorByTemp(float par1) {
		return 0x13F0F0;
	}
	
}
