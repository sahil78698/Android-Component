package component.support.android;

import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

public class ContextAware {
    public static int in = 10;
    public static boolean completed = false;

    public static void s(AppCompatButton button) {
        updater(button);
    }

    public static void updater(AppCompatButton button) {
        button.setEnabled(false);
        in = 10;
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
                button.setText(in + " Seconds");
                in--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        button.setText("Continue");
        button.setVisibility(View.VISIBLE);
        button.setBackground(button.getContext().getDrawable(R.drawable.button));
        button.setEnabled(true);
        completed = true;
    }

}
