//
//  NativeOrginToastHUD.h
//  native_orgin_toast
//
//  Created by 工作 on 2022/2/23.
//

#import <Foundation/Foundation.h>

NS_ASSUME_NONNULL_BEGIN

@interface NativeOrginToastHUD : NSObject

+ (void)showAgreeToast;
+ (void)showTextToast:(NSString *)message;
@end

NS_ASSUME_NONNULL_END
