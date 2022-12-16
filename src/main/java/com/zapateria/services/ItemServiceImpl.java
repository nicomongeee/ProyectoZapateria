package com.zapateria.services;

import com.zapateria.domain.Item;
import static com.zapateria.services.ItemService.listaItems;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

    @Override
    public List<Item> getItems() {
        return listaItems;
    }

    @Override
    public Item getItem(Item item) {
        for (Item t : listaItems) {
            if (Objects.equals(t.getIdArticulo(), item.getIdArticulo())) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void save(Item item) {
        boolean existe = false;
        for (Item t : listaItems) {
            if (Objects.equals(t.getIdArticulo(), item.getIdArticulo())) {
                if (t.getCantidad() < item.getExistencias()) {
                    t.setCantidad(t.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }
    }

    @Override
    public void delete(Item item) {
        var posicion = -1;
        var existe = false;
        for (Item t : listaItems) {
            ++posicion;
            if (Objects.equals(t.getIdArticulo(), item.getIdArticulo())) {
                existe = true;
                break;
            }
        }
        if (existe) {
            listaItems.remove(posicion);
        }
    }

  /* @Override
    public void delete(Item item) {
        boolean existe = false;
        for (Item t : listaItems) {
            if (Objects.equals(t.getIdArticulo(), item.getIdArticulo())) {
                if (t.getCantidad() < item.getExistencias()) {
                    t.setCantidad(t.getCantidad() + 1);
                }
                existe = true;
                break;
            }
        }
        if (!existe) {
            item.setCantidad(1);
            listaItems.add(item);
        }
    }*/

    @Override
    public void actualiza(Item item) {
        for (Item i : listaItems) {
            if (Objects.equals(i.getIdArticulo(), item.getIdArticulo())) {
                i.setCantidad(item.getCantidad());
                break;
            }
        }
    }

    @Override
    public void facturar() {
        for (Item i : listaItems) {

        }
        listaItems.clear();
    }

}
