package gregtech.common.tileentities.machines.multi;

import gregtech.api.enums.ItemList;
import gregtech.api.enums.Materials;
import gregtech.api.interfaces.metatileentity.IMetaTileEntity;
import gregtech.api.interfaces.tileentity.IGregTechTileEntity;
import net.minecraft.nbt.NBTTagCompound;
import org.apache.commons.lang3.NotImplementedException;

import static gregtech.api.enums.GT_Values.ROMAN_LETTERS;

public class GT_MetaTileEntity_OilDrillTiered extends GT_MetaTileEntity_OilDrillBase {

    private byte mTier;

    public GT_MetaTileEntity_OilDrillTiered(int aID, String aName, String aNameRegional, int tier) {
        super(aID, aName, aNameRegional);
        mTier = (byte) tier;
        if (mTier < 1 || mTier > 4)
            throw new NotImplementedException("This tier is not supported yet! Modify the base class to support it!");
    }

    public GT_MetaTileEntity_OilDrillTiered(String aName, byte tier) {
        super(aName);
        this.mTier = tier;
    }

    @Override
    public void saveNBTData(NBTTagCompound aNBT) {
        super.saveNBTData(aNBT);
        aNBT.setByte("mTier", mTier);
    }

    @Override
    public void loadNBTData(NBTTagCompound aNBT) {
        super.loadNBTData(aNBT);
        mTier = aNBT.getByte("mTier");
    }

    @Override
    public String[] getDescription() {
        return getDescriptionInternal(ROMAN_LETTERS[mTier]);
    }

    @Override
    public IMetaTileEntity newMetaEntity(IGregTechTileEntity aTileEntity) {
        return new GT_MetaTileEntity_OilDrillTiered(mName, mTier);
    }

    @Override
    protected ItemList getCasingBlockItem() {
        return GT_MetaTileEntity_DrillerBase.getCasingFromTier(mTier);
    }

    @Override
    protected Materials getFrameMaterial() {
        return GT_MetaTileEntity_DrillerBase.getMaterialFromTier(mTier);
    }

    @Override
    protected int getCasingTextureIndex() {
        return GT_MetaTileEntity_DrillerBase.getTextureIndexFromTier(mTier);
    }

    @Override
    protected int getRangeInChunks() {
        return (int) Math.pow(4, mTier - 1);
    }

    @Override
    protected int getMinTier() {
        return mTier + 1;
    }
}