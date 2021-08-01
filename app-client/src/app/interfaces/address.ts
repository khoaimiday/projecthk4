export class Address {

    public id:number;
    public cities:string;
    public country:string;
    public district:string;
    public lane:string;
    public note:string;
    public state:string;
    public street:string;
    public type:string;
    public ward:string;
    public createdAt:Date;
    public updatedAt:Date;

    
    constructor(
                id:number,
                cities:string,
                country:string,
                district:string,
                lane:string,
                note:string,
                state:string,
                street:string,
                type:string,
                ward:string,
                createdAt:Date,
                updatedAt:Date
                ){
                    // this.id = id;
                    this.cities = cities;
                    this.country = country;
                    this.district = district;
                    this.lane = lane;
                    this.note = note;
                    this.state = state;
                    this.street = street;
                    this.type = type
                    this.ward = ward;
                    this.createdAt = createdAt;
                    this.updatedAt = updatedAt;
                }
    
    getAddress():string {
        return `${this.street}, ${this.ward}, ${this.district}`
    }

    get getAddressCity(): string{
        return `${this.street}, ${this.ward}, ${this.district}, ${this.cities} `
    }
}
