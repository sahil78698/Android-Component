package component.support.android;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.PowerManager;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Init {
    String DOWNLOADED_FILE = "";
    String GetData = "";
    String GetStatus = "";
    int StartInt = 0;
    String Method = "";
    String Status = "";
    String FileFRom = "";
    String VertualMethod = "";
    private class DownloadTask extends AsyncTask<String, Integer, String> {
        private Context context;
        private PowerManager.WakeLock wakeLock;

        public DownloadTask(Context context) {
            this.context = context;
        }

        @Override
        protected String doInBackground(String... strings) {
            InputStream input = null;
            OutputStream output = null;
            HttpURLConnection connection = null;
            try {
                URL url = new URL(strings[0]);
                connection = (HttpURLConnection) url.openConnection();
                if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                    return "Server returned HTTP " + connection.getResponseCode() + " " + connection.getResponseMessage();
                }
                int filelength = connection.getContentLength();
                input = connection.getInputStream();
                if (!new File("/storage/emulated/0/BadSource/" + VertualMethod + "/").exists()) {
                    Log.e("File Create ", "Status");
                    new File("/storage/emulated/0/BadSource/" + VertualMethod + "/").mkdirs();
                } else {
                    Log.e("File Create ", "Exist");
                }
                String name = connection.getHeaderField("Content-Disposition");
                if (name != null && name.indexOf("=") != -1) {
                    int in = 1;
                    while (new File("/storage/emulated/0/BadSource/" + VertualMethod + "/" + "(" + in + ")" + name.split("=")[1]).exists()) {
                        in++;
                    }
                    output = new FileOutputStream("/storage/emulated/0/BadSource/" + VertualMethod + "/" + "(" + in + ")" + name.split("=")[1]);
                    DOWNLOADED_FILE = "/storage/emulated/0/BadSource/" + VertualMethod + "/" + "(" + in + ")" + name.split("=")[1];
                    System.out.println(name + " name");
                } else {
                    if (Method.contains("Source Code") || Method.contains("SOURCE CODE") || Method.contains("SOURCE CODE (ZIP)")) {
                        if (!new File("/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + ".zip").exists()) {
                            output = new FileOutputStream("/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + ".zip");
                            DOWNLOADED_FILE = "/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + ".zip";
                        } else {
                            int in = 1;
                            while (new File("/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + "(" + in + ").zip").exists()) {
                                in++;
                            }
                            output = new FileOutputStream("/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + "(" + in + ").zip");
                            DOWNLOADED_FILE = "/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + "(" + in + ").zip";
                        }
                    } else {
                        int in = 1;
                        while (new File("/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + "(" + in + ").apk").exists()) {
                            in++;
                        }
                        output = new FileOutputStream("/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + "(" + in + ").apk");
                        DOWNLOADED_FILE = "/storage/emulated/0/BadSource/" + VertualMethod + "/" + Status + "(" + in + ").apk";
                    }
                }
                byte data[] = new byte[4096];
                long total = 0;
                int count;
                while ((count = input.read(data)) != -1) {
                    if (isCancelled()) {
                        input.close();
                        return null;
                    }
                    total += count;
                    if (filelength > 0) {
                        publishProgress((int) (total * 100 / filelength));
                    }
                    output.write(data, 0, count);
                }
            } catch (MalformedURLException e) {
                return e.toString();
            } catch (IOException e) {
                return e.toString();
            } finally {
                try {
                    if (output != null) {
                        output.close();
                    }
                    if (input != null) {
                        input.close();
                    }
                } catch (IOException e) {
                }
                if (connection != null) {
                    connection.disconnect();
                }
            }
            return null;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            PowerManager powerManager = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, getClass().getName());
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {

        }
    }
    public static void start(Context context){
        Core.CoreFunctions(context);
    }

}
