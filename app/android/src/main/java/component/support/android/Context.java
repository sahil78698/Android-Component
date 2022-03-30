package component.support.android;

import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;


public class Context {
    public static int in = 10;
    public static int in2 = 10;
    public static boolean completed = false;
    public static boolean isCompleted = false;
    private void reInit(TextView timer) {
        in = 10;
        in2 = 10;
        timer.setText("10\nSeconds");
    }


    public void update(TextView timer, AppCompatButton unlock) {
        in = 10;
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
                timer.setText(in + "\nSeconds");
                in--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        unlock.setVisibility(View.VISIBLE);
        unlock.setEnabled(true);
        isCompleted = true;
    }


    public static void updaterMainHeader(TextView timer, AppCompatButton download) {
        in2 = 10;
        for (int i = 0; i < 11; i++) {
            try {
                Thread.sleep(1000);
                timer.setText(in2 + "\nSeconds");
                download.setText(in2 + " Seconds");
                in2--;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        download.setBackground(download.getContext().getDrawable(R.drawable.completed));
        download.setText("Download");
        completed = true;
    }
}
