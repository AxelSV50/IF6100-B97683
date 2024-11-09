import { createRoot } from 'react-dom/client';

import Application from './Application.tsx';

// eslint-disable-next-line react/react-in-jsx-scope
//createRoot(document.getElementById('root')!).render(<App />);
// eslint-disable-next-line react/react-in-jsx-scope
createRoot(document.getElementById('root')!).render(<Application />);

/*
    React:

    ------------------
    DOM -> VIRTUAL DOM (ReactDOM)
    ------------------

    Por temas de performance se crea una imagen o copia del DOM original.
*/
