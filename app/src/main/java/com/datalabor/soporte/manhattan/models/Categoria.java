package com.datalabor.soporte.manhattan.models;

import java.io.Serializable;

/**
 * Created by EnriqueLap on 18/10/2017.
 */

public class Categoria implements Serializable {

    private String _name;
    private int _id;
    private int _idcategoria;
    private int _resId;
    private String _desc;

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public int get_idcategoria() {
        return _idcategoria;
    }

    public void set_idcategoria(int _idcategoria) {
        this._idcategoria = _idcategoria;
    }

    public String get_desc() {
        return _desc;
    }

    public void set_desc(String _desc) {
        this._desc = _desc;
    }

    public int get_resId() {
        return _resId;
    }

    public void set_resId(int _resId) {
        this._resId = _resId;
    }
}
