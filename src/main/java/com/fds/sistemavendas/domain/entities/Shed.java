package com.fds.sistemavendas.domain.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity(name = "tb_shed")
public class Shed {
    @Id
    private Long id;
    @OneToMany(cascade = CascadeType.ALL)
    private List<StorageItem> itemList;

    public Shed(Long id, List<StorageItem> itemList) {
        this.id = id;
        this.itemList = itemList;
    }

    protected Shed(){}

    public Long getId() {
        return id;
    }

    public List<StorageItem> getItemList() {
        return itemList;
    }
}