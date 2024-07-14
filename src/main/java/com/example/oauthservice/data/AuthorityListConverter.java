package com.example.oauthservice.data;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Converter
public class AuthorityListConverter implements AttributeConverter<List<GrantedAuthority>, String> {

    @Override
    public String convertToDatabaseColumn(List<GrantedAuthority> attribute) {
        if (attribute == null) {
            return null;
        }
        return attribute.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    @Override
    public List<GrantedAuthority> convertToEntityAttribute(String dbData) {
        if (dbData == null || dbData.isEmpty()) {
            return null;
        }
        return Arrays.stream(dbData.split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());
    }
}