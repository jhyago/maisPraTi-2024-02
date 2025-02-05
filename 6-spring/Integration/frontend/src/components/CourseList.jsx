import React, { useEffect, useState } from "react";
import api from "../services/api";

const CourseList = () => {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    api.get("/cursos").then((response) => {
      setCourses(response.data);
    });
  }, []);

  return (
    <div className="container">
      <h2>Lista de Cursos</h2>
      <ul className="list-group">
        {courses.map((course) => (
          <li key={course.id} className="list-group-item">
            {course.nome}
          </li>
        ))}
      </ul>
    </div>
  );
};

export default CourseList;