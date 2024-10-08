declare module "@heytea/react-native-allpay" {
    export interface IAllPayParam {
        tn: string;
        scheme: string;
        mode: string;
    }

    export interface IAllPayResponse {
        state:string;  //success cancel fail
        paymentSchema:string;
        orderNum:string;
        errorDetail:string;
    }

    export function allPay(param:IAllPayParam): Promise<IAllPayResponse>

}