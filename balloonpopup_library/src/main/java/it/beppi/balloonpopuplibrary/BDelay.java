package it.beppi.balloonpopuplibrary;

/**
 * Created by Beppi on 15/12/2016.
 */

import android.os.Handler;
import android.util.Log;

/**
 * Lancia un Runnable dopo un tempo tot in ms.
 * Created by Beppi on 26/07/2016.
 */
public class BDelay {
    private Handler handler;
    private Runnable tickHandler, delegate;

    private long interval;
    public long getInterval() { return interval; }
    public void setInterval(long delay) { interval = delay; }
    public void updateInterval(long delay) {
        interval = delay;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
            handler.postDelayed(delegate, interval);
        }
    }

    public BDelay(long interv, Runnable onTickHandler)
    {
        Log.d("beppi", "bdelay constructor");
        interval = interv;
        setOnTickHandler(onTickHandler);
        handler = new Handler();
        handler.postDelayed(delegate, interval);
    }

    public void setOnTickHandler(Runnable onTickHandler)
    {
        if (onTickHandler == null)
            return;

        tickHandler = onTickHandler;

        delegate = new Runnable() {
            public void run()
            {
                if (tickHandler == null) return;
                handler.removeCallbacksAndMessages(null);
                tickHandler.run();
            }
        };
    }

    public void clear()
    {
        if (handler != null)
            handler.removeCallbacksAndMessages(null);
    }

}