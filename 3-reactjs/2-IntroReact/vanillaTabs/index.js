const content = [ // Array de conteúdo para cada aba
    [
      "React é extremamente popular", // Primeira aba: motivos para usar React
      "Facilita a criação de interfaces de usuário complexas e interativas",
      "É poderoso e flexível",
      "Possui um ecossistema muito ativo e versátil"
    ],
    [
      "Componentes, JSX e Props", // Segunda aba: principais recursos do React
      "Estado",
      "Hooks (ex.: useEffect())",
      "Renderização dinâmica"
    ],
    [
      "Página oficial (react.dev)", // Terceira aba: recursos para aprendizado do React
      "Next.js (Framework Fullstack)",
      "React Native (construa aplicativos móveis nativos com React)"
    ]
  ];
  
  const btnWhyReact = document.getElementById("btn-why-react"); // Botão para a aba "Por que React"
  const btnCoreFeature = document.getElementById("btn-core-features"); // Botão para a aba "Recursos principais"
  const btnResources = document.getElementById("btn-resources"); // Botão para a aba "Recursos"
  const tabContent = document.getElementById("tab-content"); // Área onde o conteúdo da aba será exibido
  
  function displayContent(items) { // Função para exibir o conteúdo da aba selecionada
    const list = document.createElement("ul"); // Cria um elemento <ul> para a lista
    list.innerHTML = items.map(item => `<li>${item}</li>`).join(""); // Constrói o conteúdo da lista usando map e join
    tabContent.innerHTML = ""; // Limpa o conteúdo existente em tabContent
    tabContent.append(list); // Adiciona a nova lista ao conteúdo da aba
  }
  
  function highlightButton(btn) { // Função para destacar o botão da aba ativa
    [btnWhyReact, btnCoreFeature, btnResources].forEach(button => button.classList.remove("active")); // Remove a classe "active" de todos os botões
    btn.classList.add("active"); // Adiciona a classe "active" ao botão clicado
  }
  
  function handleClick(event) { // Função para lidar com o evento de clique em um botão de aba
    const buttonMap = { // Mapeia os IDs dos botões para índices do array de conteúdo
      "btn-why-react": 0,
      "btn-core-features": 1,
      "btn-resources": 2
    };
    highlightButton(event.target); // Chama a função para destacar o botão clicado
    displayContent(content[buttonMap[event.target.id]]); // Exibe o conteúdo correspondente à aba clicada
  }
  
  displayContent(content[0]); // Exibe o conteúdo inicial da primeira aba
  
  // Adiciona eventos de clique a cada botão de aba, vinculando a função handleClick a cada um deles
  [btnWhyReact, btnCoreFeature, btnResources].forEach(btn => btn.addEventListener("click", handleClick));
  