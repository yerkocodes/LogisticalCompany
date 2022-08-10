package com.logistiqal.util;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public abstract class Util {
	
//	Lo que hace, es construir un arreglo que mostrará una cantidad razonable de botones en el
//	paginador, dejando el número correspondiente a la página actual lo más centralizado posible
//	e impidiendo que aparezcan números de páginas inexistentes.
	public static List<Integer> getArrayPages(Integer paginaSolicitada, Integer totalPaginas) {

		Integer cantidadBotonesPaginador = 2;

		Integer inicioLista = (paginaSolicitada - cantidadBotonesPaginador) > 1 ? 1 : paginaSolicitada-cantidadBotonesPaginador;
		
		Integer finLista = (paginaSolicitada+cantidadBotonesPaginador) > totalPaginas ? totalPaginas : paginaSolicitada+cantidadBotonesPaginador;
		
		List<Integer> paginas = IntStream.rangeClosed(inicioLista, finLista).boxed().collect(Collectors.toList());

		return paginas;

	}

}
