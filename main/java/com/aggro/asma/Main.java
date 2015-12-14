package com.aggro.asma;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.EntityList;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

import com.DwainEdwards.Blocks.SmashBlocks;
import com.DwainEdwards.CreativeTabs.SmashTabs;
import com.DwainEdwards.Entity.Donkey.EntityDonkey;
import com.DwainEdwards.Entity.Luigi.EntityLuigi;
import com.DwainEdwards.Entity.MiiGunner.EntityMiiGunner;
import com.DwainEdwards.Entity.Pikachu.EntityPikachu;
import com.DwainEdwards.Entity.mario.EntityMario;
import com.DwainEdwards.Items.SmashItems;
import com.aggro.asma.blocks.BlockStage;
import com.aggro.asma.characters.ItemChar;
import com.aggro.asma.characters.ItemDhunt;
import com.aggro.asma.characters.ItemGrenin;
import com.aggro.asma.characters.ItemLink;
import com.aggro.asma.characters.ItemMario;
import com.aggro.asma.characters.ItemRob;
import com.aggro.asma.characters.ItemYLink;
import com.aggro.asma.entity.EntityDHDog;
import com.aggro.asma.entity.EntityHandler;
import com.aggro.asma.entity.EntityLakitu;
import com.aggro.asma.entity.EntityYoyo;
import com.aggro.asma.item.ItemDPad;
import com.aggro.asma.item.ItemFLUDD;
import com.aggro.asma.item.ItemNESZ;
import com.aggro.asma.item.ItemStockP;
import com.aggro.asma.item.ItemYoyo;
import com.aggro.asma.proxy.CommonProxy;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.GameRegistry;



@Mod(modid = Main.MODID, version = Main.VERSION)
public class Main
{
    public static final String MODID = "asma";
    public static final String VERSION = "1.1";
     
    public static  String chara = "rob";
    public static int emotion = 0;
    
    public static ToolMaterial enumToolMaterialSmash1 = EnumHelper.addToolMaterial("SMASHt1", 3, 1984, 16.0F, 4.0F, 30);
    public static ToolMaterial enumToolMaterialSmash2 = EnumHelper.addToolMaterial("SMASHt2", 3, 1984, 16.0F, 7.0F, 32);
    public static ToolMaterial enumToolMaterialSmash3 = EnumHelper.addToolMaterial("SMASHt3", 3, 1984, 16.0F, 10.0F, 34);
    public static ToolMaterial enumToolMaterialSmash4 = EnumHelper.addToolMaterial("SMASHt4", 3, 1984, 16.0F, 13.0F, 36);
    public static ToolMaterial enumToolMaterialSmash5 = EnumHelper.addToolMaterial("SMASHt5", 3, 1984, 16.0F, 16.0F, 38);
    
    public static ArmorMaterial enumArmorMaterialSmash0 = EnumHelper.addArmorMaterial("SMASHa0", 50, new int[] {1, 5, 3, 1}, 30);
    public static ArmorMaterial enumArmorMaterialSmash1 = EnumHelper.addArmorMaterial("SMASHa1", 90, new int[] {2, 16, 14, 2}, 30);
    public static ArmorMaterial enumArmorMaterialSmash2 = EnumHelper.addArmorMaterial("SMASHa2", 90, new int[] {3, 17, 15, 3}, 30);
    public static ArmorMaterial enumArmorMaterialSmash3 = EnumHelper.addArmorMaterial("SMASHa3", 90, new int[] {4, 18, 16, 4}, 30);
    public static ArmorMaterial enumArmorMaterialSmash4 = EnumHelper.addArmorMaterial("SMASHa4", 90, new int[] {5, 19, 17, 5}, 30);
    public static ArmorMaterial enumArmorMaterialSmash5 = EnumHelper.addArmorMaterial("SMASHa5", 90, new int[] {6, 20, 18, 6}, 30);
    
    @Instance(MODID)
    public static Main modInstance;
    
    public static final ItemYoyo yoyo = new ItemYoyo();
    public static final ItemNESZ zapper = new ItemNESZ();
    
    public static com.aggro.asma.item.SwordSmash swordSmash;
    int SwordSmashID = 599;
    public static com.aggro.asma.item.SwordDuck swordDuck;
    int SwordDuckID = 584;
    public static final Block blockStage = new BlockStage(Material.iron);
    public static final ItemStockP stockp = new ItemStockP();
    public static final ItemChar character = new ItemChar();
    public static final ItemDhunt characterdhunt = new ItemDhunt();
    public static final ItemMario charactermario = new ItemMario();
    public static final ItemLink characterlink = new ItemLink();
    public static final ItemYLink characterylink = new ItemYLink();
    public static final ItemRob characterrob = new ItemRob();
    public static final ItemDPad dpad = new ItemDPad();
    public static final ItemGrenin charactergrenin = new ItemGrenin();
    public static final ItemFLUDD fludd = new ItemFLUDD();
    
    
    @SidedProxy(clientSide="com.aggro.asma.proxy.ClientProxy", serverSide="com.aggro.asma.proxy.CommonProxy")
public static CommonProxy proxy;
	public static Object instance;
    
    public static void registerEntity(Class entityClass, String name)
    {
    int entityID = EntityRegistry.findGlobalUniqueEntityId();
    long seed = name.hashCode();
    Random rand = new Random(seed);
    int primaryColor = rand.nextInt() * 16777215;
    int secondaryColor = rand.nextInt() * 16777215;

    EntityRegistry.registerGlobalEntityID(entityClass, name, entityID);
    EntityRegistry.registerModEntity(entityClass, name, entityID, modInstance, 64, 1, true);
    EntityList.entityEggs.put(Integer.valueOf(entityID), new EntityList.EntityEggInfo(entityID, primaryColor, secondaryColor));
    }
	
    
    
    @EventHandler
	public static void PreLoad(FMLPreInitializationEvent PostEvent){
		SmashTabs.initialiseTabs();
		SmashItems.mainRegistry();
		SmashBlocks.mainRegistry();
    		//MinecraftForge.EVENT_BUS.register(new EventOnRenderPlayer());
    	//registerEntity(EntityHand.class, "entityHand");
    	//registerEntity(EntityMii.class, "entityMii");
    	registerEntity(EntityLakitu.class, "entityLakitu");
    	EntityHandler.registerMario(EntityMario.class, "mario");
    	EntityHandler.registerMario(EntityDonkey.class, "donkey");
    	EntityHandler.registerPikachu(EntityPikachu.class, "pikachu");
    	EntityHandler.registerLuigi(EntityLuigi.class, "luigi");
    	EntityHandler.registerMii(EntityMiiGunner.class, "miigunner");
    	//registerEntity(EntityDisc.class, "entitydisc");
    	registerEntity(EntityDHDog.class, "entitydhdog");
    	EntityRegistry.registerGlobalEntityID(EntityYoyo.class, "entityYoyo", EntityRegistry.findGlobalUniqueEntityId());
        EntityRegistry.registerModEntity(EntityYoyo.class, "entityYoyo", EntityRegistry.findGlobalUniqueEntityId(), modInstance, 64, 1, true);
    	proxy.registerRenderers();
	}
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
    	

    	RenderingRegistry.addNewArmourRendererPrefix("5");
    	
    	swordSmash = new com.aggro.asma.item.SwordSmash(Main.enumToolMaterialSmash5);
    	swordDuck = new com.aggro.asma.item.SwordDuck(Main.enumToolMaterialSmash3);
    	GameRegistry.registerItem(yoyo, yoyo.getUnlocalizedName());
    	
    	GameRegistry.registerItem(zapper, zapper.getUnlocalizedName());
    	GameRegistry.registerItem(swordSmash, swordSmash.getUnlocalizedName());
    	GameRegistry.registerItem(swordDuck, swordDuck.getUnlocalizedName());
    	proxy.registerRenderThings();
    	proxy.registerSounds();
    	GameRegistry.registerBlock(blockStage, blockStage.getUnlocalizedName());
    	GameRegistry.registerItem(character, character.getUnlocalizedName());
    	GameRegistry.registerItem(characterdhunt, characterdhunt.getUnlocalizedName());
    	GameRegistry.registerItem(charactermario, charactermario.getUnlocalizedName());
    	GameRegistry.registerItem(characterlink, characterlink.getUnlocalizedName());
    	GameRegistry.registerItem(characterylink, characterylink.getUnlocalizedName());
    	GameRegistry.registerItem(characterrob, characterrob.getUnlocalizedName());
    	GameRegistry.registerItem(charactergrenin, charactergrenin.getUnlocalizedName());
       	GameRegistry.registerItem(fludd, fludd.getUnlocalizedName());
    }
    
    @EventHandler
	public static void PostLoad(FMLPostInitializationEvent PostEvent){
		
	}
    
    
}

