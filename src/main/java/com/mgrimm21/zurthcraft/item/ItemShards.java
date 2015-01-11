package com.mgrimm21.zurthcraft.item;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Reference;

import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;

public class ItemShards extends ItemZurthCraft {

	private final int maxMeta =7;
	
	private IIcon[] icons;
	
	public ItemShards() {
		super();
		this.setUnlocalizedName("shards");
		icons = new IIcon[maxMeta];
		this.setCreativeTab(ZCTabs.ZURTHCRAFT_MAGIC);
	}

	@Override
	public void registerIcons(IIconRegister iconRegister) {
		
		for (int i = 0; i < icons.length; i++) {
			iconRegister.registerIcon(Reference.MOD_ID + ":" + this.getUnlocalizedName() + i);
		}
		
	}

	@Override
	public IIcon getIcon(ItemStack stack, int pass) {
		return null;
	}
	
}
