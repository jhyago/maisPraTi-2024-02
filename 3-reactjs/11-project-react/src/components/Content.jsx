import { useState } from 'react'
import Modal from 'react-modal'
import "./ModalStyle.css"
import { FaFileDownload } from "react-icons/fa"
import { MdOutlineClose } from "react-icons/md"

Modal.setAppElement("#root")

export const Content = () => {
    const [modalIsOpen, setModalIsOpen] = useState(false)

    const openModal = () => {
        setModalIsOpen(true)
    }

    const closeModal = () => {
        setModalIsOpen(false)
    }

    return (
        <div className="relative sm:mb-0 mb-24">
            {/* Contêiner principal com posicionamento relativo. Margem inferior variável: `mb-24` para telas menores, `sm:mb-0` para maiores. */}
            
            <div>
                {/* Banner para telas ultrawide */}
                <div className="absolute -z-10 hidden xl:brightness-80 md:brightness-50 2xl:block">
                    <img
                        className="min-h-[800px] w-full object-cover"
                        src="./Banner-Background_Wide.webp"
                        alt="Banner Background"
                    />
                    {/* Imagem para telas ultrawide. 
                        - Oculta em telas menores que 2xl (`hidden`).
                        - Aparece com brilho ajustado para telas maiores (`brightness-80` em xl e `brightness-50` em md). 
                        - Propriedades: largura total (`w-full`), altura mínima (`min-h-[800px]`), e preenchimento proporcional (`object-cover`). */}
                </div>
    
                {/* Banner para telas grandes */}
                <div className="absolute -z-10 hidden 2xl:hidden md:brightness-50 md:block">
                    <img
                        className="md:min-h-[1080px] xl:min-h-[800px] max-h-[800px] object-cover"
                        src="./Banner-Background.webp"
                        alt="Banner Background"
                    />
                    {/* Imagem para telas grandes.
                        - Mostra-se apenas em telas entre md e xl (`hidden` para outras).
                        - Brilho ajustado para md.
                        - Altura variável: `min-h` e `max-h`. */}
                </div>
    
                {/* Banner para telas menores */}
                <div className="absolute -z-10 brightness-50 md:hidden">
                    <img
                        className="w-full h-[1000px] object-cover"
                        src="./Banner-Background_Mobile.webp"
                        alt="Banner Background Mobile"
                    />
                    {/* Imagem para telas menores que md.
                        - Largura total (`w-full`) e altura fixa de 1000px. 
                        - Preenchimento proporcional (`object-cover`) e brilho reduzido (`brightness-50`). */}
                </div>
            </div>
    
            <div className="flex flex-col-reverse items-center justify-between pt-40 p-6 md:p-12 md:pt-40 lg:p-32 lg:pt-40 lg:flex-row text-left">
                {/* Contêiner do conteúdo principal.
                    - No mobile: itens alinhados ao centro em coluna reversa.
                    - No desktop: disposição em linha (`lg:flex-row`).
                    - Espaçamento e preenchimento variáveis por breakpoint. */}
    
                <div className="lg:w-1/2">
                    {/* Texto ocupa metade do espaço horizontal em telas grandes. */}
                    
                    <h1 className="font-sans font-bold text-branco text-5xl sm:text-7xl lg:text-7xl xl:text-5xl 2xl:text-7xl">
                        Relatos de um <br /> Vampiro na Guerra
                    </h1>
                    {/* Título do livro. Tamanhos ajustados conforme o tamanho da tela. */}
    
                    <p className="text-branco mt-4 lg:mt-6 text-sm md:text-base lg:text-xl 2xl:text-2xl">
                        Hermina, uma jovem obscurecida pela monotonia de sua vida,
                        tem sua existência transformada ao se deparar com um encontro extraordinário. 
                        {/* Descrição introdutória sobre o livro. */}
                        
                        <br />
                        <br />
                        Ambientado na Hungria, nas vésperas da Primeira Guerra, Mina se vê diante de um dilema que irá desencadear uma reação em cadeia irreversível. 
                        {/* História e contexto do livro. */}
                    </p>
    
                    <button
                        className="text-branco mt-4 lg:mt-6"
                        onClick={openModal}
                    >
                        Leia os primeiros capítulos de graça
                    </button>
                    {/* Botão para abrir o modal com os primeiros capítulos do livro. */}
                </div>
    
                <img
                    className="w-4/5 sm:w-3/5 max-w-[550px] h-auto mb-4 lg:ml-12 2xl:w-full"
                    src="./Book-Kit.webp"
                    alt="Book Kit"
                />
                {/* Imagem do livro ou kit, ajustável conforme o tamanho da tela. 
                    - `max-w-[550px]` garante um tamanho máximo.
                    - `lg:ml-12` adiciona margem esquerda em telas grandes. */}
            </div>
    
            <Modal
                isOpen={modalIsOpen}
                onRequestClose={closeModal}
                contentLabel="Leitura dos Primeiros Capítulos"
                className="modal"
                overlayClassName="overlay"
            >
                {/* Modal para exibir os primeiros capítulos. 
                    - Propriedade `isOpen` controla a visibilidade.
                    - `onRequestClose` define o comportamento ao fechar o modal. */}
                
                <button
                    className="p-4 text-2xl rounded-xl close-button"
                    onClick={closeModal}
                >
                    <MdOutlineClose />
                </button>
                {/* Botão para fechar o modal. Representado pelo ícone `MdOutlineClose`. */}
    
                <a
                    href="/Primeiros-Capítulos.pdf"
                    download="Primeiros-Capítulos.pdf"
                    className="download-button p-4 text-2xl rounded-xl"
                >
                    <FaFileDownload />
                </a>
                {/* Link para download do PDF com os primeiros capítulos. Representado pelo ícone `FaFileDownload`. */}
    
                <iframe
                    className="w-full h-full"
                    src="./Primeiros-Capítulos.pdf"
                    title="Primeiros Capítulos"
                />
                {/* Iframe para exibição do conteúdo do PDF diretamente no modal. 
                    - Ocupa toda a largura e altura do modal (`w-full h-full`). */}
            </Modal>
        </div>
    );
    
}