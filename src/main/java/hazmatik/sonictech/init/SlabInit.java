package hazmatik.sonictech.init;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.blocks.SlabChromitite;
import hazmatik.sonictech.blocks.SlabChromititeBrick;
import hazmatik.sonictech.blocks.SlabGneiss;
import hazmatik.sonictech.blocks.SlabGneissBrick;
import hazmatik.sonictech.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemSlab;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid=Reference.MODID)
public class SlabInit 
{

	public static SlabChromitite SLAB_CHROMITITE;
	public static SlabChromitite SLAB_CHROMITITE_HALF;
	public static SlabChromititeBrick SLAB_CHROMITITE_BRICK;
	public static SlabChromititeBrick SLAB_CHROMITITE_BRICK_HALF;
	public static SlabGneiss SLAB_GNEISS;
	public static SlabGneiss SLAB_GNEISS_HALF;
	public static SlabGneissBrick SLAB_GNEISS_BRICK;
	public static SlabGneissBrick SLAB_GNEISS_BRICK_HALF;
	
	public static void init()
	{
		SLAB_CHROMITITE = new SlabChromitite.DoubleCS("slab_chromitite_double");
		SLAB_CHROMITITE_HALF = new SlabChromitite.HalfCS("slab_chromitite");
		SLAB_CHROMITITE_HALF.setCreativeTab(SonicTech.sonictechtab);
		SLAB_CHROMITITE_BRICK = new SlabChromititeBrick.DoubleCS("slab_chromitite_brick_double");
		SLAB_CHROMITITE_BRICK_HALF = new SlabChromititeBrick.HalfCS("slab_chromitite_brick");
		SLAB_CHROMITITE_BRICK_HALF.setCreativeTab(SonicTech.sonictechtab);
		SLAB_GNEISS = new SlabGneiss.DoubleCS("slab_gneiss_double");
		SLAB_GNEISS_HALF = new SlabGneiss.HalfCS("slab_gneiss");
		SLAB_GNEISS_HALF.setCreativeTab(SonicTech.sonictechtab);
		SLAB_GNEISS_BRICK = new SlabGneissBrick.DoubleCS("slab_gneiss_brick_double");
		SLAB_GNEISS_BRICK_HALF = new SlabGneissBrick.HalfCS("slab_gneiss_brick");
		SLAB_GNEISS_BRICK_HALF.setCreativeTab(SonicTech.sonictechtab);
	}
	
	@SubscribeEvent
	public static void registerSlabs(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(SLAB_CHROMITITE, SLAB_CHROMITITE_HALF, SLAB_CHROMITITE_BRICK, SLAB_CHROMITITE_BRICK_HALF, SLAB_GNEISS, SLAB_GNEISS_HALF, SLAB_GNEISS_BRICK, SLAB_GNEISS_BRICK_HALF);
	}
	
	@SubscribeEvent
	public static void registerItemSlabs(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().register(new ItemSlab(SLAB_CHROMITITE_HALF, SLAB_CHROMITITE_HALF, SLAB_CHROMITITE).setRegistryName(SLAB_CHROMITITE_HALF.getRegistryName()));
		event.getRegistry().register(new ItemSlab(SLAB_CHROMITITE_BRICK_HALF, SLAB_CHROMITITE_BRICK_HALF, SLAB_CHROMITITE_BRICK).setRegistryName(SLAB_CHROMITITE_BRICK_HALF.getRegistryName()));
		event.getRegistry().register(new ItemSlab(SLAB_GNEISS_HALF, SLAB_GNEISS_HALF, SLAB_GNEISS).setRegistryName(SLAB_GNEISS_HALF.getRegistryName()));
		event.getRegistry().register(new ItemSlab(SLAB_GNEISS_BRICK_HALF, SLAB_GNEISS_BRICK_HALF, SLAB_GNEISS_BRICK).setRegistryName(SLAB_GNEISS_BRICK_HALF.getRegistryName()));
	}
	
	@SubscribeEvent
	public static void registerRenders(ModelRegistryEvent event)
	{
		registerRender(Item.getItemFromBlock(SLAB_CHROMITITE_HALF));
		registerRender(Item.getItemFromBlock(SLAB_CHROMITITE_BRICK_HALF));
		registerRender(Item.getItemFromBlock(SLAB_GNEISS_HALF));
		registerRender(Item.getItemFromBlock(SLAB_GNEISS_BRICK_HALF));
	}
	
	public static void registerRender(Item item)
	{
		ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
	}
}
