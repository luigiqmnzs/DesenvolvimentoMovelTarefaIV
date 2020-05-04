package com.example.tarefaiv

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var referencia: DatabaseReference = FirebaseDatabase.getInstance().reference;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        botao.setOnClickListener {
            mostrarNome()
        }

        //var pessoas: DatabaseReference = referencia.child( "Pessoa" )


    }

    fun mostrarNome(){
        var idText = id.text.toString()
        if(idText != ""){
            var pessoa: DatabaseReference = referencia.child( "Pessoa" ).child(idText).child("Nome")
            pessoa.addListenerForSingleValueEvent(object: ValueEventListener {
                override fun onCancelled(p0: DatabaseError) {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun onDataChange(p0: DataSnapshot) {
                   var nomeFb: String = p0.value as String
                    nome.setText(nomeFb)
                }

            })


        }
    }
}
