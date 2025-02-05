import React, { useState, useEffect } from "react";
import api from "../services/api";

const Enroll = () => {
  const [usuarios, setUsuarios] = useState([]);
  const [cursos, setCursos] = useState([]);
  const [selectedUser, setSelectedUser] = useState("");
  const [selectedCourse, setSelectedCourse] = useState("");
  const [success, setSuccess] = useState(false);

  useEffect(() => {
    api.get("/usuarios").then((response) => setUsuarios(response.data));
    api.get("/cursos").then((response) => setCursos(response.data));
  }, []);

  const handleEnroll = async (e) => {
    e.preventDefault();
    try {
      await api.post(`/usuarios/${selectedUser}/matricular/${selectedCourse}`);
      setSuccess(true);
    } catch (error) {
      console.error("Erro ao matricular usuário", error);
    }
  };

  return (
    <div className="container">
      <h2>Matrícula em Curso</h2>
      {success && <p className="text-success">Usuário matriculado com sucesso!</p>}
      <form onSubmit={handleEnroll}>
        <div className="mb-3">
          <label>Usuário</label>
          <select className="form-control" onChange={(e) => setSelectedUser(e.target.value)}>
            <option value="">Selecione</option>
            {usuarios.map((user) => (
              <option key={user.id} value={user.id}>{user.nome}</option>
            ))}
          </select>
        </div>
        <div className="mb-3">
          <label>Curso</label>
          <select className="form-control" onChange={(e) => setSelectedCourse(e.target.value)}>
            <option value="">Selecione</option>
            {cursos.map((course) => (
              <option key={course.id} value={course.id}>{course.nome}</option>
            ))}
          </select>
        </div>
        <button className="btn btn-primary">Matricular</button>
      </form>
    </div>
  );
};

export default Enroll;
