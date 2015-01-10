package com.mgrimm21.zurthcraft.block;

import java.util.Random;

import net.minecraft.item.Item;

import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.ConfigValues;
import com.mgrimm21.zurthcraft.reference.Names;

public class BlockRichZincOre extends BlockZurthCraft{
	
	private Item drop;
	private int meta;
	private int least_quantity = 2;
	private int most_quantity = 6;
	
	public BlockRichZincOre() {
		super();
		this.setBlockName(Names.RICHZINCORE);
		this.setHardness(3.0F);
		this.setLightLevel(0.3F);
		this.setResistance(15.0F);
		this.setHarvestLevel("pickaxe", 2);
	}

	public int itemdroppednum;
	public int amtdropped;
	public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
		itemdroppednum = rnd.nextInt(10) + 1;
		if (itemdroppednum < 3) {
			return ModItems.sulfur;
		} else {
			return ModItems.zincchunk;
		}
    }
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random) {
		amtdropped = random.nextInt(6) + 1;
		return amtdropped;
	}
	
	public boolean isOpaqueCube() {
		return false;
	}
	
	
}
