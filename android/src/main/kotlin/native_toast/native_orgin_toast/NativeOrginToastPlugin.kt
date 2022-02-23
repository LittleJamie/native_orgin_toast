package native_toast.native_orgin_toast

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

  override fun onAttachedToEngine(@NonNull flutterPluginBinding: FlutterPlugin.FlutterPluginBinding) {
    channel = MethodChannel(flutterPluginBinding.binaryMessenger, "native_orgin_toast")
    channel.setMethodCallHandler(this)
  }

  override fun onMethodCall(@NonNull call: MethodCall, @NonNull result: Result) {

    if (call.method == "getPlatformVersion") {
      result.success("Android ${android.os.Build.VERSION.RELEASE}")
    } else if (call.method == "showTextToast") {
      Toast mToast = Toast.makeText(context, call.argument, Toast.LENGTH_SHORT);
      mToast.setText(call.argument);
      mToast.setGravity(Gravity.CENTER, 0, 0);
      mToast.show();
    } else if (call.method == "showArgeeToast") {
      Toast mToast = Toast.makeText(context, "请勾选同意后再登录", Toast.LENGTH_SHORT);
      mToast.setText("请勾选同意后再登录");
      mToast.setGravity(Gravity.CENTER, 0, 0);
      mToast.show();
    } else {
      result.notImplemented()
    }
  }

  override fun onDetachedFromEngine(@NonNull binding: FlutterPlugin.FlutterPluginBinding) {
    channel.setMethodCallHandler(null)
  }
}
