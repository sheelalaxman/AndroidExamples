import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import lmndevelopers.com.services.R

class MyService : Service() {
    lateinit var mediaPlayer: MediaPlayer
    override fun onBind(p0: Intent?): IBinder {
        return null!!
    }

    override fun onCreate() {
        super.onCreate()
        mediaPlayer = MediaPlayer.create(this, R.raw.kalimba)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {

        mediaPlayer.start()
        return super.onStartCommand(intent, flags, startId)

    }

    override fun onDestroy() {
        super.onDestroy()
        mediaPlayer.stop()
    }
}