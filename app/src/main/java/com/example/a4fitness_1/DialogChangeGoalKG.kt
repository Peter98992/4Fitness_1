package com.example.a4fitness_1

import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialogFragment


class DialogChangeGoalKG : AppCompatDialogFragment() {
    private var listener: KGGoalDialogListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val inflater = requireActivity().layoutInflater
        val view: View = inflater.inflate(R.layout.layout_dialog_goalkg, null)

        val editTextValue = view.findViewById<EditText>(R.id.edit_value)

        return AlertDialog.Builder(requireActivity())
            .setView(view)
            .setTitle("Enter KG")
            .setNegativeButton("Cancel") {_, _, ->}
            .setPositiveButton("Ok") {_, _, ->
                val valuekg = editTextValue.text.toString()
                listener!!.applyTextsGoalKg(valuekg)
            }
            .create()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = try {
            context as KGGoalDialogListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                context.toString() +
                        "must implement ExampleDialogListener"
            )
        }
    }

    interface KGGoalDialogListener {
        fun applyTextsGoalKg(valuekg: String?)
    }
}
