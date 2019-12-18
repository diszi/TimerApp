package d2.hu.timerapp;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText startEditText;
    EditText endEditText;
    EditText counterText;
    Button startButton;

    private int mCounter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startEditText = (EditText)findViewById(R.id.start);
        endEditText = (EditText)findViewById(R.id.end);
        counterText = (EditText)findViewById(R.id.counterEditText);
        startButton = (Button)findViewById(R.id.button);
    }

    public void startCounting(View view) {

        int s = Integer.parseInt(startEditText.getText().toString());
        int e = Integer.parseInt(endEditText.getText().toString());

//        System.out.println(" START COUNTING >> " +s+" | "+e);

         int i = e - s;
        Intent intent = new Intent(this, MyBroadcastReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(
                this.getApplicationContext(), 234324243, intent, 0);
        AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()
                + (i * 1000), pendingIntent);
        Toast.makeText(this, "Alarm set in " + i + " seconds >> " + e + "-" + s,
                Toast.LENGTH_LONG).show(); //megjelenik ez a szoveg, mikor megadom a szamot es megnyomom a gombot

        mCounter = i--;
        System.out.println(" COUNTER ="+mCounter);

        counterText.setText(Integer.toString(mCounter));

    }




}
