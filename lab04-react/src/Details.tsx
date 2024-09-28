/* eslint-disable react/react-in-jsx-scope */

interface DetailsProps {
	names: string[];
	title: string | undefined;
}
const Details = (props: DetailsProps) => {
	const { names } = props;

	return (
		<div style={{ textAlign: 'center', display: 'flex', flexFlow: 'column' }}>
			<h1>Details</h1>
			<ol style={{ textAlign: 'center', alignSelf: 'center' }}>
				{names.map((name, index) => (
					<li key={index}>{name}</li>
				))}
			</ol>
		</div>
	);
};

export default Details;
