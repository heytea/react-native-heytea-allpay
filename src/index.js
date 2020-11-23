'use strict'
import { NativeModules, Platform } from 'react-native'
const { AllPay } = NativeModules

export const allPay = (param) => {
  return new Promise((resolve) => {
    if (Platform.OS === 'ios') {
      AllPay.pay(param, (res) => {
        resolve(res)
      })
    } else {
      AllPay.allPay(param).then((res) => {
        resolve(res)
      })
    }
  })
}
