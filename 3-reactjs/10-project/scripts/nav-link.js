// Adiciona um evento de clique ao link com o ID 'linkKits'
document.getElementById('linkKits').addEventListener('click', function (event) {
    // Previne o comportamento padrão do link, que seria recarregar a página ou navegar para outro local
    event.preventDefault();
    // Faz a rolagem suave para o elemento com ID 'kits'
    document.getElementById('kits').scrollIntoView({
        behavior: 'smooth' // Define o comportamento da rolagem como suave
    });
});

// Adiciona um evento de clique ao link com o ID 'linkOndeComprar'
document.getElementById('linkOndeComprar').addEventListener('click', function (event) {
    // Previne o comportamento padrão do link
    event.preventDefault();
    // Faz a rolagem suave para o elemento com ID 'onde-comprar'
    document.getElementById('onde-comprar').scrollIntoView({
        behavior: 'smooth' // Define o comportamento da rolagem como suave
    });
});

// Adiciona um evento de clique ao link com o ID 'linkFaleComigo'
document.getElementById('linkFaleComigo').addEventListener('click', function (event) {
    // Previne o comportamento padrão do link
    event.preventDefault();
    // Faz a rolagem suave para o elemento com ID 'fale-comigo'
    document.getElementById('fale-comigo').scrollIntoView({
        behavior: 'smooth' // Define o comportamento da rolagem como suave
    });
});
