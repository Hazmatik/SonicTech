package hazmatik.sonictech.blocks;

import hazmatik.sonictech.SonicTech;
import hazmatik.sonictech.blocks.item.ItemBlockVariants;
import hazmatik.sonictech.init.BlockInit;
import hazmatik.sonictech.init.ItemInit;
import hazmatik.sonictech.util.interfaces.IHasModel;
import hazmatik.sonictech.util.interfaces.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class BlockOreBase extends Block implements IHasModel, IMetaName
{
	public static final PropertyEnum<Type> VARIANT = PropertyEnum.create("type", Type.class);
	
	private String name;
	
	public BlockOreBase(String name) 
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setResistance(5.0F);
		setSoundType(SoundType.STONE);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, Type.COPPER));
		setCreativeTab(SonicTech.sonictechtab);
		
		setHarvestLevel("pickaxe", 2);
		setHarvestLevel("pickaxe", 3, getStateFromMeta(Type.CHROMITE.getMetadata()));
		
		this.name = name;
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public float getBlockHardness(IBlockState state, World worldIn, BlockPos pos) 
	{
		float hardness = 3.0F;
		if(state == state.withProperty(VARIANT, Type.CHROMITE))
		{
			hardness = 10.0F;
		}
		return hardness;
	}
	
	@Override
	protected BlockStateContainer createBlockState() 
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}
	
	@Override
	public void getSubBlocks(CreativeTabs tab, NonNullList<ItemStack> items) 
	{
		for(int i = 0; i < Type.METADATA_LOOKUP.length; i++)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, Type.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state) 
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state)
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return Type.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < Type.METADATA_LOOKUP.length; i++)
		{
			SonicTech.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "ore_" + Type.values()[i].getName(), "inventory");
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
		CHROMITE(8, "chromite"),
		MAGNESITE(9, "magnesite");
		
		private static final Type[] METADATA_LOOKUP = new Type[values().length];
		private final int metadata;
		private final String name;
		
		Type(int metadata, String name)
		{
			this.metadata = metadata;
			this.name= name;
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
