package com.example.projetoeconomize

data class Comodo(val name: String, val eletrodomesticos: MutableList<Eletrodomestico>) {

    fun pegarConsumoTotal():Int {
        var consumoTotal = 0
        eletrodomesticos.forEach { eletrodomestico ->
            consumoTotal = eletrodomestico.consumo + consumoTotal

        }
        return consumoTotal
    }


}

