package com.mgrimm21.zurthcraft.block;

import java.util.Random;

import com.mgrimm21.zurthcraft.init.ModItems;
import com.mgrimm21.zurthcraft.reference.ConfigValues;

import net.minecraft.block.material.Material;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class BlockZurditeLamp extends BlockZurthCraft{
	
	public BlockZurditeLamp() {
		super(Material.rock);
		this.setBlockName("zurditelamp");
		this.setLightLevel(16.0F);
	}
	
	public Item getItemDropped(int p_149650_1_, Random rnd, int p_149650_3_)
    {
        return ModItems.zurditeDust;
    }
	
	public int quantityDropped(int meta, int fortune, Random random) {
	    return ConfigValues.zurditelampdustdropped;
	}
	
	public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_)
    {
		
		
        int i1 = p_149727_1_.getBlockMetadata(p_149727_2_, p_149727_3_, p_149727_4_);
        int j1 = i1 & 7;
        int k1 = 8 - (i1 & 8);

        if (k1 == 0)
        {
            return true;
        }
        else
        {
            p_149727_1_.setBlockMetadataWithNotify(p_149727_2_, p_149727_3_, p_149727_4_, j1 + k1, 3);
            p_149727_1_.markBlockRangeForRenderUpdate(p_149727_2_, p_149727_3_, p_149727_4_, p_149727_2_, p_149727_3_, p_149727_4_);
            p_149727_1_.playSoundEffect((double)p_149727_2_ + 0.5D, (double)p_149727_3_ + 0.5D, (double)p_149727_4_ + 0.5D, "random.click", 0.3F, 0.6F);
            this.func_150042_a(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, j1);
            p_149727_1_.scheduleBlockUpdate(p_149727_2_, p_149727_3_, p_149727_4_, this, this.tickRate(p_149727_1_));
            return true;
        }
    }
	
	private void func_150042_a(World p_150042_1_, int p_150042_2_, int p_150042_3_, int p_150042_4_, int p_150042_5_)
    {
        p_150042_1_.notifyBlocksOfNeighborChange(p_150042_2_, p_150042_3_, p_150042_4_, this);

        if (p_150042_5_ == 1)
        {
            p_150042_1_.notifyBlocksOfNeighborChange(p_150042_2_ - 1, p_150042_3_, p_150042_4_, this);
        }
        else if (p_150042_5_ == 2)
        {
            p_150042_1_.notifyBlocksOfNeighborChange(p_150042_2_ + 1, p_150042_3_, p_150042_4_, this);
        }
        else if (p_150042_5_ == 3)
        {
            p_150042_1_.notifyBlocksOfNeighborChange(p_150042_2_, p_150042_3_, p_150042_4_ - 1, this);
        }
        else if (p_150042_5_ == 4)
        {
            p_150042_1_.notifyBlocksOfNeighborChange(p_150042_2_, p_150042_3_, p_150042_4_ + 1, this);
        }
        else
        {
            p_150042_1_.notifyBlocksOfNeighborChange(p_150042_2_, p_150042_3_ - 1, p_150042_4_, this);
        }
    }
	
}
