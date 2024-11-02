import { useEffect, useState } from "react";
import { Route, Routes } from "react-router-dom";
import Tiles from "./tiles/Tiles";
import Navbar from "../navbar/Navbar";
import Constants from "../assets/constants/Constants";
import "./Course.css";
import TilesInterface from "../models/TilesInterface";


function Courses() {
  const [courses, setCourses] = useState<TilesInterface[]>([]);

  useEffect(() => {
    fetch(Constants.getCourseUrl)
      .then((response) => response.json())
      .then((data) => {
        const formattedCourses = data.map((course: any) => ({
          name: course.name,
          description: course.description,
        }));
        setCourses(formattedCourses);
      })
      .catch((error) => console.error("Error fetching courses:", error));
  }, []);

  return (
    <>
      <Navbar />
      <div className="container overflow-hidden text-center">
        <Routes>
          <Route
            path="/"
            element={
              <div className="row">
                {courses.map((course, index) => (
                  <Tiles
                    key={index}
                    name={course.name}
                    description={course.description}
                  />
                ))}
              </div>
            }
          />
        </Routes>
      </div>
    </>
  );
}

export default Courses;
