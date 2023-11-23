package com.example.accessoriesmanagement.Mapper;

import org.modelmapper.ModelMapper;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Mappers {
    private static final ModelMapper modelMapper = new ModelMapper();

    public static <S, D> D convertToDto(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static <S, D> List<D> mapperEntityToDto(List<S> sourceList, Class<D> destinationType) {
        if (sourceList == null) {
            return Collections.emptyList();
        }

        return sourceList.stream()
                .map(source -> modelMapper.map(source, destinationType))
                .collect(Collectors.toList());
    }

    public static <S, D> D convertToEntity(S source, Class<D> destinationType) {
        return modelMapper.map(source, destinationType);
    }

    public static <S, D> List<D> mapperDtoToEntity(List<S> sourceList, Class<D> destinationType) {
        if (sourceList == null) {
            return Collections.emptyList();
        }

        return sourceList.stream()
                .map(source -> modelMapper.map(source, destinationType))
                .collect(Collectors.toList());
    }
}
