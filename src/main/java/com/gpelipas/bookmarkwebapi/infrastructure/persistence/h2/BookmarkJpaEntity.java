package com.gpelipas.bookmarkwebapi.infrastructure.persistence.h2;

import java.io.Serializable;
import java.time.ZonedDateTime;

import org.hibernate.annotations.TimeZoneStorage;
import org.hibernate.annotations.TimeZoneStorageType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bookmarks")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookmarkJpaEntity implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)    
    private String id;

    private String name;
    private String url;

    @TimeZoneStorage(TimeZoneStorageType.NATIVE)
    private ZonedDateTime dateSaved;

    private Boolean active;

}
