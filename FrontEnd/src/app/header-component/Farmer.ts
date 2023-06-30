import { Items } from "./Items";

export interface Farmer{
    id:number;
    UserName:string;
    Password:string;
    city:string;
    pincode:number;
    mobileNumber:number;
    state:string;
    Item:Items[]
}