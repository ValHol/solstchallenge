package com.valhol.SolstCodeExam.dao;

import java.util.List;
import java.util.ArrayList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.SqlUtils;
import de.greenrobot.dao.internal.DaoConfig;

import com.valhol.SolstCodeExam.dao.ContactDetails;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "CONTACT_DETAILS".
*/
public class ContactDetailsDao extends AbstractDao<ContactDetails, Long> {

    public static final String TABLENAME = "CONTACT_DETAILS";

    /**
     * Properties of entity ContactDetails.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Id = new Property(0, Long.class, "id", true, "_id");
        public final static Property EmployeeId = new Property(1, Long.class, "employeeId", false, "EMPLOYEE_ID");
        public final static Property Favorite = new Property(2, Boolean.class, "favorite", false, "FAVORITE");
        public final static Property LargeImageURL = new Property(3, String.class, "largeImageURL", false, "LARGE_IMAGE_URL");
        public final static Property Email = new Property(4, String.class, "email", false, "EMAIL");
        public final static Property Website = new Property(5, String.class, "website", false, "WEBSITE");
        public final static Property AddressId = new Property(6, Long.class, "addressId", false, "ADDRESS_ID");
    };

    private DaoSession daoSession;


    public ContactDetailsDao(DaoConfig config) {
        super(config);
    }
    
    public ContactDetailsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"CONTACT_DETAILS\" (" + //
                "\"_id\" INTEGER PRIMARY KEY ," + // 0: id
                "\"EMPLOYEE_ID\" INTEGER UNIQUE ," + // 1: employeeId
                "\"FAVORITE\" INTEGER," + // 2: favorite
                "\"LARGE_IMAGE_URL\" TEXT," + // 3: largeImageURL
                "\"EMAIL\" TEXT," + // 4: email
                "\"WEBSITE\" TEXT," + // 5: website
                "\"ADDRESS_ID\" INTEGER);"); // 6: addressId
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"CONTACT_DETAILS\"";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, ContactDetails entity) {
        stmt.clearBindings();
 
        Long id = entity.getId();
        if (id != null) {
            stmt.bindLong(1, id);
        }
 
        Long employeeId = entity.getEmployeeId();
        if (employeeId != null) {
            stmt.bindLong(2, employeeId);
        }
 
        Boolean favorite = entity.getFavorite();
        if (favorite != null) {
            stmt.bindLong(3, favorite ? 1L: 0L);
        }
 
        String largeImageURL = entity.getLargeImageURL();
        if (largeImageURL != null) {
            stmt.bindString(4, largeImageURL);
        }
 
        String email = entity.getEmail();
        if (email != null) {
            stmt.bindString(5, email);
        }
 
        String website = entity.getWebsite();
        if (website != null) {
            stmt.bindString(6, website);
        }
 
        Long addressId = entity.getAddressId();
        if (addressId != null) {
            stmt.bindLong(7, addressId);
        }
    }

    @Override
    protected void attachEntity(ContactDetails entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public ContactDetails readEntity(Cursor cursor, int offset) {
        ContactDetails entity = new ContactDetails( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // id
            cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1), // employeeId
            cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0, // favorite
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // largeImageURL
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // email
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // website
            cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6) // addressId
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, ContactDetails entity, int offset) {
        entity.setId(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setEmployeeId(cursor.isNull(offset + 1) ? null : cursor.getLong(offset + 1));
        entity.setFavorite(cursor.isNull(offset + 2) ? null : cursor.getShort(offset + 2) != 0);
        entity.setLargeImageURL(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setEmail(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setWebsite(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setAddressId(cursor.isNull(offset + 6) ? null : cursor.getLong(offset + 6));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(ContactDetails entity, long rowId) {
        entity.setId(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(ContactDetails entity) {
        if(entity != null) {
            return entity.getId();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
    private String selectDeep;

    protected String getSelectDeep() {
        if (selectDeep == null) {
            StringBuilder builder = new StringBuilder("SELECT ");
            SqlUtils.appendColumns(builder, "T", getAllColumns());
            builder.append(',');
            SqlUtils.appendColumns(builder, "T0", daoSession.getAddressDao().getAllColumns());
            builder.append(" FROM CONTACT_DETAILS T");
            builder.append(" LEFT JOIN ADDRESS T0 ON T.\"ADDRESS_ID\"=T0.\"_id\"");
            builder.append(' ');
            selectDeep = builder.toString();
        }
        return selectDeep;
    }
    
    protected ContactDetails loadCurrentDeep(Cursor cursor, boolean lock) {
        ContactDetails entity = loadCurrent(cursor, 0, lock);
        int offset = getAllColumns().length;

        Address address = loadCurrentOther(daoSession.getAddressDao(), cursor, offset);
        entity.setAddress(address);

        return entity;    
    }

    public ContactDetails loadDeep(Long key) {
        assertSinglePk();
        if (key == null) {
            return null;
        }

        StringBuilder builder = new StringBuilder(getSelectDeep());
        builder.append("WHERE ");
        SqlUtils.appendColumnsEqValue(builder, "T", getPkColumns());
        String sql = builder.toString();
        
        String[] keyArray = new String[] { key.toString() };
        Cursor cursor = db.rawQuery(sql, keyArray);
        
        try {
            boolean available = cursor.moveToFirst();
            if (!available) {
                return null;
            } else if (!cursor.isLast()) {
                throw new IllegalStateException("Expected unique result, but count was " + cursor.getCount());
            }
            return loadCurrentDeep(cursor, true);
        } finally {
            cursor.close();
        }
    }
    
    /** Reads all available rows from the given cursor and returns a list of new ImageTO objects. */
    public List<ContactDetails> loadAllDeepFromCursor(Cursor cursor) {
        int count = cursor.getCount();
        List<ContactDetails> list = new ArrayList<ContactDetails>(count);
        
        if (cursor.moveToFirst()) {
            if (identityScope != null) {
                identityScope.lock();
                identityScope.reserveRoom(count);
            }
            try {
                do {
                    list.add(loadCurrentDeep(cursor, false));
                } while (cursor.moveToNext());
            } finally {
                if (identityScope != null) {
                    identityScope.unlock();
                }
            }
        }
        return list;
    }
    
    protected List<ContactDetails> loadDeepAllAndCloseCursor(Cursor cursor) {
        try {
            return loadAllDeepFromCursor(cursor);
        } finally {
            cursor.close();
        }
    }
    

    /** A raw-style query where you can pass any WHERE clause and arguments. */
    public List<ContactDetails> queryDeep(String where, String... selectionArg) {
        Cursor cursor = db.rawQuery(getSelectDeep() + where, selectionArg);
        return loadDeepAllAndCloseCursor(cursor);
    }
 
}
