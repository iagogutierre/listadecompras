package com.example.darth.listamercado;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public ArrayList<Produto> produtos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        produtos = new ArrayList<Produto>();
        produtos.add(new Produto("Leite", 3.00));
        produtos.add(new Produto("Pera", 1.89));
        produtos.add(new Produto("Uva", 4.00));
        produtos.add(new Produto("Maçã", 2.00));
        produtos.add(new Produto("Salada Mista", 5.00));
        produtos.add(new Produto("Abacaxi", 10.00));
        produtos.add(new Produto("Ovo", 6.00));
        produtos.add((new Produto("Cacetinho", 3.00)));
        produtos.add(new Produto("Amaciante", 9.00));
        produtos.add(new Produto("Café", 23.00));
        produtos.add(new Produto("Manteiga", 3.89));
        produtos.add(new Produto("Papel Higienico", 0.95));
        produtos.add(new Produto("Bombril", 1.25));
        produtos.add(new Produto("Esponja", 5.30));
        produtos.add(new Produto("Detergente", 2.50));
        produtos.add(new Produto("Chocolate", 6.00));
        produtos.add((new Produto("Tapioca", 3.00)));
        produtos.add(new Produto("Farinha", 4.80));

        ArrayAdapter<Produto> adaptador  = new Adapter(this,  R.layout.item_da_lista, produtos);
        ListView lv = (ListView) findViewById(R.id.lvProdutos);
        lv.setAdapter(adaptador);

    }
    public void calcular(View v) {
        double total = 0;
        for (Produto p : produtos) {
            if (p.check) {
                total += p.preco;
            }
        }
        Toast.makeText(getApplicationContext(), "Total a pagar: "+total, Toast.LENGTH_LONG).show();
    }
}
