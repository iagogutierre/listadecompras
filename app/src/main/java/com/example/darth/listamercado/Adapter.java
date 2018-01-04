package com.example.darth.listamercado;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import java.util.List;

/**
 * Created by darth on 26/12/17.
 */

public class Adapter extends ArrayAdapter<Produto> {
    private LayoutInflater inflater;
    int id;

    public Adapter(@NonNull Context context, int id, List<Produto> produtos) {
        super(context, id, produtos);
        this.inflater = LayoutInflater.from(context);
        this.id = id;
    }

    public View getView(int position, View convertView, ViewGroup parent){
        final Produto produto = getItem(position);
        convertView = inflater.inflate(id, parent, false);
        CheckBox chSelecionado = (CheckBox) convertView.findViewById(R.id.cbProduto);
        chSelecionado.setChecked(produto.check);
        chSelecionado.setText(produto.nome + " "+produto.preco+"$");
        chSelecionado.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                produto.check = isChecked;
            }
        });

        return convertView;
    }
}
