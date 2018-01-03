package soft.sonugan.salesapp

import android.app.Application
import io.objectbox.BoxStore

/**
 * Created by gaston on 02/01/2018.
 */
class SalesApp : Application(){
    lateinit var boxStore: BoxStore
        private set

    override fun onCreate() {
        super.onCreate()
    }
}