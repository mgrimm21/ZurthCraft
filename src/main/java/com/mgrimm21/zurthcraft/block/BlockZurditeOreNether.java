package com.mgrimm21.zurthcraft.block;

import java.util.Random;

import net.minecraft.item.Item;

import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.ConfigValues;

public class BlockZurditeOreNether extends BlockZurthCraft{
	private Item drop;
	private int meta;
	private int least_quantity = ConfigValues.minzurditedustonorebreak;
	private int most_quantity = ConfigValues.maxzurditedustonorebreak;
	
	public BlockZurditeOreNether() {
		this.setBlockName("zurditeorenether");
		this.setHardness(3.0F);
		this.setLightLevel(0.3F);
		this.setResistance(15.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	
	public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return ModItems.zurditeDust;
    }

	@Override
	public int damageDropped(int metadata) {
	    return this.meta;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
	    if (this.least_quantity >= this.most_quantity)
	        return this.least_quantity;
	    int finalnum = this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	    if (finalnum > 4) {
	    	return 4;
	    }else {
	    		return finalnum;
	    	}
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	
}
