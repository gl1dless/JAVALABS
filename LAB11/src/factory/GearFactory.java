package factory;

import gear.*;

public class GearFactory {

    public static GearItem create(GearType type) {

        switch (type) {

            case WEAPON_AK308:
                return new BasicWeapon("AK-308", 38, 102);

            case WEAPON_RSSAS:
                return new BasicWeapon("RSASS", 42, 96);

            case WEAPON_TKPD:
                return new BasicWeapon("TKPD", 50, 88);

            case WEAPON_MP7A1:
                return new BasicWeapon("HK MP7A1", 69, 42);

            case WEAPON_NL545:
                return new BasicWeapon("NL545", 55, 78);

            case WEAPON_MPX:
                return new BasicWeapon("SIG MPX", 66, 37);

            case WEAPON_AVT_40:
                return new BasicWeapon("AVT-40", 34, 128);

            //helmet
            case HELMET_NONE:
                return null;

            case HELMET_FAST_MT:
                return new Helmet("FAST MT", 4);

            case HELMET_ALTYN:
                return new Helmet("Altyn", 5);

            case HELMET_ULACH:
                return new Helmet("ULACH", 4);

            case HELMET_LSHZ_2DTM:
                return new Helmet("LShZ-2DTM", 4);

            case HELMET_ZSH_1_2M:
                return new Helmet("ZSh-1-2M", 4);

            case HELMET_KIVER_M:
                return new Helmet("Kiver-M", 3);

            //armor
            case ARMOR_PACA:
                return new Armor("PACA", 2);

            case ARMOR_6B2:
                return new Armor("6B2", 2);

            case ARMOR_6B13:
                return new Armor("6B13", 4);

            case ARMOR_KORUND:
                return new Armor("Korund", 5);

            case ARMOR_GZHEL:
                return new Armor("Gzhel-K", 5);

            case ARMOR_SLICK:
                return new Armor("Slick", 6);

            case ARMOR_FORT_REDUT_M:
                return new Armor("FORT Redut-M", 6);

            //rig
            case RIG_BANK_ROBBER:
                return new Rig("Bank Robber", 8);

            case RIG_MK3:
                return new Rig("Tactical MK3", 10);

            case RIG_AVS:
                return new Rig("AVS", 20);

            case RIG_BLACKROCK:
                return new Rig("BlackRock", 18);

            case RIG_CSA:
                return new Rig("CSA", 12);

            case RIG_SMR:
                return new Rig("SOE Micro Rig (SMR)", 14);

            case RIG_TV_106_107:
                return new Rig("TV-106 + TV-107", 16);

            //armored rig
            case ARMORED_RIG_TV110:
                return new ArmoredRig("TV-110", 4, 24);

            case ARMORED_RIG_AACPC:
                return new ArmoredRig("AACPC", 5, 22);

            case ARMORED_RIG_6B3TM:
                return new ArmoredRig("6B3TM-01M", 4, 18);

            case ARMORED_RIG_6B5_15:
                return new ArmoredRig("6B5-15", 4, 20);

            case ARMORED_RIG_MMCA:
                return new ArmoredRig("MMAC", 4, 20);

            case ARMORED_RIG_TACTEC:
                return new ArmoredRig("TacTec", 5, 18);

            case ARMORED_RIG_CPC_MOD2:
                return new ArmoredRig("CPC MOD.2", 6, 16);

            //headset
            case HEADSET_NONE:
                return null;

            case HEADSET_GSSH_01:
                return new Headset("GSSH-01");

            case HEADSET_PELTOR_COMTAC_2:
                return new Headset("Peltor ComTac 2");

            case HEADSET_PELTOR_COMTAC_4:
                return new Headset("Peltor ComTac 4");

            case HEADSET_SORDIN:
                return new Headset("Sordin");

            case HEADSET_RAZOR:
                return new Headset("Razor");

            case HEADSET_XCEL:
                return new Headset("XCEL");

            //face cover
            case FACECOVER_NONE:
                return null;

            case FACECOVER_BALACLAVA:
                return new FaceCover("Balaclava");

            case FACECOVER_HALFMASK:
                return new FaceCover("Half-mask");

            case FACECOVER_SHEMAGH:
                return new FaceCover("Shemagh");

            case FACECOVER_BANDANA:
                return new FaceCover("Bandana");

            case FACECOVER_GHOST_BALACLAVA:
                return new FaceCover("Ghost balaclava");

            case FACECOVER_NEOPRENE_MASK:
                return new FaceCover("Neoprene mask");

            //backpack
            case BACKPACK_NONE:
                return null;

            case BACKPACK_BERKUT:
                return new Backpack("Berkut", 20);

            case BACKPACK_DAY_PACK:
                return new Backpack("Day Pack", 20);

            case BACKPACK_SCAV_BP:
                return new Backpack("Scav Backpack", 25);

            case BACKPACK_TRIZIP:
                return new Backpack("Tri-Zip", 34);

            case BACKPACK_PILGRIM:
                return new Backpack("Pilgrim", 35);

            case BACKPACK_ATTACK2:
                return new Backpack("Attack 2", 45);

            default:
                throw new IllegalArgumentException("Unknown gear type: " + type);
        }
    }
}
