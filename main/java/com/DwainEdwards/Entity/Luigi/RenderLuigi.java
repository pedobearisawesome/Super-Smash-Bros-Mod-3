package com.DwainEdwards.Entity.Luigi;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import com.aggro.asma.Main;

public class RenderLuigi extends RenderLiving {

	public static final ResourceLocation texture = new ResourceLocation(Main.MODID + ":" + "textures/models/LUIGI.png");
	
	protected ModelLUIGI modelEntity;
	
	public RenderLuigi(ModelBase p_i1262_1_, float p_i1262_2_) {
		super(p_i1262_1_, p_i1262_2_);
		
		modelEntity = ((ModelLUIGI) mainModel);
		
	}
	
	public void renderLuigi(EntityLuigi entity, double x, double y, double z, float u, float v) {
		super.doRender(entity, x, y, z, u, v);
	}
	
	
	public void doRenderLiving(EntityLiving entityLiving, double x, double y, double z, float u, float v) {
		renderLuigi((EntityLuigi)entityLiving, x, y, z, u, v);
	}
	
	public void doRender(Entity entity, double x, double y, double z, float u, float v) {
		renderLuigi((EntityLuigi)entity, x, y, z, u, v);
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity p_110775_1_) {
	return texture;
	}


}
