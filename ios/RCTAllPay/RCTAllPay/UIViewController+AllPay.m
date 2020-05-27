//
//  UIViewController+AllPay.m
//  RCTAllPay
//
//  Created by 肖怡宁 on 2020/5/26.
//  Copyright © 2020 肖怡宁. All rights reserved.
//

#import "UIViewController+AllPay.h"

@implementation UIViewController (AllPay)

//获得当前导航控制器
+ (UINavigationController *)allPayGetRootNavVc {
    UIWindow * window = [[UIApplication sharedApplication] keyWindow];
    
    return (UINavigationController *)window.rootViewController;
}

//获取当前屏幕显示的viewcontroller
+ (UIViewController *)allPayGetCurrentVC {
    UIViewController *rootViewController = [UIApplication sharedApplication].keyWindow.rootViewController;
    
    UIViewController *currentVC = [self allPayGetCurrentVCFrom:rootViewController];
    
    return currentVC;
}

+ (UIViewController *)allPayGetCurrentVCFrom:(UIViewController *)rootVC {
    UIViewController *currentVC;
    
    if ([rootVC presentedViewController]) {
        
        rootVC = [rootVC presentedViewController];
    }
    
    if ([rootVC isKindOfClass:[UITabBarController class]]) {
        
        currentVC = [self allPayGetCurrentVCFrom:[(UITabBarController *)rootVC selectedViewController]];
        
    } else if ([rootVC isKindOfClass:[UINavigationController class]]){
        
        currentVC = [self allPayGetCurrentVCFrom:[(UINavigationController *)rootVC visibleViewController]];
        
    } else {
        
        currentVC = rootVC;
    }
    
    return currentVC;
}


@end
