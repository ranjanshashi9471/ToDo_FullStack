import React from "react";
import { FaClipboardList } from "react-icons/fa";

interface LayoutProps {
	isLoggedIn: boolean;
	onLogin: () => void;
	onLogout: () => void;
	children: React.ReactNode;
}

export default function Layout({
	isLoggedIn,
	onLogin,
	onLogout,
	children,
}: LayoutProps) {
	return (
		<div className="min-h-screen flex flex-col w-full">
			{/* Navbar */}
			<nav className="text-zinc-600 p-2 px-10 shadow-md flex flex-row w-full">
				<div className="text-xl font-semibold flex flex-row py-1">
					<span className="">
						<FaClipboardList />
					</span>

					<span className="ml-1">TodoApp</span>
				</div>
				<div className="ml-auto cursor-pointer">
					{isLoggedIn ? (
						<div className="flex" onClick={onLogout}>
							<span>Logout</span>
						</div>
					) : (
						<div className="flex" onClick={onLogin}>
							<span className="text-2xl">Login</span>
						</div>
					)}
				</div>
			</nav>

			{/* Page Content */}
			<main className="mx-auto p-4">{children}</main>
		</div>
	);
}
