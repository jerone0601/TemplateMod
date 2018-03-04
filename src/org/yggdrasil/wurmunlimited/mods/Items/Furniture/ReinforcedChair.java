package org.yggdrasil.wurmunlimited.mods.Items.Furniture;

import com.wurmonline.server.MiscConstants;
import com.wurmonline.server.behaviours.Vehicle;
import com.wurmonline.server.creatures.Creature;
import com.wurmonline.server.items.*;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modsupport.ItemTemplateBuilder;
import org.gotti.wurmunlimited.modsupport.vehicles.ModVehicleBehaviour;
import org.gotti.wurmunlimited.modsupport.vehicles.VehicleFacade;

import java.io.IOException;
import java.util.logging.Logger;

public class ReinforcedChair implements ItemTypes, MiscConstants {
    public static Logger logger = Logger.getLogger(ReinforcedChair.class.getName());
    public static int templateId;
    private String name = "Reinforced Chair";
    public void createTemplate() throws IOException {
//createItemTemplate(265, "armchair", "armchairs", "superb", "good", "ok", "poor", "A comfortable armchair with a seat padded with cloth.", new short[]
// { 108, 21, 135, 86, 51, 52, 44, 92, 117, 197, 199 }, (short)274, (short)41, 0, 9072000L, 10, 30, 60, -10, MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY,
// "model.furniture.chair.armchair.", 30.0F, 7000, (byte)14, 10000, true);
        ItemTemplateBuilder itemBuilder = new ItemTemplateBuilder("mod.item.ReinforcedChair");
        itemBuilder.name(name, "ReinforcedChairs", "A chair reinforced for those who have not adventured much.");
        itemBuilder.itemTypes(new short[]{ // new short[]{44, 22} - Large Maul Head
                ItemTypes.ITEM_TYPE_NAMED,
                ItemTypes.ITEM_TYPE_OWNER_DESTROYABLE,
                ItemTypes.ITEM_TYPE_OWNER_MOVEABLE,
                ItemTypes.ITEM_TYPE_TURNABLE,
                ItemTypes.ITEM_TYPE_DECORATION,
                ItemTypes.ITEM_TYPE_COLORABLE,
                ItemTypes.ITEM_TYPE_REPAIRABLE,
                ItemTypes.ITEM_TYPE_VEHICLE,
                ItemTypes.ITEM_TYPE_CHAIR,
                ItemTypes.ITEM_TYPE_PLANTABLE,
                ItemTypes.ITEM_TYPE_WOOD
        });
        itemBuilder.imageNumber((short) 274);
        itemBuilder.behaviourType((short) 41);
        itemBuilder.decayTime(Long.MAX_VALUE);
        itemBuilder.dimensions(5, 10, 80);
        itemBuilder.bodySpaces(MiscConstants.EMPTY_BYTE_PRIMITIVE_ARRAY);
        itemBuilder.modelName("model.furniture.chair.armchair."); //If you have new models you would put them here. You will need a serverpack to make them work correctly for everyone
        itemBuilder.difficulty(45.0f);
        itemBuilder.weightGrams(6000);
        itemBuilder.material(Materials.MATERIAL_UNDEFINED);
        itemBuilder.value(1000);

        ItemTemplate template = itemBuilder.build();
        templateId = template.getTemplateId();
        logger.info(name+" TemplateID: "+templateId);
    }

    public void initCreationEntry(){
        logger.info("initCreationEntry()");
        if(templateId > 0){
            logger.info("Creating "+name+" creation entry, ID = "+templateId);

            final AdvancedCreationEntry entry = CreationEntryCreator.createAdvancedEntry(SkillList.SMITHING_BLACKSMITHING,
            ItemList.ironBand, ItemList.shaft, templateId, false, false, 0f, true, false, CreationCategories.FURNITURE);
            entry.addRequirement(new CreationRequirement(1, ItemList.ironBand, 10, true));
            entry.addRequirement(new CreationRequirement(2, ItemList.shaft, 4, true));
            entry.addRequirement(new CreationRequirement(3, ItemList.nailsIronSmall, 10, true));
            entry.addRequirement(new CreationRequirement(4, ItemList.plank, 4, true));
        }else{
            logger.info(name+" does not have a template ID on creation entry.");
        }
    }

}
