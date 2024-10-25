import { useState } from "react"; // Importa o hook useState para gerenciar o estado do componente
import "./styles.css"; // Importa o arquivo CSS para estilização

// Array de conteúdo para cada aba
const content = [
  {
    label: "Por que React?",
    items: [
      "React é extremamente popular",
      "Facilita a criação de interfaces de usuário complexas e interativas",
      "É poderoso e flexível",
      "Possui um ecossistema muito ativo e versátil"
    ]
  },
  {
    label: "Recursos Principais",
    items: [
      "Componentes, JSX e Props",
      "Estado",
      "Hooks (ex.: useEffect())",
      "Renderização dinâmica"
    ]
  },
  {
    label: "Recursos Relacionados",
    items: [
      "Página oficial (react.dev)",
      "Next.js (Framework Fullstack)",
      "React Native (construa aplicativos móveis nativos com React)"
    ]
  }
];

export default function App() { // Define o componente principal App
  const [activeContentIndex, setActiveContentIndex] = useState(0); // Estado para acompanhar a aba ativa (inicia na primeira aba)

  return (
    <div className="container"> {/* Contêiner principal do aplicativo */}
      <header> {/* Cabeçalho com logo e descrição */}
        <img src="react-logo-xs" alt="React logo" /> {/* Exibe o logotipo do React */}
        <div> {/* Contêiner para título e descrição */}
          <h1>React.js</h1> {/* Título */}
          <p>Usando a biblioteca React para renderizar a UI</p> {/* Descrição */}
        </div>
      </header>

      <div id="tabs"> {/* Contêiner para as abas e o conteúdo da aba ativa */}
        <menu> {/* Menu com botões para alternar entre abas */}
          {content.map((tab, index) => ( // Mapeia cada aba para criar o botão correspondente
            <button
              key={tab.label} // Define a key com base no rótulo da aba
              className={activeContentIndex === index ? "active" : ""} // Adiciona a classe "active" se a aba for a atual
              onClick={() => setActiveContentIndex(index)} // Altera o índice da aba ativa
            >
              {tab.label} {/* Exibe o rótulo da aba */}
            </button>
          ))}
        </menu>
        <div id="tab-content"> {/* Área de conteúdo das abas */}
          <ul> {/* Lista dos itens de conteúdo da aba ativa */}
            {content[activeContentIndex].items.map((item) => ( // Mapeia o conteúdo da aba ativa
              <li key={item}>{item}</li> // Exibe cada item da aba como um item de lista, com key para cada item único
            ))}
          </ul>
        </div>
      </div>
    </div>
  );
}