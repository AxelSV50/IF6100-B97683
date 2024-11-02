import { FormEvent, useState } from 'react';
import Details from './Details';
function App() {
	const [name, setName] = useState('Welcome to React');
	const [names, setNames] = useState<string[]>([]);

	const addName = (e: FormEvent<HTMLFormElement>) => {
		e.preventDefault();
		setNames([...names, name]);
		setName('');
	};
	return (
		<div
			style={{ alignContent: 'center', display: 'flex', flexFlow: 'column' }}
		>
			<form style={{ textAlign: 'center' }} onSubmit={e => addName(e)}>
				<input
					type='text'
					value={name}
					onChange={e => setName(e.target.value)}
				/>
				<button>Agregar</button>
			</form>

			<Details names={names} title={undefined} />
		</div>
	);
}

export default App;
