package modelo;

import java.util.ArrayList;

public interface ComunicacionDB <T>{
	int grabarColumna(T objeto);
	int editarColumna(T objeto);
	ArrayList<T> buscarObjetos(T busqueda);
	ArrayList<T> obtenerColumnas();
}
