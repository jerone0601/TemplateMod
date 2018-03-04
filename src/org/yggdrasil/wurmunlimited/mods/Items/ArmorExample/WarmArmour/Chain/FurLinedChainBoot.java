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
public class FurLinedChainBoot implements ItemTypes, MiscConstants {
    public static Logger logger = Logger.getLogger(FurLinedChainBoot.class.getName());
    public static int templateId;
    private String name = "Cozy chain boot";
    public void createTemplate() throws IOException {
        //Some of the armor and weapons you will see notes like this one. During creation a few of us will put in the original values so we can easily stay close to original values or
        //make sure we have everything we need in it. Behemoth did most of the templates for armor as a learning  project for him and also to implement on World of WOnders.
        /*        createItemTemplate(274, 3, "chain boot", "chain boots", "excellent", "good", "ok", "poor",
         *"A sock made from metal chain.", new short[]{108, 44, 22, 4, 189, 147}, (short)1045, (short)1, 0, 3024000L, 5, 20, 30, -10,
         * new byte[]{15, 16}, "model.armour.foot.chain.", 30.0F, 700, (byte)0, 10000, true, 3);
         */
        ItemTemplateBuilder itemBuilder = new ItemTemplateBuilder("mod.item.furlinedchainboots");
        itemBuilder.name(name, "Cozy chain boots", "A sock made from metal chain, lined with cozy fur.");
        //Some developers work completely from the shorts list here and just type in the numbers. It is faster if you remember them all. The ItemTypes. is advantage of the modloader.
        itemBuilder.itemTypes(new short[]{ // {108, 44, 22, 4, 189, 147} - chain boot
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_METAL,
                ItemTypes.ITEM_TYPE_ARMOUR,
                ItemTypes.ITEM_TYPE_CHALL_NEWBIE,
                ItemTypes.ITEM_TYPE_MISSION
        });
        itemBuilder.imageNumber((short) 1045);
        itemBuilder.behaviourType((short) 1);
        itemBuilder.combatDamage(0);
        itemBuilder.decayTime(3024000L);
        itemBuilder.dimensions(5, 20, 30);
        itemBuilder.primarySkill(-10);
        itemBuilder.bodySpaces(new byte[]{15, 16});
        itemBuilder.modelName("model.armour.foot.chain.");
        itemBuilder.difficulty(30.0f);
        itemBuilder.weightGrams(1700);
        itemBuilder.material(Materials.MATERIAL_UNDEFINED);
        itemBuilder.value(10000);
        itemBuilder.armourType(ArmourTypes.ARMOUR_CHAIN);
        //There is three armourTypes that are not currently associated to player armor. It is only used for mobs. If you use Sindusk's armory mod they are listed there.
        //Using those then you have multiple different base armor types to use and can use different materials like Seryll/Adamantine/GLimmersteel to tweak exactly what you want.


        ItemTemplate template = itemBuilder.build();
        templateId = template.getTemplateId();
        logger.info(name+" TemplateID: "+templateId);
    }

    public void initCreationEntry(){
        logger.info("initCreationEntry()");
        if(templateId > 0){
            logger.info("Creating "+name+" creation entry, ID = "+templateId);
            //This is a simple entry of two items to make final object. Skill shows what skill it should use where next two items are items needed. The second item will determine material type.
            //Example below the simple entry shows how an advanced entry is made.
            CreationEntryCreator.createSimpleEntry(SkillList.CLOTHTAILORING,ItemList.fur, ItemList.chainBoot,
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