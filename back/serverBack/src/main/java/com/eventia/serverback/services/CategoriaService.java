package com.eventia.serverback.services;

import com.eventia.serverback.models.Categoria;
import com.eventia.serverback.repositories.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CategoriaService {
    private final CategoriaRepository categoriaRepository;

    public CategoriaService(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void handleCategorias(int idEvento, ArrayList<Categoria> categorias) {
        for (Categoria categoria : categorias) {
            int catId = searchCategoria(categoria.getCat_nombre());
            if (catId != -1) {
                categoriaRepository.addEventoCategoria(idEvento, catId);

            } else {
                catId = categoriaRepository.addCategoria(categoria);
                categoriaRepository.addEventoCategoria(idEvento, catId);
            }
        }
    }

    public int searchCategoria(String catNombre) {
        return categoriaRepository.searchCategoria(catNombre);
    }

    public ArrayList<Categoria> getCategorias() {
        return categoriaRepository.getCategorias();
    }

    public String deleteEventoCategoria(int idEvento) {
        return categoriaRepository.deleteEventoCategoria(idEvento);
    }
}
