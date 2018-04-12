package hazmatik.sonictech;

import org.apache.logging.log4j.Level;

import net.minecraftforge.common.config.Configuration;

public class Config 
{
	private static final String CATEGORY_GENERAL = "General";
	private static final String CATEGORY_MACHINES = "Machines";
	private static final String CATEGORY_WORLD = "World Generation";
	
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
	}
}
