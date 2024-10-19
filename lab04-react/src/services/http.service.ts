/* eslint-disable @typescript-eslint/no-unused-vars */
import axios, { AxiosInstance, AxiosResponse, InternalAxiosRequestConfig } from "axios";

//Interceptor (Patrón de diseño), se ejecuta antes o después de una acción.
//Por ejemplo, para crear un token de login antes de enviar un request.
// Para un response, por ejemplo cuando se vence el token   
const apiInstance: AxiosInstance = axios.create({
    baseURL: 'http://localhost:8080',

})


apiInstance.interceptors.request.use(
	(config: InternalAxiosRequestConfig) => {
		// const token = getSessionToken();

		// if (!isNill(token)) {
			// config.headers.Authorization = `Bearer ${token}`;
		// }

		return config;
	},
	async error => {
		return await Promise.reject(error);
	},
);
apiInstance.interceptors.response.use(
	response => {
		return response;
	},
	async error => {
		console.log(JSON.stringify(error.data));
		if (error.status === 401 && error.data.code === 40103) {
			// removeSessionToken();
		}
		return await Promise.reject(error);
	},
);

//Cuestión de orden, no hay diferencia en hacerlo directo, 
//se hace así porque queremos que el nombre del método sea distinto al que proporciona axios (ejm. axios.get)
export const doPost = async <I, R>(payload: I, path: string): Promise<R> => {
	const response: AxiosResponse<R, I> = await apiInstance.post(path, payload);
	return response.data;
};

export const doPut = async <I, R>(payload: I, path: string): Promise<R> => {
	const response: AxiosResponse<R, I> = await apiInstance.put(path, payload);
	return response.data;
};

export const doGet = async <R>(path: string): Promise<R> => {
	const response: AxiosResponse<R> = await apiInstance.get(path);
	return response.data;
};
