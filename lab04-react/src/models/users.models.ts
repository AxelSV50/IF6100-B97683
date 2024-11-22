//Posible error por el atributo name/user, verificar con el BE

export interface RegisterUserRequest {
	user: string;
	email: string;
	password: string;
}

export type AuthenticationInput = {
	username: string;
	password: string;
};
export type AuthenticationResponse = {
	token: string;
	name: string;
	email: string;
};
