import { useEffect, useState } from "react";
import { useParams, useNavigate } from "react-router-dom";
import "./CourseDetails.css";
import Constants from "../../assets/constants/Constants";
import Navbar from "../../navbar/Navbar";
import CourseDetailsValues from "../../models/CourseDetails";


function CourseDetails() {
  const { name } = useParams<{ name: string }>();
  const [courses, setCourses] = useState<CourseDetailsValues>();
  const [activeCard, setActiveCard] = useState<string | null>(null);
  const navigate = useNavigate();

  useEffect(() => {
    fetch(Constants.getCourseDetailsUrl + name)
      .then((response) => response.json())
      .then((course) => {
        const formattedCourses = {
          details: course.description,
          video: course.video,
          tips: course.tips,
          challenges: course.challenges,
        };
        setCourses(formattedCourses);
      })
      .catch((error) => console.error("Error fetching courses:", error));
  }, [name]);

  const toggleCard = (cardName: string) => {
    if (activeCard === cardName) {
      setActiveCard(null);
    } else {
      setActiveCard(cardName);
    }
  };


  const goToChallengeDetails = (challengeName: string) => {
    navigate(`/challenge/${challengeName}`);
  };

  return (
    <div className="container">
      <Navbar />
      <h1>{name}</h1>
      <div className="row">
        <div
          className={`${activeCard === "Description" ? "col-12" : "col-sm-6"}`}
        >
          <div
            className={`card ${
              activeCard === "Description" ? "active-card" : ""
            }`}
            onClick={() => toggleCard("Description")}
          >
            <div className="card-body text-black">
              <h5 className="card-name">Description</h5>
              <p className="card-text text-black">{courses?.details}</p>
            </div>
          </div>
        </div>
        <div className={`${activeCard === "Tips" ? "col-12" : "col-sm-6"}`}>
          <div
            className={`card ${activeCard === "Tips" ? "active-card" : ""}`}
            onClick={() => toggleCard("Tips")}
          >
            <div className="card-body text-black">
              <h5 className="card-name">Tips</h5>
              <p className="card-text text-black">{courses?.tips}</p>
            </div>
          </div>
        </div>
        <div className={`${activeCard === "Video" ? "col-12" : "col-sm-6"}`}>
          <div
            className={`card ${activeCard === "Video" ? "active-card" : ""}`}
            onClick={() => toggleCard("Video")}
          >
            <div className="card-body text-black">
              <h5 className="card-name">Video</h5>
              <p className="card-text text-black">{courses?.video}</p>
            </div>
          </div>
        </div>
        <div
          className={`${activeCard === "Challanges" ? "col-12" : "col-sm-6"}`}
        >
          <div
            className={`card ${
              activeCard === "Challanges" ? "active-card" : ""
            }`}
            onClick={() => toggleCard("Challanges")}
          >
            <div className="card-body text-black">
              <h5 className="card-name">Challenges</h5>
              {courses?.challenges && courses.challenges.length > 0 ? (
                <ul>
                  {courses.challenges.map((challenge) => (
                    <li
                      key={challenge}
                      className="challenge-item"
                      onClick={() => goToChallengeDetails(challenge)}
                      style={{ cursor: "pointer" }}
                    >
                      {challenge}
                    </li>
                  ))}
                </ul>
              ) : (
                <p>No challenges available</p>
              )}
            </div>
          </div>
        </div>
      </div>
    </div>
  );
}

export default CourseDetails;
