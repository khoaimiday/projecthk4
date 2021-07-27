import { Dishes } from "./dishes";

export class CartItem {
    public id: number;
    public restanrantId: number;
    public fullName: string;
    public price: number;
    public imageURL: string;

    public quantity: number;

    constructor(dishes : Dishes){ 
        this.id = dishes.id;
        this.fullName = dishes.fullName;
        this.price = dishes.price;
        this.imageURL = dishes.imageURL;

        this.quantity = dishes.quantity;
    }

}

