import 'dart:async';

import 'package:flutter/services.dart';

class NativeOrginToast {
  static const MethodChannel _channel =
      const MethodChannel('native_orgin_toast');

  static Future<String> get platformVersion async {
    final String version = await _channel.invokeMethod('getPlatformVersion');
    return version;
  }

  /// 弹出 Toast
  static Future<void> showAgreeToast() async {
    await _channel.invokeMethod("showAgreeToast");
  }

  /// 弹出 Toast
  static Future<void> showTextToast(String message) async {
    await _channel.invokeMethod("showTextToast", {
      "message": message,
    });
  }

   /// 弹出 加载 Toast
  static Future<void> showProgressTextToast(String message) async {
    await _channel.invokeMethod("showProgressTextToast", {
      "message": message,
    });
  }

     /// 弹出 加载 Toast
  static Future<void> dismissToast() async {
    await _channel.invokeMethod("dismissToast");
  }
}
