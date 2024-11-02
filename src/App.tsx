import {
  BrowserRouter as Router,
  Route,
  Routes,
  useNavigate,
} from "react-router-dom";
import { useEffect, useState } from "react";
import "./App.css";
import Courses from "./courses/Courses";
import Login from "./login/Login";
import Constants from "./assets/constants/Constants";
import CourseDetails from "./courses/details/CourseDetails";
import StartCourse from "./courses/StartCourse";
import Profile from "./profile/Profile";
import ChallengeDetails from "./courses/challenges/challengeDetails/ChallengeDetails";

function App() {
  const navigate = useNavigate();
  const [expired, setExpired] = useState<boolean | null>(null);
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const token = localStorage.getItem("token");

    if (!token) {
      navigate("/login");
      setLoading(false);
      return;
    }

    fetch(Constants.verifyToken + `${token}`)
      .then((response) => response.json())
      .then((data) => {
        setExpired(data);
        setLoading(false);
      })
      .catch((error) => {
        console.error("Error verifying token:", error);
        setLoading(false);
      });
  }, [navigate]);

  useEffect(() => {
    if (expired === true) {
      localStorage.removeItem("token");
      navigate("/login");
    }
  }, [expired, navigate]);

  if (loading) {
    return <div>Loading...</div>;
  }

  return (
    <Routes>
      <Route path="/login" element={<Login />} />
      <Route path="/" element={<Courses />} />
      <Route path="/course/:name" element={<CourseDetails />} />
      <Route path="/start-course" element={<StartCourse />} />
      <Route path="/profile" element={<Profile />} />
      <Route path="/challenge/:name" element={<ChallengeDetails />} />
    </Routes>
  );
}

export default function AppWrapper() {
  return (
    <Router>
      <App />
    </Router>
  );
}
