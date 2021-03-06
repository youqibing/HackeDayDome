package greendao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.Property;
import de.greenrobot.dao.internal.DaoConfig;

import greendao.Goods;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table GOODS.
*/
public class GoodsDao extends AbstractDao<Goods, Long> {

    public static final String TABLENAME = "GOODS";

    /**
     * Properties of entity Goods.<br/>
     * Can be used for QueryBuilder and for referencing column names.
    */
    public static class Properties {
        public final static Property Goods_id = new Property(0, Long.class, "goods_id", true, "GOODS_ID");
        public final static Property Goods_rank = new Property(1, Integer.class, "goods_rank", false, "GOODS_RANK");
        public final static Property Goods_home_type = new Property(2, Integer.class, "goods_home_type", false, "GOODS_HOME_TYPE");
        public final static Property Goods_name = new Property(3, String.class, "goods_name", false, "GOODS_NAME");
        public final static Property Goods_detail = new Property(4, String.class, "goods_detail", false, "GOODS_DETAIL");
        public final static Property Goods_user_avatar = new Property(5, String.class, "goods_user_avatar", false, "GOODS_USER_AVATAR");
        public final static Property Goods_image_url = new Property(6, String.class, "goods_image_url", false, "GOODS_IMAGE_URL");
        public final static Property Goods_favorites_num = new Property(7, Integer.class, "goods_favorites_num", false, "GOODS_FAVORITES_NUM");
        public final static Property Goods_comment_num = new Property(8, Integer.class, "goods_comment_num", false, "GOODS_COMMENT_NUM");
        public final static Property Goods_user_cert_info = new Property(9, String.class, "goods_user_cert_info", false, "GOODS_USER_CERT_INFO");
        public final static Property Goods_user_nickname = new Property(10, String.class, "goods_user_nickname", false, "GOODS_USER_NICKNAME");
        public final static Property Goods_price = new Property(11, Integer.class, "goods_price", false, "GOODS_PRICE");
        public final static Property Goods_user_id = new Property(12, Integer.class, "goods_user_id", false, "GOODS_USER_ID");
        public final static Property Goods_release_time = new Property(13, String.class, "goods_release_time", false, "GOODS_RELEASE_TIME");
        public final static Property Goods_class_id = new Property(14, Integer.class, "goods_class_id", false, "GOODS_CLASS_ID");
        public final static Property Goods_trade_place_id = new Property(15, Integer.class, "goods_trade_place_id", false, "GOODS_TRADE_PLACE_ID");
    };


    public GoodsDao(DaoConfig config) {
        super(config);
    }
    
    public GoodsDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
    }

    /** Creates the underlying database table. */
    public static void createTable(SQLiteDatabase db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "'GOODS' (" + //
                "'GOODS_ID' INTEGER PRIMARY KEY ," + // 0: goods_id
                "'GOODS_RANK' INTEGER," + // 1: goods_rank
                "'GOODS_HOME_TYPE' INTEGER," + // 2: goods_home_type
                "'GOODS_NAME' TEXT," + // 3: goods_name
                "'GOODS_DETAIL' TEXT," + // 4: goods_detail
                "'GOODS_USER_AVATAR' TEXT," + // 5: goods_user_avatar
                "'GOODS_IMAGE_URL' TEXT," + // 6: goods_image_url
                "'GOODS_FAVORITES_NUM' INTEGER," + // 7: goods_favorites_num
                "'GOODS_COMMENT_NUM' INTEGER," + // 8: goods_comment_num
                "'GOODS_USER_CERT_INFO' TEXT," + // 9: goods_user_cert_info
                "'GOODS_USER_NICKNAME' TEXT," + // 10: goods_user_nickname
                "'GOODS_PRICE' INTEGER," + // 11: goods_price
                "'GOODS_USER_ID' INTEGER," + // 12: goods_user_id
                "'GOODS_RELEASE_TIME' TEXT," + // 13: goods_release_time
                "'GOODS_CLASS_ID' INTEGER," + // 14: goods_class_id
                "'GOODS_TRADE_PLACE_ID' INTEGER);"); // 15: goods_trade_place_id
    }

    /** Drops the underlying database table. */
    public static void dropTable(SQLiteDatabase db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "'GOODS'";
        db.execSQL(sql);
    }

    /** @inheritdoc */
    @Override
    protected void bindValues(SQLiteStatement stmt, Goods entity) {
        stmt.clearBindings();
 
        Long goods_id = entity.getGoods_id();
        if (goods_id != null) {
            stmt.bindLong(1, goods_id);
        }
 
        Integer goods_rank = entity.getGoods_rank();
        if (goods_rank != null) {
            stmt.bindLong(2, goods_rank);
        }
 
        Integer goods_home_type = entity.getGoods_home_type();
        if (goods_home_type != null) {
            stmt.bindLong(3, goods_home_type);
        }
 
        String goods_name = entity.getGoods_name();
        if (goods_name != null) {
            stmt.bindString(4, goods_name);
        }
 
        String goods_detail = entity.getGoods_detail();
        if (goods_detail != null) {
            stmt.bindString(5, goods_detail);
        }
 
        String goods_user_avatar = entity.getGoods_user_avatar();
        if (goods_user_avatar != null) {
            stmt.bindString(6, goods_user_avatar);
        }
 
        String goods_image_url = entity.getGoods_image_url();
        if (goods_image_url != null) {
            stmt.bindString(7, goods_image_url);
        }
 
        Integer goods_favorites_num = entity.getGoods_favorites_num();
        if (goods_favorites_num != null) {
            stmt.bindLong(8, goods_favorites_num);
        }
 
        Integer goods_comment_num = entity.getGoods_comment_num();
        if (goods_comment_num != null) {
            stmt.bindLong(9, goods_comment_num);
        }
 
        String goods_user_cert_info = entity.getGoods_user_cert_info();
        if (goods_user_cert_info != null) {
            stmt.bindString(10, goods_user_cert_info);
        }
 
        String goods_user_nickname = entity.getGoods_user_nickname();
        if (goods_user_nickname != null) {
            stmt.bindString(11, goods_user_nickname);
        }
 
        Integer goods_price = entity.getGoods_price();
        if (goods_price != null) {
            stmt.bindLong(12, goods_price);
        }
 
        Integer goods_user_id = entity.getGoods_user_id();
        if (goods_user_id != null) {
            stmt.bindLong(13, goods_user_id);
        }
 
        String goods_release_time = entity.getGoods_release_time();
        if (goods_release_time != null) {
            stmt.bindString(14, goods_release_time);
        }
 
        Integer goods_class_id = entity.getGoods_class_id();
        if (goods_class_id != null) {
            stmt.bindLong(15, goods_class_id);
        }
 
        Integer goods_trade_place_id = entity.getGoods_trade_place_id();
        if (goods_trade_place_id != null) {
            stmt.bindLong(16, goods_trade_place_id);
        }
    }

    /** @inheritdoc */
    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    /** @inheritdoc */
    @Override
    public Goods readEntity(Cursor cursor, int offset) {
        Goods entity = new Goods( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // goods_id
            cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1), // goods_rank
            cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2), // goods_home_type
            cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3), // goods_name
            cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4), // goods_detail
            cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5), // goods_user_avatar
            cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6), // goods_image_url
            cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7), // goods_favorites_num
            cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8), // goods_comment_num
            cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9), // goods_user_cert_info
            cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10), // goods_user_nickname
            cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11), // goods_price
            cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12), // goods_user_id
            cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13), // goods_release_time
            cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14), // goods_class_id
            cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15) // goods_trade_place_id
        );
        return entity;
    }
     
    /** @inheritdoc */
    @Override
    public void readEntity(Cursor cursor, Goods entity, int offset) {
        entity.setGoods_id(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setGoods_rank(cursor.isNull(offset + 1) ? null : cursor.getInt(offset + 1));
        entity.setGoods_home_type(cursor.isNull(offset + 2) ? null : cursor.getInt(offset + 2));
        entity.setGoods_name(cursor.isNull(offset + 3) ? null : cursor.getString(offset + 3));
        entity.setGoods_detail(cursor.isNull(offset + 4) ? null : cursor.getString(offset + 4));
        entity.setGoods_user_avatar(cursor.isNull(offset + 5) ? null : cursor.getString(offset + 5));
        entity.setGoods_image_url(cursor.isNull(offset + 6) ? null : cursor.getString(offset + 6));
        entity.setGoods_favorites_num(cursor.isNull(offset + 7) ? null : cursor.getInt(offset + 7));
        entity.setGoods_comment_num(cursor.isNull(offset + 8) ? null : cursor.getInt(offset + 8));
        entity.setGoods_user_cert_info(cursor.isNull(offset + 9) ? null : cursor.getString(offset + 9));
        entity.setGoods_user_nickname(cursor.isNull(offset + 10) ? null : cursor.getString(offset + 10));
        entity.setGoods_price(cursor.isNull(offset + 11) ? null : cursor.getInt(offset + 11));
        entity.setGoods_user_id(cursor.isNull(offset + 12) ? null : cursor.getInt(offset + 12));
        entity.setGoods_release_time(cursor.isNull(offset + 13) ? null : cursor.getString(offset + 13));
        entity.setGoods_class_id(cursor.isNull(offset + 14) ? null : cursor.getInt(offset + 14));
        entity.setGoods_trade_place_id(cursor.isNull(offset + 15) ? null : cursor.getInt(offset + 15));
     }
    
    /** @inheritdoc */
    @Override
    protected Long updateKeyAfterInsert(Goods entity, long rowId) {
        entity.setGoods_id(rowId);
        return rowId;
    }
    
    /** @inheritdoc */
    @Override
    public Long getKey(Goods entity) {
        if(entity != null) {
            return entity.getGoods_id();
        } else {
            return null;
        }
    }

    /** @inheritdoc */
    @Override    
    protected boolean isEntityUpdateable() {
        return true;
    }
    
}
