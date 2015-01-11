package com.mgrimm21.zurthcraft.block;

import com.mgrimm21.zurthcraft.creativetab.ZCTabs;
import com.mgrimm21.zurthcraft.reference.Reference;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IIconRegister;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import com.google.common.base.Optional;
import com.google.common.collect.Lists;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.resources.IResource;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.IIcon;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Vec3;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.common.util.ForgeDirection;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.ReflectionHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
public class BlockZurthCraft extends Block{

	public BlockZurthCraft(Material material) {
		super(material);
		this.setHardness(2.2F);
		this.setLightOpacity(255);
		this.setHarvestLevel("pickaxe", 0);
		this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
	}
	
	public BlockZurthCraft() {
		this(Material.rock);
		this.setHardness(2.2F);
		this.setLightOpacity(255);
		this.setHarvestLevel("pickaxe", 0);
		this.setCreativeTab(ZCTabs.ZURTHRAFT_MAIN);
	}
	

@Override
public String getUnlocalizedName()
{
return String.format("tile.%s%s", Reference.MOD_ID.toLowerCase() + ":", getUnwrappedUnlocalizedName(super.getUnlocalizedName()));
}
@Override
@SideOnly(Side.CLIENT)
public void registerBlockIcons(IIconRegister iconRegister)
{
blockIcon = iconRegister.registerIcon(String.format("%s", getUnwrappedUnlocalizedName(this.getUnlocalizedName())));
}
protected String getUnwrappedUnlocalizedName(String unlocalizedName)
{
return unlocalizedName.substring(unlocalizedName.indexOf(".") + 1);
}
	
}
