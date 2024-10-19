export interface RegisterUserRequest {
	name: string;
	email: string;
	password: string;
}
export interface RegisterUserForm {
	name: string;
	email: string;
	password: string;
	passwordConfirmation: string;
}