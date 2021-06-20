package com.example.ecommerceapi.util;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.ecommerceapi.dto.ColorDTO;
import com.example.ecommerceapi.dto.ProductDTO;
import com.example.ecommerceapi.entity.ColorsEntity;
import com.example.ecommerceapi.entity.ProductEntity;
import com.example.ecommerceapi.entity.TagsEntity;

public class Mapper {
	public static <T> List<T> iterableToList(Iterable<T> iterable) {
		return StreamSupport.stream(iterable.spliterator(), false).collect(Collectors.toList());
	}

	public static List<ProductEntity> mapListDTOToListEntity(List<ProductDTO> listDTO) {
		List<ProductEntity> listEntity = new ArrayList<>();

		for (ProductDTO dto : listDTO) {
			ProductEntity entity = mapDTOToEntity(dto);
			listEntity.add(entity);
		}

		return listEntity;
	}

	public static ProductEntity mapDTOToEntity(ProductDTO dto) {
		ProductEntity entity = new ProductEntity();
		entity.setId(dto.getId());
		entity.setCategory(dto.getCategory());
		entity.setFabric(dto.getFabric());
		entity.setName(dto.getName());
		entity.setOriginalPrice(dto.getOriginalPrice());

		ColorDTO colorDTO = dto.getColors();
		ColorsEntity colorsEntity = new ColorsEntity();
		colorsEntity.setProductId(dto.getId());
		colorsEntity.setBlack(colorDTO.isBlack());
		colorsEntity.setBlue(colorDTO.isBlue());
		colorsEntity.setWhite(colorDTO.isWhite());
		colorsEntity.setProduct(entity);

		entity.setColors(colorsEntity);

		List<TagsEntity> tagsList = new ArrayList<>();
		if (dto.getTags() != null) {
			for (String tag : dto.getTags()) {
				TagsEntity tagsEntity = new TagsEntity();
				tagsEntity.setProductId(entity.getId());
				tagsEntity.setTag(tag);

				tagsList.add(tagsEntity);
			}
		}

		entity.setTags(tagsList);
		return entity;
	}

	public static List<ProductDTO> mapListEntityToListDTO(List<ProductEntity> listEntity) {
		List<ProductDTO> listDTO = new ArrayList<>();

		for (ProductEntity entity : listEntity) {
			ProductDTO dto = mapEntityToDTO(entity);
			listDTO.add(dto);
		}

		return listDTO;
	}

	public static ProductDTO mapEntityToDTO(ProductEntity entity) {
		ProductDTO dto = new ProductDTO();
		dto.setId(entity.getId());
		dto.setCategory(entity.getCategory());
		dto.setFabric(entity.getFabric());
		dto.setName(entity.getName());
		dto.setOriginalPrice(entity.getOriginalPrice());

		ColorsEntity colorsEntity = entity.getColors();
		ColorDTO colorDTO = new ColorDTO();
		if (colorsEntity != null) {
			colorDTO.setBlack(colorsEntity.isBlack());
			colorDTO.setBlue(colorsEntity.isBlue());
			colorDTO.setWhite(colorsEntity.isWhite());
		}

		dto.setColors(colorDTO);

		List<String> tagsList = new ArrayList<>();
		for (TagsEntity tag : entity.getTags()) {
			tagsList.add(tag.getTag());
		}

		dto.setTags(tagsList);
		return dto;
	}
}
