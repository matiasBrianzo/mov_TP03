package com.example.mov_tp03.ui.listar;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import  static com.example.mov_tp03.MainActivity.*;

import com.example.mov_tp03.Modelo.Producto;

import java.util.ArrayList;

public class ListarViewModel extends ViewModel {

    private  MutableLiveData<ArrayList<Producto>> mLista;

    public LiveData<ArrayList<Producto>> getMLista() {
        if(mLista == null)
        {
            mLista= new MutableLiveData<>();
        }
        return mLista;
    }

    public void CargarLista()
    {
        mLista.setValue(lstProducto);
    }
}