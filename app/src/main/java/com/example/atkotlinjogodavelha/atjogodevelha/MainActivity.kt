package com.example.atkotlinjogodavelha.atjogodevelha

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Int3
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun buttonClick(view: View) {
        val buttonSelecionado = view as Button
        var cellID = 0

        when(buttonSelecionado.id) {
            R.id.button1 -> cellID = 1
            R.id.button2 -> cellID = 2
            R.id.button3 -> cellID = 3
            R.id.button4 -> cellID = 4
            R.id.button5 -> cellID = 5
            R.id.button6 -> cellID = 6
            R.id.button7 -> cellID = 7
            R.id.button8 -> cellID = 8
            R.id.button9 -> cellID = 9

        }

        //Toast.makeText(this, "teste",  Toast.LENGTH_SHORT).show()
        playGame(cellID, buttonSelecionado)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

    var activeplayer = 1

    fun playGame(cellID:Int, buttonSelecionaado:Button) {

        if(activeplayer==1) {
            buttonSelecionaado.text = "X"
            buttonSelecionaado.setBackgroundColor(Color.GREEN)
            player1.add(cellID)
            activeplayer = 2
        } else {
            buttonSelecionaado.text = "0"
            buttonSelecionaado.setBackgroundColor(Color.MAGENTA)
            player2.add(cellID)
            activeplayer = 1
        }

        buttonSelecionaado.isEnabled = false
        checkWinner()
    }

    fun checkWinner() {
        var winner = -1

        if(player1.contains(1) && player1.contains(2) && player1.contains(3)) {
           winner = 1
        }
        if(player2.contains(1) && player2.contains(2) && player2.contains(3)) {
           winner = 2
        }
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
           winner = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winner = 2
        }
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winner = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winner = 2
        }

        ///////// COLUNAS ///////////
        if(player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner = 2
        }

        if(player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner = 1
        }
        if(player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner = 2
        }

        if(player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner = 2
        }

        //////// DIAGONAL ///////////
        if(player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner = 1
        }
        if(player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner = 2
        }

        if(player1.contains(3) && player1.contains(5) && player1.contains(7)){
            winner = 1
        }
        if(player2.contains(3) && player2.contains(5) && player2.contains(7)){
            winner = 2
        }



        if(winner != -1) {
             if(winner == 1) {

                 Toast.makeText( this,"Player 1 won the game", Toast.LENGTH_SHORT).show()
             } else {
                 Toast.makeText( this,"Player 2 won the game", Toast.LENGTH_SHORT).show()
             }
        }
    }
}
