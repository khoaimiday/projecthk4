export class User {
  id: number;
  username = '';
  password = '';
  fullName = '';
  address = '';
  phoneNumber = '';
  roles = [];
  refreshToken = '';

  constructor(id?: number, username?: string, password?: string, fullName?: string, address?: string
                        , phoneNumber?: string,refreshToken?: string, roles?: []) {
    this.id = id;
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.address = address;
    this.phoneNumber = phoneNumber;
    this.roles = roles;
  }

}
