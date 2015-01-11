package com.mgrimm21.zurthcraft.item;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemRawZippMeat extends ItemFood{
	
	public ItemRawZippMeat(int hunger, float saturation, boolean wolffood) {
		super(hunger, saturation, wolffood);
		this.setUnlocalizedName("rawzippmeat");
		this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
		this.maxStackSize = 16;
	}

	@Override
	public String getUnlocalizedName()
	{
	return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	@Override
	public String getUnlocalizedName(ItemStack itemStack)
	{
	return String.format("item.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
	}
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister iconRegister)
	{
	itemIcon = iconRegister.registerIcon(this.getUnlocalizedName().substring(this.getUnlocalizedName().indexOf(".") + 1));
	}
	protected String getUnwrappedUnlocalizedName(String unlocalizedName)
	{
	return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
	}
	
	
	
}
