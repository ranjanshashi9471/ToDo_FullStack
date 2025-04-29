export default function Login(props: { isLogged: boolean; setLoggedin: Function }) {
	const { isLogged, setLoggedin } = props;
	return (<div class="container-fluid">
    <div class="row mb-3">
        <div class="col-md-6 me-auto ms-auto">
            <div class="card signin-card">
                <h1 class="mt-3">LogIn</h1>
                <div class="card-body">
                    <!-- Makes POST request to /login route -->
                    <form action="/login" method="POST">
                        <div class="form-group">
                            <input type="text" class="line text-center" name="username" placeholder="Enter Your Email / Username.">
                        </div>
                        <div class="form-group">
                            <input type="password" class="line mt-5 text-center" name="password" placeholder="Enter Your Password.">
                        </div>
                        <button type="submit" class="btn btn-outline-success btn-lg download-button"><i
                                    class="fa-solid fa-arrow-right-to-bracket"></i> LogIn
                        </button>
                        <a class="btn btn-outline-light btn-lg download-button" href="/register"><i
                                    class="fa-solid fa-user-plus"></i> Register</a>
                    </form>

                    <a class="btn btn-block btn-social btn-google mb-3" href="/auth/google" role="button">
                        <i class="fab fa-google"></i>
                        LogIn with Google
                    </a>

                    <a class="btn btn-block btn-social btn-facebook mb-3" href="/auth/facebook" role="button">
                        <i class="fab fa-facebook"></i>
                        LogIn with Facebook
                    </a>

                </div>
            </div>
        </div>
    </div>
</div>);
}
