// App
import React from 'react';
import { BrowserRouter as Router, Route, Link, Routes } from 'react-router-dom';
import Counter from './Counter';
import BackgroundColorChanger from './BackgroundColorChanger';
import TodoList from './TodoList';
import Timer from './Timer';
import NameFilter from './NameFilter';
import RegistrationForm from './RegistrationForm';
import DataFetcher from './DataFetcher';
import ImageGallery from './ImageGallery';
import CountdownTimer from './CountdownTimer';
import Tabs from './Tabs';

function App() {
  return (
    <Router>
      <div>
        <h1>React Hooks Project Menu</h1>
        <nav>
          <ul>
            <li><Link to="/counter">Contador Simples</Link></li>
            <li><Link to="/background-color">Alteração de Cor de Fundo</Link></li>
            <li><Link to="/todo-list">Lista de Tarefas</Link></li>
            <li><Link to="/timer">Temporizador com useEffect</Link></li>
            <li><Link to="/name-filter">Filtro de Lista</Link></li>
            <li><Link to="/registration-form">Formulário de Registro Simples</Link></li>
            <li><Link to="/data-fetcher">Aplicação de Requisição de Dados Simples</Link></li>
            <li><Link to="/image-gallery">Galeria de Imagens</Link></li>
            <li><Link to="/countdown-timer">Timer com Intervalo e Alerta</Link></li>
            <li><Link to="/tabs">Componentes com Tabs Navegáveis</Link></li>
          </ul>
        </nav>
        <Routes>
          <Route path="/counter" element={<Counter />} />
          <Route path="/background-color" element={<BackgroundColorChanger />} />
          <Route path="/todo-list" element={<TodoList />} />
          <Route path="/timer" element={<Timer />} />
          <Route path="/name-filter" element={<NameFilter />} />
          <Route path="/registration-form" element={<RegistrationForm />} />
          <Route path="/data-fetcher" element={<DataFetcher />} />
          <Route path="/image-gallery" element={<ImageGallery />} />
          <Route path="/countdown-timer" element={<CountdownTimer />} />
          <Route path="/tabs" element={<Tabs />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;

// Counter.
import React, { useState } from 'react';

function Counter() {
  const [count, setCount] = useState(0);

  return (
    <div>
      <h2>Contador Simples</h2>
      <p>Valor: {count}</p>
      <button onClick={() => setCount(count + 1)}>Incrementar</button>
      <button onClick={() => setCount(count > 0 ? count - 1 : 0)}>Decrementar</button>
    </div>
  );
}

export default Counter;

// BackgroundColorChanger
import React, { useState, useEffect } from 'react';

function BackgroundColorChanger() {
  const [color, setColor] = useState('#ffffff');

  useEffect(() => {
    document.body.style.backgroundColor = color;
  }, [color]);

  const generateRandomColor = () => {
    const randomColor = `#${Math.floor(Math.random() * 16777215).toString(16)}`;
    setColor(randomColor);
  };

  return (
    <div>
      <h2>Alteração de Cor de Fundo</h2>
      <button onClick={generateRandomColor}>Mudar Cor</button>
    </div>
  );
}

export default BackgroundColorChanger;

// TodoList
import React, { useState } from 'react';

function TodoList() {
  const [tasks, setTasks] = useState([]);
  const [task, setTask] = useState('');

  const addTask = () => {
    if (task.trim()) {
      setTasks([...tasks, { text: task, completed: false }]);
      setTask('');
    }
  };

  const toggleTask = (index) => {
    const newTasks = tasks.map((t, i) =>
      i === index ? { ...t, completed: !t.completed } : t
    );
    setTasks(newTasks);
  };

  const removeTask = (index) => {
    setTasks(tasks.filter((_, i) => i !== index));
  };

  return (
    <div>
      <h2>Lista de Tarefas</h2>
      <input
        type="text"
        value={task}
        onChange={(e) => setTask(e.target.value)}
        placeholder="Nova tarefa"
      />
      <button onClick={addTask}>Adicionar</button>
      <ul>
        {tasks.map((t, index) => (
          <li key={index} style={{ textDecoration: t.completed ? 'line-through' : 'none' }}>
            <span onClick={() => toggleTask(index)}>{t.text}</span>
            <button onClick={() => removeTask(index)}>Remover</button>
          </li>
        ))}
      </ul>
    </div>
  );
}

export default TodoList;

// Timer
import React, { useState, useEffect } from 'react';

function Timer() {
  const [seconds, setSeconds] = useState(0);
  const [isActive, setIsActive] = useState(false);

  useEffect(() => {
    let interval = null;
    if (isActive) {
      interval = setInterval(() => {
        setSeconds((s) => s + 1);
      }, 1000);
    } else if (!isActive && seconds !== 0) {
      clearInterval(interval);
    }
    return () => clearInterval(interval);
  }, [isActive, seconds]);

  return (
    <div>
      <h2>Temporizador com useEffect</h2>
      <p>Tempo: {seconds}s</p>
      <button onClick={() => setIsActive(!isActive)}>{isActive ? 'Pausar' : 'Iniciar'}</button>
      <button onClick={() => { setIsActive(false); setSeconds(0); }}>Reiniciar</button>
    </div>
  );
}

export default Timer;

// NameFilter
import React, { useState } from 'react';

function NameFilter() {
  const [filter, setFilter] = useState('');
  const names = ['Alice', 'Bob', 'Charlie', 'David', 'Eve'];

  const filteredNames = names.filter((name) =>
    name.toLowerCase().includes(filter.toLowerCase())
  );

  return (
    <div>
      <h2>Filtro de Lista</h2>
      <input
        type="text"
        value={filter}
        onChange={(e) => setFilter(e.target.value)}
        placeholder="Filtrar nomes"
      />
      <ul>
        {filteredNames.map((name, index) => (
          <li key={index}>{name}</li>
        ))}
      </ul>
    </div>
  );
}

export default NameFilter;

// RegistrationForm
import React, { useState } from 'react';

function RegistrationForm() {
  const [name, setName] = useState('');
  const [email, setEmail] = useState('');
  const [password, setPassword] = useState('');
  const [submitted, setSubmitted] = useState(false);

  const handleSubmit = (e) => {
    e.preventDefault();
    if (name && email && password) {
      setSubmitted(true);
    }
  };

  return (
    <div>
      <h2>Formulário de Registro Simples</h2>
      {submitted ? (
        <p>Bem-vindo/a, {name}!</p>
      ) : (
        <form onSubmit={handleSubmit}>
          <input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            placeholder="Nome"
          />
          <input
            type="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            placeholder="Email"
          />
          <input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            placeholder="Senha"
          />
          <button type="submit">Registrar</button>
        </form>
      )}
    </div>
  );
}

export default RegistrationForm;

// DataFetcher
import React, { useState, useEffect } from 'react';

function DataFetcher() {
  const [posts, setPosts] = useState([]);
  const [loading, setLoading] = useState(true);

  const fetchData = async () => {
    setLoading(true);
    const response = await fetch('https://jsonplaceholder.typicode.com/posts');
    const data = await responseon();
    setPosts(data);
    setLoading(false);
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <div>
      <h2>Aplicação de Requisição de Dados Simples</h2>
      {loading ? (
        <p>Carregando...</p>
      ) : (
        <ul>
          {posts.map((post) => (
            <li key={post.id}>{post.title}</li>
          ))}
        </ul>
      )}
      <button onClick={fetchData}>Recarregar Dados</button>
    </div>
  );
}

export default DataFetcher;

// ImageGallery
import React, { useState } from 'react';

function ImageGallery() {
  const images = [
    'https://via.placeholder.com/150/0000FF',
    'https://via.placeholder.com/150/FF0000',
    'https://via.placeholder.com/150/00FF00'
  ];
  const [selectedImage, setSelectedImage] = useState(null);

  return (
    <div>
      <h2>Galeria de Imagens</h2>
      <div>
        {images.map((src, index) => (
          <img
            key={index}
            src={src}
            alt={`Imagem ${index + 1}`}
            style={{ width: '100px', margin: '5px', cursor: 'pointer' }}
            onClick={() => setSelectedImage(src)}
          />
        ))}
      </div>
      {selectedImage && (
        <div>
          <h3>Visualização Ampliada</h3>
          <img src={selectedImage} alt="Visualização" style={{ width: '300px' }} />
          <button onClick={() => setSelectedImage(null)}>Fechar</button>
        </div>
      )}
    </div>
  );
}

export default ImageGallery;

// CountdownTimer
import React, { useState, useEffect } from 'react';

function CountdownTimer() {
  const [time, setTime] = useState(0);
  const [isActive, setIsActive] = useState(false);

  useEffect(() => {
    let interval = null;
    if (isActive && time > 0) {
      interval = setInterval(() => {
        setTime((t) => t - 1);
      }, 1000);
    } else if (time === 0) {
      clearInterval(interval);
      if (isActive) alert('Tempo acabou!');
    }
    return () => clearInterval(interval);
  }, [isActive, time]);

  return (
    <div>
      <h2>Timer com Intervalo e Alerta</h2>
      <input
        type="number"
        value={time}
        onChange={(e) => setTime(Number(e.target.value))}
        placeholder="Segundos"
      />
      <button onClick={() => setIsActive(true)}>Iniciar</button>
      <button onClick={() => setIsActive(false)}>Pausar</button>
      <button onClick={() => { setIsActive(false); setTime(0); }}>Reiniciar</button>
      <p>Tempo restante: {time}s</p>
    </div>
  );
}

export default CountdownTimer;

// Tabs
import React, { useState } from 'react';

function Tabs() {
  const [activeTab, setActiveTab] = useState('sobre');

  return (
    <div>
      <h2>Componentes com Tabs Navegáveis</h2>
      <div>
        <button onClick={() => setActiveTab('sobre')} style={{ fontWeight: activeTab === 'sobre' ? 'bold' : 'normal' }}>Sobre</button>
        <button onClick={() => setActiveTab('contato')} style={{ fontWeight: activeTab === 'contato' ? 'bold' : 'normal' }}>Contato</button>
      </div>
      <div>
        {activeTab === 'sobre' && <p>Esta é a aba Sobre.</p>}
        {activeTab === 'contato' && <p>Esta é a aba Contato.</p>}
      </div>
    </div>
  );
}

export default Tabs;