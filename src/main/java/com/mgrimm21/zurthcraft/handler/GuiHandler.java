package com.mgrimm21.zurthcraft.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

import com.mgrimm21.zurthcraft.client.gui.GuiAlloySmelter;
import com.mgrimm21.zurthcraft.container.ContainerAlloySmelter;
import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.reference.GuiID;
import com.mgrimm21.zurthcraft.tileentity.TileEntityAlloySmelter;
import com.mgrimm21.zurthcraft.util.LogHelper;

import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		if (ID == GuiID.ALLOYSMELTER.ordinal()) {
			LogHelper.info("returning server element for smelter");
			TileEntityAlloySmelter tileEntityAlloySmelter = (TileEntityAlloySmelter) world.getTileEntity(x, y, z);
			return new ContainerAlloySmelter(player.inventory, tileEntityAlloySmelter);
		}
		LogHelper.info("not returning server element for smelter");
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		
		
		if (ID == GuiID.ALLOYSMELTER.ordinal()) {
			LogHelper.info("returning client element for smelter");
			TileEntityAlloySmelter tileEntityAlloySmelter = (TileEntityAlloySmelter) world.getTileEntity(x, y, z);
			return new GuiAlloySmelter(player.inventory, tileEntityAlloySmelter);
		}
		LogHelper.info("not returning client element for smelter");
		return null;
		
	}
	
}



