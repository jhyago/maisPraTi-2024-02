import React, { useState } from "react";
import { BrowserRouter as Router, Route, Routes, Navigate } from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import Login from "./components/Login";
import Register from "./components/Register";
import UserList from "./components/UserList";
import CourseList from "./components/CourseList";
import AddCourse from "./components/AddCourse";
import Enroll from "./components/Enroll";

function App() {
  const [authenticated, setAuthenticated] = useState(false);

  return (
    <Router>
      <div className="container mt-4">
        <Routes>
          <Route path="/" element={<Login onLogin={() => setAuthenticated(true)} />} />
          <Route path="/register" element={<Register />} />

          {authenticated ? (
            <>
              <Route path="/usuarios" element={<UserList />} />
              <Route path="/cursos" element={<CourseList />} />
              <Route path="/add-course" element={<AddCourse />} />
              <Route path="/enroll" element={<Enroll />} />
            </>
          ) : (

            <Route path="*" element={<Navigate to="/" />} />
          )}
        </Routes>
      </div>
    </Router>
  );
}

export default App;