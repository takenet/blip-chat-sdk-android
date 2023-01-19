package blip.chat.sdk.android

import android.content.Context
import android.content.Intent
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.android.FlutterActivityLaunchConfigs

class BlipChatActivity : FlutterActivity() {

    companion object {
        fun withCachedEngine(cachedEngineId: String): CachedEngineIntentBuilder {
            return CachedEngineIntentBuilder(BlipChatActivity::class.java, cachedEngineId)
        }

        fun withEngineDefault(): CachedEngineIntentBuilder {
            return CachedEngineIntentBuilder(BlipChatActivity::class.java, BlipChat.ENGINE_NAME)
        }
    }

    class CachedEngineIntentBuilder(
        private val activityClass: Class<out FlutterActivity?>,
        private val cachedEngineId: String
    ) {

        private val DEFAULT_BACKGROUND_MODE =
            FlutterActivityLaunchConfigs.BackgroundMode.opaque.name
        private var destroyEngineWithActivity = false
        private var backgroundMode = DEFAULT_BACKGROUND_MODE

        fun build(blipChat: BlipChat, context: Context): Intent {

            blipChat.getMethodChannel()
                .invokeMethod("onInit", blipChat.getBlipChatModel().toString())

            return Intent(context, activityClass)
                .putExtra("cached_engine_id", cachedEngineId)
                .putExtra("destroy_engine_with_activity", destroyEngineWithActivity)
                .putExtra("background_mode", backgroundMode)
        }
    }

}