export default function ToDoApp(props: {
	listTitle: string;
	newListItems: string[];
}) {
	const { listTitle, newListItems } = props;
	return (
		<div>
			<div className="box" id="heading">
				<h1> {listTitle} </h1>
			</div>
			<div className="box">
				{newListItems.map((ListItem: string) => (
					<div className="item">
						<input type="checkbox" name="" id="" />
						<p> {ListItem} </p>
					</div>
				))}

				<form className="item" action="/" method="post">
					<input
						type="text"
						name="newItem"
						placeholder="New Item"
						autoComplete="off"
					/>
					<button type="submit" name="list" value={listTitle}>
						+
					</button>
				</form>
			</div>
		</div>
	);
}
