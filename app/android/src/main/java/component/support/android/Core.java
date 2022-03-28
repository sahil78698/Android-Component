package component.support.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

public class Core {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void CoreFunctions(Context context) {
        sharedPreferences = context.getSharedPreferences("app-data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (Component.Main_itemRe.equals(Component.Main_itemMainRe) && Component.Main_itemInRe.equals(Component.Main_itemMainInre)) {
            Toast.makeText(context, "Downloading...", Toast.LENGTH_SHORT).show();
            Intent i = context.getPackageManager().getLaunchIntentForPackage("com.badmodder.badsourcedownloader");
            i.putExtra("profile_name", Component.Main_name);
            i.putExtra("profile_url", Component.Main_img);
            i.putExtra("m_i", Component.Main_itemRe);
            i.putExtra("a_i", Component.Main_itemMainRe);
            i.putExtra("r_i", Component.Main_itemInRe);
            i.putExtra("l_i", Component.Main_itemMainInre);
            i.putExtra("appKey", CoreItems.Item());
            i.putExtra("game", Invoke.start());
            i.putExtra("current_game", Component.Main_Current_Game);
            i.putExtra("url", Component.Main_url.trim());
            context.startActivity(i);
        } else {
            Intent i = context.getPackageManager().getLaunchIntentForPackage("com.badmodder.badsourcedownloader");
            i.putExtra("goodBy", true);
            context.startActivity(i);

        }

    }
}