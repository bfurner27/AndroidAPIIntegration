package benjamin.apiintegration;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


/**
 * Created by Benjamin on 10/17/2016.
 */

public class RetrieveFeedTask extends AsyncTask<Void, Void, String> {

    private Exception exception;
    private MainActivity mainActivity;
    private ProgressBar progressBar;
    private TextView responseView;
    private String emailText;

    public RetrieveFeedTask (EditText emailText) {
        mainActivity = new MainActivity();
        progressBar = mainActivity.getProgressBar();
        responseView = mainActivity.getResponseView();
        this.emailText = emailText.getText().toString();

    }



    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
        responseView.setText("");
    }

    protected String doInBackground(Void... urls) {
        String email = emailText;
        Log.i("INBACKGROUND", "email: " + email);
        // Do some validation here

        /*
        try {
            URL url = new URL(API_URL + "email=" + email + "&apiKey=" + API_KEY);
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                StringBuilder stringBuilder = new StringBuilder();
                String line;
                while ((line = bufferedReader.readLine()) != null) {
                    stringBuilder.append(line).append("\n");
                }
                bufferedReader.close();
                return stringBuilder.toString();
            }
            finally{
                urlConnection.disconnect();
            }
        }
        catch(Exception e) {
            Log.e("ERROR", e.getMessage(), e);
            return null;
        }*/
        return email;
    }

    protected void onPostExecute(String response) {
        if(response == null) {
            response = "THERE WAS AN ERROR";
        }
        progressBar.setVisibility(View.GONE);
        Log.i("INFO", response);
        responseView.setText(response);
    }
}

