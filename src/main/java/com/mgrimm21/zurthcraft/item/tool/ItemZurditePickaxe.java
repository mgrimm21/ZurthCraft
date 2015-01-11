package com.mgrimm21.zurthcraft.item.tool;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;

public class ItemZurditePickaxe extends ItemPickaxe{

	public ItemZurditePickaxe(ToolMaterial material) {
		super(material);
		this.setUnlocalizedName("zurditepickaxe");
		this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
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
