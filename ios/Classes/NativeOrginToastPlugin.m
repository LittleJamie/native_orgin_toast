#import "NativeOrginToastPlugin.h"
#if __has_include(<native_orgin_toast/native_orgin_toast-Swift.h>)
#import <native_orgin_toast/native_orgin_toast-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "native_orgin_toast-Swift.h"
#endif

@implementation NativeOrginToastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  [SwiftNativeOrginToastPlugin registerWithRegistrar:registrar];
}
@end
