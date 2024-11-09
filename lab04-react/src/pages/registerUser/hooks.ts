import { useApiHandler } from '../../hooks/useApiGHandlers';
import { registerUser } from '../../services/users.service';
import { RegisterUserForm, RegisterUserRequest } from './types';

//Cualquier lógica que no tenga que ver con componentes del UI

export const useDependencies = () => {
	const { handleMutation } = useApiHandler();

	const initialValues = {
		name: '',
		email: '',
		password: '',
	};

	//Reglas. Para dar formato, esto es parte del componente form de ANT
	const rules = {
		name: [
			{
				required: true,
				message: 'Por favor ingrese su nombre',
			},
		],
		email: [
			{
				required: true,
				message: 'Por favor ingrese su correo',
			},
		],
		password: [
			{
				required: true,
				message: 'Por favor ingrese su contraseña',
			},
		],
		passwordConfirmation: [
			{
				required: true,
				message: 'Por favor vuelva a ingresar su contraseña',
			},
		],
	};

	const handleSubmit = async (parms: RegisterUserForm) => {
		if (parms.password !== parms.passwordConfirmation) {
			return;
		}
		const request: RegisterUserRequest = {
			user: parms.name,
			email: parms.email,
			password: parms.password,
		};

		const { isError, message } = await handleMutation(registerUser, request);

		if (isError) {
			console.log(message);
		}
		console.log(`${parms.name} ${parms.email} ${parms.password}`);
	};

	return {
		handleSubmit,
		initialValues,
		rules,
	};
};
