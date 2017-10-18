package com.datalabor.soporte.manhattan.models;

/**
 * Created by Enrique on 17/10/2017.
 */
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by soporte on 15/08/2017.
 */

public class Product implements Serializable
{
    private int _id;
    private String _name;
    private int _resId;
    private String _description;
    private String _desc_complete;
    private String _nota;

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String get_name() {
        return _name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_resId() {
        return _resId;
    }

    public void set_resId(int _resId) {
        this._resId = _resId;
    }

    public String get_description() {
        return _description;
    }

    public void set_description(String _description) {
        this._description = _description;
    }

    public String get_desc_complete() {
        return _desc_complete;
    }

    public void set_desc_complete(String _desc_complete) {
        this._desc_complete = _desc_complete;
    }

    public String get_nota() {
        return _nota;
    }

    public void set_nota(String _nota) {
        this._nota = _nota;
    }
}

