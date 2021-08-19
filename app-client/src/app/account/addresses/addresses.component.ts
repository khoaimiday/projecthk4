import { Component, OnInit } from '@angular/core';
import { OktaAuthService } from '@okta/okta-angular';

@Component({
  selector: 'app-addresses',
  templateUrl: './addresses.component.html',
  styleUrls: ['./addresses.component.scss']
})
export class AddressesComponent implements OnInit {

  claims: Array<Claim>;
  constructor( public oktaAuth: OktaAuthService) { }

  async ngOnInit() {
    const userClaims = await this.oktaAuth.getUser();
    this.claims = Object.entries(userClaims).map(
          entry => ({ claim: entry[0], value: entry[1] })
    );
    console.log(this.claims)
  }

}
