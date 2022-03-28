package component.support.android;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Build;
import android.widget.Toast;

public class CoreBase {
    public static SharedPreferences sharedPreferences;
    public static SharedPreferences.Editor editor;

    public static boolean InitFunctions(Context context) {
        sharedPreferences = context.getSharedPreferences("app-data", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            if (!Component.Main_itemRe.equals(Component.Main_itemMainRe) || !Component.Main_itemInRe.equals(Component.Main_itemMainInre)) {
                editor.putBoolean("securityBreach", true);
                editor.commit();
                throw new RuntimeException("error");
            }else{
                return true;
            }
        } else {
            editor.putBoolean("securityBreach", true);
            editor.commit();
            return false;
        }
    }
}
