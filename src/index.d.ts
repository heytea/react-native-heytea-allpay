declare module "react-native-heytea-allpay" {
    export interface IAllPayParam {
        tn:string;
        scheme:string;
        mode:boolean
    }

    export interface IAllPayResponse {
        state:string;  //success cancel fail
        paymentSchema:string;
        orderNum:string;
        errorDetail:string;
    }

    export function allPay(param:IAllPayParam): Promise<IAllPayResponse>

}