/** @type {import('tailwindcss').Config} */
// Declaração de tipo para configurar o TailwindCSS com suporte a autocomplete e validação.
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
    // Define os caminhos para os arquivos onde as classes do Tailwind serão aplicadas.
    // Inclui todos os arquivos JavaScript, TypeScript, JSX e TSX dentro da pasta src.
  ],
  darkMode: 'class', // ou 'media' se preferir
  // Define o modo escuro. Pode ser ativado manualmente por uma classe ('class') ou baseado no sistema do usuário ('media').
  theme: {
    extend: {
      // Estende a configuração padrão do Tailwind com novas definições.
      colors: {
        // Define cores personalizadas para o projeto.
        
        // Cores padrão:
        'fundo': '#F6F1ED', // Cor de fundo principal.
        'branco': '#ffffff', // Branco puro.
        'preto': '#000000', // Preto puro.
        'cinza': '#verde', // ERRO: '#verde' não é válido, deve ser um código hexadecimal.
        'vermelho': '#881212', // Vermelho escuro para elementos de destaque ou erro.
        'verde1': '#1B1E18', // Um tom escuro de verde.
        'verde2': '#121410', // Outro tom de verde mais escuro.
        'creme1': '#d7d1cb', // Um tom claro de creme.
        'creme2': '#b9b3ac', // Um tom médio de creme.

        // Cores para o modo escuro:
        'fundo-dark': '#121410', // Cor de fundo para o modo escuro.
        'branco-dark': '#F6F1ED', // Branco alternativo para modo escuro.
        'preto-dark': '#ffffff', // Preto substituído por branco no modo escuro.
        'cinza-dark': '#a0a0a0', // Cinza para textos ou elementos no modo escuro.
        'vermelho-dark': '#730f0f', // Vermelho mais escuro para modo escuro.
        'verde1-dark': '#f9f9f9', // Um tom claro de verde no modo escuro.
        'verde2-dark': '#1B1E18', // Outro tom escuro de verde no modo escuro.
        'creme1-dark': '#b9b3ac', // Tom de creme para o modo escuro.
        'creme2-dark': '#d7d1cb', // Outro tom de creme para o modo escuro.
      },
      fontFamily: {
        // Define famílias de fontes personalizadas.
        sans: ['Karma', 'sans-serif'], // Fonte 'Karma' como padrão para texto sans-serif.
        serif: ['Older Dictator', 'serif'], // Fonte 'Older Dictator' como padrão para texto serifado.
      },
    },
  },
  plugins: [],
  // Define plugins adicionais, se necessário. Atualmente, está vazio.
}