package com.mgrimm21.zurthcraft.client.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import com.mgrimm21.zurthcraft.block.BlockAlloySmelter;
import com.mgrimm21.zurthcraft.container.ContainerAlloySmelter;
import com.mgrimm21.zurthcraft.init.ModBlocks;
import com.mgrimm21.zurthcraft.reference.Reference;
import com.mgrimm21.zurthcraft.tileentity.TileEntityAlloySmelter;
import com.mgrimm21.zurthcraft.util.LogHelper;

public class GuiAlloySmelter extends GuiContainer{
	private ResourceLocation texture = new ResourceLocation(Reference.MOD_ID + ":" + "/textures/gui/alloysmeltergui.png");
	public TileEntityAlloySmelter alloysmelter;
	public int lavastored;
	public int waterstored;
	
	public GuiAlloySmelter(InventoryPlayer invPlayer, TileEntityAlloySmelter te) {
		super(new ContainerAlloySmelter(invPlayer, te));
		this.lavastored = te.lavastored;
		this.waterstored = te.waterstored;
		this.alloysmelter = te;

		this.ySize = 186;
		this.xSize = 176;

	}

	protected void drawGuiContainerForegroundLayer(int i, int j) {
		String name = this.alloysmelter.hasCustomInventoryName() ? this.alloysmelter.getInventoryName() : I18n.format(this.alloysmelter.getInventoryName());
		this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2 + 15, 15, 4210752);
		this.fontRendererObj.drawString(I18n.format("container.inventory"), 85, this.ySize - 118 + 5, 4210752);

	}
	public int getLavaRemainingScaled(int i) { return (this.lavastored * i) / alloysmelter.getMaxLava();}
	public int getWaterRemainingScaled(int i) {return (this.waterstored * i) / alloysmelter.getMaxWater();}
	
	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
		drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
		
		
		int intWater = alloysmelter.getWaterRemainingScaled(64);
		//LogHelper.info(intWater);
			drawTexturedModalRect(guiLeft + 17, guiTop + 60 - intWater, 177, 59 - intWater, 16, intWater);
			
			int intLava = alloysmelter.getLavaRemainingScaled(64);
			//LogHelper.info(intLava);
			drawTexturedModalRect(guiLeft + 53, guiTop + 60 - intLava, 194, 59 - intLava, 16, intLava);
			} 
	}
