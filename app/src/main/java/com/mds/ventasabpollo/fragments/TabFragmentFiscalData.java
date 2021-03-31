package com.mds.ventasabpollo.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;

import com.mds.ventasabpollo.R;
import com.mds.ventasabpollo.application.BaseApp;
import com.mds.ventasabpollo.application.SPClass;
import com.mds.ventasabpollo.models.MethodPay;
import com.mds.ventasabpollo.models.NewClients;
import com.mds.ventasabpollo.models.UseCFDI;
import com.mds.ventasabpollo.models.WayPay;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class TabFragmentFiscalData extends Fragment {

    Realm realm;
    int idNewClient;

    EditText editTxtNameClient, editTxtTradeName, editTxtRFC, editTxtCURP, editTxtNoAccount, editTxtEmail, editTxtNameContact, editTxtSurnameContact;
    String nombre_cliente, nombre_comercial, rfc, curp, forma_pago, no_cuenta, uso_cfdi, metodo_pago, correo_electronico, nombre_contacto, apellido_contacto;

    Spinner spinnerWayPay, spinnerCFDI, spinnerMethodPay;

    RealmResults<WayPay> listWayPay;
    RealmResults<UseCFDI> listUseCFDI;
    RealmResults<MethodPay> listMethodPay;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        View view=inflater.inflate(R.layout.tab_fragment_fiscal_data, container, false);

        editTxtNameClient = view.findViewById(R.id.editTxtNameClient);
        editTxtTradeName = view.findViewById(R.id.editTxtTradeName);
        editTxtRFC = view.findViewById(R.id.editTxtRFC);
        editTxtCURP = view.findViewById(R.id.editTxtCURP);
        editTxtNoAccount = view.findViewById(R.id.editTxtNoAccount);
        editTxtEmail = view.findViewById(R.id.editTxtEmail);
        editTxtNameContact = view.findViewById(R.id.editTxtNameContact);
        editTxtSurnameContact = view.findViewById(R.id.editTxtSurnameContact);

        spinnerWayPay = view.findViewById(R.id.spinnerWayPay);
        spinnerCFDI = view.findViewById(R.id.spinnerCFDI);
        spinnerMethodPay = view.findViewById(R.id.spinnerMethodPay);

        showData();
        populateListWayPay();
        populateListUseCFDI();
        populateListMethodPay();

        editTxtNameClient.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });

        editTxtTradeName.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });

        editTxtRFC.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtCURP.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtNoAccount.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });

        editTxtEmail.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtNameContact.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });
        editTxtSurnameContact.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
            }

            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                updateValues();
            }
        });

        return view;
    }

    public void showData(){
        SPClass spClass = new SPClass(getActivity());
        BaseApp baseApp = new BaseApp(getActivity());

        try{
            realm = Realm.getDefaultInstance();
            idNewClient = spClass.intGetSP("idNewClient");

            RealmResults<NewClients> newClients = realm.where(NewClients.class).equalTo("id", idNewClient).findAll();
            if(newClients.get(0) != null){

                editTxtNameClient.setText(newClients.get(0).getNombre_cliente());
                editTxtTradeName.setText(newClients.get(0).getNombre_comercial());
                editTxtRFC.setText(newClients.get(0).getRfc());
                editTxtCURP.setText(newClients.get(0).getCurp());
                //editTxtWayPay.setText(newClients.get(0).getForma_pago());
                editTxtNoAccount.setText(newClients.get(0).getNo_cuenta());
                //editTxtCFDI.setText(newClients.get(0).getUso_cfdi());
                //editTxtPayMethod.setText(newClients.get(0).getMetodo_pago());
                editTxtEmail.setText(newClients.get(0).getCorreo_electronico());
                editTxtNameContact.setText(newClients.get(0).getNombre_contacto());
                editTxtSurnameContact.setText(newClients.get(0).getApellido_contacto());
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error: " + ex);
        }
    }

    public void updateValues(){
        SPClass spClass = new SPClass(getActivity());
        BaseApp baseApp = new BaseApp(getActivity());

        try{
            realm = Realm.getDefaultInstance();
            idNewClient = spClass.intGetSP("idNewClient");

            nombre_cliente = editTxtNameClient.getText().toString();
            nombre_comercial = editTxtTradeName.getText().toString();
            rfc = editTxtRFC.getText().toString();
            curp = editTxtCURP.getText().toString();
            //forma_pago = editTxtWayPay.getText().toString();
            no_cuenta = editTxtNoAccount.getText().toString();
            //uso_cfdi = editTxtCFDI.getText().toString();
            //metodo_pago = editTxtPayMethod.getText().toString();
            correo_electronico = editTxtEmail.getText().toString();
            nombre_contacto = editTxtNameContact.getText().toString();
            apellido_contacto = editTxtSurnameContact.getText().toString();

                RealmResults<NewClients> newClients = realm.where(NewClients.class).equalTo("id", idNewClient).findAll();
                if(newClients.get(0) != null){
                    realm.beginTransaction();

                    newClients.get(0).setNombre_cliente(nombre_cliente);
                    newClients.get(0).setNombre_comercial(nombre_comercial);
                    newClients.get(0).setRfc(rfc);
                    newClients.get(0).setCurp(curp);
                    newClients.get(0).setForma_pago(forma_pago);
                    newClients.get(0).setNo_cuenta(no_cuenta);
                    newClients.get(0).setUso_cfdi(uso_cfdi);
                    newClients.get(0).setMetodo_pago(metodo_pago);
                    newClients.get(0).setCorreo_electronico(correo_electronico);
                    newClients.get(0).setNombre_contacto(nombre_contacto);
                    newClients.get(0).setApellido_contacto(apellido_contacto);

                    realm.commitTransaction();
                baseApp.showLog("Cambios guardados");
            }
        }catch (Exception ex){
            baseApp.showToast("Ocurrió un error: " +  ex);
        }
    }

    public void populateListWayPay(){
        BaseApp baseApp = new BaseApp(getActivity());

        try {

            List<String> listArray = new ArrayList<>();
            listWayPay = realm.where(WayPay.class).findAll();

            if (listWayPay.size() == 0) {
                //baseApp.showToast("No se encontraron Métodos de Pago para cargar.");
                //finish();
                spinnerWayPay.setEnabled(false);
            } else {

                for (int i = 0; i < listWayPay.size(); i++) {
                    listArray.add(listWayPay.get(i).getDescripcion().trim());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getActivity(), android.R.layout.simple_spinner_item, listArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerWayPay.setAdapter(adapter);
                spinnerWayPay.setEnabled(true);

                //RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();
                //spinnerClasifications.setSelection(visitsClients.get(0).getPosition_clasificacion_visita());
            }

        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las Formas de Pago por este error: " + ex);
        }
    }

    public void populateListUseCFDI(){
        BaseApp baseApp = new BaseApp(getActivity());

        try {

            List<String> listArray = new ArrayList<>();
            listUseCFDI = realm.where(UseCFDI.class).findAll();

            if (listUseCFDI.size() == 0) {
                //baseApp.showToast("No se encontraron Lista de Uso de CFDI para cargar.");
                //finish();
                spinnerCFDI.setEnabled(false);
            } else {

                for (int i = 0; i < listUseCFDI.size(); i++) {
                    listArray.add(listUseCFDI.get(i).getDescripcion().trim());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getActivity(), android.R.layout.simple_spinner_item, listArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerCFDI.setAdapter(adapter);
                spinnerCFDI.setEnabled(true);

                //RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();
                //spinnerClasifications.setSelection(visitsClients.get(0).getPosition_clasificacion_visita());
            }

        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las Clasificaciones de Visitas por este error: " + ex);
        }
    }


    public void populateListMethodPay(){
        BaseApp baseApp = new BaseApp(getActivity());

        try {

            List<String> listArray = new ArrayList<>();
            listMethodPay = realm.where(MethodPay.class).findAll();

            if (listMethodPay.size() == 0) {
                //baseApp.showToast("No se encontraron Lista de Métodos de pago para cargar.");
                //finish();
                spinnerMethodPay.setEnabled(false);
            } else {

                for (int i = 0; i < listMethodPay.size(); i++) {
                    listArray.add(listMethodPay.get(i).getDescripcion().trim());
                }

                ArrayAdapter<String> adapter = new ArrayAdapter<>(
                        getActivity(), android.R.layout.simple_spinner_item, listArray);

                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinnerMethodPay.setAdapter(adapter);
                spinnerMethodPay.setEnabled(true);

                //RealmResults<VisitsClients> visitsClients = realm.where(VisitsClients.class).equalTo("id", nVisit).findAll();
                //spinnerClasifications.setSelection(visitsClients.get(0).getPosition_clasificacion_visita());
            }

        }catch (Exception ex){
            baseApp.showAlert("Error", "No se pudieron cargar las Clasificaciones de Visitas por este error: " + ex);
        }
    }

}