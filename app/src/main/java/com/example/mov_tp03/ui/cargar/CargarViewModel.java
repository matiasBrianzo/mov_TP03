package com.example.mov_tp03.ui.cargar;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import  static  com.example.mov_tp03.MainActivity.*;

import android.app.Application;

import com.example.mov_tp03.Modelo.Producto;
import com.example.mov_tp03.databinding.FragmentCargarBinding;

public class CargarViewModel extends AndroidViewModel {

    private  MutableLiveData<String> MsjError;
    private  MutableLiveData<String> MsjExito;
    private FragmentCargarBinding binding;

    public CargarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<String> getMsjError() {
    if(MsjError == null)
    {
        MsjError= new MutableLiveData<String>();
    }
        return MsjError;
    }
    public LiveData<String> getMsjExito() {
        if(MsjExito == null)
        {
            MsjExito= new MutableLiveData<String>();
        }
        return MsjExito;
    }

    public void AddProducto(String pCodigo, String pDesc, String pPrec)
    {
        boolean validar =ValidarDatos(pCodigo,pDesc,pPrec);
       if(validar){
           double pre= Double.parseDouble(pPrec);
           lstProducto.add(new Producto(pCodigo,pDesc,pre));
           MsjExito.setValue("Carga Correcta");
       }

    }
    private boolean ValidarDatos(String pCodigo, String pDesc, String pPrec)
    {
       boolean validar= true;
       StringBuilder sb= new StringBuilder();
        try{
           double pre= Double.parseDouble(pPrec);
           validar= !lstProducto.contains(new Producto(pCodigo,pDesc,pre));

        } catch (NumberFormatException e) {
            sb.append("El valor ingresado para precio es incorrecto");

        }
        if(!validar){
            sb.append("Ya existe un CODIGO ingresado");
            validar=false;
        }
        if (pDesc.isBlank())
        {
            sb.append("El valor ingresado para DESCRIPCION es incorrecto");
            validar=false;
        }
        if(!validar){
            MsjError.setValue(sb.toString());
        }

        return validar;

    }
}