package com.mercadolibre.crm.Data.Persistence;


import android.content.Context;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import net.sqlcipher.database.SQLiteDatabase;

/**
 * Created by fpardo on 9/17/15.
 */
public class AppSchema extends OrmLiteSqliteOpenHelper {

    private int version = 1;

    public AppSchema(Context context, String database) {
        super(context, database, null, 1, "password");
    }

    public AppSchema(Context context, String database, int version) {
        super(context, database, null, version, "password");
    }

    public AppSchema(Context context) {
        super(context.getApplicationContext(), "AppDB", null, 1, "password");
    }

    public AppSchema(Context context, String databaseName,
                     SQLiteDatabase.CursorFactory factory, int databaseVersion) {

        super(context, databaseName, factory, databaseVersion, "password");
        // TODO Auto-generated constructor stub
        SQLiteDatabase.loadLibs(context);

    }

    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        try {
            /**
             * Add all the entities to be created here.
             * Example:
             * TableUtils.createTable(connectionSource, entityClass.class);
             */
            //TableUtils.createTable(connectionSource, BaseRequestCache.class);
            //TableUtils.createTable(connectionSource, AtributoDto.class);

        } catch (Exception e) {
            /**
             * It should be an SQLException, but since there is no code to fire the exception is not possible to use it.
             * UPDATE: Now it can be an SQL Exception.
             */
            throw new RuntimeException(e);
        }

    }

    /**
     * If the database in connectionSource requires it (oldVersion<newVersion), upgrades it.
     */
    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {
        database.beginTransaction();
        try {
            /**
             * Add all the update statements here.
             * Example:
             * single column:
             * db.execSQL("ALTER TABLE `table` ADD COLUMN column DATATYPE;");
             * Full table creation:
             * TableUtils.createTable(connectionSource, entityClass.class);
             * Full table deletion:
             * TableUtils.dropTable(connectionSource, entityClass.class);
             */
            //if(oldVersion == 1)db.execSQL("ALTER TABLE PortalProfile ADD COLUMN "+PortalProfile.NATIONAL_ID +" TEXT;");
            //db.execSQL("ALTER TABLE Inmueble ADD COLUMN "+Inmueble.PORTAL_URL +" TEXT;");
            //db.execSQL("ALTER TABLE Inmueble ADD COLUMN "+Inmueble.CURRENCY_ID +" TEXT;");
            //db.execSQL("ALTER TABLE Inmueble ADD COLUMN "+Inmueble.TIPO_PROPIEDAD_STRING + " TEXT");
            //db.execSQL("ALTER TABLE PortalProfile ADD COLUMN phone_number TEXT;");
            //TableUtils.createTable(connectionSource, UserFavorites.class);
            //TableUtils.createTable(connectionSource, PortalProfile.class);
            database.setTransactionSuccessful();
        } catch (Exception e) {
            if(e!=null)e.printStackTrace();
        } finally {
            database.endTransaction();
        }
    }


    @Override
    public void close() {
        super.close();

        /**
         * Set all DAOs to null to close the database.
         * Example:
         * setEntityDao(null);
         */
    }
}
