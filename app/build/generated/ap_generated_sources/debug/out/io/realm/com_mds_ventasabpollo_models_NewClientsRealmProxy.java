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
public class com_mds_ventasabpollo_models_NewClientsRealmProxy extends com.mds.ventasabpollo.models.NewClients
    implements RealmObjectProxy, com_mds_ventasabpollo_models_NewClientsRealmProxyInterface {

    static final class NewClientsColumnInfo extends ColumnInfo {
        long maxColumnIndexValue;
        long idIndex;
        long nombre_clienteIndex;
        long nombre_comercialIndex;
        long rfcIndex;
        long curpIndex;
        long forma_pagoIndex;
        long no_cuentaIndex;
        long uso_cfdiIndex;
        long metodo_pagoIndex;
        long correo_electronicoIndex;
        long nombre_contactoIndex;
        long apellido_contactoIndex;
        long nombre_calleIndex;
        long no_exteriorIndex;
        long no_interiorIndex;
        long coloniaIndex;
        long codigo_postalIndex;
        long ciudadIndex;
        long telefonoIndex;
        long descripcionIndex;
        long localidadIndex;
        long municipioIndex;
        long fecha_registroIndex;
        long id_dbIndex;
        long borradorIndex;
        long sincronizadoIndex;
        long fecha_sincronizadoIndex;

        NewClientsColumnInfo(OsSchemaInfo schemaInfo) {
            super(27);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("NewClients");
            this.idIndex = addColumnDetails("id", "id", objectSchemaInfo);
            this.nombre_clienteIndex = addColumnDetails("nombre_cliente", "nombre_cliente", objectSchemaInfo);
            this.nombre_comercialIndex = addColumnDetails("nombre_comercial", "nombre_comercial", objectSchemaInfo);
            this.rfcIndex = addColumnDetails("rfc", "rfc", objectSchemaInfo);
            this.curpIndex = addColumnDetails("curp", "curp", objectSchemaInfo);
            this.forma_pagoIndex = addColumnDetails("forma_pago", "forma_pago", objectSchemaInfo);
            this.no_cuentaIndex = addColumnDetails("no_cuenta", "no_cuenta", objectSchemaInfo);
            this.uso_cfdiIndex = addColumnDetails("uso_cfdi", "uso_cfdi", objectSchemaInfo);
            this.metodo_pagoIndex = addColumnDetails("metodo_pago", "metodo_pago", objectSchemaInfo);
            this.correo_electronicoIndex = addColumnDetails("correo_electronico", "correo_electronico", objectSchemaInfo);
            this.nombre_contactoIndex = addColumnDetails("nombre_contacto", "nombre_contacto", objectSchemaInfo);
            this.apellido_contactoIndex = addColumnDetails("apellido_contacto", "apellido_contacto", objectSchemaInfo);
            this.nombre_calleIndex = addColumnDetails("nombre_calle", "nombre_calle", objectSchemaInfo);
            this.no_exteriorIndex = addColumnDetails("no_exterior", "no_exterior", objectSchemaInfo);
            this.no_interiorIndex = addColumnDetails("no_interior", "no_interior", objectSchemaInfo);
            this.coloniaIndex = addColumnDetails("colonia", "colonia", objectSchemaInfo);
            this.codigo_postalIndex = addColumnDetails("codigo_postal", "codigo_postal", objectSchemaInfo);
            this.ciudadIndex = addColumnDetails("ciudad", "ciudad", objectSchemaInfo);
            this.telefonoIndex = addColumnDetails("telefono", "telefono", objectSchemaInfo);
            this.descripcionIndex = addColumnDetails("descripcion", "descripcion", objectSchemaInfo);
            this.localidadIndex = addColumnDetails("localidad", "localidad", objectSchemaInfo);
            this.municipioIndex = addColumnDetails("municipio", "municipio", objectSchemaInfo);
            this.fecha_registroIndex = addColumnDetails("fecha_registro", "fecha_registro", objectSchemaInfo);
            this.id_dbIndex = addColumnDetails("id_db", "id_db", objectSchemaInfo);
            this.borradorIndex = addColumnDetails("borrador", "borrador", objectSchemaInfo);
            this.sincronizadoIndex = addColumnDetails("sincronizado", "sincronizado", objectSchemaInfo);
            this.fecha_sincronizadoIndex = addColumnDetails("fecha_sincronizado", "fecha_sincronizado", objectSchemaInfo);
            this.maxColumnIndexValue = objectSchemaInfo.getMaxColumnIndex();
        }

        NewClientsColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new NewClientsColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final NewClientsColumnInfo src = (NewClientsColumnInfo) rawSrc;
            final NewClientsColumnInfo dst = (NewClientsColumnInfo) rawDst;
            dst.idIndex = src.idIndex;
            dst.nombre_clienteIndex = src.nombre_clienteIndex;
            dst.nombre_comercialIndex = src.nombre_comercialIndex;
            dst.rfcIndex = src.rfcIndex;
            dst.curpIndex = src.curpIndex;
            dst.forma_pagoIndex = src.forma_pagoIndex;
            dst.no_cuentaIndex = src.no_cuentaIndex;
            dst.uso_cfdiIndex = src.uso_cfdiIndex;
            dst.metodo_pagoIndex = src.metodo_pagoIndex;
            dst.correo_electronicoIndex = src.correo_electronicoIndex;
            dst.nombre_contactoIndex = src.nombre_contactoIndex;
            dst.apellido_contactoIndex = src.apellido_contactoIndex;
            dst.nombre_calleIndex = src.nombre_calleIndex;
            dst.no_exteriorIndex = src.no_exteriorIndex;
            dst.no_interiorIndex = src.no_interiorIndex;
            dst.coloniaIndex = src.coloniaIndex;
            dst.codigo_postalIndex = src.codigo_postalIndex;
            dst.ciudadIndex = src.ciudadIndex;
            dst.telefonoIndex = src.telefonoIndex;
            dst.descripcionIndex = src.descripcionIndex;
            dst.localidadIndex = src.localidadIndex;
            dst.municipioIndex = src.municipioIndex;
            dst.fecha_registroIndex = src.fecha_registroIndex;
            dst.id_dbIndex = src.id_dbIndex;
            dst.borradorIndex = src.borradorIndex;
            dst.sincronizadoIndex = src.sincronizadoIndex;
            dst.fecha_sincronizadoIndex = src.fecha_sincronizadoIndex;
            dst.maxColumnIndexValue = src.maxColumnIndexValue;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private NewClientsColumnInfo columnInfo;
    private ProxyState<com.mds.ventasabpollo.models.NewClients> proxyState;

    com_mds_ventasabpollo_models_NewClientsRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (NewClientsColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<com.mds.ventasabpollo.models.NewClients>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idIndex);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.idIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.idIndex, value);
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
    public String realmGet$curp() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.curpIndex);
    }

    @Override
    public void realmSet$curp(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.curpIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.curpIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.curpIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.curpIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$forma_pago() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.forma_pagoIndex);
    }

    @Override
    public void realmSet$forma_pago(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.forma_pagoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.forma_pagoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.forma_pagoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.forma_pagoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$no_cuenta() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.no_cuentaIndex);
    }

    @Override
    public void realmSet$no_cuenta(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.no_cuentaIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.no_cuentaIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.no_cuentaIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.no_cuentaIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$uso_cfdi() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.uso_cfdiIndex);
    }

    @Override
    public void realmSet$uso_cfdi(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.uso_cfdiIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.uso_cfdiIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.uso_cfdiIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.uso_cfdiIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$metodo_pago() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.metodo_pagoIndex);
    }

    @Override
    public void realmSet$metodo_pago(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.metodo_pagoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.metodo_pagoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.metodo_pagoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.metodo_pagoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$correo_electronico() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.correo_electronicoIndex);
    }

    @Override
    public void realmSet$correo_electronico(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.correo_electronicoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.correo_electronicoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.correo_electronicoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.correo_electronicoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_contacto() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_contactoIndex);
    }

    @Override
    public void realmSet$nombre_contacto(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_contactoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_contactoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_contactoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_contactoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$apellido_contacto() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.apellido_contactoIndex);
    }

    @Override
    public void realmSet$apellido_contacto(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.apellido_contactoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.apellido_contactoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.apellido_contactoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.apellido_contactoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$nombre_calle() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.nombre_calleIndex);
    }

    @Override
    public void realmSet$nombre_calle(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.nombre_calleIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.nombre_calleIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.nombre_calleIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.nombre_calleIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$no_exterior() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.no_exteriorIndex);
    }

    @Override
    public void realmSet$no_exterior(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.no_exteriorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.no_exteriorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.no_exteriorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.no_exteriorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$no_interior() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.no_interiorIndex);
    }

    @Override
    public void realmSet$no_interior(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.no_interiorIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.no_interiorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.no_interiorIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.no_interiorIndex, value);
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
    public int realmGet$ciudad() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.ciudadIndex);
    }

    @Override
    public void realmSet$ciudad(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.ciudadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.ciudadIndex, value);
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
    public String realmGet$descripcion() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.descripcionIndex);
    }

    @Override
    public void realmSet$descripcion(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.descripcionIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.descripcionIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.descripcionIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.descripcionIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$localidad() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.localidadIndex);
    }

    @Override
    public void realmSet$localidad(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.localidadIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.localidadIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.localidadIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.localidadIndex, value);
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
    public String realmGet$fecha_registro() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_registroIndex);
    }

    @Override
    public void realmSet$fecha_registro(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_registroIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_registroIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_registroIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_registroIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id_db() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.id_dbIndex);
    }

    @Override
    public void realmSet$id_db(int value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setLong(columnInfo.id_dbIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setLong(columnInfo.id_dbIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$borrador() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.borradorIndex);
    }

    @Override
    public void realmSet$borrador(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.borradorIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.borradorIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public boolean realmGet$sincronizado() {
        proxyState.getRealm$realm().checkIfValid();
        return (boolean) proxyState.getRow$realm().getBoolean(columnInfo.sincronizadoIndex);
    }

    @Override
    public void realmSet$sincronizado(boolean value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            row.getTable().setBoolean(columnInfo.sincronizadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        proxyState.getRow$realm().setBoolean(columnInfo.sincronizadoIndex, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$fecha_sincronizado() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.fecha_sincronizadoIndex);
    }

    @Override
    public void realmSet$fecha_sincronizado(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                row.getTable().setNull(columnInfo.fecha_sincronizadoIndex, row.getIndex(), true);
                return;
            }
            row.getTable().setString(columnInfo.fecha_sincronizadoIndex, row.getIndex(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            proxyState.getRow$realm().setNull(columnInfo.fecha_sincronizadoIndex);
            return;
        }
        proxyState.getRow$realm().setString(columnInfo.fecha_sincronizadoIndex, value);
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("NewClients", 27, 0);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("nombre_cliente", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_comercial", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("rfc", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("curp", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("forma_pago", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("no_cuenta", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("uso_cfdi", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("metodo_pago", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("correo_electronico", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_contacto", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("apellido_contacto", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("nombre_calle", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("no_exterior", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("no_interior", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("colonia", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("codigo_postal", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("ciudad", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("telefono", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("descripcion", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("localidad", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("municipio", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("fecha_registro", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        builder.addPersistedProperty("id_db", RealmFieldType.INTEGER, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("borrador", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("sincronizado", RealmFieldType.BOOLEAN, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("fecha_sincronizado", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, !Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static NewClientsColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new NewClientsColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "NewClients";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "NewClients";
    }

    @SuppressWarnings("cast")
    public static com.mds.ventasabpollo.models.NewClients createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        com.mds.ventasabpollo.models.NewClients obj = realm.createObjectInternal(com.mds.ventasabpollo.models.NewClients.class, true, excludeFields);

        final com_mds_ventasabpollo_models_NewClientsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) obj;
        if (json.has("id")) {
            if (json.isNull("id")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
            } else {
                objProxy.realmSet$id((int) json.getInt("id"));
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
        if (json.has("rfc")) {
            if (json.isNull("rfc")) {
                objProxy.realmSet$rfc(null);
            } else {
                objProxy.realmSet$rfc((String) json.getString("rfc"));
            }
        }
        if (json.has("curp")) {
            if (json.isNull("curp")) {
                objProxy.realmSet$curp(null);
            } else {
                objProxy.realmSet$curp((String) json.getString("curp"));
            }
        }
        if (json.has("forma_pago")) {
            if (json.isNull("forma_pago")) {
                objProxy.realmSet$forma_pago(null);
            } else {
                objProxy.realmSet$forma_pago((String) json.getString("forma_pago"));
            }
        }
        if (json.has("no_cuenta")) {
            if (json.isNull("no_cuenta")) {
                objProxy.realmSet$no_cuenta(null);
            } else {
                objProxy.realmSet$no_cuenta((String) json.getString("no_cuenta"));
            }
        }
        if (json.has("uso_cfdi")) {
            if (json.isNull("uso_cfdi")) {
                objProxy.realmSet$uso_cfdi(null);
            } else {
                objProxy.realmSet$uso_cfdi((String) json.getString("uso_cfdi"));
            }
        }
        if (json.has("metodo_pago")) {
            if (json.isNull("metodo_pago")) {
                objProxy.realmSet$metodo_pago(null);
            } else {
                objProxy.realmSet$metodo_pago((String) json.getString("metodo_pago"));
            }
        }
        if (json.has("correo_electronico")) {
            if (json.isNull("correo_electronico")) {
                objProxy.realmSet$correo_electronico(null);
            } else {
                objProxy.realmSet$correo_electronico((String) json.getString("correo_electronico"));
            }
        }
        if (json.has("nombre_contacto")) {
            if (json.isNull("nombre_contacto")) {
                objProxy.realmSet$nombre_contacto(null);
            } else {
                objProxy.realmSet$nombre_contacto((String) json.getString("nombre_contacto"));
            }
        }
        if (json.has("apellido_contacto")) {
            if (json.isNull("apellido_contacto")) {
                objProxy.realmSet$apellido_contacto(null);
            } else {
                objProxy.realmSet$apellido_contacto((String) json.getString("apellido_contacto"));
            }
        }
        if (json.has("nombre_calle")) {
            if (json.isNull("nombre_calle")) {
                objProxy.realmSet$nombre_calle(null);
            } else {
                objProxy.realmSet$nombre_calle((String) json.getString("nombre_calle"));
            }
        }
        if (json.has("no_exterior")) {
            if (json.isNull("no_exterior")) {
                objProxy.realmSet$no_exterior(null);
            } else {
                objProxy.realmSet$no_exterior((String) json.getString("no_exterior"));
            }
        }
        if (json.has("no_interior")) {
            if (json.isNull("no_interior")) {
                objProxy.realmSet$no_interior(null);
            } else {
                objProxy.realmSet$no_interior((String) json.getString("no_interior"));
            }
        }
        if (json.has("colonia")) {
            if (json.isNull("colonia")) {
                objProxy.realmSet$colonia(null);
            } else {
                objProxy.realmSet$colonia((String) json.getString("colonia"));
            }
        }
        if (json.has("codigo_postal")) {
            if (json.isNull("codigo_postal")) {
                objProxy.realmSet$codigo_postal(null);
            } else {
                objProxy.realmSet$codigo_postal((String) json.getString("codigo_postal"));
            }
        }
        if (json.has("ciudad")) {
            if (json.isNull("ciudad")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'ciudad' to null.");
            } else {
                objProxy.realmSet$ciudad((int) json.getInt("ciudad"));
            }
        }
        if (json.has("telefono")) {
            if (json.isNull("telefono")) {
                objProxy.realmSet$telefono(null);
            } else {
                objProxy.realmSet$telefono((String) json.getString("telefono"));
            }
        }
        if (json.has("descripcion")) {
            if (json.isNull("descripcion")) {
                objProxy.realmSet$descripcion(null);
            } else {
                objProxy.realmSet$descripcion((String) json.getString("descripcion"));
            }
        }
        if (json.has("localidad")) {
            if (json.isNull("localidad")) {
                objProxy.realmSet$localidad(null);
            } else {
                objProxy.realmSet$localidad((String) json.getString("localidad"));
            }
        }
        if (json.has("municipio")) {
            if (json.isNull("municipio")) {
                objProxy.realmSet$municipio(null);
            } else {
                objProxy.realmSet$municipio((String) json.getString("municipio"));
            }
        }
        if (json.has("fecha_registro")) {
            if (json.isNull("fecha_registro")) {
                objProxy.realmSet$fecha_registro(null);
            } else {
                objProxy.realmSet$fecha_registro((String) json.getString("fecha_registro"));
            }
        }
        if (json.has("id_db")) {
            if (json.isNull("id_db")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'id_db' to null.");
            } else {
                objProxy.realmSet$id_db((int) json.getInt("id_db"));
            }
        }
        if (json.has("borrador")) {
            if (json.isNull("borrador")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'borrador' to null.");
            } else {
                objProxy.realmSet$borrador((boolean) json.getBoolean("borrador"));
            }
        }
        if (json.has("sincronizado")) {
            if (json.isNull("sincronizado")) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'sincronizado' to null.");
            } else {
                objProxy.realmSet$sincronizado((boolean) json.getBoolean("sincronizado"));
            }
        }
        if (json.has("fecha_sincronizado")) {
            if (json.isNull("fecha_sincronizado")) {
                objProxy.realmSet$fecha_sincronizado(null);
            } else {
                objProxy.realmSet$fecha_sincronizado((String) json.getString("fecha_sincronizado"));
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static com.mds.ventasabpollo.models.NewClients createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        final com.mds.ventasabpollo.models.NewClients obj = new com.mds.ventasabpollo.models.NewClients();
        final com_mds_ventasabpollo_models_NewClientsRealmProxyInterface objProxy = (com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
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
            } else if (name.equals("rfc")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$rfc((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$rfc(null);
                }
            } else if (name.equals("curp")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$curp((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$curp(null);
                }
            } else if (name.equals("forma_pago")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$forma_pago((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$forma_pago(null);
                }
            } else if (name.equals("no_cuenta")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$no_cuenta((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$no_cuenta(null);
                }
            } else if (name.equals("uso_cfdi")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$uso_cfdi((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$uso_cfdi(null);
                }
            } else if (name.equals("metodo_pago")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$metodo_pago((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$metodo_pago(null);
                }
            } else if (name.equals("correo_electronico")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$correo_electronico((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$correo_electronico(null);
                }
            } else if (name.equals("nombre_contacto")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_contacto((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_contacto(null);
                }
            } else if (name.equals("apellido_contacto")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$apellido_contacto((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$apellido_contacto(null);
                }
            } else if (name.equals("nombre_calle")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$nombre_calle((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$nombre_calle(null);
                }
            } else if (name.equals("no_exterior")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$no_exterior((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$no_exterior(null);
                }
            } else if (name.equals("no_interior")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$no_interior((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$no_interior(null);
                }
            } else if (name.equals("colonia")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$colonia((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$colonia(null);
                }
            } else if (name.equals("codigo_postal")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$codigo_postal((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$codigo_postal(null);
                }
            } else if (name.equals("ciudad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$ciudad((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'ciudad' to null.");
                }
            } else if (name.equals("telefono")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$telefono((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$telefono(null);
                }
            } else if (name.equals("descripcion")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$descripcion((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$descripcion(null);
                }
            } else if (name.equals("localidad")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$localidad((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$localidad(null);
                }
            } else if (name.equals("municipio")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$municipio((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$municipio(null);
                }
            } else if (name.equals("fecha_registro")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_registro((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_registro(null);
                }
            } else if (name.equals("id_db")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id_db((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id_db' to null.");
                }
            } else if (name.equals("borrador")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$borrador((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'borrador' to null.");
                }
            } else if (name.equals("sincronizado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$sincronizado((boolean) reader.nextBoolean());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'sincronizado' to null.");
                }
            } else if (name.equals("fecha_sincronizado")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$fecha_sincronizado((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$fecha_sincronizado(null);
                }
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        return realm.copyToRealm(obj);
    }

    private static com_mds_ventasabpollo_models_NewClientsRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.NewClients.class), false, Collections.<String>emptyList());
        io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy obj = new io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static com.mds.ventasabpollo.models.NewClients copyOrUpdate(Realm realm, NewClientsColumnInfo columnInfo, com.mds.ventasabpollo.models.NewClients object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
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
            return (com.mds.ventasabpollo.models.NewClients) cachedRealmObject;
        }

        return copy(realm, columnInfo, object, update, cache, flags);
    }

    public static com.mds.ventasabpollo.models.NewClients copy(Realm realm, NewClientsColumnInfo columnInfo, com.mds.ventasabpollo.models.NewClients newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (com.mds.ventasabpollo.models.NewClients) cachedRealmObject;
        }

        com_mds_ventasabpollo_models_NewClientsRealmProxyInterface realmObjectSource = (com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) newObject;

        Table table = realm.getTable(com.mds.ventasabpollo.models.NewClients.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, columnInfo.maxColumnIndexValue, flags);

        // Add all non-"object reference" fields
        builder.addInteger(columnInfo.idIndex, realmObjectSource.realmGet$id());
        builder.addString(columnInfo.nombre_clienteIndex, realmObjectSource.realmGet$nombre_cliente());
        builder.addString(columnInfo.nombre_comercialIndex, realmObjectSource.realmGet$nombre_comercial());
        builder.addString(columnInfo.rfcIndex, realmObjectSource.realmGet$rfc());
        builder.addString(columnInfo.curpIndex, realmObjectSource.realmGet$curp());
        builder.addString(columnInfo.forma_pagoIndex, realmObjectSource.realmGet$forma_pago());
        builder.addString(columnInfo.no_cuentaIndex, realmObjectSource.realmGet$no_cuenta());
        builder.addString(columnInfo.uso_cfdiIndex, realmObjectSource.realmGet$uso_cfdi());
        builder.addString(columnInfo.metodo_pagoIndex, realmObjectSource.realmGet$metodo_pago());
        builder.addString(columnInfo.correo_electronicoIndex, realmObjectSource.realmGet$correo_electronico());
        builder.addString(columnInfo.nombre_contactoIndex, realmObjectSource.realmGet$nombre_contacto());
        builder.addString(columnInfo.apellido_contactoIndex, realmObjectSource.realmGet$apellido_contacto());
        builder.addString(columnInfo.nombre_calleIndex, realmObjectSource.realmGet$nombre_calle());
        builder.addString(columnInfo.no_exteriorIndex, realmObjectSource.realmGet$no_exterior());
        builder.addString(columnInfo.no_interiorIndex, realmObjectSource.realmGet$no_interior());
        builder.addString(columnInfo.coloniaIndex, realmObjectSource.realmGet$colonia());
        builder.addString(columnInfo.codigo_postalIndex, realmObjectSource.realmGet$codigo_postal());
        builder.addInteger(columnInfo.ciudadIndex, realmObjectSource.realmGet$ciudad());
        builder.addString(columnInfo.telefonoIndex, realmObjectSource.realmGet$telefono());
        builder.addString(columnInfo.descripcionIndex, realmObjectSource.realmGet$descripcion());
        builder.addString(columnInfo.localidadIndex, realmObjectSource.realmGet$localidad());
        builder.addString(columnInfo.municipioIndex, realmObjectSource.realmGet$municipio());
        builder.addString(columnInfo.fecha_registroIndex, realmObjectSource.realmGet$fecha_registro());
        builder.addInteger(columnInfo.id_dbIndex, realmObjectSource.realmGet$id_db());
        builder.addBoolean(columnInfo.borradorIndex, realmObjectSource.realmGet$borrador());
        builder.addBoolean(columnInfo.sincronizadoIndex, realmObjectSource.realmGet$sincronizado());
        builder.addString(columnInfo.fecha_sincronizadoIndex, realmObjectSource.realmGet$fecha_sincronizado());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.com_mds_ventasabpollo_models_NewClientsRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, com.mds.ventasabpollo.models.NewClients object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.NewClients.class);
        long tableNativePtr = table.getNativePtr();
        NewClientsColumnInfo columnInfo = (NewClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.NewClients.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id(), false);
        String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_cliente();
        if (realmGet$nombre_cliente != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
        }
        String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_comercial();
        if (realmGet$nombre_comercial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
        }
        String realmGet$rfc = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$rfc();
        if (realmGet$rfc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
        }
        String realmGet$curp = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$curp();
        if (realmGet$curp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.curpIndex, rowIndex, realmGet$curp, false);
        }
        String realmGet$forma_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$forma_pago();
        if (realmGet$forma_pago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.forma_pagoIndex, rowIndex, realmGet$forma_pago, false);
        }
        String realmGet$no_cuenta = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_cuenta();
        if (realmGet$no_cuenta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.no_cuentaIndex, rowIndex, realmGet$no_cuenta, false);
        }
        String realmGet$uso_cfdi = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$uso_cfdi();
        if (realmGet$uso_cfdi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uso_cfdiIndex, rowIndex, realmGet$uso_cfdi, false);
        }
        String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$metodo_pago();
        if (realmGet$metodo_pago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
        }
        String realmGet$correo_electronico = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$correo_electronico();
        if (realmGet$correo_electronico != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.correo_electronicoIndex, rowIndex, realmGet$correo_electronico, false);
        }
        String realmGet$nombre_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_contacto();
        if (realmGet$nombre_contacto != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_contactoIndex, rowIndex, realmGet$nombre_contacto, false);
        }
        String realmGet$apellido_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$apellido_contacto();
        if (realmGet$apellido_contacto != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.apellido_contactoIndex, rowIndex, realmGet$apellido_contacto, false);
        }
        String realmGet$nombre_calle = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_calle();
        if (realmGet$nombre_calle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_calleIndex, rowIndex, realmGet$nombre_calle, false);
        }
        String realmGet$no_exterior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_exterior();
        if (realmGet$no_exterior != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.no_exteriorIndex, rowIndex, realmGet$no_exterior, false);
        }
        String realmGet$no_interior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_interior();
        if (realmGet$no_interior != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.no_interiorIndex, rowIndex, realmGet$no_interior, false);
        }
        String realmGet$colonia = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$colonia();
        if (realmGet$colonia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
        }
        String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$codigo_postal();
        if (realmGet$codigo_postal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$ciudad(), false);
        String realmGet$telefono = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$telefono();
        if (realmGet$telefono != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
        }
        String realmGet$descripcion = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        }
        String realmGet$localidad = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$localidad();
        if (realmGet$localidad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localidadIndex, rowIndex, realmGet$localidad, false);
        }
        String realmGet$municipio = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$municipio();
        if (realmGet$municipio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
        }
        String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_registro();
        if (realmGet$fecha_registro != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id_db(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.borradorIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$borrador(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.sincronizadoIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$sincronizado(), false);
        String realmGet$fecha_sincronizado = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_sincronizado();
        if (realmGet$fecha_sincronizado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_sincronizadoIndex, rowIndex, realmGet$fecha_sincronizado, false);
        }
        return rowIndex;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.NewClients.class);
        long tableNativePtr = table.getNativePtr();
        NewClientsColumnInfo columnInfo = (NewClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.NewClients.class);
        com.mds.ventasabpollo.models.NewClients object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.NewClients) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id(), false);
            String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_cliente();
            if (realmGet$nombre_cliente != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
            }
            String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_comercial();
            if (realmGet$nombre_comercial != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
            }
            String realmGet$rfc = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$rfc();
            if (realmGet$rfc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
            }
            String realmGet$curp = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$curp();
            if (realmGet$curp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.curpIndex, rowIndex, realmGet$curp, false);
            }
            String realmGet$forma_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$forma_pago();
            if (realmGet$forma_pago != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.forma_pagoIndex, rowIndex, realmGet$forma_pago, false);
            }
            String realmGet$no_cuenta = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_cuenta();
            if (realmGet$no_cuenta != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.no_cuentaIndex, rowIndex, realmGet$no_cuenta, false);
            }
            String realmGet$uso_cfdi = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$uso_cfdi();
            if (realmGet$uso_cfdi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uso_cfdiIndex, rowIndex, realmGet$uso_cfdi, false);
            }
            String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$metodo_pago();
            if (realmGet$metodo_pago != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
            }
            String realmGet$correo_electronico = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$correo_electronico();
            if (realmGet$correo_electronico != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.correo_electronicoIndex, rowIndex, realmGet$correo_electronico, false);
            }
            String realmGet$nombre_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_contacto();
            if (realmGet$nombre_contacto != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_contactoIndex, rowIndex, realmGet$nombre_contacto, false);
            }
            String realmGet$apellido_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$apellido_contacto();
            if (realmGet$apellido_contacto != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.apellido_contactoIndex, rowIndex, realmGet$apellido_contacto, false);
            }
            String realmGet$nombre_calle = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_calle();
            if (realmGet$nombre_calle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_calleIndex, rowIndex, realmGet$nombre_calle, false);
            }
            String realmGet$no_exterior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_exterior();
            if (realmGet$no_exterior != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.no_exteriorIndex, rowIndex, realmGet$no_exterior, false);
            }
            String realmGet$no_interior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_interior();
            if (realmGet$no_interior != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.no_interiorIndex, rowIndex, realmGet$no_interior, false);
            }
            String realmGet$colonia = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$colonia();
            if (realmGet$colonia != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
            }
            String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$codigo_postal();
            if (realmGet$codigo_postal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$ciudad(), false);
            String realmGet$telefono = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$telefono();
            if (realmGet$telefono != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
            }
            String realmGet$descripcion = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            }
            String realmGet$localidad = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$localidad();
            if (realmGet$localidad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localidadIndex, rowIndex, realmGet$localidad, false);
            }
            String realmGet$municipio = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$municipio();
            if (realmGet$municipio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
            }
            String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_registro();
            if (realmGet$fecha_registro != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id_db(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.borradorIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$borrador(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.sincronizadoIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$sincronizado(), false);
            String realmGet$fecha_sincronizado = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_sincronizado();
            if (realmGet$fecha_sincronizado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_sincronizadoIndex, rowIndex, realmGet$fecha_sincronizado, false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, com.mds.ventasabpollo.models.NewClients object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex();
        }
        Table table = realm.getTable(com.mds.ventasabpollo.models.NewClients.class);
        long tableNativePtr = table.getNativePtr();
        NewClientsColumnInfo columnInfo = (NewClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.NewClients.class);
        long rowIndex = OsObject.createRow(table);
        cache.put(object, rowIndex);
        Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id(), false);
        String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_cliente();
        if (realmGet$nombre_cliente != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, false);
        }
        String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_comercial();
        if (realmGet$nombre_comercial != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, false);
        }
        String realmGet$rfc = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$rfc();
        if (realmGet$rfc != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.rfcIndex, rowIndex, false);
        }
        String realmGet$curp = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$curp();
        if (realmGet$curp != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.curpIndex, rowIndex, realmGet$curp, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.curpIndex, rowIndex, false);
        }
        String realmGet$forma_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$forma_pago();
        if (realmGet$forma_pago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.forma_pagoIndex, rowIndex, realmGet$forma_pago, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.forma_pagoIndex, rowIndex, false);
        }
        String realmGet$no_cuenta = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_cuenta();
        if (realmGet$no_cuenta != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.no_cuentaIndex, rowIndex, realmGet$no_cuenta, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.no_cuentaIndex, rowIndex, false);
        }
        String realmGet$uso_cfdi = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$uso_cfdi();
        if (realmGet$uso_cfdi != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.uso_cfdiIndex, rowIndex, realmGet$uso_cfdi, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.uso_cfdiIndex, rowIndex, false);
        }
        String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$metodo_pago();
        if (realmGet$metodo_pago != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, false);
        }
        String realmGet$correo_electronico = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$correo_electronico();
        if (realmGet$correo_electronico != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.correo_electronicoIndex, rowIndex, realmGet$correo_electronico, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.correo_electronicoIndex, rowIndex, false);
        }
        String realmGet$nombre_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_contacto();
        if (realmGet$nombre_contacto != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_contactoIndex, rowIndex, realmGet$nombre_contacto, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_contactoIndex, rowIndex, false);
        }
        String realmGet$apellido_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$apellido_contacto();
        if (realmGet$apellido_contacto != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.apellido_contactoIndex, rowIndex, realmGet$apellido_contacto, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.apellido_contactoIndex, rowIndex, false);
        }
        String realmGet$nombre_calle = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_calle();
        if (realmGet$nombre_calle != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.nombre_calleIndex, rowIndex, realmGet$nombre_calle, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.nombre_calleIndex, rowIndex, false);
        }
        String realmGet$no_exterior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_exterior();
        if (realmGet$no_exterior != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.no_exteriorIndex, rowIndex, realmGet$no_exterior, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.no_exteriorIndex, rowIndex, false);
        }
        String realmGet$no_interior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_interior();
        if (realmGet$no_interior != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.no_interiorIndex, rowIndex, realmGet$no_interior, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.no_interiorIndex, rowIndex, false);
        }
        String realmGet$colonia = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$colonia();
        if (realmGet$colonia != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.coloniaIndex, rowIndex, false);
        }
        String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$codigo_postal();
        if (realmGet$codigo_postal != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$ciudad(), false);
        String realmGet$telefono = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$telefono();
        if (realmGet$telefono != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.telefonoIndex, rowIndex, false);
        }
        String realmGet$descripcion = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$descripcion();
        if (realmGet$descripcion != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
        }
        String realmGet$localidad = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$localidad();
        if (realmGet$localidad != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.localidadIndex, rowIndex, realmGet$localidad, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.localidadIndex, rowIndex, false);
        }
        String realmGet$municipio = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$municipio();
        if (realmGet$municipio != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.municipioIndex, rowIndex, false);
        }
        String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_registro();
        if (realmGet$fecha_registro != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, false);
        }
        Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id_db(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.borradorIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$borrador(), false);
        Table.nativeSetBoolean(tableNativePtr, columnInfo.sincronizadoIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$sincronizado(), false);
        String realmGet$fecha_sincronizado = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_sincronizado();
        if (realmGet$fecha_sincronizado != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.fecha_sincronizadoIndex, rowIndex, realmGet$fecha_sincronizado, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.fecha_sincronizadoIndex, rowIndex, false);
        }
        return rowIndex;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(com.mds.ventasabpollo.models.NewClients.class);
        long tableNativePtr = table.getNativePtr();
        NewClientsColumnInfo columnInfo = (NewClientsColumnInfo) realm.getSchema().getColumnInfo(com.mds.ventasabpollo.models.NewClients.class);
        com.mds.ventasabpollo.models.NewClients object = null;
        while (objects.hasNext()) {
            object = (com.mds.ventasabpollo.models.NewClients) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getIndex());
                continue;
            }
            long rowIndex = OsObject.createRow(table);
            cache.put(object, rowIndex);
            Table.nativeSetLong(tableNativePtr, columnInfo.idIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id(), false);
            String realmGet$nombre_cliente = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_cliente();
            if (realmGet$nombre_cliente != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, realmGet$nombre_cliente, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_clienteIndex, rowIndex, false);
            }
            String realmGet$nombre_comercial = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_comercial();
            if (realmGet$nombre_comercial != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, realmGet$nombre_comercial, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_comercialIndex, rowIndex, false);
            }
            String realmGet$rfc = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$rfc();
            if (realmGet$rfc != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.rfcIndex, rowIndex, realmGet$rfc, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.rfcIndex, rowIndex, false);
            }
            String realmGet$curp = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$curp();
            if (realmGet$curp != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.curpIndex, rowIndex, realmGet$curp, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.curpIndex, rowIndex, false);
            }
            String realmGet$forma_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$forma_pago();
            if (realmGet$forma_pago != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.forma_pagoIndex, rowIndex, realmGet$forma_pago, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.forma_pagoIndex, rowIndex, false);
            }
            String realmGet$no_cuenta = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_cuenta();
            if (realmGet$no_cuenta != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.no_cuentaIndex, rowIndex, realmGet$no_cuenta, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.no_cuentaIndex, rowIndex, false);
            }
            String realmGet$uso_cfdi = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$uso_cfdi();
            if (realmGet$uso_cfdi != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.uso_cfdiIndex, rowIndex, realmGet$uso_cfdi, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.uso_cfdiIndex, rowIndex, false);
            }
            String realmGet$metodo_pago = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$metodo_pago();
            if (realmGet$metodo_pago != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, realmGet$metodo_pago, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.metodo_pagoIndex, rowIndex, false);
            }
            String realmGet$correo_electronico = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$correo_electronico();
            if (realmGet$correo_electronico != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.correo_electronicoIndex, rowIndex, realmGet$correo_electronico, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.correo_electronicoIndex, rowIndex, false);
            }
            String realmGet$nombre_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_contacto();
            if (realmGet$nombre_contacto != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_contactoIndex, rowIndex, realmGet$nombre_contacto, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_contactoIndex, rowIndex, false);
            }
            String realmGet$apellido_contacto = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$apellido_contacto();
            if (realmGet$apellido_contacto != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.apellido_contactoIndex, rowIndex, realmGet$apellido_contacto, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.apellido_contactoIndex, rowIndex, false);
            }
            String realmGet$nombre_calle = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$nombre_calle();
            if (realmGet$nombre_calle != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.nombre_calleIndex, rowIndex, realmGet$nombre_calle, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.nombre_calleIndex, rowIndex, false);
            }
            String realmGet$no_exterior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_exterior();
            if (realmGet$no_exterior != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.no_exteriorIndex, rowIndex, realmGet$no_exterior, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.no_exteriorIndex, rowIndex, false);
            }
            String realmGet$no_interior = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$no_interior();
            if (realmGet$no_interior != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.no_interiorIndex, rowIndex, realmGet$no_interior, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.no_interiorIndex, rowIndex, false);
            }
            String realmGet$colonia = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$colonia();
            if (realmGet$colonia != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.coloniaIndex, rowIndex, realmGet$colonia, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.coloniaIndex, rowIndex, false);
            }
            String realmGet$codigo_postal = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$codigo_postal();
            if (realmGet$codigo_postal != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, realmGet$codigo_postal, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.codigo_postalIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.ciudadIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$ciudad(), false);
            String realmGet$telefono = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$telefono();
            if (realmGet$telefono != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.telefonoIndex, rowIndex, realmGet$telefono, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.telefonoIndex, rowIndex, false);
            }
            String realmGet$descripcion = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$descripcion();
            if (realmGet$descripcion != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.descripcionIndex, rowIndex, realmGet$descripcion, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.descripcionIndex, rowIndex, false);
            }
            String realmGet$localidad = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$localidad();
            if (realmGet$localidad != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.localidadIndex, rowIndex, realmGet$localidad, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.localidadIndex, rowIndex, false);
            }
            String realmGet$municipio = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$municipio();
            if (realmGet$municipio != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.municipioIndex, rowIndex, realmGet$municipio, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.municipioIndex, rowIndex, false);
            }
            String realmGet$fecha_registro = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_registro();
            if (realmGet$fecha_registro != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, realmGet$fecha_registro, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_registroIndex, rowIndex, false);
            }
            Table.nativeSetLong(tableNativePtr, columnInfo.id_dbIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$id_db(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.borradorIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$borrador(), false);
            Table.nativeSetBoolean(tableNativePtr, columnInfo.sincronizadoIndex, rowIndex, ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$sincronizado(), false);
            String realmGet$fecha_sincronizado = ((com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) object).realmGet$fecha_sincronizado();
            if (realmGet$fecha_sincronizado != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.fecha_sincronizadoIndex, rowIndex, realmGet$fecha_sincronizado, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.fecha_sincronizadoIndex, rowIndex, false);
            }
        }
    }

    public static com.mds.ventasabpollo.models.NewClients createDetachedCopy(com.mds.ventasabpollo.models.NewClients realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        com.mds.ventasabpollo.models.NewClients unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new com.mds.ventasabpollo.models.NewClients();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (com.mds.ventasabpollo.models.NewClients) cachedObject.object;
            }
            unmanagedObject = (com.mds.ventasabpollo.models.NewClients) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        com_mds_ventasabpollo_models_NewClientsRealmProxyInterface unmanagedCopy = (com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) unmanagedObject;
        com_mds_ventasabpollo_models_NewClientsRealmProxyInterface realmSource = (com_mds_ventasabpollo_models_NewClientsRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());
        unmanagedCopy.realmSet$nombre_cliente(realmSource.realmGet$nombre_cliente());
        unmanagedCopy.realmSet$nombre_comercial(realmSource.realmGet$nombre_comercial());
        unmanagedCopy.realmSet$rfc(realmSource.realmGet$rfc());
        unmanagedCopy.realmSet$curp(realmSource.realmGet$curp());
        unmanagedCopy.realmSet$forma_pago(realmSource.realmGet$forma_pago());
        unmanagedCopy.realmSet$no_cuenta(realmSource.realmGet$no_cuenta());
        unmanagedCopy.realmSet$uso_cfdi(realmSource.realmGet$uso_cfdi());
        unmanagedCopy.realmSet$metodo_pago(realmSource.realmGet$metodo_pago());
        unmanagedCopy.realmSet$correo_electronico(realmSource.realmGet$correo_electronico());
        unmanagedCopy.realmSet$nombre_contacto(realmSource.realmGet$nombre_contacto());
        unmanagedCopy.realmSet$apellido_contacto(realmSource.realmGet$apellido_contacto());
        unmanagedCopy.realmSet$nombre_calle(realmSource.realmGet$nombre_calle());
        unmanagedCopy.realmSet$no_exterior(realmSource.realmGet$no_exterior());
        unmanagedCopy.realmSet$no_interior(realmSource.realmGet$no_interior());
        unmanagedCopy.realmSet$colonia(realmSource.realmGet$colonia());
        unmanagedCopy.realmSet$codigo_postal(realmSource.realmGet$codigo_postal());
        unmanagedCopy.realmSet$ciudad(realmSource.realmGet$ciudad());
        unmanagedCopy.realmSet$telefono(realmSource.realmGet$telefono());
        unmanagedCopy.realmSet$descripcion(realmSource.realmGet$descripcion());
        unmanagedCopy.realmSet$localidad(realmSource.realmGet$localidad());
        unmanagedCopy.realmSet$municipio(realmSource.realmGet$municipio());
        unmanagedCopy.realmSet$fecha_registro(realmSource.realmGet$fecha_registro());
        unmanagedCopy.realmSet$id_db(realmSource.realmGet$id_db());
        unmanagedCopy.realmSet$borrador(realmSource.realmGet$borrador());
        unmanagedCopy.realmSet$sincronizado(realmSource.realmGet$sincronizado());
        unmanagedCopy.realmSet$fecha_sincronizado(realmSource.realmGet$fecha_sincronizado());

        return unmanagedObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("NewClients = proxy[");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
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
        stringBuilder.append("{rfc:");
        stringBuilder.append(realmGet$rfc() != null ? realmGet$rfc() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{curp:");
        stringBuilder.append(realmGet$curp() != null ? realmGet$curp() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{forma_pago:");
        stringBuilder.append(realmGet$forma_pago() != null ? realmGet$forma_pago() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{no_cuenta:");
        stringBuilder.append(realmGet$no_cuenta() != null ? realmGet$no_cuenta() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{uso_cfdi:");
        stringBuilder.append(realmGet$uso_cfdi() != null ? realmGet$uso_cfdi() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{metodo_pago:");
        stringBuilder.append(realmGet$metodo_pago() != null ? realmGet$metodo_pago() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{correo_electronico:");
        stringBuilder.append(realmGet$correo_electronico() != null ? realmGet$correo_electronico() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_contacto:");
        stringBuilder.append(realmGet$nombre_contacto() != null ? realmGet$nombre_contacto() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{apellido_contacto:");
        stringBuilder.append(realmGet$apellido_contacto() != null ? realmGet$apellido_contacto() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{nombre_calle:");
        stringBuilder.append(realmGet$nombre_calle() != null ? realmGet$nombre_calle() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{no_exterior:");
        stringBuilder.append(realmGet$no_exterior() != null ? realmGet$no_exterior() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{no_interior:");
        stringBuilder.append(realmGet$no_interior() != null ? realmGet$no_interior() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{colonia:");
        stringBuilder.append(realmGet$colonia() != null ? realmGet$colonia() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{codigo_postal:");
        stringBuilder.append(realmGet$codigo_postal() != null ? realmGet$codigo_postal() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{ciudad:");
        stringBuilder.append(realmGet$ciudad());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{telefono:");
        stringBuilder.append(realmGet$telefono() != null ? realmGet$telefono() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{descripcion:");
        stringBuilder.append(realmGet$descripcion() != null ? realmGet$descripcion() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{localidad:");
        stringBuilder.append(realmGet$localidad() != null ? realmGet$localidad() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{municipio:");
        stringBuilder.append(realmGet$municipio() != null ? realmGet$municipio() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_registro:");
        stringBuilder.append(realmGet$fecha_registro() != null ? realmGet$fecha_registro() : "null");
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id_db:");
        stringBuilder.append(realmGet$id_db());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{borrador:");
        stringBuilder.append(realmGet$borrador());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{sincronizado:");
        stringBuilder.append(realmGet$sincronizado());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{fecha_sincronizado:");
        stringBuilder.append(realmGet$fecha_sincronizado() != null ? realmGet$fecha_sincronizado() : "null");
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
        com_mds_ventasabpollo_models_NewClientsRealmProxy aNewClients = (com_mds_ventasabpollo_models_NewClientsRealmProxy)o;

        String path = proxyState.getRealm$realm().getPath();
        String otherPath = aNewClients.proxyState.getRealm$realm().getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aNewClients.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getIndex() != aNewClients.proxyState.getRow$realm().getIndex()) return false;

        return true;
    }
}
