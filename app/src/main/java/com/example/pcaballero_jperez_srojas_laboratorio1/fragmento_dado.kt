package com.example.pcaballero_jperez_srojas_laboratorio1

// Importaciones necesarias para la funcionalidad del fragmento
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.ImageView
import androidx.core.content.ContextCompat

// Clase del fragmento que manejará la visualización del dado y los cambios en el layout del fragmento.
class DadoFragmento : Fragment() {

    // Declaración de variables para el ImageView donde se mostrará la imagen del dado y la vista del layout del fragmento.
    private lateinit var imagenDado: ImageView
    private lateinit var fragmentLayout: View

    // Método que infla la vista del fragmento cuando este es creado.
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Infla el layout del fragmento desde el archivo XML dado_fragmento
        val view = inflater.inflate(R.layout.dado_fragmento, container, false)

        // Inicialización del ImageView para mostrar el resultado del dado y del layout del fragmento
        imagenDado = view.findViewById(R.id.imgvw_dadosresultado)
        fragmentLayout = view.findViewById(R.id.fragment_layout)

        // Se retorna la vista inflada
        return view
    }

    // Método encargado de actualizar el resultado del dado y cambiar la apariencia del fragmento
    fun actualizarResultado(valorDado: Int) {
        // Obtener la referencia de la actividad principal (MainActivity) para poder interactuar con ella
        val activity = requireActivity() as MainActivity

        // Verificar si el valor del dado es 6 (ganador)
        if (valorDado == 6) {
            // Cambiar el color de fondo del fragmento a dorado si el jugador ha ganado
            val colorDorado = ContextCompat.getColor(requireContext(), R.color.dorado)
            fragmentLayout.setBackgroundColor(colorDorado)

            // Actualizar también el fondo de MainActivity
            activity.cambiarColorFondo(colorDorado)

            // Mostrar un mensaje emergente (Toast) indicando que el jugador ha ganado
            Toast.makeText(requireContext(), "¡Has ganado!", Toast.LENGTH_SHORT).show()
        } else {
            // Cambiar el color de fondo del fragmento a gris claro si no ha ganado
            val colorGrisClaro = ContextCompat.getColor(requireContext(), R.color.gris_claro)
            fragmentLayout.setBackgroundColor(colorGrisClaro)

            // Actualizar también el fondo de MainActivity
            activity.cambiarColorFondo(colorGrisClaro)

            // Mostrar un mensaje emergente (Toast) indicando el resultado del dado
            Toast.makeText(requireContext(), "No has ganado, el resultado es: $valorDado", Toast.LENGTH_SHORT).show()
        }

        // Actualizar la imagen del dado dependiendo del valor obtenido
        val recursoImagenDado = when (valorDado) {
            1 -> R.drawable.dice_1 // Imagen del dado con valor 1
            2 -> R.drawable.dice_2 // Imagen del dado con valor 2
            3 -> R.drawable.dice_3 // Imagen del dado con valor 3
            4 -> R.drawable.dice_4 // Imagen del dado con valor 4
            5 -> R.drawable.dice_5 // Imagen del dado con valor 5
            else -> R.drawable.dice_6 // Imagen del dado con valor 6
        }

        // Establecer la imagen correspondiente al valor del dado
        imagenDado.setImageResource(recursoImagenDado)
    }
}
