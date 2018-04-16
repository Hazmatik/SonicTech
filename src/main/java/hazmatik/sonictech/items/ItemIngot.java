package hazmatik.sonictech.items;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.init.ItemInit;
import hazmatik.sonictech.util.interfaces.IHasModel;
import hazmatik.sonictech.util.interfaces.IMetaName;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;

public class ItemIngot extends Item implements IHasModel, IMetaName
{
	private String name;
	
	public ItemIngot(String name)
	{
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(SonicTech.sonictechtab);
		setHasSubtypes(true);
		
		this.name = name;
		ItemInit.ITEMS.add(this);
	}
	
	@Override
	public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		if(isInCreativeTab(tab)) 
		{
			for(int i = 0; i < Type.METADATA_LOOKUP.length; i++)
			{
				items.add(new ItemStack(this, 1, i));
			}
		}
	}
	
	@Override
	public String getSpecialName(ItemStack stack)
	{
		return Type.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public String getUnlocalizedName(ItemStack stack) 
	{
		return super.getUnlocalizedName() + "_" + this.getSpecialName(stack);
	}

	@Override
	public void registerModels() 
	{
		for(int i = 0; i < Type.METADATA_LOOKUP.length; i++)
		{
			SonicTech.proxy.registerVariantRenderer(this, i, "ingot_" + Type.values()[i].getName(), "inventory");
		}
	}
	
	
	public enum Type implements IStringSerializable
	{
		COPPER(0, "copper"),
		ALUMINIUM(1, "aluminium"),
		ZINC(2, "zinc"),
		TIN(3, "tin"),
		ANTIMONY(4, "antimony"),
		MOLYBDENUM(5, "molybdenum"),
		LEAD(6, "lead"),
		SILVER(7, "silver"),
		CHROMIUM(8, "chromium"),
		MAGNESIUM(9, "magnesium");
		
		private static final Type[] METADATA_LOOKUP = new Type[values().length];
		private final int metadata;
		private final String name;
		
		Type(int metadata, String name)
		{
			this.metadata = metadata;
			this.name = name;
		}
		
		public int getMetadata()
		{
			return this.metadata;
		}
		
		@Override
		public String getName() 
		{
			return this.name;
		}
		
		public static Type byMetadata(int metadata)
		{
			if(metadata < 0 || metadata >= METADATA_LOOKUP.length)
			{
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}
		
		static
		{
			for(Type type: values())
			{
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}
	}
}
