package com.aggro.asma.characters;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.passive.EntityWolf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathEntity;
import net.minecraft.world.World;

import com.aggro.asma.Main;

public class ItemDhunt extends Item{
	
	public ItemDhunt()
	{
	this.setUnlocalizedName("characterdhunt"); 
	this.setCreativeTab(CreativeTabs.tabMisc); 
	this.setTextureName(Main.MODID + ":" + "CharDhunt"); 
	}
	
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer player)
	{
		if (!par2World.isRemote)
		{
			Main.chara = "dhunt";
			EntityWolf edog = new EntityWolf(player.worldObj);
			edog.setTamed(true);
            edog.setPathToEntity((PathEntity)null);
            edog.setAttackTarget((EntityLivingBase)null);
            
            edog.func_152115_b(player.getUniqueID().toString());
            edog.worldObj.setEntityState(edog, (byte)7);
            edog.setLocationAndAngles(player.posX, player.posY, player.posZ, player.rotationYaw, 0.0F);
            player.worldObj.spawnEntityInWorld(edog);
		}
	return par1ItemStack;
	
	}
}
