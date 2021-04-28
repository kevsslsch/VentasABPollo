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
public class com_mds_ventasabpollo_models_BranchOfficesRealmProxy extends com.mds.ventasabpollo.models.BranchOffices
    implements RealmObjectProxy, com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface {

    static final class BranchOfficesColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long sucursalIndex;
        long nombre_sucursalIndex;
        long rfcIndex;
        long direccionIndex;
        long coloniaIndex;
        long municipioIndex;
        long areaIndex;
        long telefonoIndex;
        long emailIndex;
        long sitio_webIndex;

        BranchOfficesColumnInfo(OsSchemaInfo schemaInfo) {
            super(10);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("BranchOffices");
            this.sucursalIndex = addColumnDetails("sucursal", "sucursal", objectSchemaInfo);
            this.nombre_sucursalIndex = addColumnDetails("nombre_sucursal", "nombre_sucursal", objectSchemaInfo);
            this.rfcIndex = addColumnDetails("rfc", "rfc", objectSchemaInfo);
            this.direccionIndex = addColumnDetails("direccion", "direccion", objectSchemaInfo);
            this.coloniaIndex = addColumnDetails("colonia", "colonia", objectSchemaInfo);
            this.municipioIndex = addColumnDetails("municipio", "municipio", objectSchemaInfo);
            this.areaIndex = addColumnDetails("area", "area", objectSchemaInfo);
            this.telefonoIndex = addColumnDetails("telefono", "telefono", objectSchemaInfo);
            this.emailIndex = addColumnDetails("email", "email", objectSchemaInfo);
            this.sitio_webIndex = addColumnDetails("sitio_web", "sitio_web", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        BranchOfficesColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new BranchOfficesColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final BranchOfficesColumnInfo src = (BranchOfficesColumnInfo) rawSrc;
            final BranchOfficesColumnInfo dst = (BranchOfficesColumnInfo) rawDst;
            dst.sucursalIndex = src.sucursalIndex;
            dst.nombre_sucursalIndex = src.nombre_sucursalIndex;
            dst.rfcIndex = src.rfcIndex;
            dst.direccionIndex = src.direccionIndex;
            dst.coloniaIndex = src.coloniaIndex;
            dst.municipioIndex = src.municipioIndex;
            dst.areaIndex = src.areaIndex;
            dst.telefonoIndex = src.telefonoIndex;
            dst.emailIndex = src.emailIndex;
            dst.sitio_webIndex = src.sitio_webIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private BranchOfficesColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.BranchOffices> proxyState;

    com_mds_ventasabpollo_models_BranchOfficesRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (BranchOfficesColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.BranchOffices>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$sucursal() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.sucursalIndex);
    }

    @Override
    public void realmSet$sucursal(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.sucursalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.sucursalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_sucursal() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_sucursalIndex);
    }

    @Override
    public void realmSet$nombre_sucursal(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_sucursalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_sucursalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_sucursalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_sucursalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$rfc() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.rfcIndex);
    }

    @Override
    public void realmSet$rfc(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.rfcIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.rfcIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.rfcIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.rfcIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$direccion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.direccionIndex);
    }

    @Override
    public void realmSet$direccion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.direccionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.direccionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.direccionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.direccionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$colonia() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.coloniaIndex);
    }

    @Override
    public void realmSet$colonia(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.coloniaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.coloniaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.coloniaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.coloniaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$municipio() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.municipioIndex);
    }

    @Override
    public void realmSet$municipio(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.municipioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.municipioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.municipioIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.municipioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$area() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.areaIndex);
    }

    @Override
    public void realmSet$area(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.areaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.areaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$telefono() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.telefonoIndex);
    }

    @Override
    public void realmSet$telefono(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.telefonoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.telefonoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$email() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.emailIndex);
    }

    @Override
    public void realmSet$email(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.emailIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.emailIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.emailIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.emailIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$sitio_web() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.sitio_webIndex);
    }

    @Override
    public void realmSet$sitio_web(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.sitio_webIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.sitio_webIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.sitio_webIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.sitio_webIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("BranchOffices", 10, 0);
        builder.addPersistedProperty("sucursal", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_sucursal", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rfc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("direccion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("colonia", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("municipio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("area", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("telefono", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("email", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("sitio_web", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static BranchOfficesColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new BranchOfficesColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "BranchOffices";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "BranchOffices";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.BranchOffices createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.BranchOffices obj = realm.createObjectInternal(com.mds.ventasabpollo.models.BranchOffices.class, true, excludeFields);

        final com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) obj;
        if (json.has("sucursal")) {
            if (json.isNull("sucursal")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sucursal' to null.");
            } else {
                objProxy.realmSet$sucursal((int) json.getInt("sucursal"));
            }
        }
        if (json.has("nombre_sucursal")) {
            if (json.isNull("nombre_sucursal")) {
                objProxy.realmSet$nombre_sucursal(null);
            } else {
                objProxy.realmSet$nombre_sucursal((String) json.getString("nombre_sucursal"));
            }
        }
        if (json.has("rfc")) {
            if (json.isNull("rfc")) {
                objProxy.realmSet$rfc(null);
            } else {
                objProxy.realmSet$rfc((String) json.getString("rfc"));
            }
        }
        if (json.has("direccion")) {
            if (json.isNull("direccion")) {
                objProxy.realmSet$direccion(null);
            } else {
                objProxy.realmSet$direccion((String) json.getString("direccion"));
            }
        }
        if (json.has("colonia")) {
            if (json.isNull("colonia")) {
                objProxy.realmSet$colonia(null);
            } else {
                objProxy.realmSet$colonia((String) json.getString("colonia"));
            }
        }
        if (json.has("municipio")) {
            if (json.isNull("municipio")) {
                objProxy.realmSet$municipio(null);
            } else {
                objProxy.realmSet$municipio((String) json.getString("municipio"));
            }
        }
        if (json.has("area")) {
            if (json.isNull("area")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'area' to null.");
            } else {
                objProxy.realmSet$area((int) json.getInt("area"));
            }
        }
        if (json.has("telefono")) {
            if (json.isNull("telefono")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'telefono' to null.");
            } else {
                objProxy.realmSet$telefono((int) json.getInt("telefono"));
            }
        }
        if (json.has("email")) {
            if (json.isNull("email")) {
                objProxy.realmSet$email(null);
            } else {
                objProxy.realmSet$email((String) json.getString("email"));
            }
        }
        if (json.has("sitio_web")) {
            if (json.isNull("sitio_web")) {
                objProxy.realmSet$sitio_web(null);
            } else {
                objProxy.realmSet$sitio_web((String) json.getString("sitio_web"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.BranchOffices createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.BranchOffices obj = new com.mds.ventasabpollo.models.BranchOffices();
        final com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("sucursal")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sucursal((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sucursal' to null.");
                }
            } else if (name.equals("nombre_sucursal")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_sucursal((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_sucursal(null);
                }
            } else if (name.equals("rfc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rfc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rfc(null);
                }
            } else if (name.equals("direccion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$direccion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$direccion(null);
                }
            } else if (name.equals("colonia")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$colonia((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$colonia(null);
                }
            } else if (name.equals("municipio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$municipio((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$municipio(null);
                }
            } else if (name.equals("area")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$area((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'area' to null.");
                }
            } else if (name.equals("telefono")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$telefono((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'telefono' to null.");
                }
            } else if (name.equals("email")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$email((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$email(null);
                }
            } else if (name.equals("sitio_web")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sitio_web((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$sitio_web(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_BranchOfficesRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.BranchOffices.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.BranchOffices copyOrUpdate(Realm realm, BranchOfficesColumnInfo columnInfo, com.mds.ventasabpollo.models.BranchOffices object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.BranchOffices) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.BranchOffices copy(Realm realm, BranchOfficesColumnInfo columnInfo, com.mds.ventasabpollo.models.BranchOffices newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.BranchOffices) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.BranchOffices.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.sucursalIndex, realmObjectSource.realmGet$sucursal());
        builder.addString(columnInfo.nombre_sucursalIndex, realmObjectSource.realmGet$nombre_sucursal());
        builder.addString(columnInfo.rfcIndex, realmObjectSource.realmGet$rfc());
        builder.addString(columnInfo.direccionIndex, realmObjectSource.realmGet$direccion());
        builder.addString(columnInfo.coloniaIndex, realmObjectSource.realmGet$colonia());
        builder.addString(columnInfo.municipioIndex, realmObjectSource.realmGet$municipio());
        builder.addInteger(columnInfo.areaIndex, realmObjectSource.realmGet$area());
        builder.addInteger(columnInfo.telefonoIndex, realmObjectSource.realmGet$telefono());
        builder.addString(columnInfo.emailIndex, realmObjectSource.realmGet$email());
        builder.addString(columnInfo.sitio_webIndex, realmObjectSource.realmGet$sitio_web());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_BranchOfficesRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.BranchOffices object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.BranchOffices.class);
        long tableNativePtr = table.getNativePtr();
        BranchOfficesColumnInfo columnInfo = (BranchOfficesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.BranchOffices.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sucursal(), false);
        String realmGet$nombre_sucursal = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$nombre_sucursal();
        if (realmGet$nombre_sucursal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_sucursalIndex, rowIndex, realmGet$nombre_sucursal, false);
        }
        String realmGet$rfc = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$rfc();
        if (realmGet$rfc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
        }
        String realmGet$direccion = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$direccion();
        if (realmGet$direccion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.direccionIndex, rowIndex, realmGet$direccion, false);
        }
        String realmGet$colonia = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$colonia();
        if (realmGet$colonia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
        }
        String realmGet$municipio = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$municipio();
        if (realmGet$municipio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.areaIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$area(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.telefonoIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$telefono(), false);
        String realmGet$email = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        }
        String realmGet$sitio_web = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sitio_web();
        if (realmGet$sitio_web != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sitio_webIndex, rowIndex, realmGet$sitio_web, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.BranchOffices.class);
        long tableNativePtr = table.getNativePtr();
        BranchOfficesColumnInfo columnInfo = (BranchOfficesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.BranchOffices.class);
        com.mds.ventasabpollo.models.BranchOffices object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.BranchOffices) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sucursal(), false);
            String realmGet$nombre_sucursal = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$nombre_sucursal();
            if (realmGet$nombre_sucursal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_sucursalIndex, rowIndex, realmGet$nombre_sucursal, false);
            }
            String realmGet$rfc = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$rfc();
            if (realmGet$rfc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
            }
            String realmGet$direccion = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$direccion();
            if (realmGet$direccion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.direccionIndex, rowIndex, realmGet$direccion, false);
            }
            String realmGet$colonia = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$colonia();
            if (realmGet$colonia != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
            }
            String realmGet$municipio = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$municipio();
            if (realmGet$municipio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.areaIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$area(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.telefonoIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$telefono(), false);
            String realmGet$email = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            }
            String realmGet$sitio_web = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sitio_web();
            if (realmGet$sitio_web != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sitio_webIndex, rowIndex, realmGet$sitio_web, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.BranchOffices object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.BranchOffices.class);
        long tableNativePtr = table.getNativePtr();
        BranchOfficesColumnInfo columnInfo = (BranchOfficesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.BranchOffices.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sucursal(), false);
        String realmGet$nombre_sucursal = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$nombre_sucursal();
        if (realmGet$nombre_sucursal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_sucursalIndex, rowIndex, realmGet$nombre_sucursal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_sucursalIndex, rowIndex, false);
        }
        String realmGet$rfc = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$rfc();
        if (realmGet$rfc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.rfcIndex, rowIndex, false);
        }
        String realmGet$direccion = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$direccion();
        if (realmGet$direccion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.direccionIndex, rowIndex, realmGet$direccion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.direccionIndex, rowIndex, false);
        }
        String realmGet$colonia = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$colonia();
        if (realmGet$colonia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coloniaIndex, rowIndex, false);
        }
        String realmGet$municipio = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$municipio();
        if (realmGet$municipio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.municipioIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.areaIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$area(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.telefonoIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$telefono(), false);
        String realmGet$email = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$email();
        if (realmGet$email != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
        }
        String realmGet$sitio_web = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sitio_web();
        if (realmGet$sitio_web != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.sitio_webIndex, rowIndex, realmGet$sitio_web, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.sitio_webIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.BranchOffices.class);
        long tableNativePtr = table.getNativePtr();
        BranchOfficesColumnInfo columnInfo = (BranchOfficesColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.BranchOffices.class);
        com.mds.ventasabpollo.models.BranchOffices object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.BranchOffices) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sucursal(), false);
            String realmGet$nombre_sucursal = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$nombre_sucursal();
            if (realmGet$nombre_sucursal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_sucursalIndex, rowIndex, realmGet$nombre_sucursal, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_sucursalIndex, rowIndex, false);
            }
            String realmGet$rfc = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$rfc();
            if (realmGet$rfc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.rfcIndex, rowIndex, false);
            }
            String realmGet$direccion = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$direccion();
            if (realmGet$direccion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.direccionIndex, rowIndex, realmGet$direccion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.direccionIndex, rowIndex, false);
            }
            String realmGet$colonia = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$colonia();
            if (realmGet$colonia != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.coloniaIndex, rowIndex, false);
            }
            String realmGet$municipio = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$municipio();
            if (realmGet$municipio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.municipioIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.areaIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$area(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.telefonoIndex, rowIndex, ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$telefono(), false);
            String realmGet$email = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$email();
            if (realmGet$email != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.emailIndex, rowIndex, realmGet$email, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.emailIndex, rowIndex, false);
            }
            String realmGet$sitio_web = ((com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) object).realmGet$sitio_web();
            if (realmGet$sitio_web != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.sitio_webIndex, rowIndex, realmGet$sitio_web, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.sitio_webIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.BranchOffices createDetachedCopy(com.mds.ventasabpollo.models.BranchOffices realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.BranchOffices unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.BranchOffices();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.BranchOffices) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.BranchOffices) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_BranchOfficesRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$sucursal(realmSource.realmGet$sucursal());
        unmanagedCopy.realmSet$nombre_sucursal(realmSource.realmGet$nombre_sucursal());
        unmanagedCopy.realmSet$rfc(realmSource.realmGet$rfc());
        unmanagedCopy.realmSet$direccion(realmSource.realmGet$direccion());
        unmanagedCopy.realmSet$colonia(realmSource.realmGet$colonia());
        unmanagedCopy.realmSet$municipio(realmSource.realmGet$municipio());
        unmanagedCopy.realmSet$area(realmSource.realmGet$area());
        unmanagedCopy.realmSet$telefono(realmSource.realmGet$telefono());
        unmanagedCopy.realmSet$email(realmSource.realmGet$email());
        unmanagedCopy.realmSet$sitio_web(realmSource.realmGet$sitio_web());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("BranchOffices = proxy[");
        stringBuilder.append("{sucursal:");
        stringBuilder.append(realmGet$sucursal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_sucursal:");
        stringBuilder.append(realmGet$nombre_sucursal() != null ? realmGet$nombre_sucursal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{rfc:");
        stringBuilder.append(realmGet$rfc() != null ? realmGet$rfc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{direccion:");
        stringBuilder.append(realmGet$direccion() != null ? realmGet$direccion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{colonia:");
        stringBuilder.append(realmGet$colonia() != null ? realmGet$colonia() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{municipio:");
        stringBuilder.append(realmGet$municipio() != null ? realmGet$municipio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{area:");
        stringBuilder.append(realmGet$area());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{telefono:");
        stringBuilder.append(realmGet$telefono());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{email:");
        stringBuilder.append(realmGet$email() != null ? realmGet$email() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sitio_web:");
        stringBuilder.append(realmGet$sitio_web() != null ? realmGet$sitio_web() : "null");
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
        com_mds_ventasabpollo_models_BranchOfficesRealmProxy aBranchOffices = (com_mds_ventasabpollo_models_BranchOfficesRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aBranchOffices.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aBranchOffices.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aBranchOffices.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
