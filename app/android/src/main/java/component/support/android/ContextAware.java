package component.support.android;

import android.os.AsyncTask;
import android.view.View;

import androidx.appcompat.widget.AppCompatButton;

public class ContextAware {
    public static int in = 10;
    public static boolean completed = false;
    public static AppCompatButton button;

    public static void s(AppCompatButton mButton) {
        button = mButton;
    }

    public static void updater() {
        UpdateMainDataMain updateMainDataMain = new UpdateMainDataMain();
        updateMainDataMain.execute();
    }

    public static class UpdateMainDataMain extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            button.setEnabled(false);
            button.setText("10 Seconds");
            in = 10;
        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i = 0; i < 11; i++) {
                try {
                    Thread.sleep(1000);
                    in--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(in);
            }
            return "Updated";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            button.setText(in + " Seconds");
        }

        @Override
        protected void onPostExecute(String s) {
            button.setText("Continue");
            button.setVisibility(View.VISIBLE);
            button.setBackground(button.getContext().getDrawable(R.drawable.button));
            button.setEnabled(true);
            completed = true;
        }
    }


}
