import React, { useState } from "react";
import api from "../services/api";

const Register = () => {
  const [nome, setNome] = useState("");
  const [success, setSuccess] = useState(false);

  const handleRegister = async (e) => {
    e.preventDefault();
    try {
      await api.post("/usuarios", { nome });
      setSuccess(true);
      setNome("");
    } catch (error) {
      console.error("Erro ao cadastrar usuário", error);
    }
  };

  return (
    <div className="container">
      <h2>Cadastro de Usuário</h2>
      {success && <p className="text-success">Usuário cadastrado com sucesso!</p>}
      <form onSubmit={handleRegister}>
        <div className="mb-3">
          <label>Nome</label>
          <input
            type="text"
            className="form-control"
            value={nome}
            onChange={(e) => setNome(e.target.value)}
            required
          />
        </div>
        <button className="btn btn-primary">Cadastrar</button>
      </form>
    </div>
  );
};

export default Register;
