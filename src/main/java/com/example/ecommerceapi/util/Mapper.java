package com.example.ecommerceapi.util;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.modelmapper.ModelMapper;

public class Mapper {
	private static ModelMapper mapper = new ModelMapper();

	public static <S, T> T map(S source, Class<T> targetClass) {
		return mapper.map(source, targetClass);
	}

	public static <S, T> List<T> mapList(List<S> source, Class<T> targetClass) {
		return source.stream().map(element -> mapper.map(element, targetClass)).collect(Collectors.toList());
	}
	
	public static <T> List<T> iterableToList(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}
}
