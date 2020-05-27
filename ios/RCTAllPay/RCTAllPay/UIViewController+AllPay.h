//
//  UIViewController+AllPay.h
//  RCTAllPay
//
//  Created by 肖怡宁 on 2020/5/26.
//  Copyright © 2020 肖怡宁. All rights reserved.
//

#import <UIKit/UIKit.h>

NS_ASSUME_NONNULL_BEGIN

@interface UIViewController (AllPay)
//获得当前导航控制器
+ (UINavigationController *)allPayGetRootNavVc;

//获取当前屏幕显示的控制器
+ (UIViewController *)allPayGetCurrentVC;
@end

NS_ASSUME_NONNULL_END
