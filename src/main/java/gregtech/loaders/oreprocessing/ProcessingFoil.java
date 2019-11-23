package gregtech.loaders.oreprocessing;

import gregtech.api.GregTech_API;
import gregtech.api.enums.Materials;
import gregtech.api.enums.OrePrefixes;
import gregtech.api.interfaces.IOreRecipeRegistrator;
import gregtech.api.objects.GT_RenderedTexture;
import net.minecraft.item.ItemStack;

public class ProcessingFoil implements IOreRecipeRegistrator {
    public ProcessingFoil() {
        OrePrefixes.foil.add(this);
    }

    public void registerOre(OrePrefixes aPrefix, Materials aMaterial, String aOreDictName, String aModName, ItemStack aStack) {
//        if (!aMaterial.contains(SubTag.NO_SMASHING)) {
//            GT_Values.RA.addBenderRecipe(GT_Utility.copyAmount(1L, GT_OreDictUnificator.get(OrePrefixes.plate, aMaterial, 4L)), GT_OreDictUnificator.get(OrePrefixes.foil, aMaterial, 4L), (int) Math.max(aMaterial.getMass(), 1L), 24);
//        }
        GregTech_API.registerCover(aStack, new GT_RenderedTexture(aMaterial.mIconSet.mTextures[70], aMaterial.mRGBa, false), null);
    }
}
