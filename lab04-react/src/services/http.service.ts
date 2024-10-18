import axios, { AxiosInstance } from "axios";

//Interceptor (Patrón de diseño)
const apiInstance: AxiosInstance = axios.create({
    baseURL: 'http://localhost:8080',

})