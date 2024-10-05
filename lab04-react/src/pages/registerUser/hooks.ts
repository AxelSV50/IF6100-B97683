import { RegisterUserForm } from "./types";

//Cualquier lógica que no tenga que ver con componentes del UI
export const useDependencies = () => {
	const initialValues = {
		name: 'Axel',
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
	};

    
	const handleSubmit = (parms:RegisterUserForm) => {
		console.log(`${parms.name} ${parms.email} ${parms.password}`);
	};

	return {
		handleSubmit,
		initialValues,
        rules
	};
};
