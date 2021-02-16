package android.example.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class CustomReceiver extends BroadcastReceiver {
    private CustomReceiver mReceiver=new CustomReceiver();
    private static final String ACTION_CUSTOM_BROADCAST=BuildConfig.APPLICATION_ID+".ACTION_CUSTOM_BROADCAST";

    @Override
    public void onReceive(Context context, Intent intent) {
        String intentAction=intent.getAction();
        if(intentAction!=null){
            String toastMessage="";
            switch(intentAction){
                //cek intent yang dikirim itu apa

                //connected charge
                case Intent.ACTION_POWER_CONNECTED:
                    toastMessage=context.getString(R.string.power_connected);
                    break;

                    //disconnect charge
                case Intent.ACTION_POWER_DISCONNECTED:
                    toastMessage=context.getString(R.string.power_disconnect);
                    break;

                case ACTION_CUSTOM_BROADCAST:
                    toastMessage=intent.getStringExtra("DATA");
                    break;
            }
            //menampilkan pop up
            Toast.makeText(context, toastMessage, Toast.LENGTH_SHORT).show();
        }
    }
}
