import { RegisterUserRequest } from '../models/users.models';
import { doPost } from './http.service';

export const registerUser = async (
	user: RegisterUserRequest,
    //Promise ya viene de react, es de tipo Response que ya viene predefinida, no inventamos el agua tibia
): Promise<Response> => {
	const response = await doPost<RegisterUserRequest, Response>(
		user,
		'/api/public/register',
	);

	return response;
};

