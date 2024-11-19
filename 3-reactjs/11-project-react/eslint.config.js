import js from '@eslint/js';
// Importa as configurações padrão para ESLint.

import globals from 'globals';
// Importa definições de variáveis globais baseadas em ambientes, como 'browser' ou 'node'.

import react from 'eslint-plugin-react';
// Importa o plugin ESLint para React, que fornece regras específicas para o desenvolvimento em React.

import reactHooks from 'eslint-plugin-react-hooks';
// Importa o plugin ESLint para verificar regras específicas relacionadas aos hooks do React.

import reactRefresh from 'eslint-plugin-react-refresh';
// Importa o plugin ESLint para garantir boas práticas ao usar o React Refresh (Hot Module Replacement - HMR).

export default [
  { ignores: ['dist'] },
  // Configuração para ignorar a pasta 'dist' ao rodar o ESLint.

  {
    files: ['**/*.{js,jsx}'],
    // Aplica as configurações a todos os arquivos com as extensões .js e .jsx.

    languageOptions: {
      ecmaVersion: 2020,
      // Define a versão do ECMAScript para 2020, permitindo o uso de recursos modernos de JavaScript.

      globals: globals.browser,
      // Define variáveis globais padrão para o ambiente de navegador.

      parserOptions: {
        ecmaVersion: 'latest',
        // Especifica o parser para usar a versão mais recente do ECMAScript.

        ecmaFeatures: { jsx: true },
        // Habilita o suporte para JSX.

        sourceType: 'module',
        // Define o tipo de fonte como 'module', permitindo a importação/exportação de módulos ES6.
      },
    },

    settings: { react: { version: '18.3' } },
    // Configura a versão do React que está sendo utilizada no projeto (18.3).

    plugins: {
      react,
      // Ativa o plugin do React.

      'react-hooks': reactHooks,
      // Ativa o plugin para validação de regras dos hooks.

      'react-refresh': reactRefresh,
      // Ativa o plugin para validação de práticas relacionadas ao React Refresh.
    },

    rules: {
      ...js.configs.recommended.rules,
      // Aplica as regras recomendadas do ESLint.

      ...react.configs.recommended.rules,
      // Aplica as regras recomendadas do plugin do React.

      ...react.configs['jsx-runtime'].rules,
      // Aplica as regras específicas para o JSX runtime.

      ...reactHooks.configs.recommended.rules,
      // Aplica as regras recomendadas para hooks do React.

      'react/jsx-no-target-blank': 'off',
      // Desativa a regra que impede o uso de `_blank` sem `rel="noopener noreferrer"`.

      'react-refresh/only-export-components': [
        'warn',
        { allowConstantExport: true },
        // Emite um aviso para exportar apenas componentes no React Refresh.
        // Permite exportar constantes para otimização e modularidade.
      ],
    },
  },
];