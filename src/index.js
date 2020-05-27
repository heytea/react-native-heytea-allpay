'use strict';
import {
    NativeModules,
} from 'react-native';
const {
    AllPay
} = NativeModules;


export const allPay = param => {

    return new Promise(resolve => {
        AllPay.pay(param).then(res => {
            resolve(res);
        })
    })

}