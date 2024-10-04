import { Button, Input, Space } from 'antd';
import React from 'react';

const RegisterUser = () => {
	return (
		<>
			<Space direction='vertical'>
				<Input placeholder='Nombre'/>
				<Input placeholder='Correo' />
				<Input placeholder='Contraseña' type='password' />
				<Button type='primary'>Registrar</Button>
			</Space>
		</>
	);
};

export default RegisterUser;
