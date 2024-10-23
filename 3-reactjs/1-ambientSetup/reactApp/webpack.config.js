// Importa o módulo 'path' do Node.js, que ajuda a trabalhar com caminhos de arquivos e diretórios
const path = require('path')

// Importa o plugin 'html-webpack-plugin', que vai gerar um arquivo HTML e injetar automaticamente o bundle JavaScript nele
const HtmlWebPackPlugin = require('html-webpack-plugin')

module.exports = {
    // Define o arquivo de entrada para o Webpack, que será o ponto de partida da aplicação
    entry: './index.js',
    
    // Define o local e nome do arquivo de saída, onde o código transpilado e agrupado será salvo
    output: {
        // path.resolve resolve o caminho absoluto até o diretório 'dist', onde o bundle será gerado
        path: path.resolve(__dirname, 'dist'),
        
        // O arquivo de saída será nomeado 'bundle.js'
        filename: 'bundle.js',
    },

    // Configura os módulos e regras para lidar com diferentes tipos de arquivos
    module: {
        rules: [
            {
                // Aplica esta regra a todos os arquivos que terminam em .js ou .jsx
                test: /\.(js|jsx)$/,
                
                // Exclui a pasta 'node_modules' do processo de transpilar, pois normalmente os pacotes externos já estão prontos para uso
                exclude: /node_modules/,
                
                // Usa o 'babel-loader' para transformar o código JavaScript moderno em uma versão mais compatível com navegadores antigos
                use: {
                    loader: 'babel-loader'
                }
            },
            {
                // Aplica esta regra a arquivos .css
                test: /\.css$/,
                
                // Usa dois loaders:
                // 'style-loader' injeta os estilos CSS diretamente no HTML
                // 'css-loader' permite que o Webpack entenda arquivos CSS como módulos JavaScript
                use: ['style-loader', 'css-loader']
            }
        ]   
    },
    
    // Define quais extensões de arquivos o Webpack deve resolver automaticamente
    resolve: {
        // Permite que os arquivos .js e .jsx sejam resolvidos sem precisar especificar a extensão nas importações
        extensions: ['.js', '.jsx']
    },
    
    // Configura o servidor de desenvolvimento
    devServer: {
        // Define a pasta onde os arquivos estáticos serão servidos
        static: {
            directory: path.join(__dirname, 'public')
        },
        
        // Ativa a compressão de arquivos, melhorando o desempenho durante o desenvolvimento
        compress: true,
        
        // Abre automaticamente o navegador quando o servidor é iniciado
        open: true,
        
        // Ativa a atualização em tempo real (Hot Module Replacement) sempre que o código é alterado
        hot: true,
        
        // Define a porta que o servidor de desenvolvimento vai usar (nesse caso, 3000)
        port: 3000
    },
    
    // Configura os plugins que o Webpack vai usar
    plugins: [
        // O 'HtmlWebPackPlugin' vai gerar automaticamente um arquivo HTML baseado no template fornecido
        // e vai injetar o bundle gerado pelo Webpack dentro do arquivo HTML
        new HtmlWebPackPlugin({
            template: './public/index.html'
        })
    ]
}