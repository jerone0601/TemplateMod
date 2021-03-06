package org.yggdrasil.wurmunlimited.mods.Items.ArmorExample.WarmArmour.Chain;

import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.combat.ArmourTypes;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;

import java.io.IOException;
import java.util.logging.Logger;

/**
 * Created by Behemoth on 08.01.2018.
 */
public class FurLinedChainPants implements ItemTypes, MiscConstants {
    public static Logger logger = Logger.getLogger(FurLinedChainPants.class.getName());
    public static int templateId;
    private String name = "Cozy chain pants";
    public void createTemplate() throws IOException {
        /*        createItemTemplate(275, 3, "chain pants", "chain pants", "excellent", "good", "ok", "poor",
         *"Leg protection made from metal chain.", new short[]{108, 44, 22, 4, 189, 147}, (short)1041, (short)1, 0, 3024000L, 1, 10, 40, -10, new byte[]{34},
         * "model.armour.leg.chain.", 50.0F, 2200, (byte)0, 10000, true, 3);
         */
        ItemTemplateBuilder itemBuilder = new ItemTemplateBuilder("mod.item.furlinedchainpants");
        itemBuilder.name(name, "Cozy chain pants", "Leg protection made from metal chain, lined with cozy fur.");
        itemBuilder.itemTypes(new short[]{ // {108, 44, 22, 4, 189, 147} - chain boot
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_ARMOUR,
                ItemTypes.ITEM_TYPE_CHALL_NEWBIE,
                ItemTypes.ITEM_TYPE_MISSION
        });
        itemBuilder.imageNumber((short) 1041);
        itemBuilder.behaviourType((short) 1);
        itemBuilder.combatDamage(0);
        itemBuilder.decayTime(3024000L);
        itemBuilder.dimensions(1, 10, 40);
        itemBuilder.primarySkill(-10);
        itemBuilder.bodySpaces(new byte[]{34});
        itemBuilder.modelName("model.armour.leg.chain.");
        itemBuilder.difficulty(50.0f);
        itemBuilder.weightGrams(3200);
        itemBuilder.material(Materials.MATERIAL_UNDEFINED);
        itemBuilder.value(10000);
        itemBuilder.armourType(ArmourTypes.ARMOUR_CHAIN);


        ItemTemplate template = itemBuilder.build();
        templateId = template.getTemplateId();
        logger.info(name+" TemplateID: "+templateId);
    }

    public void initCreationEntry(){
        logger.info("initCreationEntry()");
        if(templateId > 0){
            logger.info("Creating "+name+" creation entry, ID = "+templateId);
            CreationEntryCreator.createSimpleEntry(SkillList.CLOTHTAILORING, ItemList.fur, ItemList.chainHose,
                    templateId, true, true, 0.0f, false, false, CreationCategories.ARMOUR);
            //final AdvancedCreationEntry entry = CreationEntryCreator.createAdvancedEntry(SkillList.SMITHING_WEAPON_HEADS,
            //		ItemList.ironBand, ItemList.shaft, templateId, false, false, 0f, true, false, CreationCategories.TOOLS);
            //entry.addRequirement(new CreationRequirement(1, ItemList.woodenHandleSword, 2, true));
            //entry.addRequirement(new CreationRequirement(2, ItemList.nailsIronSmall, 1, true));
        }else{
            logger.info(name+" does not have a template ID on creation entry.");
        }
    }
}