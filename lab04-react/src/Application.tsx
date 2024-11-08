//Punto de entrada en la que se decidirá a qué lugar enviar al usuario,
// se settean las rutas aquí, después podemos dirigirnos a ellas
 
import { BrowserRouter, Route, Routes } from 'react-router-dom';
import React, { useMemo } from 'react';
import { Main } from './pages/Main';
import { useSessionHandler } from './hooks/useSessionHandler';
import ErrorBoundary from 'antd/es/alert/ErrorBoundary';
import RegisterUser from './pages/registerUser';
import Login from './pages/Login/login';

//
const publicRoute = () => {
	return (
		<Routes>
			<Route path='/' element={<Main />}>
				<Route index element={<Login />} />
				<Route path='Register' element={<RegisterUser />} />
				<Route path='Login' element={<Login />} />
			</Route>
		</Routes>
	);
};

const Application = () => {
	const { sessionContext, loadSessionFromToken } = useSessionHandler();

    //Igual que useEffect: Sirve para cargar datos, calcular datos
	useMemo(() => {
		if (sessionContext == null) {
			loadSessionFromToken();
		}
	}, []);

	return (
        //este componente es como un try catch
		<ErrorBoundary
			description='Something when wrong, please contact an administrator'
			message='An unknown error ocurrs'
		>
			<BrowserRouter>{publicRoute()}</BrowserRouter>
		</ErrorBoundary>
	);
};

export default Application;
