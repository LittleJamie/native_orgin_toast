//
//  NativeOrginToastHUD.m
//  native_orgin_toast
//
//  Created by 工作 on 2022/2/23.
//

#import "NativeOrginToastHUD.h"
#import "SVProgressHUD.h"
@implementation NativeOrginToastHUD

+ (void)showAgreeToast {
    [SVProgressHUD showImage:[UIImage imageNamed:@""] status:@"请勾选同意后再登录"];
    [SVProgressHUD setDefaultStyle:SVProgressHUDStyleDark];
    [SVProgressHUD dismissWithDelay:2.5];
}

+ (void)showTextToast:(NSString *)message {
    [SVProgressHUD showImage:[UIImage imageNamed:@""] status:message];
    [SVProgressHUD setDefaultStyle:SVProgressHUDStyleDark];
    [SVProgressHUD dismissWithDelay:2.5];
}
@end
