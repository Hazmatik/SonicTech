package hazmatik.sonictech;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;

public class Config 
{
	private static final String CATEGORY_GENERAL = "General";
	private static final String CATEGORY_MACHINES = "Machines";
	private static final String CATEGORY_WORLD = "World Generation";
	
	//WorldGeneration
	//Aluminium
	public static int aluminiumMinY = 40;
	public static int aluminiumMaxY = 64;
	public static int aluminiumChance = 25;
	public static int aluminiumSize = 10;
	//Antimony
	public static int antimonyMinY = 5;
	public static int antimonyMaxY = 100;
	public static int antimonyChance = 50;
	public static int antimonySize = 8;
	//Chromitite
	public static int chromititeEndMinY = 0;
	public static int chromititeEndMaxY = 128;
	public static int chromititeEndChance = 25;
	public static int chromititeEndSize = 16;
	public static boolean chromititeOverworld = false;
	public static int chromititeOWMinY = 0;
	public static int chromititeOWMaxY = 24;
	public static int chromititeOWChance = 25;
	public static int chromititeOWSize = 16;
	public static boolean chromititeNether = false;
	public static int chromititeNetherMinY = 0;
	public static int chromititeNetherMaxY = 64;
	public static int chromititeNetherChance = 25;
	public static int chromititeNetherSize = 16;
	//Chromite
	public static int chromiteSize = 6;
	public static int chromiteEndChance = 50;
	public static int chromiteOWChance = 50;
	public static int chromiteNetherChance = 50;
	//Copper
	public static int copperMinY = 42;
	public static int copperMaxY = 74;
	public static int copperChance = 25;
	public static int copperSize = 10;
	//Gneiss
	public static int gneissMinY = 0;
	public static int gneissMaxY = 128;
	public static int gneissChance = 25;
	public static int gneissSize = 25;
	//Lead
	public static int leadMinY = 5;
	public static int leadMaxY = 32;
	public static int leadChance = 25;
	public static int leadSize = 6;
	//Magnesite
	public static int magnesiteMinY = 5;
	public static int magnesiteMaxY = 100;
	public static int magnesiteChance = 50;
	public static int magnesiteSize = 6;
	//Molybdenum
	public static int molybdenumMinY = 5;
	public static int molybdenumMaxY = 100;
	public static int molybdenumChance = 50;
	public static int molybdenumSize = 6;
	//Silver
	public static int silverMinY = 5;
	public static int silverMaxY = 42;
	public static int silverChance = 25;
	public static int silverSize = 6;
	//Tin
	public static int tinMinY = 36;
	public static int tinMaxY = 54;
	public static int tinChance = 35;
	public static int tinSize = 8;
	//Zinc
	public static int zincMinY = 32;
	public static int zincMaxY = 100;
	public static int zincChance = 50;
	public static int zincSize = 6;
	
	public static void readConfig()
	{
		Configuration cfg = SonicTech.config;
		try
		{
			cfg.load();
			initGeneralConfig(cfg);
		}
		catch(Exception e1)
		{
			SonicTech.logger.log(Level.ERROR, "Problem loading SonicTech config file!", e1);
		}
		finally
		{
			if(cfg.hasChanged())
			{
				cfg.save();
			}
		}
	}
	
	private static void initGeneralConfig(Configuration cfg)
	{
		cfg.addCustomCategoryComment(CATEGORY_GENERAL, "General configs");
		cfg.addCustomCategoryComment(CATEGORY_WORLD, "World Generation Configs");
		
		//Aluminium
		aluminiumMinY = cfg.getInt("aluminiumMinY", CATEGORY_WORLD, aluminiumMinY, 0, 256, "Minimum Y level for Aluminium Ore to generate");
		aluminiumMaxY = cfg.getInt("aluminiumMaxY", CATEGORY_WORLD, aluminiumMaxY, 0, 256, "Maximum Y level for Aluminium Ore to generate");
		aluminiumChance = cfg.getInt("aluminiumChance", CATEGORY_WORLD, aluminiumChance, 0, 100, "The chance for Aluminium Ore to generate");
		aluminiumSize = cfg.getInt("aluminiumSize", CATEGORY_WORLD, aluminiumSize, 0, 24, "Size of the vein of Aluminium Ore to generate");
		//Antimony
		antimonyMinY = cfg.getInt("antimonyMinY", CATEGORY_WORLD, antimonyMinY, 0, 256, "Minimum Y level for Antimony Ore to generate");
		antimonyMaxY = cfg.getInt("antimonyMaxY", CATEGORY_WORLD, antimonyMaxY, 0, 256, "Maximum Y level for Antimony Ore to generate");
		antimonyChance = cfg.getInt("antimonyChance", CATEGORY_WORLD, antimonyChance, 0, 100, "The chance for Antimony Ore to generate");
		antimonySize = cfg.getInt("antimonySize", CATEGORY_WORLD, antimonySize, 0, 24, "Size of the vein of Antimony Ore to generate");
		//Chromitite
		chromititeEndMinY = cfg.getInt("chromititeEndMinY", CATEGORY_WORLD, chromititeEndMinY, 0, 256, "Minimum Y level for Chromitite to generate in the end");
		chromititeEndMaxY = cfg.getInt("chromititeEndMaxY", CATEGORY_WORLD, chromititeEndMaxY, 0, 256, "Maximum Y level for Chromitite to generate in the end");
		chromititeEndChance = cfg.getInt("chromititeEndChance", CATEGORY_WORLD, chromititeEndChance, 0, 100, "The chance for Chromitite to generate in the End");
		chromititeEndSize = cfg.getInt("chromititeEndSize", CATEGORY_WORLD, chromititeEndSize, 0, 100, "Size of the vein of Chromitite to generate in the End");
		chromititeOverworld = cfg.getBoolean("chromititeOverworld", CATEGORY_WORLD, chromititeOverworld, "Set to true to enable Chromitite and Chromium Ore to generate in the Overworld");
		chromititeOWMinY = cfg.getInt("chromititeOWMinY", CATEGORY_WORLD, chromititeOWMinY, 0, 256, "Minimum Y level for Chromitite to generate in the Overworld");
		chromititeOWMaxY = cfg.getInt("chromititeOWMaxY", CATEGORY_WORLD, chromititeOWMaxY, 0, 256, "Maximum Y level for Chromitite to generate in the Overworld");
		chromititeOWChance = cfg.getInt("chromititeOWChance", CATEGORY_WORLD, chromititeOWChance, 0, 100, "The chance for Chromitite to generate in the Overworld");
		chromititeOWSize = cfg.getInt("chromititeOWSize", CATEGORY_WORLD, chromititeOWSize, 0, 100, "Size of the vein of Chromitite to generate in the Overworld");
		chromititeNether = cfg.getBoolean("chromititeNether", CATEGORY_WORLD, chromititeNether, "Set to true to enable Chromitite and Chromium Ore to generate in the Nether");
		chromititeNetherMinY = cfg.getInt("chromititeNetherMinY", CATEGORY_WORLD, chromititeNetherMinY, 0, 256, "Minimum Y level for Chromitite to generate in the Nether");
		chromititeNetherMaxY = cfg.getInt("chromititeNetherMaxY", CATEGORY_WORLD, chromititeNetherMaxY, 0, 256, "Maximum Y level for Chromitite to generate in the Nether");
		chromititeNetherChance = cfg.getInt("chromititeNetherChance", CATEGORY_WORLD, chromititeNetherChance, 0, 100, "The chance for Chromitite to generate in the Nether");
		chromititeNetherSize = cfg.getInt("chromititeNetherSize", CATEGORY_WORLD, chromititeNetherSize, 0, 100, "Size of the vein of Chromitite to generate in the Nether");
		//Chromite
		chromiteSize = cfg.getInt("chromiteSize", CATEGORY_WORLD, chromiteSize, 0, 24, "The size of the vein of Chromite Ore to generate in Chromitite");
		chromiteEndChance = cfg.getInt("chromiteEndChance", CATEGORY_WORLD, chromiteEndChance, 0, 100, "The chance for Chromite Ore to generate in the End");
		chromiteOWChance = cfg.getInt("chromiteOWChance", CATEGORY_WORLD, chromiteOWChance, 0, 100, "The chance for Chromite Ore to generate in the Overworld(If enabled)");
		chromiteNetherChance = cfg.getInt("chromiteNetherChance", CATEGORY_WORLD, chromiteNetherChance, 0, 100, "The chance for Chromite Ore to generate in the Nether(If enabled)");
		//Copper
		copperMinY = cfg.getInt("copperMinY", CATEGORY_WORLD, copperMinY, 0, 256, "Minimum Y level for Copper Ore to generate");
		copperMaxY = cfg.getInt("copperMaxY", CATEGORY_WORLD, copperMaxY, 0, 256, "Maximum Y level for Copper Ore to generate");
		copperChance = cfg.getInt("copperChance", CATEGORY_WORLD, copperChance, 0, 100, "The chance for Copper Ore to generate");
		copperSize = cfg.getInt("copperSize", CATEGORY_WORLD, copperSize, 0, 24, "Size of the vein of Copper Ore to generate");
		//Gneiss
		gneissMinY = cfg.getInt("gneissMinY", CATEGORY_WORLD, gneissMinY, 0, 256, "Minimum Y level for Gneiss to generate");
		gneissMaxY = cfg.getInt("gneissMaxY", CATEGORY_WORLD, gneissMaxY, 0, 256, "Maximum Y level for Gneiss to generate");
		gneissChance = cfg.getInt("gneissChance", CATEGORY_WORLD, gneissChance, 0, 100, "The chance for Gneiss to generate");
		gneissSize = cfg.getInt("gneissSize", CATEGORY_WORLD, gneissSize, 0, 24, "Size of the vein of Gneiss to generate");
		//Lead
		leadMinY = cfg.getInt("leadMinY", CATEGORY_WORLD, leadMinY, 0, 256, "Minimum Y level for Lead Ore to generate");
		leadMaxY = cfg.getInt("leadMaxY", CATEGORY_WORLD, leadMaxY, 0, 256, "Maximum Y level for Lead Ore to generate");
		leadChance = cfg.getInt("leadChance", CATEGORY_WORLD, leadChance, 0, 100, "The chance for Lead Ore to generate");
		leadSize = cfg.getInt("leadSize", CATEGORY_WORLD, leadSize, 0, 24, "Size of the vein of Lead Ore to generate");
		//Magnesite
		magnesiteMinY = cfg.getInt("magnesiteMinY", CATEGORY_WORLD, magnesiteMinY, 0, 256, "Minimum Y level for Magnesite Ore to generate");
		magnesiteMaxY = cfg.getInt("magnesiteMaxY", CATEGORY_WORLD, magnesiteMaxY, 0, 256, "Maximum Y level for Magnesite Ore to generate");
		magnesiteChance = cfg.getInt("magnesiteChance", CATEGORY_WORLD, magnesiteChance, 0, 100, "The chance for Magnesite Ore to generate");
		magnesiteSize = cfg.getInt("magnesiteSize", CATEGORY_WORLD, magnesiteSize, 0, 24, "Size of the vein of Magnesite Ore to generate");
		//Molybdenum
		molybdenumMinY = cfg.getInt("molybdenumMinY", CATEGORY_WORLD, molybdenumMinY, 0, 256, "Minimum Y level for Molybdenum Ore to generate");
		molybdenumMaxY = cfg.getInt("molybdenumMaxY", CATEGORY_WORLD, molybdenumMaxY, 0, 256, "Maximum Y level for Molybdenum Ore to generate");
		molybdenumChance = cfg.getInt("molybdenumChance", CATEGORY_WORLD, molybdenumChance, 0, 100, "The chance for Molybdenum Ore to generate");
		molybdenumSize = cfg.getInt("molybdenumSize", CATEGORY_WORLD, molybdenumSize, 0, 24, "Size of the vein of Molybdenum Ore to generate");
		//Silver
		silverMinY = cfg.getInt("silverMinY", CATEGORY_WORLD, silverMinY, 0, 256, "Minimum Y level for Silver Ore to generate");
		silverMaxY = cfg.getInt("silverMaxY", CATEGORY_WORLD, silverMaxY, 0, 256, "Maximum Y level for Silver Ore to generate");
		silverChance = cfg.getInt("silverChance", CATEGORY_WORLD, silverChance, 0, 100, "The chance for Silver Ore to generate");
		silverSize = cfg.getInt("silverSize", CATEGORY_WORLD, silverSize, 0, 24, "Size of the vein of Silver Ore to generate");
		//Tin
		tinMinY = cfg.getInt("tinMinY", CATEGORY_WORLD, tinMinY, 0, 256, "Minimum Y level for Tin Ore to generate");
		tinMaxY = cfg.getInt("tinMaxY", CATEGORY_WORLD, tinMaxY, 0, 256, "Maximum Y level for Tin Ore to generate");
		tinChance = cfg.getInt("tinChance", CATEGORY_WORLD, tinChance, 0, 100, "The chance for Tin Ore to generate");
		tinSize = cfg.getInt("tinSize", CATEGORY_WORLD, tinSize, 0, 24, "Size of the vein of Tin Ore to generate");
		//Zinc
		zincMinY = cfg.getInt("zincMinY", CATEGORY_WORLD, zincMinY, 0, 256, "Minimum Y level for Zinc Ore to generate");
		zincMaxY = cfg.getInt("zincMaxY", CATEGORY_WORLD, zincMaxY, 0, 256, "Maximum Y level for Zinc Ore to generate");
		zincChance = cfg.getInt("zincChance", CATEGORY_WORLD, zincChance, 0, 100, "The chance for Zinc Ore to generate");
		zincSize = cfg.getInt("zincSize", CATEGORY_WORLD, zincSize, 0, 24, "Size of the vein of Zinc Ore to generate");
	}
}
