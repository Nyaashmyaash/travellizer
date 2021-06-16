package com.nyash.travellizer.model.entity.base;

import com.nyash.travellizer.model.entity.person.User;
import lombok.Setter;

import java.time.LocalDateTime;

/**
 * Base class for all business entities
 *
 * @author Nyash
 */
@Setter
public class AbstractEntity {

    /**
     * Unique entity identifier
     */
    private int id;

    /**
     * Timestamp of entity creation
     */
    private LocalDateTime createdAt;

    /**
     * Timestamp of entity last modification
     */
    private LocalDateTime modifiedAt;

    /**
     * Person who created specific entity
     */
    private User createdBy;

    /**
     * Last person who modified entity
     */
    private User modifiedBy;

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getModifiedAt() {
        return modifiedAt;
    }

    public User getCreatedBy() {
        return createdBy;
    }

    public User getModifiedBy() {
        return modifiedBy;
    }
}
