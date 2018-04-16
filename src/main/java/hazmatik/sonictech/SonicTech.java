package hazmatik.sonictech;

import java.io.File;

import org.apache.logging.log4j.Logger;

import hazmatik.sonictech.init.STProfessions;
import hazmatik.sonictech.init.SlabInit;
import hazmatik.sonictech.proxy.CommonProxy;
import hazmatik.sonictech.util.Reference;
import hazmatik.sonictech.util.handlers.RegistryHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MODID, name = Reference.NAME, version = Reference.VERSION)
public class SonicTech 
{
	@Instance
	public static SonicTech instance;
	public static Configuration config;
	public static Logger logger;
	
	public static final CreativeTabs sonictechtab = new SonicTechTab("sonictechtab");
	
	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.COMMON)
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event)
	{
		RegistryHandler.preInitRegistries();
		File directory = event.getModConfigurationDirectory();
		config = new Configuration(new File(directory.getPath(), "sonictech.cfg"));
		Config.readConfig();
		SlabInit.init();
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event)
	{		
		RegistryHandler.initRegistries();
		STProfessions.associateCareersAndTrades();
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event)
	{
		
	}
}
