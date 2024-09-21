import { useState } from 'react';

function App() {
	const [name, setName] = useState('Welcome to React');
	const [names, setNames] = useState<string[]>([]);

  const addName = () =>{

    setNames([...names, name])
    //setName("")

  }
	return (
		<>
			<div style={{ textAlign: 'center', flexFlow: 'column', display: 'flex' }}>
				<ul>
          {names.map((name, index) => <li key = {index}>{name}</li>)}
        </ul>
				<input
					type='text'
					onChange={e => setName(e.target.value)}
				/>
        <button onClick={addName}>Agregar</button>
			</div>
		</>
	);
}

export default App;
