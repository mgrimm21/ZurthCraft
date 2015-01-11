package com.mgrimm21.zurthcraft.item;

import java.util.List;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;

public class ItemCookedZippMeat extends ItemFood{

	public ItemCookedZippMeat(int Hunger, float Saturation, boolean canwolfeat) {
		super(Hunger, Saturation, canwolfeat);
		this.setUnlocalizedName("cookedzippmeat");
		this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
		this.maxStackSize = 16;
		}
	
	@Override
	public void addInformation(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, List par3List, boolean par4) {
		par3List.add("I hope you feel good about killing it when you eat.");
	
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
