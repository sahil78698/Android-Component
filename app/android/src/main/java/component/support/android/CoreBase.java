package component.support.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

public class CoreBase {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static void InitFunctions(Context context) {
        sharedPreferences = context.getSharedPreferences("app-data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (!Component.Main_itemRe.equals(Component.Main_itemMainRe) || !Component.Main_itemInRe.equals(Component.Main_itemMainInre)) {
            editor.putBoolean("securityBreach", true);
            editor.commit();
            Toast.makeText(context, "Detected From LM", Toast.LENGTH_SHORT).show();
            throw new RuntimeException("error");
        }

    }
}
