export class Cart {

    constructor( public createdAt : Date,
                public updatedAt: Date,
                public id: number,
                public fullName: string,
                public unit: string,
                public  quantity: number,
                public  note: string,
                public rate: number,
                public price: number,
                public like: number,
                public delivered: number,
                public imageURL: string,
                public active: boolean,
                public itemCount: number){ }
}

