package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class com_mds_ventasabpollo_models_ArticlesRealmProxy extends com.mds.ventasabpollo.models.Articles
    implements RealmObjectProxy, com_mds_ventasabpollo_models_ArticlesRealmProxyInterface {

    static final class ArticlesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long clave_articuloIndex;
        long familiaIndex;
        long sublineaIndex;
        long articuloIndex;
        long nombre_articuloIndex;
        long nombre_unidadIndex;
        long descripcion_extendidaIndex;
        long image_loadedIndex;
        long image_loaded_dateIndex;
        long temporal_flagIndex;
        long user_idIndex;

        ArticlesColumnInfo(OsSchemaInfo schemaInfo) {
            super(11);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Articles");
            this.clave_articuloIndex = addColumnDetails("clave_articulo", "clave_articulo", objectSchemaInfo);
            this.familiaIndex = addColumnDetails("familia", "familia", objectSchemaInfo);
            this.sublineaIndex = addColumnDetails("sublinea", "sublinea", objectSchemaInfo);
            this.articuloIndex = addColumnDetails("articulo", "articulo", objectSchemaInfo);
            this.nombre_articuloIndex = addColumnDetails("nombre_articulo", "nombre_articulo", objectSchemaInfo);
            this.nombre_unidadIndex = addColumnDetails("nombre_unidad", "nombre_unidad", objectSchemaInfo);
            this.descripcion_extendidaIndex = addColumnDetails("descripcion_extendida", "descripcion_extendida", objectSchemaInfo);
            this.image_loadedIndex = addColumnDetails("image_loaded", "image_loaded", objectSchemaInfo);
            this.image_loaded_dateIndex = addColumnDetails("image_loaded_date", "image_loaded_date", objectSchemaInfo);
            this.temporal_flagIndex = addColumnDetails("temporal_flag", "temporal_flag", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ArticlesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ArticlesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ArticlesColumnInfo src = (ArticlesColumnInfo) rawSrc;
            final ArticlesColumnInfo dst = (ArticlesColumnInfo) rawDst;
            dst.clave_articuloIndex = src.clave_articuloIndex;
            dst.familiaIndex = src.familiaIndex;
            dst.sublineaIndex = src.sublineaIndex;
            dst.articuloIndex = src.articuloIndex;
            dst.nombre_articuloIndex = src.nombre_articuloIndex;
            dst.nombre_unidadIndex = src.nombre_unidadIndex;
            dst.descripcion_extendidaIndex = src.descripcion_extendidaIndex;
            dst.image_loadedIndex = src.image_loadedIndex;
            dst.image_loaded_dateIndex = src.image_loaded_dateIndex;
            dst.temporal_flagIndex = src.temporal_flagIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ArticlesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Articles> proxyState;

    com_mds_ventasabpollo_models_ArticlesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ArticlesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Articles>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$clave_articulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clave_articuloIndex);
    }

    @Override
    public void realmSet$clave_articulo(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clave_articuloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clave_articuloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$familia() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.familiaIndex);
    }

    @Override
    public void realmSet$familia(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.familiaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.familiaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$sublinea() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.sublineaIndex);
    }

    @Override
    public void realmSet$sublinea(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sublineaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sublineaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$articulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.articuloIndex);
    }

    @Override
    public void realmSet$articulo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.articuloIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.articuloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.articuloIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.articuloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_articulo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_articuloIndex);
    }

    @Override
    public void realmSet$nombre_articulo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_articuloIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_articuloIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_articuloIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_articuloIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_unidad() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_unidadIndex);
    }

    @Override
    public void realmSet$nombre_unidad(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_unidadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_unidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_unidadIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_unidadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$descripcion_extendida() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descripcion_extendidaIndex);
    }

    @Override
    public void realmSet$descripcion_extendida(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descripcion_extendidaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descripcion_extendidaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descripcion_extendidaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descripcion_extendidaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$image_loaded() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.image_loadedIndex);
    }

    @Override
    public void realmSet$image_loaded(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.image_loadedIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.image_loadedIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$image_loaded_date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.image_loaded_dateIndex);
    }

    @Override
    public void realmSet$image_loaded_date(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.image_loaded_dateIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.image_loaded_dateIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.image_loaded_dateIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.image_loaded_dateIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$temporal_flag() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.temporal_flagIndex);
    }

    @Override
    public void realmSet$temporal_flag(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.temporal_flagIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.temporal_flagIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$user_id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.user_idIndex);
    }

    @Override
    public void realmSet$user_id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.user_idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.user_idIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Articles", 11, 0);
        builder.addPersistedProperty("clave_articulo", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("familia", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sublinea", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("articulo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_articulo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_unidad", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("descripcion_extendida", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("image_loaded", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("image_loaded_date", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("temporal_flag", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ArticlesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ArticlesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Articles";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Articles";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Articles createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Articles obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Articles.class, true, excludeFields);

        final com_mds_ventasabpollo_models_ArticlesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) obj;
        if (json.has("clave_articulo")) {
            if (json.isNull("clave_articulo")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
            } else {
                objProxy.realmSet$clave_articulo((int) json.getInt("clave_articulo"));
            }
        }
        if (json.has("familia")) {
            if (json.isNull("familia")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'familia' to null.");
            } else {
                objProxy.realmSet$familia((int) json.getInt("familia"));
            }
        }
        if (json.has("sublinea")) {
            if (json.isNull("sublinea")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sublinea' to null.");
            } else {
                objProxy.realmSet$sublinea((int) json.getInt("sublinea"));
            }
        }
        if (json.has("articulo")) {
            if (json.isNull("articulo")) {
                objProxy.realmSet$articulo(null);
            } else {
                objProxy.realmSet$articulo((String) json.getString("articulo"));
            }
        }
        if (json.has("nombre_articulo")) {
            if (json.isNull("nombre_articulo")) {
                objProxy.realmSet$nombre_articulo(null);
            } else {
                objProxy.realmSet$nombre_articulo((String) json.getString("nombre_articulo"));
            }
        }
        if (json.has("nombre_unidad")) {
            if (json.isNull("nombre_unidad")) {
                objProxy.realmSet$nombre_unidad(null);
            } else {
                objProxy.realmSet$nombre_unidad((String) json.getString("nombre_unidad"));
            }
        }
        if (json.has("descripcion_extendida")) {
            if (json.isNull("descripcion_extendida")) {
                objProxy.realmSet$descripcion_extendida(null);
            } else {
                objProxy.realmSet$descripcion_extendida((String) json.getString("descripcion_extendida"));
            }
        }
        if (json.has("image_loaded")) {
            if (json.isNull("image_loaded")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'image_loaded' to null.");
            } else {
                objProxy.realmSet$image_loaded((boolean) json.getBoolean("image_loaded"));
            }
        }
        if (json.has("image_loaded_date")) {
            if (json.isNull("image_loaded_date")) {
                objProxy.realmSet$image_loaded_date(null);
            } else {
                objProxy.realmSet$image_loaded_date((String) json.getString("image_loaded_date"));
            }
        }
        if (json.has("temporal_flag")) {
            if (json.isNull("temporal_flag")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'temporal_flag' to null.");
            } else {
                objProxy.realmSet$temporal_flag((boolean) json.getBoolean("temporal_flag"));
            }
        }
        if (json.has("user_id")) {
            if (json.isNull("user_id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
            } else {
                objProxy.realmSet$user_id((int) json.getInt("user_id"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.Articles createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Articles obj = new com.mds.ventasabpollo.models.Articles();
        final com_mds_ventasabpollo_models_ArticlesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("clave_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$clave_articulo((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'clave_articulo' to null.");
                }
            } else if (name.equals("familia")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$familia((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'familia' to null.");
                }
            } else if (name.equals("sublinea")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sublinea((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sublinea' to null.");
                }
            } else if (name.equals("articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$articulo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$articulo(null);
                }
            } else if (name.equals("nombre_articulo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_articulo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_articulo(null);
                }
            } else if (name.equals("nombre_unidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_unidad((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_unidad(null);
                }
            } else if (name.equals("descripcion_extendida")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descripcion_extendida((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$descripcion_extendida(null);
                }
            } else if (name.equals("image_loaded")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$image_loaded((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'image_loaded' to null.");
                }
            } else if (name.equals("image_loaded_date")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$image_loaded_date((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$image_loaded_date(null);
                }
            } else if (name.equals("temporal_flag")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$temporal_flag((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'temporal_flag' to null.");
                }
            } else if (name.equals("user_id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$user_id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'user_id' to null.");
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_ArticlesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Articles.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Articles copyOrUpdate(Realm realm, ArticlesColumnInfo columnInfo, com.mds.ventasabpollo.models.Articles object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Articles) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Articles copy(Realm realm, ArticlesColumnInfo columnInfo, com.mds.ventasabpollo.models.Articles newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Articles) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_ArticlesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Articles.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clave_articuloIndex, realmObjectSource.realmGet$clave_articulo());
        builder.addInteger(columnInfo.familiaIndex, realmObjectSource.realmGet$familia());
        builder.addInteger(columnInfo.sublineaIndex, realmObjectSource.realmGet$sublinea());
        builder.addString(columnInfo.articuloIndex, realmObjectSource.realmGet$articulo());
        builder.addString(columnInfo.nombre_articuloIndex, realmObjectSource.realmGet$nombre_articulo());
        builder.addString(columnInfo.nombre_unidadIndex, realmObjectSource.realmGet$nombre_unidad());
        builder.addString(columnInfo.descripcion_extendidaIndex, realmObjectSource.realmGet$descripcion_extendida());
        builder.addBoolean(columnInfo.image_loadedIndex, realmObjectSource.realmGet$image_loaded());
        builder.addString(columnInfo.image_loaded_dateIndex, realmObjectSource.realmGet$image_loaded_date());
        builder.addBoolean(columnInfo.temporal_flagIndex, realmObjectSource.realmGet$temporal_flag());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_ArticlesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Articles object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Articles.class);
        long tableNativePtr = table.getNativePtr();
        ArticlesColumnInfo columnInfo = (ArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Articles.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.familiaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$familia(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sublineaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$sublinea(), false);
        String realmGet$articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$articulo();
        if (realmGet$articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
        }
        String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_articulo();
        if (realmGet$nombre_articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
        }
        String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_unidad();
        if (realmGet$nombre_unidad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
        }
        String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$descripcion_extendida();
        if (realmGet$descripcion_extendida != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.image_loadedIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded(), false);
        String realmGet$image_loaded_date = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded_date();
        if (realmGet$image_loaded_date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.image_loaded_dateIndex, rowIndex, realmGet$image_loaded_date, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.temporal_flagIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$temporal_flag(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Articles.class);
        long tableNativePtr = table.getNativePtr();
        ArticlesColumnInfo columnInfo = (ArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Articles.class);
        com.mds.ventasabpollo.models.Articles object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Articles) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.familiaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$familia(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sublineaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$sublinea(), false);
            String realmGet$articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$articulo();
            if (realmGet$articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
            }
            String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_articulo();
            if (realmGet$nombre_articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
            }
            String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_unidad();
            if (realmGet$nombre_unidad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
            }
            String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$descripcion_extendida();
            if (realmGet$descripcion_extendida != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.image_loadedIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded(), false);
            String realmGet$image_loaded_date = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded_date();
            if (realmGet$image_loaded_date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.image_loaded_dateIndex, rowIndex, realmGet$image_loaded_date, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.temporal_flagIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$temporal_flag(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Articles object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Articles.class);
        long tableNativePtr = table.getNativePtr();
        ArticlesColumnInfo columnInfo = (ArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Articles.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.familiaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$familia(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sublineaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$sublinea(), false);
        String realmGet$articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$articulo();
        if (realmGet$articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.articuloIndex, rowIndex, false);
        }
        String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_articulo();
        if (realmGet$nombre_articulo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, false);
        }
        String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_unidad();
        if (realmGet$nombre_unidad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, false);
        }
        String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$descripcion_extendida();
        if (realmGet$descripcion_extendida != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.image_loadedIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded(), false);
        String realmGet$image_loaded_date = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded_date();
        if (realmGet$image_loaded_date != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.image_loaded_dateIndex, rowIndex, realmGet$image_loaded_date, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.image_loaded_dateIndex, rowIndex, false);
        }
        Table.nativeSetBoolean(tableNativePtr, columnInfo.temporal_flagIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$temporal_flag(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Articles.class);
        long tableNativePtr = table.getNativePtr();
        ArticlesColumnInfo columnInfo = (ArticlesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Articles.class);
        com.mds.ventasabpollo.models.Articles object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Articles) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clave_articuloIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$clave_articulo(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.familiaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$familia(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sublineaIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$sublinea(), false);
            String realmGet$articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$articulo();
            if (realmGet$articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.articuloIndex, rowIndex, realmGet$articulo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.articuloIndex, rowIndex, false);
            }
            String realmGet$nombre_articulo = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_articulo();
            if (realmGet$nombre_articulo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, realmGet$nombre_articulo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_articuloIndex, rowIndex, false);
            }
            String realmGet$nombre_unidad = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$nombre_unidad();
            if (realmGet$nombre_unidad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, realmGet$nombre_unidad, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_unidadIndex, rowIndex, false);
            }
            String realmGet$descripcion_extendida = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$descripcion_extendida();
            if (realmGet$descripcion_extendida != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, realmGet$descripcion_extendida, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descripcion_extendidaIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.image_loadedIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded(), false);
            String realmGet$image_loaded_date = ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$image_loaded_date();
            if (realmGet$image_loaded_date != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.image_loaded_dateIndex, rowIndex, realmGet$image_loaded_date, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.image_loaded_dateIndex, rowIndex, false);
            }
            Table.nativeSetBoolean(tableNativePtr, columnInfo.temporal_flagIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$temporal_flag(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.Articles createDetachedCopy(com.mds.ventasabpollo.models.Articles realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Articles unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Articles();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Articles) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Articles) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_ArticlesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_ArticlesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_ArticlesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$clave_articulo(realmSource.realmGet$clave_articulo());
        unmanagedCopy.realmSet$familia(realmSource.realmGet$familia());
        unmanagedCopy.realmSet$sublinea(realmSource.realmGet$sublinea());
        unmanagedCopy.realmSet$articulo(realmSource.realmGet$articulo());
        unmanagedCopy.realmSet$nombre_articulo(realmSource.realmGet$nombre_articulo());
        unmanagedCopy.realmSet$nombre_unidad(realmSource.realmGet$nombre_unidad());
        unmanagedCopy.realmSet$descripcion_extendida(realmSource.realmGet$descripcion_extendida());
        unmanagedCopy.realmSet$image_loaded(realmSource.realmGet$image_loaded());
        unmanagedCopy.realmSet$image_loaded_date(realmSource.realmGet$image_loaded_date());
        unmanagedCopy.realmSet$temporal_flag(realmSource.realmGet$temporal_flag());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Articles = proxy[");
        stringBuilder.append("{clave_articulo:");
        stringBuilder.append(realmGet$clave_articulo());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{familia:");
        stringBuilder.append(realmGet$familia());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sublinea:");
        stringBuilder.append(realmGet$sublinea());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{articulo:");
        stringBuilder.append(realmGet$articulo() != null ? realmGet$articulo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_articulo:");
        stringBuilder.append(realmGet$nombre_articulo() != null ? realmGet$nombre_articulo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_unidad:");
        stringBuilder.append(realmGet$nombre_unidad() != null ? realmGet$nombre_unidad() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{descripcion_extendida:");
        stringBuilder.append(realmGet$descripcion_extendida() != null ? realmGet$descripcion_extendida() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{image_loaded:");
        stringBuilder.append(realmGet$image_loaded());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{image_loaded_date:");
        stringBuilder.append(realmGet$image_loaded_date() != null ? realmGet$image_loaded_date() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{temporal_flag:");
        stringBuilder.append(realmGet$temporal_flag());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{user_id:");
        stringBuilder.append(realmGet$user_id());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long rowIndex = proxyState.getRow$realm().getIndex();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (rowIndex ^ (rowIndex >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        com_mds_ventasabpollo_models_ArticlesRealmProxy aArticles = (com_mds_ventasabpollo_models_ArticlesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aArticles.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aArticles.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aArticles.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
