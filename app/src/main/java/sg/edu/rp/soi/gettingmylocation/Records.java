package sg.edu.rp.soi.gettingmylocation;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Records extends Activity {
    TextView tv;
    String folderLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_record);
        tv = findViewById(R.id.tv1);
        folderLocation = Environment.getExternalStorageDirectory().getAbsolutePath() + "/MyFolder";
        File targetFile = new File(folderLocation, "data2.txt");
        if (targetFile.exists() == true) {
            String data = "";
            try {
                FileReader reader = new FileReader(targetFile);
                BufferedReader br = new BufferedReader(reader);
                String line = br.readLine();
                while (line != null) {
                    data += line + "\n";
                    line = br.readLine();
                }
                br.close();
                reader.close();
            } catch (Exception e) {
                Toast.makeText(getApplicationContext(), "Failed to read", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
            tv.setText(data);
        }
    }
}
