//
//  RCTAllPay.m
//  RCTAllPay
//
//  Created by 肖怡宁 on 2020/5/26.
//  Copyright © 2020 肖怡宁. All rights reserved.
//


#import "RCTAllPay.h"
#import "AllPaySDK.h"
#import "UIViewController+AllPay.h"

@implementation RCTAllPay

RCT_EXPORT_MODULE(AllPay);

- (dispatch_queue_t)methodQueue {
    return dispatch_get_main_queue();
}


+ (BOOL)requiresMainQueueSetup {
    return YES;
}

//rn调用的方法
RCT_EXPORT_METHOD(pay:(NSDictionary *)data:(RCTResponseSenderBlock)callback) {
    
  [self payWithParam:data onResult:^(NSDictionary *resultDic) {
     callback(@[resultDic]);
  }];
  
}

//发起支付
- (void)payWithParam:(NSDictionary *)paramDict onResult:(void(^)(NSDictionary * resultDic))onResult {
      
  NSString *tn = [paramDict objectForKey:@"tn"];
  NSString *scheme = [paramDict objectForKey:@"scheme"];
  NSNumber  *mode = @([[paramDict objectForKey:@"mode"] intValue]); //测试环境为NO，生产环境为YES
  [AllPaySDK pay:tn mode:[mode boolValue] scheme:scheme ViewController:[UIViewController allPayGetCurrentVC] onResult:onResult];
  
}


@end
