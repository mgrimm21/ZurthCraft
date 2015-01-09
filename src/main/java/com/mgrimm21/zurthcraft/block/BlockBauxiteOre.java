package com.mgrimm21.zurthcraft.block;

public class BlockBauxiteOre extends BlockZurthCraft{

	public BlockBauxiteOre() {
		super();
		this.setBlockName("bauxiteore");
		this.setHardness(3.0F);
		this.setLightLevel(0.3F);
		this.setResistance(15.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
}
