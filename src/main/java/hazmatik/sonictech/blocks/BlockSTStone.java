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
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class BlockSTStone extends Block implements IHasModel, IMetaName
{
	public static final PropertyEnum<StoneType> VARIANT = PropertyEnum.create("type", StoneType.class);
	
	private String name;
	
	public BlockSTStone(String name)
	{
		super(Material.ROCK);
		setUnlocalizedName(name);
		setRegistryName(name);
		setResistance(5.0F);
		setSoundType(SoundType.STONE);
		setDefaultState(this.blockState.getBaseState().withProperty(VARIANT, StoneType.CHROMITITE));
		setCreativeTab(SonicTech.sonictechtab);
		setHarvestLevel("pickaxe", 2);
		setHarvestLevel("pickaxe", 3, getStateFromMeta(StoneType.CHROMITITE.getMetadata()));
		setHarvestLevel("pickaxe", 3, getStateFromMeta(StoneType.CHROMITITE_BRICK.getMetadata()));
		setHarvestLevel("pickaxe", 3, getStateFromMeta(StoneType.CHROMITITE_BRICK_CRACKED.getMetadata()));
		setHarvestLevel("pickaxe", 3, getStateFromMeta(StoneType.CHROMITITE_BRICK_MOSSY.getMetadata()));
		setHarvestLevel("pickaxe", 3, getStateFromMeta(StoneType.CHROMITITE_BRICK_CARVED.getMetadata()));
		setHarvestLevel("pickaxe", 3, getStateFromMeta(StoneType.CHROMITITE_COBBLE.getMetadata()));
		setHarvestLevel("pickaxe", 3, getStateFromMeta(StoneType.CHROMITITE_POLISHED.getMetadata()));
		
		this.name = name;
		BlockInit.BLOCKS.add(this);
		ItemInit.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	}
	
	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos,
			EntityPlayer player) 
	{
		return new ItemStack(this, 1, this.getMetaFromState(state));
	}
	
	@Override
	public float getBlockHardness(IBlockState state, World worldIn, BlockPos pos) 
	{
		float hardness = 3.0F;
		for(int i = 0; i < 7; i++)
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
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) 
	{
		for(int i = 0; i < StoneType.METADATA_LOOKUP.length; i++)
		{
			items.add(new ItemStack(this, 1, i));
		}
	}
	
	@Override
	public IBlockState getStateFromMeta(int meta) 
	{
		return this.getDefaultState().withProperty(VARIANT, StoneType.byMetadata(meta));
	}
	
	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(VARIANT).getMetadata();
	}
	
	@Override
	public int damageDropped(IBlockState state) 
	{
		if(state == this.getDefaultState().withProperty(VARIANT, StoneType.CHROMITITE))
		{
			return 1;
		}
		if(state == this.getDefaultState().withProperty(VARIANT, StoneType.GNEISS))
		{
			return 8;
		}
		else
		{
			return state.getValue(VARIANT).getMetadata();
		}
	}
	
	@Override
	public String getSpecialName(ItemStack stack) 
	{
		return StoneType.values()[stack.getItemDamage()].getName();
	}
	
	@Override
	public void registerModels() 
	{
		for(int i = 0; i < StoneType.METADATA_LOOKUP.length; i++)
		{
			SonicTech.proxy.registerVariantRenderer(Item.getItemFromBlock(this), i, "st_stone_" + StoneType.values()[i].getName(), "inventory");
		}
	}
	
	public enum StoneType implements IStringSerializable
	{
		CHROMITITE(0, "chromitite"),
		CHROMITITE_COBBLE(1, "chromitite_cobble"),
		CHROMITITE_POLISHED(2, "chromitite_polished"),
		CHROMITITE_BRICK(3, "chromitite_brick"),
		CHROMITITE_BRICK_MOSSY(4, "chromitite_brick_mossy"),
		CHROMITITE_BRICK_CRACKED(5, "chromitite_brick_cracked"),
		CHROMITITE_BRICK_CARVED(6, "chromitite_brick_carved"),
		GNEISS(7, "gneiss"),
		GNEISS_COBBLE(8, "gneiss_cobble"),
		GNEISS_POLISHED(9, "gneiss_polished"),
		GNEISS_BRICK(10, "gneiss_brick"),
		GNEISS_BRICK_MOSSY(11, "gneiss_brick_mossy"),
		GNEISS_BRICK_CRACKED(12, "gneiss_brick_cracked"),
		GNEISS_BRICK_CARVED(13, "gneiss_brick_carved");
		
		private static final StoneType[] METADATA_LOOKUP = new StoneType[values().length];
		private final int metadata;
		private final String name;
		
		StoneType(int metadata, String name)
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
		
		public static StoneType byMetadata(int metadata)
		{
			if(metadata < 0 || metadata >= METADATA_LOOKUP.length)
			{
				metadata = 0;
			}
			return METADATA_LOOKUP[metadata];
		}
		
		static
		{
			for(StoneType type : values())
			{
				METADATA_LOOKUP[type.getMetadata()] = type;
			}
		}
	}
}
