package blip.chat.sdk.android

import android.content.Context
import android.util.Log
import blip.chat.sdk.android.models.BlipChatModel
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor
import io.flutter.plugin.common.MethodChannel

open class BlipChat(context: Context, var model: BlipChatModel) {

    private var flutterEngine: FlutterEngine = FlutterEngine(context)
    private var methodChannel: MethodChannel
    private val CHANNEL_NAME = "blip.sdk.chat.native/helper"

    companion object {
        val ENGINE_NAME = "my_engine_id"
    }

    init {
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )
        FlutterEngineCache.getInstance().put(ENGINE_NAME, flutterEngine)

        methodChannel = MethodChannel(flutterEngine.dartExecutor.binaryMessenger, CHANNEL_NAME)
        methodChannel.setMethodCallHandler { call, result ->
            Log.i("RETORNO", result.toString())
        }
    }

    fun getMethodChannel(): MethodChannel {
        return methodChannel
    }

    fun getBlipChatModel(): BlipChatModel {
        return model
    }

}