import { createRoot } from 'react-dom/client';
//import App from './App.tsx';
import RegisterUser from './pages/registerUser/index.tsx';

// eslint-disable-next-line react/react-in-jsx-scope
//createRoot(document.getElementById('root')!).render(<App />);
// eslint-disable-next-line react/react-in-jsx-scope
createRoot(document.getElementById('root')!).render(<RegisterUser />);

/*
    React:

    ------------------
    DOM -> VIRTUAL DOM (ReactDOM)
    ------------------

    Por temas de performance se crea una imagen o copia del DOM original.
*/
