package component.support.android;

import android.os.AsyncTask;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatButton;


public class Context {
    public static int in = 10;
    public static int in2 = 10;
    public static boolean completed = false;
    public static boolean isCompleted = false;
    public static AppCompatButton download;
    public static AppCompatButton unlock;
    public static TextView timer;

    public static void reInit(TextView timer) {
        completed = false;
        isCompleted = false;
        in = 10;
        in2 = 10;
    }

    public static void Init(TextView mTimer, AppCompatButton mUnlock, AppCompatButton mDownload) {
        download = (AppCompatButton) mDownload;
        unlock = (AppCompatButton) mUnlock;
        timer = (TextView) mTimer;

    }

    public static void update() {
        in = 10;
        UpdateMainData updateMainData = new UpdateMainData();
        updateMainData.execute();
    }

    public static void updaterMainHeader() {
        UpdateData updateData = new UpdateData();
        updateData.execute();
    }

    public static class UpdateMainData extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            timer.setText("10\nSeconds");
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
            timer.setText(in + "\nSeconds");
        }

        @Override
        protected void onPostExecute(String s) {
            unlock.setVisibility(View.VISIBLE);
            unlock.setEnabled(true);
            isCompleted = true;
        }
    }


    public static class UpdateData extends AsyncTask<String, Integer, String> {
        @Override
        protected void onPreExecute() {
            timer.setText("10\nSeconds");
            in2 = 10;
            download.setText(in2 + " Seconds");
        }

        @Override
        protected String doInBackground(String... strings) {
            for (int i = 0; i < 11; i++) {
                try {
                    Thread.sleep(1000);
                    in2--;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(in2);
            }
            return "Updated";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            timer.setText(in + "\nSeconds");
            download.setText(in2 + " Seconds");
        }

        @Override
        protected void onPostExecute(String s) {
            download.setBackground(download.getContext().getDrawable(R.drawable.completed));
            download.setText("Download");
            completed = true;
        }
    }


}
