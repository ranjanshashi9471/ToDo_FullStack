import * as React from "react";
import { FaArrowRight, FaUserPlus, FaGoogle, FaFacebook } from "react-icons/fa";

export interface ISignUpProps {}

export default function SignUp(props: ISignUpProps) {
	return (
		<div className="w-full min-h-screen flex items-center justify-center bg-gray-100">
			<div className="w-full max-w-md p-6 bg-white rounded-2xl shadow-lg">
				<h1 className="text-3xl font-bold text-center mb-6">Signup</h1>
				<form action="/login" method="POST" className="space-y-6">
					<div>
						<input
							type="text"
							name="username"
							placeholder="Enter Your Email / Username."
							className="w-full px-4 py-2 border border-gray-300 rounded-lg text-center focus:outline-none focus:ring-2 focus:ring-blue-500"
						/>
					</div>
					<div>
						<input
							type="password"
							name="password"
							placeholder="Enter Your Password."
							className="w-full px-4 py-2 border border-gray-300 rounded-lg text-center focus:outline-none focus:ring-2 focus:ring-blue-500"
						/>
					</div>
					<div className="flex flex-col space-y-4">
						<button
							type="submit"
							className="flex items-center justify-center gap-2 bg-green-500 hover:bg-green-600 text-white py-2 px-4 rounded-lg text-lg"
						>
							<FaArrowRight /> LogIn
						</button>
						<a
							href="/register"
							className="flex items-center justify-center gap-2 bg-gray-800 hover:bg-gray-900 text-white py-2 px-4 rounded-lg text-lg"
						>
							<FaUserPlus /> Register
						</a>
					</div>
				</form>

				<div className="mt-6 space-y-3">
					<a
						href="/auth/google"
						className="flex items-center justify-center gap-2 bg-red-500 hover:bg-red-600 text-white py-2 px-4 rounded-lg"
					>
						<FaGoogle /> LogIn with Google
					</a>
					<a
						href="/auth/facebook"
						className="flex items-center justify-center gap-2 bg-blue-600 hover:bg-blue-700 text-white py-2 px-4 rounded-lg"
					>
						<FaFacebook /> LogIn with Facebook
					</a>
				</div>
			</div>
		</div>
	);
}
