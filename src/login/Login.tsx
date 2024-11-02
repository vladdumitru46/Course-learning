import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import Constants from "../assets/constants/Constants";

function Login() {
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [errorMessage, setErrorMessage] = useState("");
  const navigate = useNavigate();

  const handleSubmit = async (e: any) => {
    e.preventDefault();

    const loginData = {
      usernameOrEmail: email,
      password: password,
    };

    try {
      const response = await fetch(Constants.logInUrl, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(loginData),
      });

      if (response.ok) {
        const token = await response.text();
        localStorage.setItem("token", token);
        navigate("/");
      } else {
        const error = await response.text();
        setErrorMessage(error);
        console.error("Error:", error);
      }
    } catch (error) {
      console.error("Error during fetch:", error);
      setErrorMessage("An unexpected error occurred");
    }
  };

  return (
    <form onSubmit={handleSubmit}>
      <div className="mb-3">
        <label className="form-label">Email address</label>
        <input
          type="text"
          className="form-control"
          id="exampleInputEmail1"
          aria-describedby="emailHelp"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
        />
        <div id="emailHelp" className="form-text">
          We'll never share your email with anyone else.
        </div>
      </div>
      <div className="mb-3">
        <label className="form-label">Password</label>
        <input
          type="password"
          className="form-control"
          id="exampleInputPassword1"
          value={password}
          onChange={(e) => setPassword(e.target.value)}
        />
      </div>
      <div className="mb-3 form-check">
        <input
          type="checkbox"
          className="form-check-input"
          id="exampleCheck1"
        />
        <label className="form-check-label">Check me out</label>
      </div>
      <button type="submit" className="btn btn-primary">
        Submit
      </button>
      {errorMessage && (
        <div className="alert alert-danger mt-3">{errorMessage}</div>
      )}
    </form>
  );
}

export default Login;
