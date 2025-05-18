import "./App.css";

import React, { useState } from "react";
import Layout from "./components/Layout";
import { useNavigate } from "react-router-dom";

function App() {
	const [isLoggedIn, setIsLoggedIn] = useState(false);
	const navigate = useNavigate();
	const handleLogin = () => navigate("/login");
	const handleLogout = () => setIsLoggedIn(false);

	return (
		<Layout
			isLoggedIn={isLoggedIn}
			onLogin={handleLogin}
			onLogout={handleLogout}
		>
			<h2 className="text-2xl font-bold mb-4">
				Welcome to your Todo Dashboard
			</h2>
			{/* Todo list or login prompt */}
			{isLoggedIn ? (
				<p>Your todos go here...</p>
			) : (
				<p className="text-gray-600">Please log in to view your todos.</p>
			)}
		</Layout>
	);
}

export default App;
