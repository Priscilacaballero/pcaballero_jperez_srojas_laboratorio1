package com.example.pcaballero_jperez_srojas_laboratorio1

// Importaciones necesarias para la funcionalidad de la actividad
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlin.random.Random

// Clase de la actividad principal que implementa la interfaz View.OnClickListener para manejar los clics de botones
class MainActivity : AppCompatActivity(), View.OnClickListener {

    // Declaración de variables para el botón que lanzará el dado y el fragmento del dado
    lateinit var botonLanzarDado: Button
    private lateinit var dadoFragmento: DadoFragmento

    // Método que se ejecuta cuando la actividad es creada
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Asigna el layout de la actividad desde el archivo XML activity_main
        setContentView(R.layout.activity_main)

        // Inicialización del botón para lanzar el dado y asignación del listener para manejar el clic
        botonLanzarDado = findViewById(R.id.btn_lanzar)
        botonLanzarDado.setOnClickListener(this) // Asocia el método onClick a este botón

        // Inicialización del fragmento de dado y su adición al layout de la actividad
        dadoFragmento = DadoFragmento()
        supportFragmentManager.beginTransaction().add(R.id.fragmento_resultados, dadoFragmento).commit()
    }

    // Método que maneja los eventos de clic en los botones de la actividad
    override fun onClick(v: View?) {
        // Verifica si el clic proviene del botón para lanzar el dado
        if (v?.id == R.id.btn_lanzar) {
            // Genera un número aleatorio entre 1 y 6, simulando el lanzamiento de un dado
            val valorDado = Random.nextInt(1, 7)
            // Llama al método updateDiceRoll del fragmento para actualizar la imagen y el mensaje del dado
            dadoFragmento.actualizarResultado(valorDado)
        }
    }

    // Método para cambiar el color de fondo de la actividad principal
    fun cambiarColorFondo(color: Int) {
        // Obtiene la referencia al layout principal y cambia su color de fondo
        val mainLayout = findViewById<View>(R.id.main_layout)
        mainLayout.setBackgroundColor(color)
    }
}
