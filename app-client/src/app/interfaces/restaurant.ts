import { Address } from "./address";


export interface Restaurant {
    active: boolean;
    createdAt: Date;
    email: string;
    fullName: string;
    id: number;
    imageURL: string;
    navigationId: number
    phoneNumber: string;
    address: Address;
    rate: number;
    updatedAt: Date;
  }