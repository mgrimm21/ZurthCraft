package com.mgrimm21.zurthcraft.block;

import java.util.List;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Reference;

public class BlockShardOre extends BlockZurthCraft{
	
	private final int maxMeta = 7;
	
	private IIcon[] icons;
	
	public BlockShardOre() {
		super();
		this.setBlockName("shardore");
		icons = new IIcon[maxMeta];
		this.setCreativeTab(ZCTabs.ZURTHCRAFT_MAGIC);
	}

	@Override
	public void registerBlockIcons(IIconRegister iconRegister) {
		for (int i = 0; i < icons.length; i++) {
			iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName() + i);
		}
		
		
	}

	@Override
	public IIcon getIcon(int side, int meta) {
		switch (meta) {
		
		case 0: return icons[0];
		case 1: switch(side) {
		case 0: return icons[1];
		case 1: return icons[2];
		default: return icons[0];
		}
		default: return icons[1];
		
		}
	}

	@Override
	public int damageDropped(int meta) {
		return meta;
	}

	@Override
	public void getSubBlocks(Item item, CreativeTabs ct, List list) {
		for (int i = 0; i < maxMeta; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	

	
}
