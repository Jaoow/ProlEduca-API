package com.jaoow.proleducaapi.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank; // Para validações a nível de entidade, se necessário
import jakarta.validation.constraints.Pattern; // Para validações a nível de entidade, se necessário
import jakarta.validation.constraints.Size; // Para validações a nível de entidade, se necessário
import lombok.Getter;
import lombok.NoArgsConstructor; // Adicionar se não usar @RequiredArgsConstructor para tudo
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor // É uma boa prática ter um construtor sem argumentos para JPA
// @RequiredArgsConstructor // Pode ser removido se NoArgsConstructor e construtores explícitos forem usados
@Table(name = "school", uniqueConstraints = { // Adicionando constraint de unicidade para CNPJ se necessário
    @UniqueConstraint(columnNames = "cnpj")
})
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Usar IDENTITY é comum para auto incremento
    @Column(nullable = false)
    private Long id;

    @Column(unique = true, nullable = false, length = 100)
    private String slug;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(length = 500)
    private String description;

    @Column(length = 20) // Ajuste o tamanho conforme necessário
    private String phone;

    @Column(length = 255)
    private String email;

    @Column(length = 255)
    private String website;

    @Column(nullable = false, length = 500)
    private String logoUrl;

    @Embedded
    private Address address;

    // Novos campos
    @Column(unique = true, nullable = false, length = 18) // CNPJ: 14 dígitos + pontuação
    private String cnpj;

    @Column(nullable = false, length = 10) // "Publica" ou "Privada"
    private String type;

    @Column(nullable = false, length = 100) // Armazenar a senha HASHED
    private String password;

    // Relacionamentos
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Course> courses;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Testimony> testimonies;

    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<SchoolImage> schoolImages;

    // Construtor para quando você cria a partir do DTO (exemplo)
    public School(String slug, String name, String description, Address address, String phone, String email, String logoUrl, String website, String cnpj, String type, String password) {
        this.slug = slug;
        this.name = name;
        this.description = description;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.logoUrl = logoUrl;
        this.website = website;
        this.cnpj = cnpj;
        this.type = type;
        this.password = password; // LEMBRE-SE DE FAZER HASH ANTES DE SALVAR!
    }

    // Métodos de ciclo de vida JPA (ex: @PrePersist para hashear senha)
    // @PrePersist
    // public void prePersist() {
    //     if (this.password != null && !this.password.startsWith("$2a$")) { // Simples verificação se já é hash
    //         // this.password = bCryptPasswordEncoder.encode(this.password); // Injete o PasswordEncoder
    //     }
    // }
}