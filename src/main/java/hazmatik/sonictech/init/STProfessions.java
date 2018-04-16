package hazmatik.sonictech.init;

import java.util.Random;

import hazmatik.sonictech.util.Reference;
import net.minecraft.entity.IMerchant;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.passive.EntityVillager.ITradeList;
import net.minecraft.entity.passive.EntityVillager.PriceInfo;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.village.MerchantRecipe;
import net.minecraft.village.MerchantRecipeList;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerCareer;
import net.minecraftforge.fml.common.registry.VillagerRegistry.VillagerProfession;
import net.minecraftforge.registries.IForgeRegistry;

@ObjectHolder(Reference.MODID)
public class STProfessions 
{
	public final static VillagerProfession the_doctor = null;
	
	public static VillagerCareer time_lord;
	
	@Mod.EventBusSubscriber(modid=Reference.MODID)
	public static class RegistrationHandler
	{
		@SubscribeEvent
		public static void onEvent(final RegistryEvent.Register<VillagerProfession> event)
		{
			final IForgeRegistry<VillagerProfession> registry = event.getRegistry();
			
			System.out.println("Registering Villager Professions");
			
			registry.register(new VillagerProfession(Reference.MODID + ":the_doctor", Reference.MODID + "textures/entities/the_doctor.png", Reference.MODID + ":textures/entities/the_doctor.png"));
		}
	}
	
	public static void associateCareersAndTrades()
	{
		System.out.println("Associating Careers and Trades to Villager Professions");
		
		time_lord = (new VillagerCareer(the_doctor, "time_lord"))
				.addTrade(1, new TradeEmeraldsForChromitite());
	}
	
	public static class TradeEmeraldsForChromitite implements ITradeList
	{
		public ItemStack stack;
		
		public EntityVillager.PriceInfo priceInfo;
		
		public TradeEmeraldsForChromitite()
		{
			stack = new ItemStack(BlockInit.STONE, 16, 0);
			priceInfo = new PriceInfo(2, 8);
		}
		
		@Override
		public void addMerchantRecipe(IMerchant merchant, MerchantRecipeList recipeList, Random random) 
		{
			int actualPrice = 1;
			
			if(priceInfo != null)
			{
				actualPrice = priceInfo.getPrice(random);
			}
			
			ItemStack stackToPay = new ItemStack(Items.EMERALD, actualPrice, 0);
			recipeList.add(new MerchantRecipe(stackToPay, stack));
			
			System.out.println("Merchant recipe list = "+recipeList.getRecipiesAsTags());
		}
	}
}
