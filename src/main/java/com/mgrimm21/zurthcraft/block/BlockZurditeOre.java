package com.mgrimm21.zurthcraft.block;

import java.util.Random;

import scala.tools.nsc.doc.model.Public;

import com.mgrimm21.zurthcraft.creativetab.CreativeTabZurthCraftMain;
import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.ConfigValues;

import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BlockZurditeOre extends BlockZurthCraft{
	
	private Item drop;
	private int meta;
	private int least_quantity = ConfigValues.minzurditedustonorebreak;
	private int most_quantity = ConfigValues.maxzurditedustonorebreak;
	
	public BlockZurditeOre() {
		this.setBlockName("zurditeore");
		this.setHardness(3.0F);
		this.setLightLevel(0.3F);
		this.setResistance(15.0F);
		this.setHarvestLevel("pickaxe", 2);
	}
	public int itemdroppednum;
	public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
		int itemdroppednum = rnd.nextInt(2);
		if (itemdroppednum == 0) {
			return ModItems.zurditeDust;
		} else {
			return ModItems.zurditeNugget;
		}
        
    }

	@Override
	public int damageDropped(int metadata) {
	    return this.meta;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		if (itemdroppednum == 0) {
			if (this.least_quantity >= this.most_quantity)
	        return this.least_quantity;
	    int finalnum = this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1);
	    if (finalnum > 4) {
	    	if (fortune != 0) {
	    		if (finalnum < 10) {
	    			return finalnum;
	    		} else {
	    			return random.nextInt(8) + 1;
	    		}
	    	}
	    	return 4;
	    }else {
	    		return finalnum;
	    	}
		} else {
			int lq = 5, mq = 15;
			if (lq >= mq)
		        return lq;
		    int finalnum = mq + random.nextInt(mq - lq + fortune + 1);
		    return finalnum;
		}
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	
}
