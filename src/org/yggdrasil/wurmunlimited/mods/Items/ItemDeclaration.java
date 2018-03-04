package org.yggdrasil.wurmunlimited.mods.Items;

import com.wurmonline.server.combat.Armour;

import com.wurmonline.server.combat.Weapon;
import com.wurmonline.server.items.CreationCategories;
import com.wurmonline.server.items.CreationEntryCreator;
import com.wurmonline.server.items.ItemList;
import com.wurmonline.server.skills.SkillList;
import org.gotti.wurmunlimited.modloader.ReflectionUtil;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Logger;


import org.yggdrasil.wurmunlimited.mods.Items.ArmorExample.WarmArmour.Chain.*;
import org.yggdrasil.wurmunlimited.mods.Items.Furniture.ReinforcedChair;
import org.yggdrasil.wurmunlimited.mods.Items.Weapons.*;
import org.yggdrasil.wurmunlimited.mods.Items.Weapons.heads.*;


/**
 * Created by Jerone on 1/4/2018.
 */
public class ItemDeclaration {
    public static Logger logger = Logger.getLogger(ItemDeclaration.class.getName());

    
    //Chain set

    public static FurLinedChainBoot FurLinedChainBoot = new FurLinedChainBoot();
    public static FurLinedChainCoif FurLinedChainCoif = new FurLinedChainCoif();
    public static FurLinedChainGauntlet FurLinedChainGauntlet = new FurLinedChainGauntlet();
    public static FurLinedChainJacket FurLinedChainJacket = new FurLinedChainJacket();
    public static FurLinedChainPants FurLinedChainPants = new FurLinedChainPants();
    public static FurLinedChainSleeve FurLinedChainSleeve = new FurLinedChainSleeve();


    //Weapons
    public static CurvedDaggerBlade CurvedDaggerBlade = new CurvedDaggerBlade();
    public static CurvedDagger CurvedDagger = new CurvedDagger();

    //Furniture
    public static ReinforcedChair ReinforcedChair = new ReinforcedChair();



//Adding them into the actual game as createable items below. If the createItems is set then GM can create. Need next entry after for player creation.
    public static void createItems() {
        logger.info("createItems()");
        try {



            //Chain set
            FurLinedChainBoot.createTemplate();
            FurLinedChainCoif.createTemplate();
            FurLinedChainGauntlet.createTemplate();
            FurLinedChainJacket.createTemplate();
            FurLinedChainPants.createTemplate();
            FurLinedChainSleeve.createTemplate();



            //Weapons and weapon heads
            CurvedDagger.createTemplate ();
            CurvedDaggerBlade.createTemplate ();


            //Furniture
            ReinforcedChair.createTemplate ();



        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//InitCreationENtries is needed to allow for crafting of the item. If you leave this out then players will not be able to craft orimprove but GMs will be able to create.
    public static void initCreationEntries() {
        logger.info("initCreationEntries()");

        //Chain set
        FurLinedChainBoot.initCreationEntry();
        FurLinedChainCoif.initCreationEntry();
        FurLinedChainGauntlet.initCreationEntry();
        FurLinedChainJacket.initCreationEntry();
        FurLinedChainPants.initCreationEntry();
        FurLinedChainSleeve.initCreationEntry();


        //Weapons
        CurvedDaggerBlade.initCreationEntry ();
        CurvedDagger.initCreationEntry ();

        //Furniture
        ReinforcedChair.initCreationEntry ();

//Template for allowing certain metals items to be made with different metals then default. This will not work with complex builds like Sacrifical Knife. Complex things will still end up as default metal.
// Most will not look any differently then normal counterpart. Most do not have an associated model for added metals. But for items like weapons then you will get the benefits of different
// metals like adamantine and glimmersteel. We added silverware in all metal types just for a little RP fun.

        //fork
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.steelBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.adamantineBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.glimmerSteelBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.seryllBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.goldBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.silverBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.copperBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.bronzeBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
        CreationEntryCreator.createSimpleEntry (SkillList.SMITHING_BLACKSMITHING, ItemList.anvilSmall, ItemList.brassBar, ItemList.fork,
                false, true, 10.0f, false, false, CreationCategories.COOKING_UTENSILS);
//Leather knife blade
        CreationEntryCreator.createSimpleEntry(SkillList.SMITHING_WEAPON_BLADES, ItemList.anvilSmall, ItemList.steelBar,
                ItemList.leatherKnifeBlade, false, true, 0.0f, false, false, CreationCategories.TOOL_PARTS);
        CreationEntryCreator.createSimpleEntry(SkillList.SMITHING_WEAPON_BLADES, ItemList.anvilSmall, ItemList.adamantineBar,
                ItemList.leatherKnifeBlade, false, true, 0.0f, false, false, CreationCategories.TOOL_PARTS);
        CreationEntryCreator.createSimpleEntry(SkillList.SMITHING_WEAPON_BLADES, ItemList.anvilSmall, ItemList.glimmerSteelBar,
                ItemList.leatherKnifeBlade, false, true, 0.0f, false, false, CreationCategories.TOOL_PARTS);
        CreationEntryCreator.createSimpleEntry(SkillList.SMITHING_WEAPON_BLADES, ItemList.anvilSmall, ItemList.seryllBar,
                ItemList.leatherKnifeBlade, false, true, 0.0f, false, false, CreationCategories.TOOL_PARTS);
    }

//Custom armor creation for move and limit modifiers. The defaults can be found in the server.jar file. The examples should be the same as the default armors.
// These were created to put variation for use with the survival mod. With just this mod they do nothing extra compared to the default armor. We modified the
//survival mod to give these different warmth values. Just here as examples for you to learn use. DR is based on armor type and material and is set in indvidiual class.

    public static void createCustomArmours() {
        try {
            logger.info ("Beginning custom armour creation.");
            Map<Integer, Armour> armours = ReflectionUtil.getPrivateField (null, ReflectionUtil.getField (Armour.class, "armours"));

            armours.put (FurLinedChainBoot.templateId, new Armour (FurLinedChainBoot.templateId, 0.015f, -0.15f));
            armours.put (FurLinedChainCoif.templateId, new Armour (FurLinedChainCoif.templateId, 0.01f, -0.15f));
            armours.put (FurLinedChainGauntlet.templateId, new Armour (FurLinedChainGauntlet.templateId, 0.01f, -0.15f));
            armours.put (FurLinedChainJacket.templateId, new Armour (FurLinedChainJacket.templateId, 0.07f, -0.15f));
            armours.put (FurLinedChainPants.templateId, new Armour (FurLinedChainPants.templateId, 0.07f, -0.15f));
            armours.put (FurLinedChainSleeve.templateId, new Armour (FurLinedChainSleeve.templateId, 0.008f, -0.15f));




        }  catch (IllegalArgumentException | IllegalAccessException | ClassCastException | NoSuchFieldException e) {
            e.printStackTrace ();
        }
    }

            public static void createCustomWeapons(){
                try {
                    logger.info("Beginning custom weapon creation.");
                    //This line will determine actual damage and speed of weapons. The numbers here are the base numbers and do not account for material bonuses like adamantine.
                    new Weapon(CurvedDagger.templateId, 5.50f, 2.75f, 0.202f, 1, 1, 0.2f, 0.5d);




                } catch (IllegalArgumentException | ClassCastException e) {
                    e.printStackTrace();
                }
            }
}

