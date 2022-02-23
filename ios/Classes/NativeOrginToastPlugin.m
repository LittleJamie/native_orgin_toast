#import "NativeOrginToastPlugin.h"
#if __has_include(<native_orgin_toast/native_orgin_toast-Swift.h>)
#import <native_orgin_toast/native_orgin_toast-Swift.h>
#else
// Support project import fallback if the generated compatibility header
// is not copied when this plugin is created as a library.
// https://forums.swift.org/t/swift-static-libraries-dont-copy-generated-objective-c-header/19816
#import "native_orgin_toast-Swift.h"
#endif

#import "NativeOrginToastHUD.h"
@implementation NativeOrginToastPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
    FlutterMethodChannel* channel = [FlutterMethodChannel methodChannelWithName:@"native_orgin_toast" binaryMessenger:[registrar messenger]];
       
    NativeOrginToastPlugin* instance = [[NativeOrginToastPlugin alloc] init];
       [registrar addMethodCallDelegate:instance channel:channel];
//  [SwiftNativeOrginToastPlugin regi   sterWithRegistrar:registrar];
}

- (void)handleMethodCall:(FlutterMethodCall *)call result:(FlutterResult)result {
    
//    [self logMessage:@"handle" details:call.method];
    
    if ([call.method isEqual:@"getPlatformVersion"]) {
        
    } else if ([call.method isEqual:@"showAgreeToast"]) {
        [NativeOrginToastHUD showAgreeToast];
    } else if ([call.method isEqual:@"showTextToast"]) {
        [NativeOrginToastHUD showTextToast:call.arguments];
    }
}
@end
