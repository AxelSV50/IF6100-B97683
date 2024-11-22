/* eslint-disable react/react-in-jsx-scope */
import { Button, Form, Input, Space } from 'antd';
import { useDependencies } from './hooks';

const RegisterUser = () => {
	//Hook personalizado, lo único que hace es determinar los valores iniciales para un formulario, un método para el submit
	//y un apartado de reglas de entrada para los input (documentación de ANT D)
	const { initialValues, handleSubmit, rules } = useDependencies();

	return (
		<Form onFinish={handleSubmit} initialValues={initialValues}>
			<Space direction='vertical'>
				<Form.Item name='name' rules={rules.name}>
					<Input placeholder='Nombre' />
				</Form.Item>

				<Form.Item name='email' rules={rules.email}>
					<Input placeholder='Correo' />
				</Form.Item>

				<Form.Item name='password' rules={rules.password}>
					<Input placeholder='Contraseña' type='password' />
				</Form.Item>

				<Form.Item
					name='passwordConfirmation'
					rules={rules.passwordConfirmation}
				>
					<Input placeholder='Confirmar contraseña' type='password' />
				</Form.Item>

				{/*Se debe agregar el htmlType='submit'*/}
				<Button type='primary' htmlType='submit'>
					Registrar
				</Button>
			</Space>
		</Form>
	);
};

export default RegisterUser;
