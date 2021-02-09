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
public class com_mds_ventasabpollo_models_ClientsRealmProxy extends com.mds.ventasabpollo.models.Clients
    implements RealmObjectProxy, com_mds_ventasabpollo_models_ClientsRealmProxyInterface {

    static final class ClientsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long clienteIndex;
        long sucursalIndex;
        long nombre_clienteIndex;
        long nombre_comercialIndex;
        long calleIndex;
        long numero_exteriorIndex;
        long codigo_postalIndex;
        long domicilioIndex;
        long coloniaIndex;
        long ciudadIndex;
        long id_ciudadIndex;
        long id_domicilioIndex;
        long telefonoIndex;
        long fecha_ultima_compraIndex;
        long calle_nuevaIndex;
        long numero_exterior_nuevoIndex;
        long colonia_nuevaIndex;
        long codigo_postal_nuevoIndex;
        long listasIndex;
        long ciudad_nuevaIndex;
        long latitudIndex;
        long longitudIndex;
        long latitud_nuevaIndex;
        long longitud_nuevaIndex;
        long latitud_anteriorIndex;
        long longitud_anteriorIndex;
        long limite_creditoIndex;
        long saldo_actualIndex;
        long numero_precioIndex;
        long user_idIndex;

        ClientsColumnInfo(OsSchemaInfo schemaInfo) {
            super(30);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Clients");
            this.clienteIndex = addColumnDetails("cliente", "cliente", objectSchemaInfo);
            this.sucursalIndex = addColumnDetails("sucursal", "sucursal", objectSchemaInfo);
            this.nombre_clienteIndex = addColumnDetails("nombre_cliente", "nombre_cliente", objectSchemaInfo);
            this.nombre_comercialIndex = addColumnDetails("nombre_comercial", "nombre_comercial", objectSchemaInfo);
            this.calleIndex = addColumnDetails("calle", "calle", objectSchemaInfo);
            this.numero_exteriorIndex = addColumnDetails("numero_exterior", "numero_exterior", objectSchemaInfo);
            this.codigo_postalIndex = addColumnDetails("codigo_postal", "codigo_postal", objectSchemaInfo);
            this.domicilioIndex = addColumnDetails("domicilio", "domicilio", objectSchemaInfo);
            this.coloniaIndex = addColumnDetails("colonia", "colonia", objectSchemaInfo);
            this.ciudadIndex = addColumnDetails("ciudad", "ciudad", objectSchemaInfo);
            this.id_ciudadIndex = addColumnDetails("id_ciudad", "id_ciudad", objectSchemaInfo);
            this.id_domicilioIndex = addColumnDetails("id_domicilio", "id_domicilio", objectSchemaInfo);
            this.telefonoIndex = addColumnDetails("telefono", "telefono", objectSchemaInfo);
            this.fecha_ultima_compraIndex = addColumnDetails("fecha_ultima_compra", "fecha_ultima_compra", objectSchemaInfo);
            this.calle_nuevaIndex = addColumnDetails("calle_nueva", "calle_nueva", objectSchemaInfo);
            this.numero_exterior_nuevoIndex = addColumnDetails("numero_exterior_nuevo", "numero_exterior_nuevo", objectSchemaInfo);
            this.colonia_nuevaIndex = addColumnDetails("colonia_nueva", "colonia_nueva", objectSchemaInfo);
            this.codigo_postal_nuevoIndex = addColumnDetails("codigo_postal_nuevo", "codigo_postal_nuevo", objectSchemaInfo);
            this.listasIndex = addColumnDetails("listas", "listas", objectSchemaInfo);
            this.ciudad_nuevaIndex = addColumnDetails("ciudad_nueva", "ciudad_nueva", objectSchemaInfo);
            this.latitudIndex = addColumnDetails("latitud", "latitud", objectSchemaInfo);
            this.longitudIndex = addColumnDetails("longitud", "longitud", objectSchemaInfo);
            this.latitud_nuevaIndex = addColumnDetails("latitud_nueva", "latitud_nueva", objectSchemaInfo);
            this.longitud_nuevaIndex = addColumnDetails("longitud_nueva", "longitud_nueva", objectSchemaInfo);
            this.latitud_anteriorIndex = addColumnDetails("latitud_anterior", "latitud_anterior", objectSchemaInfo);
            this.longitud_anteriorIndex = addColumnDetails("longitud_anterior", "longitud_anterior", objectSchemaInfo);
            this.limite_creditoIndex = addColumnDetails("limite_credito", "limite_credito", objectSchemaInfo);
            this.saldo_actualIndex = addColumnDetails("saldo_actual", "saldo_actual", objectSchemaInfo);
            this.numero_precioIndex = addColumnDetails("numero_precio", "numero_precio", objectSchemaInfo);
            this.user_idIndex = addColumnDetails("user_id", "user_id", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        ClientsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new ClientsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final ClientsColumnInfo src = (ClientsColumnInfo) rawSrc;
            final ClientsColumnInfo dst = (ClientsColumnInfo) rawDst;
            dst.clienteIndex = src.clienteIndex;
            dst.sucursalIndex = src.sucursalIndex;
            dst.nombre_clienteIndex = src.nombre_clienteIndex;
            dst.nombre_comercialIndex = src.nombre_comercialIndex;
            dst.calleIndex = src.calleIndex;
            dst.numero_exteriorIndex = src.numero_exteriorIndex;
            dst.codigo_postalIndex = src.codigo_postalIndex;
            dst.domicilioIndex = src.domicilioIndex;
            dst.coloniaIndex = src.coloniaIndex;
            dst.ciudadIndex = src.ciudadIndex;
            dst.id_ciudadIndex = src.id_ciudadIndex;
            dst.id_domicilioIndex = src.id_domicilioIndex;
            dst.telefonoIndex = src.telefonoIndex;
            dst.fecha_ultima_compraIndex = src.fecha_ultima_compraIndex;
            dst.calle_nuevaIndex = src.calle_nuevaIndex;
            dst.numero_exterior_nuevoIndex = src.numero_exterior_nuevoIndex;
            dst.colonia_nuevaIndex = src.colonia_nuevaIndex;
            dst.codigo_postal_nuevoIndex = src.codigo_postal_nuevoIndex;
            dst.listasIndex = src.listasIndex;
            dst.ciudad_nuevaIndex = src.ciudad_nuevaIndex;
            dst.latitudIndex = src.latitudIndex;
            dst.longitudIndex = src.longitudIndex;
            dst.latitud_nuevaIndex = src.latitud_nuevaIndex;
            dst.longitud_nuevaIndex = src.longitud_nuevaIndex;
            dst.latitud_anteriorIndex = src.latitud_anteriorIndex;
            dst.longitud_anteriorIndex = src.longitud_anteriorIndex;
            dst.limite_creditoIndex = src.limite_creditoIndex;
            dst.saldo_actualIndex = src.saldo_actualIndex;
            dst.numero_precioIndex = src.numero_precioIndex;
            dst.user_idIndex = src.user_idIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private ClientsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.Clients> proxyState;

    com_mds_ventasabpollo_models_ClientsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (ClientsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.Clients>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$cliente() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.clienteIndex);
    }

    @Override
    public void realmSet$cliente(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.clienteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.clienteIndex, value);
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
    public String realmGet$nombre_cliente() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_clienteIndex);
    }

    @Override
    public void realmSet$nombre_cliente(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_clienteIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_clienteIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_clienteIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_clienteIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_comercial() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_comercialIndex);
    }

    @Override
    public void realmSet$nombre_comercial(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_comercialIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_comercialIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_comercialIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_comercialIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$calle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.calleIndex);
    }

    @Override
    public void realmSet$calle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.calleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.calleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.calleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.calleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$numero_exterior() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.numero_exteriorIndex);
    }

    @Override
    public void realmSet$numero_exterior(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.numero_exteriorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.numero_exteriorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numero_exteriorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.numero_exteriorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$codigo_postal() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codigo_postalIndex);
    }

    @Override
    public void realmSet$codigo_postal(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigo_postalIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codigo_postalIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigo_postalIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codigo_postalIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$domicilio() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.domicilioIndex);
    }

    @Override
    public void realmSet$domicilio(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.domicilioIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.domicilioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.domicilioIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.domicilioIndex, value);
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
    public String realmGet$ciudad() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.ciudadIndex);
    }

    @Override
    public void realmSet$ciudad(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.ciudadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.ciudadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.ciudadIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.ciudadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id_ciudad() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.id_ciudadIndex);
    }

    @Override
    public void realmSet$id_ciudad(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.id_ciudadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.id_ciudadIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id_domicilio() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.id_domicilioIndex);
    }

    @Override
    public void realmSet$id_domicilio(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.id_domicilioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.id_domicilioIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$telefono() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.telefonoIndex);
    }

    @Override
    public void realmSet$telefono(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.telefonoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.telefonoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.telefonoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.telefonoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_ultima_compra() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_ultima_compraIndex);
    }

    @Override
    public void realmSet$fecha_ultima_compra(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_ultima_compraIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_ultima_compraIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_ultima_compraIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_ultima_compraIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$calle_nueva() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.calle_nuevaIndex);
    }

    @Override
    public void realmSet$calle_nueva(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.calle_nuevaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.calle_nuevaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.calle_nuevaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.calle_nuevaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$numero_exterior_nuevo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.numero_exterior_nuevoIndex);
    }

    @Override
    public void realmSet$numero_exterior_nuevo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.numero_exterior_nuevoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.numero_exterior_nuevoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.numero_exterior_nuevoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.numero_exterior_nuevoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$colonia_nueva() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.colonia_nuevaIndex);
    }

    @Override
    public void realmSet$colonia_nueva(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.colonia_nuevaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.colonia_nuevaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.colonia_nuevaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.colonia_nuevaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$codigo_postal_nuevo() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.codigo_postal_nuevoIndex);
    }

    @Override
    public void realmSet$codigo_postal_nuevo(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.codigo_postal_nuevoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.codigo_postal_nuevoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.codigo_postal_nuevoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.codigo_postal_nuevoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$listas() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.listasIndex);
    }

    @Override
    public void realmSet$listas(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.listasIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.listasIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.listasIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.listasIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$ciudad_nueva() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ciudad_nuevaIndex);
    }

    @Override
    public void realmSet$ciudad_nueva(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ciudad_nuevaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ciudad_nuevaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$latitud() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitudIndex);
    }

    @Override
    public void realmSet$latitud(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.latitudIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.latitudIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$longitud() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitudIndex);
    }

    @Override
    public void realmSet$longitud(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.longitudIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.longitudIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$latitud_nueva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitud_nuevaIndex);
    }

    @Override
    public void realmSet$latitud_nueva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.latitud_nuevaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.latitud_nuevaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$longitud_nueva() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitud_nuevaIndex);
    }

    @Override
    public void realmSet$longitud_nueva(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.longitud_nuevaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.longitud_nuevaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$latitud_anterior() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.latitud_anteriorIndex);
    }

    @Override
    public void realmSet$latitud_anterior(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.latitud_anteriorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.latitud_anteriorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$longitud_anterior() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.longitud_anteriorIndex);
    }

    @Override
    public void realmSet$longitud_anterior(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.longitud_anteriorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.longitud_anteriorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$limite_credito() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.limite_creditoIndex);
    }

    @Override
    public void realmSet$limite_credito(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.limite_creditoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.limite_creditoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public double realmGet$saldo_actual() {
        proxyState.getRealm$realm().checkIfValid();
        return (double) proxyState.getRow$realm().getDouble(columnInfo.saldo_actualIndex);
    }

    @Override
    public void realmSet$saldo_actual(double value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setDouble(columnInfo.saldo_actualIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setDouble(columnInfo.saldo_actualIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$numero_precio() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.numero_precioIndex);
    }

    @Override
    public void realmSet$numero_precio(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.numero_precioIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.numero_precioIndex, value);
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
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Clients", 30, 0);
        builder.addPersistedProperty("cliente", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sucursal", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_cliente", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_comercial", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("calle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("numero_exterior", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("codigo_postal", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("domicilio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("colonia", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ciudad", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id_ciudad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("id_domicilio", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("telefono", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_ultima_compra", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("calle_nueva", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("numero_exterior_nuevo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("colonia_nueva", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("codigo_postal_nuevo", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("listas", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ciudad_nueva", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("latitud", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("longitud", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("latitud_nueva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("longitud_nueva", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("latitud_anterior", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("longitud_anterior", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("limite_credito", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("saldo_actual", RealmFieldType.DOUBLE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("numero_precio", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("user_id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static ClientsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new ClientsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Clients";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Clients";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.Clients createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.Clients obj = realm.createObjectInternal(com.mds.ventasabpollo.models.Clients.class, true, excludeFields);

        final com_mds_ventasabpollo_models_ClientsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ClientsRealmProxyInterface) obj;
        if (json.has("cliente")) {
            if (json.isNull("cliente")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
            } else {
                objProxy.realmSet$cliente((int) json.getInt("cliente"));
            }
        }
        if (json.has("sucursal")) {
            if (json.isNull("sucursal")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sucursal' to null.");
            } else {
                objProxy.realmSet$sucursal((int) json.getInt("sucursal"));
            }
        }
        if (json.has("nombre_cliente")) {
            if (json.isNull("nombre_cliente")) {
                objProxy.realmSet$nombre_cliente(null);
            } else {
                objProxy.realmSet$nombre_cliente((String) json.getString("nombre_cliente"));
            }
        }
        if (json.has("nombre_comercial")) {
            if (json.isNull("nombre_comercial")) {
                objProxy.realmSet$nombre_comercial(null);
            } else {
                objProxy.realmSet$nombre_comercial((String) json.getString("nombre_comercial"));
            }
        }
        if (json.has("calle")) {
            if (json.isNull("calle")) {
                objProxy.realmSet$calle(null);
            } else {
                objProxy.realmSet$calle((String) json.getString("calle"));
            }
        }
        if (json.has("numero_exterior")) {
            if (json.isNull("numero_exterior")) {
                objProxy.realmSet$numero_exterior(null);
            } else {
                objProxy.realmSet$numero_exterior((String) json.getString("numero_exterior"));
            }
        }
        if (json.has("codigo_postal")) {
            if (json.isNull("codigo_postal")) {
                objProxy.realmSet$codigo_postal(null);
            } else {
                objProxy.realmSet$codigo_postal((String) json.getString("codigo_postal"));
            }
        }
        if (json.has("domicilio")) {
            if (json.isNull("domicilio")) {
                objProxy.realmSet$domicilio(null);
            } else {
                objProxy.realmSet$domicilio((String) json.getString("domicilio"));
            }
        }
        if (json.has("colonia")) {
            if (json.isNull("colonia")) {
                objProxy.realmSet$colonia(null);
            } else {
                objProxy.realmSet$colonia((String) json.getString("colonia"));
            }
        }
        if (json.has("ciudad")) {
            if (json.isNull("ciudad")) {
                objProxy.realmSet$ciudad(null);
            } else {
                objProxy.realmSet$ciudad((String) json.getString("ciudad"));
            }
        }
        if (json.has("id_ciudad")) {
            if (json.isNull("id_ciudad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id_ciudad' to null.");
            } else {
                objProxy.realmSet$id_ciudad((int) json.getInt("id_ciudad"));
            }
        }
        if (json.has("id_domicilio")) {
            if (json.isNull("id_domicilio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id_domicilio' to null.");
            } else {
                objProxy.realmSet$id_domicilio((int) json.getInt("id_domicilio"));
            }
        }
        if (json.has("telefono")) {
            if (json.isNull("telefono")) {
                objProxy.realmSet$telefono(null);
            } else {
                objProxy.realmSet$telefono((String) json.getString("telefono"));
            }
        }
        if (json.has("fecha_ultima_compra")) {
            if (json.isNull("fecha_ultima_compra")) {
                objProxy.realmSet$fecha_ultima_compra(null);
            } else {
                objProxy.realmSet$fecha_ultima_compra((String) json.getString("fecha_ultima_compra"));
            }
        }
        if (json.has("calle_nueva")) {
            if (json.isNull("calle_nueva")) {
                objProxy.realmSet$calle_nueva(null);
            } else {
                objProxy.realmSet$calle_nueva((String) json.getString("calle_nueva"));
            }
        }
        if (json.has("numero_exterior_nuevo")) {
            if (json.isNull("numero_exterior_nuevo")) {
                objProxy.realmSet$numero_exterior_nuevo(null);
            } else {
                objProxy.realmSet$numero_exterior_nuevo((String) json.getString("numero_exterior_nuevo"));
            }
        }
        if (json.has("colonia_nueva")) {
            if (json.isNull("colonia_nueva")) {
                objProxy.realmSet$colonia_nueva(null);
            } else {
                objProxy.realmSet$colonia_nueva((String) json.getString("colonia_nueva"));
            }
        }
        if (json.has("codigo_postal_nuevo")) {
            if (json.isNull("codigo_postal_nuevo")) {
                objProxy.realmSet$codigo_postal_nuevo(null);
            } else {
                objProxy.realmSet$codigo_postal_nuevo((String) json.getString("codigo_postal_nuevo"));
            }
        }
        if (json.has("listas")) {
            if (json.isNull("listas")) {
                objProxy.realmSet$listas(null);
            } else {
                objProxy.realmSet$listas((String) json.getString("listas"));
            }
        }
        if (json.has("ciudad_nueva")) {
            if (json.isNull("ciudad_nueva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ciudad_nueva' to null.");
            } else {
                objProxy.realmSet$ciudad_nueva((int) json.getInt("ciudad_nueva"));
            }
        }
        if (json.has("latitud")) {
            if (json.isNull("latitud")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitud' to null.");
            } else {
                objProxy.realmSet$latitud((double) json.getDouble("latitud"));
            }
        }
        if (json.has("longitud")) {
            if (json.isNull("longitud")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitud' to null.");
            } else {
                objProxy.realmSet$longitud((double) json.getDouble("longitud"));
            }
        }
        if (json.has("latitud_nueva")) {
            if (json.isNull("latitud_nueva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitud_nueva' to null.");
            } else {
                objProxy.realmSet$latitud_nueva((double) json.getDouble("latitud_nueva"));
            }
        }
        if (json.has("longitud_nueva")) {
            if (json.isNull("longitud_nueva")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitud_nueva' to null.");
            } else {
                objProxy.realmSet$longitud_nueva((double) json.getDouble("longitud_nueva"));
            }
        }
        if (json.has("latitud_anterior")) {
            if (json.isNull("latitud_anterior")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'latitud_anterior' to null.");
            } else {
                objProxy.realmSet$latitud_anterior((double) json.getDouble("latitud_anterior"));
            }
        }
        if (json.has("longitud_anterior")) {
            if (json.isNull("longitud_anterior")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'longitud_anterior' to null.");
            } else {
                objProxy.realmSet$longitud_anterior((double) json.getDouble("longitud_anterior"));
            }
        }
        if (json.has("limite_credito")) {
            if (json.isNull("limite_credito")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'limite_credito' to null.");
            } else {
                objProxy.realmSet$limite_credito((double) json.getDouble("limite_credito"));
            }
        }
        if (json.has("saldo_actual")) {
            if (json.isNull("saldo_actual")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'saldo_actual' to null.");
            } else {
                objProxy.realmSet$saldo_actual((double) json.getDouble("saldo_actual"));
            }
        }
        if (json.has("numero_precio")) {
            if (json.isNull("numero_precio")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'numero_precio' to null.");
            } else {
                objProxy.realmSet$numero_precio((int) json.getInt("numero_precio"));
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
    public static com.mds.ventasabpollo.models.Clients createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.Clients obj = new com.mds.ventasabpollo.models.Clients();
        final com_mds_ventasabpollo_models_ClientsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_ClientsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$cliente((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'cliente' to null.");
                }
            } else if (name.equals("sucursal")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sucursal((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sucursal' to null.");
                }
            } else if (name.equals("nombre_cliente")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_cliente((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_cliente(null);
                }
            } else if (name.equals("nombre_comercial")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_comercial((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_comercial(null);
                }
            } else if (name.equals("calle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$calle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$calle(null);
                }
            } else if (name.equals("numero_exterior")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$numero_exterior((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$numero_exterior(null);
                }
            } else if (name.equals("codigo_postal")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$codigo_postal((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$codigo_postal(null);
                }
            } else if (name.equals("domicilio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$domicilio((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$domicilio(null);
                }
            } else if (name.equals("colonia")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$colonia((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$colonia(null);
                }
            } else if (name.equals("ciudad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ciudad((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$ciudad(null);
                }
            } else if (name.equals("id_ciudad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id_ciudad((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id_ciudad' to null.");
                }
            } else if (name.equals("id_domicilio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id_domicilio((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id_domicilio' to null.");
                }
            } else if (name.equals("telefono")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$telefono((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$telefono(null);
                }
            } else if (name.equals("fecha_ultima_compra")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_ultima_compra((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_ultima_compra(null);
                }
            } else if (name.equals("calle_nueva")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$calle_nueva((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$calle_nueva(null);
                }
            } else if (name.equals("numero_exterior_nuevo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$numero_exterior_nuevo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$numero_exterior_nuevo(null);
                }
            } else if (name.equals("colonia_nueva")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$colonia_nueva((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$colonia_nueva(null);
                }
            } else if (name.equals("codigo_postal_nuevo")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$codigo_postal_nuevo((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$codigo_postal_nuevo(null);
                }
            } else if (name.equals("listas")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$listas((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$listas(null);
                }
            } else if (name.equals("ciudad_nueva")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ciudad_nueva((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ciudad_nueva' to null.");
                }
            } else if (name.equals("latitud")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitud((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'latitud' to null.");
                }
            } else if (name.equals("longitud")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitud((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'longitud' to null.");
                }
            } else if (name.equals("latitud_nueva")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitud_nueva((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'latitud_nueva' to null.");
                }
            } else if (name.equals("longitud_nueva")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitud_nueva((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'longitud_nueva' to null.");
                }
            } else if (name.equals("latitud_anterior")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$latitud_anterior((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'latitud_anterior' to null.");
                }
            } else if (name.equals("longitud_anterior")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$longitud_anterior((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'longitud_anterior' to null.");
                }
            } else if (name.equals("limite_credito")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$limite_credito((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'limite_credito' to null.");
                }
            } else if (name.equals("saldo_actual")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$saldo_actual((double) reader.nextDouble());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'saldo_actual' to null.");
                }
            } else if (name.equals("numero_precio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$numero_precio((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'numero_precio' to null.");
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

    private static com_mds_ventasabpollo_models_ClientsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Clients.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.Clients copyOrUpdate(Realm realm, ClientsColumnInfo columnInfo, com.mds.ventasabpollo.models.Clients object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.Clients) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.Clients copy(Realm realm, ClientsColumnInfo columnInfo, com.mds.ventasabpollo.models.Clients newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.Clients) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_ClientsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_ClientsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.Clients.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.clienteIndex, realmObjectSource.realmGet$cliente());
        builder.addInteger(columnInfo.sucursalIndex, realmObjectSource.realmGet$sucursal());
        builder.addString(columnInfo.nombre_clienteIndex, realmObjectSource.realmGet$nombre_cliente());
        builder.addString(columnInfo.nombre_comercialIndex, realmObjectSource.realmGet$nombre_comercial());
        builder.addString(columnInfo.calleIndex, realmObjectSource.realmGet$calle());
        builder.addString(columnInfo.numero_exteriorIndex, realmObjectSource.realmGet$numero_exterior());
        builder.addString(columnInfo.codigo_postalIndex, realmObjectSource.realmGet$codigo_postal());
        builder.addString(columnInfo.domicilioIndex, realmObjectSource.realmGet$domicilio());
        builder.addString(columnInfo.coloniaIndex, realmObjectSource.realmGet$colonia());
        builder.addString(columnInfo.ciudadIndex, realmObjectSource.realmGet$ciudad());
        builder.addInteger(columnInfo.id_ciudadIndex, realmObjectSource.realmGet$id_ciudad());
        builder.addInteger(columnInfo.id_domicilioIndex, realmObjectSource.realmGet$id_domicilio());
        builder.addString(columnInfo.telefonoIndex, realmObjectSource.realmGet$telefono());
        builder.addString(columnInfo.fecha_ultima_compraIndex, realmObjectSource.realmGet$fecha_ultima_compra());
        builder.addString(columnInfo.calle_nuevaIndex, realmObjectSource.realmGet$calle_nueva());
        builder.addString(columnInfo.numero_exterior_nuevoIndex, realmObjectSource.realmGet$numero_exterior_nuevo());
        builder.addString(columnInfo.colonia_nuevaIndex, realmObjectSource.realmGet$colonia_nueva());
        builder.addString(columnInfo.codigo_postal_nuevoIndex, realmObjectSource.realmGet$codigo_postal_nuevo());
        builder.addString(columnInfo.listasIndex, realmObjectSource.realmGet$listas());
        builder.addInteger(columnInfo.ciudad_nuevaIndex, realmObjectSource.realmGet$ciudad_nueva());
        builder.addDouble(columnInfo.latitudIndex, realmObjectSource.realmGet$latitud());
        builder.addDouble(columnInfo.longitudIndex, realmObjectSource.realmGet$longitud());
        builder.addDouble(columnInfo.latitud_nuevaIndex, realmObjectSource.realmGet$latitud_nueva());
        builder.addDouble(columnInfo.longitud_nuevaIndex, realmObjectSource.realmGet$longitud_nueva());
        builder.addDouble(columnInfo.latitud_anteriorIndex, realmObjectSource.realmGet$latitud_anterior());
        builder.addDouble(columnInfo.longitud_anteriorIndex, realmObjectSource.realmGet$longitud_anterior());
        builder.addDouble(columnInfo.limite_creditoIndex, realmObjectSource.realmGet$limite_credito());
        builder.addDouble(columnInfo.saldo_actualIndex, realmObjectSource.realmGet$saldo_actual());
        builder.addInteger(columnInfo.numero_precioIndex, realmObjectSource.realmGet$numero_precio());
        builder.addInteger(columnInfo.user_idIndex, realmObjectSource.realmGet$user_id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_ClientsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.Clients object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Clients.class);
        long tableNativePtr = table.getNativePtr();
        ClientsColumnInfo columnInfo = (ClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Clients.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$sucursal(), false);
        String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_cliente();
        if (realmGet$nombre_cliente != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
        }
        String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_comercial();
        if (realmGet$nombre_comercial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
        }
        String realmGet$calle = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle();
        if (realmGet$calle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.calleIndex, rowIndex, realmGet$calle, false);
        }
        String realmGet$numero_exterior = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior();
        if (realmGet$numero_exterior != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numero_exteriorIndex, rowIndex, realmGet$numero_exterior, false);
        }
        String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal();
        if (realmGet$codigo_postal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
        }
        String realmGet$domicilio = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$domicilio();
        if (realmGet$domicilio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.domicilioIndex, rowIndex, realmGet$domicilio, false);
        }
        String realmGet$colonia = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia();
        if (realmGet$colonia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
        }
        String realmGet$ciudad = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad();
        if (realmGet$ciudad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ciudadIndex, rowIndex, realmGet$ciudad, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.id_ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_ciudad(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.id_domicilioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_domicilio(), false);
        String realmGet$telefono = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$telefono();
        if (realmGet$telefono != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
        }
        String realmGet$fecha_ultima_compra = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$fecha_ultima_compra();
        if (realmGet$fecha_ultima_compra != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_ultima_compraIndex, rowIndex, realmGet$fecha_ultima_compra, false);
        }
        String realmGet$calle_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle_nueva();
        if (realmGet$calle_nueva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.calle_nuevaIndex, rowIndex, realmGet$calle_nueva, false);
        }
        String realmGet$numero_exterior_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior_nuevo();
        if (realmGet$numero_exterior_nuevo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numero_exterior_nuevoIndex, rowIndex, realmGet$numero_exterior_nuevo, false);
        }
        String realmGet$colonia_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia_nueva();
        if (realmGet$colonia_nueva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.colonia_nuevaIndex, rowIndex, realmGet$colonia_nueva, false);
        }
        String realmGet$codigo_postal_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal_nuevo();
        if (realmGet$codigo_postal_nuevo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigo_postal_nuevoIndex, rowIndex, realmGet$codigo_postal_nuevo, false);
        }
        String realmGet$listas = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$listas();
        if (realmGet$listas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.listasIndex, rowIndex, realmGet$listas, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ciudad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad_nueva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_nueva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_nueva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_anterior(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_anterior(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.limite_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$limite_credito(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.saldo_actualIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$saldo_actual(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.numero_precioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_precio(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Clients.class);
        long tableNativePtr = table.getNativePtr();
        ClientsColumnInfo columnInfo = (ClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Clients.class);
        com.mds.ventasabpollo.models.Clients object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Clients) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$sucursal(), false);
            String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_cliente();
            if (realmGet$nombre_cliente != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
            }
            String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_comercial();
            if (realmGet$nombre_comercial != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
            }
            String realmGet$calle = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle();
            if (realmGet$calle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.calleIndex, rowIndex, realmGet$calle, false);
            }
            String realmGet$numero_exterior = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior();
            if (realmGet$numero_exterior != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.numero_exteriorIndex, rowIndex, realmGet$numero_exterior, false);
            }
            String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal();
            if (realmGet$codigo_postal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
            }
            String realmGet$domicilio = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$domicilio();
            if (realmGet$domicilio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.domicilioIndex, rowIndex, realmGet$domicilio, false);
            }
            String realmGet$colonia = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia();
            if (realmGet$colonia != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
            }
            String realmGet$ciudad = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad();
            if (realmGet$ciudad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ciudadIndex, rowIndex, realmGet$ciudad, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.id_ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_ciudad(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.id_domicilioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_domicilio(), false);
            String realmGet$telefono = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$telefono();
            if (realmGet$telefono != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
            }
            String realmGet$fecha_ultima_compra = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$fecha_ultima_compra();
            if (realmGet$fecha_ultima_compra != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_ultima_compraIndex, rowIndex, realmGet$fecha_ultima_compra, false);
            }
            String realmGet$calle_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle_nueva();
            if (realmGet$calle_nueva != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.calle_nuevaIndex, rowIndex, realmGet$calle_nueva, false);
            }
            String realmGet$numero_exterior_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior_nuevo();
            if (realmGet$numero_exterior_nuevo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.numero_exterior_nuevoIndex, rowIndex, realmGet$numero_exterior_nuevo, false);
            }
            String realmGet$colonia_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia_nueva();
            if (realmGet$colonia_nueva != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.colonia_nuevaIndex, rowIndex, realmGet$colonia_nueva, false);
            }
            String realmGet$codigo_postal_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal_nuevo();
            if (realmGet$codigo_postal_nuevo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.codigo_postal_nuevoIndex, rowIndex, realmGet$codigo_postal_nuevo, false);
            }
            String realmGet$listas = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$listas();
            if (realmGet$listas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.listasIndex, rowIndex, realmGet$listas, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ciudad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad_nueva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_nueva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_nueva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_anterior(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_anterior(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.limite_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$limite_credito(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.saldo_actualIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$saldo_actual(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.numero_precioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_precio(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.Clients object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.Clients.class);
        long tableNativePtr = table.getNativePtr();
        ClientsColumnInfo columnInfo = (ClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Clients.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$cliente(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$sucursal(), false);
        String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_cliente();
        if (realmGet$nombre_cliente != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, false);
        }
        String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_comercial();
        if (realmGet$nombre_comercial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, false);
        }
        String realmGet$calle = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle();
        if (realmGet$calle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.calleIndex, rowIndex, realmGet$calle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.calleIndex, rowIndex, false);
        }
        String realmGet$numero_exterior = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior();
        if (realmGet$numero_exterior != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numero_exteriorIndex, rowIndex, realmGet$numero_exterior, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numero_exteriorIndex, rowIndex, false);
        }
        String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal();
        if (realmGet$codigo_postal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, false);
        }
        String realmGet$domicilio = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$domicilio();
        if (realmGet$domicilio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.domicilioIndex, rowIndex, realmGet$domicilio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.domicilioIndex, rowIndex, false);
        }
        String realmGet$colonia = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia();
        if (realmGet$colonia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coloniaIndex, rowIndex, false);
        }
        String realmGet$ciudad = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad();
        if (realmGet$ciudad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.ciudadIndex, rowIndex, realmGet$ciudad, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.ciudadIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.id_ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_ciudad(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.id_domicilioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_domicilio(), false);
        String realmGet$telefono = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$telefono();
        if (realmGet$telefono != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.telefonoIndex, rowIndex, false);
        }
        String realmGet$fecha_ultima_compra = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$fecha_ultima_compra();
        if (realmGet$fecha_ultima_compra != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_ultima_compraIndex, rowIndex, realmGet$fecha_ultima_compra, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_ultima_compraIndex, rowIndex, false);
        }
        String realmGet$calle_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle_nueva();
        if (realmGet$calle_nueva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.calle_nuevaIndex, rowIndex, realmGet$calle_nueva, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.calle_nuevaIndex, rowIndex, false);
        }
        String realmGet$numero_exterior_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior_nuevo();
        if (realmGet$numero_exterior_nuevo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.numero_exterior_nuevoIndex, rowIndex, realmGet$numero_exterior_nuevo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.numero_exterior_nuevoIndex, rowIndex, false);
        }
        String realmGet$colonia_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia_nueva();
        if (realmGet$colonia_nueva != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.colonia_nuevaIndex, rowIndex, realmGet$colonia_nueva, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.colonia_nuevaIndex, rowIndex, false);
        }
        String realmGet$codigo_postal_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal_nuevo();
        if (realmGet$codigo_postal_nuevo != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigo_postal_nuevoIndex, rowIndex, realmGet$codigo_postal_nuevo, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigo_postal_nuevoIndex, rowIndex, false);
        }
        String realmGet$listas = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$listas();
        if (realmGet$listas != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.listasIndex, rowIndex, realmGet$listas, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.listasIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ciudad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad_nueva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_nueva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_nueva(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_anterior(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_anterior(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.limite_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$limite_credito(), false);
        Table.nativeSetDouble(tableNativePtr, columnInfo.saldo_actualIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$saldo_actual(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.numero_precioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_precio(), false);
        Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$user_id(), false);
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.Clients.class);
        long tableNativePtr = table.getNativePtr();
        ClientsColumnInfo columnInfo = (ClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.Clients.class);
        com.mds.ventasabpollo.models.Clients object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.Clients) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.clienteIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$cliente(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.sucursalIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$sucursal(), false);
            String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_cliente();
            if (realmGet$nombre_cliente != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, false);
            }
            String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$nombre_comercial();
            if (realmGet$nombre_comercial != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, false);
            }
            String realmGet$calle = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle();
            if (realmGet$calle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.calleIndex, rowIndex, realmGet$calle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.calleIndex, rowIndex, false);
            }
            String realmGet$numero_exterior = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior();
            if (realmGet$numero_exterior != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.numero_exteriorIndex, rowIndex, realmGet$numero_exterior, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.numero_exteriorIndex, rowIndex, false);
            }
            String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal();
            if (realmGet$codigo_postal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, false);
            }
            String realmGet$domicilio = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$domicilio();
            if (realmGet$domicilio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.domicilioIndex, rowIndex, realmGet$domicilio, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.domicilioIndex, rowIndex, false);
            }
            String realmGet$colonia = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia();
            if (realmGet$colonia != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.coloniaIndex, rowIndex, false);
            }
            String realmGet$ciudad = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad();
            if (realmGet$ciudad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.ciudadIndex, rowIndex, realmGet$ciudad, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.ciudadIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.id_ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_ciudad(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.id_domicilioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$id_domicilio(), false);
            String realmGet$telefono = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$telefono();
            if (realmGet$telefono != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.telefonoIndex, rowIndex, false);
            }
            String realmGet$fecha_ultima_compra = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$fecha_ultima_compra();
            if (realmGet$fecha_ultima_compra != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_ultima_compraIndex, rowIndex, realmGet$fecha_ultima_compra, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_ultima_compraIndex, rowIndex, false);
            }
            String realmGet$calle_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$calle_nueva();
            if (realmGet$calle_nueva != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.calle_nuevaIndex, rowIndex, realmGet$calle_nueva, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.calle_nuevaIndex, rowIndex, false);
            }
            String realmGet$numero_exterior_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_exterior_nuevo();
            if (realmGet$numero_exterior_nuevo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.numero_exterior_nuevoIndex, rowIndex, realmGet$numero_exterior_nuevo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.numero_exterior_nuevoIndex, rowIndex, false);
            }
            String realmGet$colonia_nueva = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$colonia_nueva();
            if (realmGet$colonia_nueva != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.colonia_nuevaIndex, rowIndex, realmGet$colonia_nueva, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.colonia_nuevaIndex, rowIndex, false);
            }
            String realmGet$codigo_postal_nuevo = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$codigo_postal_nuevo();
            if (realmGet$codigo_postal_nuevo != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.codigo_postal_nuevoIndex, rowIndex, realmGet$codigo_postal_nuevo, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.codigo_postal_nuevoIndex, rowIndex, false);
            }
            String realmGet$listas = ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$listas();
            if (realmGet$listas != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.listasIndex, rowIndex, realmGet$listas, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.listasIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ciudad_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$ciudad_nueva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitudIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_nueva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_nuevaIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_nueva(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.latitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$latitud_anterior(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.longitud_anteriorIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$longitud_anterior(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.limite_creditoIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$limite_credito(), false);
            Table.nativeSetDouble(tableNativePtr, columnInfo.saldo_actualIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$saldo_actual(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.numero_precioIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$numero_precio(), false);
            Table.nativeSetLong(tableNativePtr, columnInfo.user_idIndex, rowIndex, ((com_mds_ventasabpollo_models_ClientsRealmProxyInterface) object).realmGet$user_id(), false);
        }
    }

    public static com.mds.ventasabpollo.models.Clients createDetachedCopy(com.mds.ventasabpollo.models.Clients realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.Clients unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.Clients();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.Clients) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.Clients) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_ClientsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_ClientsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_ClientsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_ClientsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$cliente(realmSource.realmGet$cliente());
        unmanagedCopy.realmSet$sucursal(realmSource.realmGet$sucursal());
        unmanagedCopy.realmSet$nombre_cliente(realmSource.realmGet$nombre_cliente());
        unmanagedCopy.realmSet$nombre_comercial(realmSource.realmGet$nombre_comercial());
        unmanagedCopy.realmSet$calle(realmSource.realmGet$calle());
        unmanagedCopy.realmSet$numero_exterior(realmSource.realmGet$numero_exterior());
        unmanagedCopy.realmSet$codigo_postal(realmSource.realmGet$codigo_postal());
        unmanagedCopy.realmSet$domicilio(realmSource.realmGet$domicilio());
        unmanagedCopy.realmSet$colonia(realmSource.realmGet$colonia());
        unmanagedCopy.realmSet$ciudad(realmSource.realmGet$ciudad());
        unmanagedCopy.realmSet$id_ciudad(realmSource.realmGet$id_ciudad());
        unmanagedCopy.realmSet$id_domicilio(realmSource.realmGet$id_domicilio());
        unmanagedCopy.realmSet$telefono(realmSource.realmGet$telefono());
        unmanagedCopy.realmSet$fecha_ultima_compra(realmSource.realmGet$fecha_ultima_compra());
        unmanagedCopy.realmSet$calle_nueva(realmSource.realmGet$calle_nueva());
        unmanagedCopy.realmSet$numero_exterior_nuevo(realmSource.realmGet$numero_exterior_nuevo());
        unmanagedCopy.realmSet$colonia_nueva(realmSource.realmGet$colonia_nueva());
        unmanagedCopy.realmSet$codigo_postal_nuevo(realmSource.realmGet$codigo_postal_nuevo());
        unmanagedCopy.realmSet$listas(realmSource.realmGet$listas());
        unmanagedCopy.realmSet$ciudad_nueva(realmSource.realmGet$ciudad_nueva());
        unmanagedCopy.realmSet$latitud(realmSource.realmGet$latitud());
        unmanagedCopy.realmSet$longitud(realmSource.realmGet$longitud());
        unmanagedCopy.realmSet$latitud_nueva(realmSource.realmGet$latitud_nueva());
        unmanagedCopy.realmSet$longitud_nueva(realmSource.realmGet$longitud_nueva());
        unmanagedCopy.realmSet$latitud_anterior(realmSource.realmGet$latitud_anterior());
        unmanagedCopy.realmSet$longitud_anterior(realmSource.realmGet$longitud_anterior());
        unmanagedCopy.realmSet$limite_credito(realmSource.realmGet$limite_credito());
        unmanagedCopy.realmSet$saldo_actual(realmSource.realmGet$saldo_actual());
        unmanagedCopy.realmSet$numero_precio(realmSource.realmGet$numero_precio());
        unmanagedCopy.realmSet$user_id(realmSource.realmGet$user_id());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Clients = proxy[");
        stringBuilder.append("{cliente:");
        stringBuilder.append(realmGet$cliente());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sucursal:");
        stringBuilder.append(realmGet$sucursal());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_cliente:");
        stringBuilder.append(realmGet$nombre_cliente() != null ? realmGet$nombre_cliente() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_comercial:");
        stringBuilder.append(realmGet$nombre_comercial() != null ? realmGet$nombre_comercial() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calle:");
        stringBuilder.append(realmGet$calle() != null ? realmGet$calle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numero_exterior:");
        stringBuilder.append(realmGet$numero_exterior() != null ? realmGet$numero_exterior() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigo_postal:");
        stringBuilder.append(realmGet$codigo_postal() != null ? realmGet$codigo_postal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{domicilio:");
        stringBuilder.append(realmGet$domicilio() != null ? realmGet$domicilio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{colonia:");
        stringBuilder.append(realmGet$colonia() != null ? realmGet$colonia() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ciudad:");
        stringBuilder.append(realmGet$ciudad() != null ? realmGet$ciudad() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id_ciudad:");
        stringBuilder.append(realmGet$id_ciudad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id_domicilio:");
        stringBuilder.append(realmGet$id_domicilio());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{telefono:");
        stringBuilder.append(realmGet$telefono() != null ? realmGet$telefono() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_ultima_compra:");
        stringBuilder.append(realmGet$fecha_ultima_compra() != null ? realmGet$fecha_ultima_compra() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{calle_nueva:");
        stringBuilder.append(realmGet$calle_nueva() != null ? realmGet$calle_nueva() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numero_exterior_nuevo:");
        stringBuilder.append(realmGet$numero_exterior_nuevo() != null ? realmGet$numero_exterior_nuevo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{colonia_nueva:");
        stringBuilder.append(realmGet$colonia_nueva() != null ? realmGet$colonia_nueva() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigo_postal_nuevo:");
        stringBuilder.append(realmGet$codigo_postal_nuevo() != null ? realmGet$codigo_postal_nuevo() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{listas:");
        stringBuilder.append(realmGet$listas() != null ? realmGet$listas() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ciudad_nueva:");
        stringBuilder.append(realmGet$ciudad_nueva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitud:");
        stringBuilder.append(realmGet$latitud());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitud:");
        stringBuilder.append(realmGet$longitud());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitud_nueva:");
        stringBuilder.append(realmGet$latitud_nueva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitud_nueva:");
        stringBuilder.append(realmGet$longitud_nueva());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{latitud_anterior:");
        stringBuilder.append(realmGet$latitud_anterior());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{longitud_anterior:");
        stringBuilder.append(realmGet$longitud_anterior());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{limite_credito:");
        stringBuilder.append(realmGet$limite_credito());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{saldo_actual:");
        stringBuilder.append(realmGet$saldo_actual());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{numero_precio:");
        stringBuilder.append(realmGet$numero_precio());
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
        com_mds_ventasabpollo_models_ClientsRealmProxy aClients = (com_mds_ventasabpollo_models_ClientsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aClients.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aClients.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aClients.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
