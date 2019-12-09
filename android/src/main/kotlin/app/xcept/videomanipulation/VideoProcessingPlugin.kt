package app.xcept.videoprocessing

import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class VideoProcessingPlugin : MethodCallHandler {
    companion object {
        @JvmStatic
        fun registerWith(registrar: Registrar) {
            val channel = MethodChannel(registrar.messenger(), "video_processing")
            channel.setMethodCallHandler(VideoProcessingPlugin())
        }
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        if (call.method == "getPlatformVersion") {
            result.success("Android ${android.os.Build.VERSION.RELEASE}")
        } else if (call.method == "generateVideo") {
            result.success(null)
        } else {
            result.notImplemented()
        }
    }
}

typealias Callback = () -> Boolean

interface IVideoProcessing {

    fun generateVideo(assetPaths: Collection<String>, outputFilename: String, outputFps: Int, outputSpeed: Double, completion: Callback);
}