package com.example.introduction.service;
// Define o pacote onde a classe está localizada, organizando o projeto.

import com.example.introduction.dto.ProfileDTO;
// Importa o DTO `ProfileDTO`, usado para transferir dados simplificados de um perfil.

import com.example.introduction.model.Profile;
// Importa a entidade `Profile`, que representa o modelo de dados de um perfil.

import com.example.introduction.repository.ProfileRepository;
// Importa o repositório `ProfileRepository`, que gerencia operações de banco de dados para a entidade `Profile`.

import org.springframework.beans.factory.annotation.Autowired;
// Importa a anotação `@Autowired`, usada para injeção automática de dependências pelo Spring.

import org.springframework.stereotype.Service;
// Importa a anotação `@Service`, usada para marcar a classe como um componente de serviço do Spring.

import java.util.Optional;
// Importa a classe `Optional`, usada para lidar com valores que podem ou não estar presentes.

@Service
// Marca a classe como um serviço do Spring, indicando que contém lógica de negócios.
public class ProfileService {

    @Autowired
    // Injeta automaticamente uma instância de `ProfileRepository` para operações relacionadas a perfis.
    private ProfileRepository profileRepository;

    public Profile saveProfile(Profile profile) {
        // Salva um perfil no banco de dados e retorna a entidade salva.

        return profileRepository.save(profile);
        // Chama o método `save` do repositório para persistir o perfil no banco.
    }

    public Optional<ProfileDTO> getProfile(Long id) {
        // Retorna um perfil pelo ID como um `Optional<ProfileDTO>`.

        return profileRepository.findById(id)
                // Busca o perfil pelo ID no repositório, retornando um `Optional<Profile>`.

                .map(profile -> new ProfileDTO(profile.getId(), profile.getBio()));
        // Se o perfil for encontrado, mapeia-o para um objeto `ProfileDTO` contendo o ID e a bio.
    }

    public Optional<ProfileDTO> updateProfile(Long id, Profile profile) {
        // Atualiza um perfil existente com base no ID.

        return profileRepository.findById(id)
                // Busca o perfil pelo ID no repositório.

                .map(existingProfile -> {
                    // Se o perfil for encontrado, executa a atualização.

                    existingProfile.setBio(profile.getBio());
                    // Atualiza o campo `bio` do perfil existente com o valor fornecido.

                    profileRepository.save(existingProfile);
                    // Salva o perfil atualizado no repositório.

                    return new ProfileDTO(existingProfile.getId(), existingProfile.getBio());
                    // Retorna um novo objeto `ProfileDTO` representando o perfil atualizado.
                });
    }

    public void deleteProfile(Long id) {
        // Deleta um perfil do banco de dados com base no ID fornecido.

        profileRepository.deleteById(id);
        // Chama o método `deleteById` do repositório para remover o perfil.
    }
}