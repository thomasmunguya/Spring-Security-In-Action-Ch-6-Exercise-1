package com.theschool.ssiach6ex1.model.authority;

/**
 * Represents an authority type.
 *
 * @see com.theschool.ssiach6ex1.model.authority.Authority
 * @author Thomas Munguya
 */
public enum AuthorityType {

    /**
     * Defines an authority that allows a user to create resources.
     */
    CREATE,

    /**
     * Defines an authority that allows a user to read resources.
     */
    READ,

    /**
     * Defines an authority that allows a user to update resources.
     */
    UPDATE,

    /**
     * Defines an authority that allows a user to delete resources.
     */
    DELETE
}
