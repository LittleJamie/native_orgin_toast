package native_toast.native_orgin_toast

import android.app.Activity
import android.content.Context
import android.widget.Toast
import androidx.annotation.NonNull

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

/** NativeOrginToastPlugin */
class NativeOrginToastPlugin: FlutterPlugin, MethodCallHandler {
  /// The MethodChannel that will the communication between Flutter and native Android
  ///
  /// This local reference serves to register the plugin with the Flutter Engine and unregister it
  /// when the Flutter Engine is detached from the Activity
  private lateinit var channel : MethodChannel
  private lateinit var context: Context

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    context = flutterPluginBinding.applicationContext
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "native_orgin_toast")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {

    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else if (call.method == "showTextToast") {
      Toast.makeText(
                context,
                call.argument("message"),
                Toast.LENGTH_SHORT
            ).show()
    } else if (call.method == "showArgeeToast") {
      Toast.makeText(
                context,
                "请勾选同意后再登录",
                  Toast.LENGTH_SHORT
            ).show()
    } else if (call.method == "showProgressTextToast") {
      Toast.makeText(
                context,
                "加载中...",
                Toast.LENGTH_SHORT
            ).show()
    } else if (call.method == "showProgressTextToast") {
      Toast.makeText(
                context,
                "加载中...",
                Toast.LENGTH_SHORT
            ).show()
    } else if (call.method == "dismissToast") {
    
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}