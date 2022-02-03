package com.example.projetoeconomize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity(), ListaDeItensAdapter.ExecutadorDeAcao {
    private val ListaDeComodos = mutableListOf<Comodo>(Comodo("Cozinha", mutableListOf()), Comodo("Sala",
        mutableListOf(Eletrodomestico("tv", 134), Eletrodomestico("Lampada", 34)
        ))
    );
    private lateinit var dialog: MaterialAlertDialogBuilder
    private val adapter = ListaDeItensAdapter(ListaDeComodos, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoCriarItem = findViewById<FloatingActionButton>(R.id.botaoCriar)
        botaoCriarItem.setOnClickListener {
            abrirDialogParaCriarItem()
        }
        dialog = MaterialAlertDialogBuilder(this);

        val listaDeItens  = findViewById<RecyclerView>(R.id.lista_de_itens)
        listaDeItens.adapter = adapter
        listaDeItens.layoutManager = LinearLayoutManager(this@MainActivity)
    }

    override fun executaEventoDeClique(comodo: Comodo){
        val intent = Intent(this@MainActivity, DetalhesDoComodoActivity::class.java)
        intent.putExtra("nomeDoComodo", comodo.nome)
        startActivity(intent)
    }

    private fun abrirDialogParaCriarItem() {
        val adicionarDialogView = LayoutInflater.from(this).inflate(R.layout.create_item_dialog, null, false)
//        dialog.setView(adicionarDialogView).setPositiveButton("confirmar") { _ , _ ->
//            val input = adicionarDialogView.findViewById<EditText>(R.id.criar_item_input)
//            val novoItem = input.text.toString()
//            ListaDeItens.add(novoItem)
//        }.show()
    }

}