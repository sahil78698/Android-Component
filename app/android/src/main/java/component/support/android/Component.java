package component.support.android;

import android.content.Context;

public class Component {

    public static Context Main_context;
    public static String Main_name;
    public static String Main_img;
    public static String Main_url;
    public static String Main_itemRe;
    public static String Main_itemMainRe;
    public static String Main_itemInRe;
    public static String Main_itemMainInre;
    public static String Main_Current_Game;

    public static void initialise(Context context, String name, String img, String url, String itemRe, String itemMainRe, String itemInRe, String itemMainInre, String currentGame) {
        Main_context = context;
        Main_name = name;
        Main_img = img;
        Main_url = url;
        Main_itemRe = itemRe;
        Main_itemMainRe = itemMainRe;
        Main_itemInRe = itemInRe;
        Main_itemMainInre = itemMainInre;
        Main_Current_Game = currentGame;
    }
}