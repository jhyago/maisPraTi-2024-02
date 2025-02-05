import React, { useState } from "react";
import api from "../services/api";

const AddCourse = () => {
  const [nome, setNome] = useState("");
  const [success, setSuccess] = useState(false);

  const handleAddCourse = async (e) => {
    e.preventDefault();
    try {
      await api.post("/cursos", { nome });
      setSuccess(true);
      setNome("");
    } catch (error) {
      console.error("Erro ao cadastrar curso", error);
    }
  };

  return (
    <div className="container">
      <h2>Cadastro de Curso</h2>
      {success && <p className="text-success">Curso cadastrado com sucesso!</p>}
      <form onSubmit={handleAddCourse}>
        <div className="mb-3">
          <label>Nome do Curso</label>
          <input
            type="text"
            className="form-control"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            required
          />
        </div>
        <button className="btn btn-primary">Adicionar Curso</button>
      </form>
    </div>
  );
};

export default AddCourse;
